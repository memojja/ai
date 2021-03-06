import model.GameState;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.stream.IntStream;

public class GameStateTest {

    private static GameState gameState;

    @BeforeClass
    public static void  init(){
        gameState = new GameState("test_game");
    }

    @Test
    public void given_card_when_initialize_then_user_must_have_four_cards(){
        IntStream.range(0,4).forEach(i -> Assert.assertEquals(gameState.getPlayersCards().get(i).size(),4));
    }

    @Test
    public void given_card_when_user_discard_card_then_card_must_be_facing_up(){
        IntStream.range(0,4).forEach(i -> Assert.assertTrue(gameState.getDiscardedCards().get(i).isFront()));
    }

    @Test
    public void given_card_when_user_discard_card_then_card_must_be_facing_down(){
        IntStream.range(0,4).forEach(i -> Assert.assertFalse(gameState.getPlayersCards().get(i).get(0).isFront()));
    }
}
