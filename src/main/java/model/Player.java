package model;

import service.GameService;

import java.util.List;

/**
 *
 * Uses the Template Pattern so all players have same actions. only difference is brain
 */
public abstract class Player implements BrainTemplate {

    private int index;
    private int point;
    private int sizeCollectedCard;
    private String gameName;
    private GameService gameService;

    public Player(final int index,final String gameName){
        this.index = index;
        this.point = 0;
        this.gameName = gameName;
        this.gameService = new GameService();

    }

    public void play(final GameState gameState) {
       final List<Card> myCards = gameState.getPlayersCards().get(index);
       final List<Card> discardedCards = gameState.getDiscardedCards();

       final Card card = logic(gameState);

        discardCard(myCards, discardedCards, card);

        gameService.calculateUserPoint(gameState,discardedCards,this,false);
    }

    public void addPoint(int point){
        this.point+=point;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getSizeCollectedCard() {
        return sizeCollectedCard;
    }

    public void setSizeCollectedCard(int sizeCollectedCard) {
        this.sizeCollectedCard = sizeCollectedCard;
    }

    public String getGameName() {
        return gameName;
    }

    private void discardCard(List<Card> myCards, List<Card> discardedCards, Card card) {
        discardedCards.add(new CardWithFacingUp(card));
        myCards.remove(card);
    }

    @Override
    public String toString() {
        return "Player{" +
            "index=" + index +
            ", point=" + point +
            ", sizeCollectedCard=" + sizeCollectedCard +
            ", gameName='" + gameName + '\'' +
            ", gameService=" + gameService +
            '}';
    }
}
