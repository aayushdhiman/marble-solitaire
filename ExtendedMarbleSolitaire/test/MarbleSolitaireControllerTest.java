import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for the {@code MarbleSolitaireController}.
 *
 * <p>Functionality explicitly tested:
 * Quitting instantly, quitting after valid moves
 * Winning the game
 * Null for views, models, and readables
 * Losing the game
 * Inputting all the moves at once
 * Invalid characters/moves in the middle of inputs
 * Custom sized boards
 * Rendering null messages</p>
 *
 * <p>Other functionality:
 * The render methods in the view are tested by way of the Interaction[] properly working;
 * thus, the render methods must be operating as expected.</p>
 *
 * <p>The functionality of the model was tested in previous assignments (moving up or down, moving
 * in a position that is not allowed, etc) , and the same code is
 * used, so I did not include the tests for those functions in this class.</p>
 */
public class MarbleSolitaireControllerTest {
  private Appendable actualOutput;
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private StringBuilder fakeUserInput;
  private StringBuilder expectedOutput;
  private Readable input;

  @Before
  public void init() throws Exception {
    actualOutput = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, actualOutput);
    fakeUserInput = new StringBuilder();
    expectedOutput = new StringBuilder();
    Readable input = new StringReader(fakeUserInput.toString());

  }

  @Test
  public void testInstantQuit() {
    Interaction[] interactions = new Interaction[]{
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O" +
                "\nScore: 32" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("q\n"),
        new PrintInteraction(System.lineSeparator() +
                "Game quit!" +
                System.lineSeparator() +
                "State of game when quit:" +
                System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O" +
                "\nScore: 32")
    };

    this.runController(interactions, model, view);
    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test
  public void oneMoveQuit() {
    Interaction[] interactions = new Interaction[]{
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("2 4 4 4\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O _ O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 31" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("q\n"),
        new PrintInteraction(System.lineSeparator() +
                "Game quit!" +
                System.lineSeparator() +
                "State of game when quit:" +
                System.lineSeparator() +
                "    O O O\n" +
                "    O _ O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 31")
    };

    this.runController(interactions, model, view);
    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test
  public void testWinGame() {
    Interaction[] interactions = new Interaction[]{
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("4 2 4 4\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O _ _ O O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 31" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("6 3 4 3\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O _ O O O O O\n" +
                "O O _ O O O O\n" +
                "    _ O O\n" +
                "    O O O\n" +
                "Score: 30" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("5 1 5 3\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O _ O O O O O\n" +
                "_ _ O O O O O\n" +
                "    _ O O\n" +
                "    O O O\n" +
                "Score: 29" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("5 4 5 2\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O _ O O O O O\n" +
                "_ O _ _ O O O\n" +
                "    _ O O\n" +
                "    O O O\n" +
                "Score: 28" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("5 6 5 4\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O _ O O O O O\n" +
                "_ O _ O _ _ O\n" +
                "    _ O O\n" +
                "    O O O\n" +
                "Score: 27" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("7 5 5 5\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O _ O O O O O\n" +
                "_ O _ O O _ O\n" +
                "    _ O _\n" +
                "    O O _\n" +
                "Score: 26" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("4 5 6 5\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O _ O O _ O O\n" +
                "_ O _ O _ _ O\n" +
                "    _ O O\n" +
                "    O O _\n" +
                "Score: 25" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("7 3 7 5\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O _ O O _ O O\n" +
                "_ O _ O _ _ O\n" +
                "    _ O O\n" +
                "    _ _ O\n" +
                "Score: 24" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("7 5 5 5\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O _ O O _ O O\n" +
                "_ O _ O O _ O\n" +
                "    _ O _\n" +
                "    _ _ _\n" +
                "Score: 23" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("3 3 5 3\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O _ O O O O\n" +
                "O _ _ O _ O O\n" +
                "_ O O O O _ O\n" +
                "    _ O _\n" +
                "    _ _ _\n" +
                "Score: 22" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("1 3 3 3\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    _ O O\n" +
                "O O O O O O O\n" +
                "O _ _ O _ O O\n" +
                "_ O O O O _ O\n" +
                "    _ O _\n" +
                "    _ _ _\n" +
                "Score: 21" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("2 5 4 5\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    _ O _\n" +
                "O O O O _ O O\n" +
                "O _ _ O O O O\n" +
                "_ O O O O _ O\n" +
                "    _ O _\n" +
                "    _ _ _\n" +
                "Score: 20" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("4 5 6 5\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    _ O _\n" +
                "O O O O _ O O\n" +
                "O _ _ O _ O O\n" +
                "_ O O O _ _ O\n" +
                "    _ O O\n" +
                "    _ _ _\n" +
                "Score: 19" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("6 5 6 3\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    _ O _\n" +
                "O O O O _ O O\n" +
                "O _ _ O _ O O\n" +
                "_ O O O _ _ O\n" +
                "    O _ _\n" +
                "    _ _ _\n" +
                "Score: 18" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("6 3 4 3\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    _ O _\n" +
                "O O O O _ O O\n" +
                "O _ O O _ O O\n" +
                "_ O _ O _ _ O\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 17" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("4 3 2 3\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    O O _\n" +
                "O O _ O _ O O\n" +
                "O _ _ O _ O O\n" +
                "_ O _ O _ _ O\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 16" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("3 1 5 1\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    O O _\n" +
                "_ O _ O _ O O\n" +
                "_ _ _ O _ O O\n" +
                "O O _ O _ _ O\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 15" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("5 1 5 3\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    O O _\n" +
                "_ O _ O _ O O\n" +
                "_ _ _ O _ O O\n" +
                "_ _ O O _ _ O\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 14" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("5 3 5 5\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    O O _\n" +
                "_ O _ O _ O O\n" +
                "_ _ _ O _ O O\n" +
                "_ _ _ _ O _ O\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 13" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("3 7 3 5\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    O O _\n" +
                "_ O _ O O _ _\n" +
                "_ _ _ O _ O O\n" +
                "_ _ _ _ O _ O\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 12" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("3 4 3 6\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    O O _\n" +
                "_ O _ _ _ O _\n" +
                "_ _ _ O _ O O\n" +
                "_ _ _ _ O _ O\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 11" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("5 7 3 7\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    O O _\n" +
                "_ O _ _ _ O O\n" +
                "_ _ _ O _ O _\n" +
                "_ _ _ _ O _ _\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 10" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("3 7 3 5\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    O O _\n" +
                "_ O _ _ O _ _\n" +
                "_ _ _ O _ O _\n" +
                "_ _ _ _ O _ _\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 9" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("1 5 1 3\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O _ _\n" +
                "    O O _\n" +
                "_ O _ _ O _ _\n" +
                "_ _ _ O _ O _\n" +
                "_ _ _ _ O _ _\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 8" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("1 3 3 3\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ _ _\n" +
                "    _ O _\n" +
                "_ O O _ O _ _\n" +
                "_ _ _ O _ O _\n" +
                "_ _ _ _ O _ _\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 7" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("3 2 3 4\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ _ _\n" +
                "    _ O _\n" +
                "_ _ _ O O _ _\n" +
                "_ _ _ O _ O _\n" +
                "_ _ _ _ O _ _\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 6" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("3 4 3 6\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ _ _\n" +
                "    _ O _\n" +
                "_ _ _ _ _ O _\n" +
                "_ _ _ O _ O _\n" +
                "_ _ _ _ O _ _\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 5" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("3 6 5 6\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ _ _\n" +
                "    _ O _\n" +
                "_ _ _ _ _ _ _\n" +
                "_ _ _ O _ _ _\n" +
                "_ _ _ _ O O _\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 4" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("5 6 5 4\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ _ _\n" +
                "    _ O _\n" +
                "_ _ _ _ _ _ _\n" +
                "_ _ _ O _ _ _\n" +
                "_ _ _ O _ _ _\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 3" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("5 4 3 4\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ _ _\n" +
                "    _ O _\n" +
                "_ _ _ O _ _ _\n" +
                "_ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 2" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("2 4 4 4\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "_ _ _ _ _ _ _\n" +
                "_ _ _ O _ _ _\n" +
                "_ _ _ _ _ _ _\n" +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "Score: 1" +
                System.lineSeparator()),
        new PrintInteraction(System.lineSeparator() +
                "Game over!" +
                System.lineSeparator() +
                "    _ _ _\n" +
                "    _ _ _\n" +
                "_ _ _ _ _ _ _\n" +
                "_ _ _ O _ _ _\n" +
                "_ _ _ _ _ _ _\n" +
                "    _ _ _\n" +
                "    _ _ _" +
                System.lineSeparator() +
                "Score: 1")
    };

    this.runController(interactions, model, view);
    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullView() {
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, null, input);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(null, view, input);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullReadable() {
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, null);
  }

  @Test
  public void testLongInputGameOver() {
    Interaction[] interactions = new Interaction[]{
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O" +
                "\nScore: 32" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("2 4 4 4 5 4 3 4 7 4 5 4 4 2 4 4 4 4 2 4 2 3 4 3 5 3 3 " +
                "3 3 2 3 4 5 1 5 3 3 1 5 1 6 3 4 3 2 5 2 3 1 3 3 3 3 3 5 3 5 4 5 2 5 1 5 3 " +
                "1 5 1 3 3 5 3 3 3 7 3 5 4 6 4 4 5 6 5 4 5 3 5 5 6 5 4 5 3 5 5 5 5 7 3 7\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O _ _\n" +
                "    _ _ _\n" +
                "_ _ O _ _ _ O\n" +
                "_ _ _ O _ _ _\n" +
                "_ _ _ _ O _ _\n" +
                "    _ _ _\n" +
                "    O _ O\n" +
                "Score: 7" + System.lineSeparator()),
        new PrintInteraction(System.lineSeparator() +
                "Game over!" +
                System.lineSeparator() +
                "    O _ _\n" +
                "    _ _ _\n" +
                "_ _ O _ _ _ O\n" +
                "_ _ _ O _ _ _\n" +
                "_ _ _ _ O _ _\n" +
                "    _ _ _\n" +
                "    O _ O" +
                System.lineSeparator() +
                "Score: 7")
    };

    this.runController(interactions, model, view);
    assertEquals(expectedOutput.toString(), actualOutput.toString());

  }

  @Test
  public void testGameOverInvalidMovesLongInput() {
    Interaction[] interactions = new Interaction[]{
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O" +
                "\nScore: 32" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("2 4 4 a 4 5 4 3 4 7 4 5 4 d 4 2 4 4 4 4 2 4 2 3 4 3 5 " +
                "3 3 3 3 2 3 4 5 1 5 3 3 1 5 1 6 g 3 4 3 2 5 2 3 1 3 y 3 3 i 3 k 3 5 e 3 5 " +
                "4 5 s 2 5 1 5 3 1 5 1 3 f 3 5 3 3 3 7 3 5 4 6 4 x 4 5 bn 6 5 4 5 3 5 5 6 d" +
                " 5 4 5 3 5 5 5 5 7 3 7\n"),
        new PrintInteraction(System.lineSeparator() +
                "    O _ _\n" +
                "    _ _ _\n" +
                "_ _ O _ _ _ O\n" +
                "_ _ _ O _ _ _\n" +
                "_ _ _ _ O _ _\n" +
                "    _ _ _\n" +
                "    O _ O\n" +
                "Score: 7" + System.lineSeparator()),
        new PrintInteraction(System.lineSeparator() +
                "Game over!" +
                System.lineSeparator() +
                "    O _ _\n" +
                "    _ _ _\n" +
                "_ _ O _ _ _ O\n" +
                "_ _ _ O _ _ _\n" +
                "_ _ _ _ O _ _\n" +
                "    _ _ _\n" +
                "    O _ O" +
                System.lineSeparator() +
                "Score: 7")
    };

    this.runController(interactions, model, view);
    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFailedAppendable() {
    view = new MarbleSolitaireTextView(model, null);
  }

  @Test(expected = IllegalStateException.class)
  public void testRunningOutOfInput() {
    Interaction[] interactions = new Interaction[]{
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("2 4 4 4")
    };

    this.runController(interactions, model, view);
    assertEquals(expectedOutput.toString(), actualOutput.toString());

  }

  @Test
  public void testInvalidMove() {
    Interaction[] interactions = new Interaction[]{
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("2 4 7 7\n"),
        new PrintInteraction("Invalid move. Play again. Invalid position (6, 6)" +
                System.lineSeparator() +
                System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("q\n"),
        new PrintInteraction(System.lineSeparator() +
                "Game quit!" +
                System.lineSeparator() +
                "State of game when quit:" +
                System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32")
    };

    this.runController(interactions, model, view);
    assertEquals(expectedOutput.toString(), actualOutput.toString());

  }

  @Test
  public void testCustomModel() {
    Interaction[] interactions = new Interaction[]{
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "    O O O\n" +
                "O O _ O O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("1 3 3 3\n"),
        new PrintInteraction(System.lineSeparator() +
                "    _ O O\n" +
                "    _ O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 31" +
                System.lineSeparator() +
                System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": "),
        new InputInteraction("q\n"),
        new PrintInteraction(System.lineSeparator() +
                "Game quit!" +
                System.lineSeparator() +
                "State of game when quit:" +
                System.lineSeparator() +
                "    _ O O\n" +
                "    _ O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 31")
    };
    model = new EnglishSolitaireModel(2, 2);
    view = new MarbleSolitaireTextView(model, this.actualOutput);
    this.runController(interactions, model, view);
    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test
  public void testNullRenderMessage() {
    try {
      this.view.renderMessage(null);
      fail("Illegally rendered message");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Contains the repeated code used to actually run the controller with the mock
   * inputs/expected outputs and the assertEquals.
   *
   * @param interactions the array of interactions that include the input and expected output.
   */
  public void runController(Interaction[] interactions, MarbleSolitaireModel model,
                            MarbleSolitaireView view) {
    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    this.input = new StringReader(fakeUserInput.toString());

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, input);
    controller.playGame();
  }

  /**
   * Represents an interaction that the user has with the controller. Allows one to test mock
   * user inputs with expected outputs.
   */
  interface Interaction {
    /**
     * Applies the operation of the interaction on either one of the StringBuilder params.
     *
     * @param in  the mock input.
     * @param out the output of the mock input.
     */
    void apply(StringBuilder in, StringBuilder out);
  }

  /**
   * Represents a mock interaction that the user has with the controller. Allows a tester to
   * fake a user input to see how the controller responds.
   */
  private class InputInteraction implements Interaction {
    private String line;

    /**
     * Creates a fake user input interaction.
     *
     * @param line the line to input to the controller.
     */
    InputInteraction(String line) {
      this.line = line;
    }

    @Override
    public void apply(StringBuilder in, StringBuilder out) {
      in.append(line);
    }
  }

  /**
   * Represents the output from a mocked interaction that the user has with the controller.
   * Allows a tester to observe the effect of a fake user input on the controller.
   */
  private class PrintInteraction implements Interaction {
    private String[] lines;

    /**
     * Creates a PrintInteraction to output the program's response.
     *
     * @param lines the lines that are outputted from the program.
     */
    public PrintInteraction(String... lines) {
      this.lines = lines;
    }

    @Override
    public void apply(StringBuilder in, StringBuilder out) {
      for (String line : lines) {
        out.append(line);
      }
    }
  }
}