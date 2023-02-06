import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for the {@code TriangleSolitaireModel} class. Ensures that all functionality is
 * working properly, including constructors, exceptions, and inherited methods.
 */
public class TriangleSolitaireModelTest {
  private TriangleSolitaireModel baseModel;
  private TriangleSolitaireModel changeModel;
  private TriangleSolitaireModel thickModel;
  private TriangleSolitaireModel varyModel;
  private TriangleSolitaireTextView baseView;
  private Appendable actualOutput;
  private StringBuilder fakeUserInput;
  private StringBuilder expectedOutput;
  private Readable input;

  @Before
  public void init() {
    this.baseModel = new TriangleSolitaireModel();
    actualOutput = new StringBuilder();
    this.baseView = new TriangleSolitaireTextView(baseModel, actualOutput);

    fakeUserInput = new StringBuilder();
    expectedOutput = new StringBuilder();
    input = new StringReader(fakeUserInput.toString());

    this.changeModel = new TriangleSolitaireModel(3, 1);
    this.thickModel = new TriangleSolitaireModel(7);
    this.varyModel = new TriangleSolitaireModel(6, 3, 1);
  }

  @Test
  public void testDefaultConstructor() {
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 1));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 2));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 3));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 4));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(1, 2));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(1, 3));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(1, 4));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 2));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(2, 3));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(2, 4));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 3));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(3, 4));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 4));
  }

  @Test
  public void testTwoArgConstructor() {
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(0, 1));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(0, 2));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(0, 3));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(0, 4));

    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(1, 0));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(1, 2));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(1, 3));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(1, 4));

    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(2, 0));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(2, 1));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(2, 2));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(2, 3));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(2, 4));

    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(3, 0));
    assertEquals(SlotState.Empty, this.changeModel.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(3, 3));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(3, 4));

    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 0));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 1));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 4));
  }

  @Test
  public void testOneArgConstructor() {
    assertEquals(SlotState.Empty, this.thickModel.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 1));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 2));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 3));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 4));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 5));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 6));

    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 2));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 3));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 4));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 5));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 6));

    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 2));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 3));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 4));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 5));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 6));

    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 3));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(3, 4));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(3, 5));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(3, 6));

    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 4));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(4, 5));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(4, 6));

    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 5));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(5, 6));

    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 6));
  }

  @Test
  public void testThreeArgConstructor() {
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 1));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 2));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 3));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 4));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 5));

    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 0));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 2));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 3));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 4));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 5));

    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 0));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 2));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 3));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 4));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 5));

    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 0));
    assertEquals(SlotState.Empty, this.varyModel.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 3));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(3, 4));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(3, 5));

    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 0));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 4));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(4, 5));

    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 0));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 5));
  }

  @Test
  public void testTwoArgConstructorExceptions() {
    try {
      this.changeModel = new TriangleSolitaireModel(-10, -10);
      fail("Illegally created TriangleSolitaireModel with empty slot at -10, -10");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.changeModel = new TriangleSolitaireModel(10, 10);
      fail("Illegally created TriangleSolitaireModel with empty slot at 10, 10");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testOneArgConstructorExceptions() {
    try {
      this.thickModel = new TriangleSolitaireModel(-19);
      fail("Illegally created TriangleSolitaireModel with side length -19.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testThreeArgConstructorExceptions() {
    try {
      this.varyModel = new TriangleSolitaireModel(3, -10, 40);
      fail("Illegally created TriangleSolitaireModel with empty slot -10, -4.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.varyModel = new TriangleSolitaireModel(-23, 3, 1);
      fail("Illegally created TriangleSolitaireModel with side length -23.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testBadEmptySlot() {
    try {
      this.changeModel = new TriangleSolitaireModel(50, 50);
      fail("Illegally created TriangleSolitaireModel with empty slot at 50,50.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.changeModel = new TriangleSolitaireModel(-10, -10);
      fail("Illegally created TriangleSolitaireModel with empty slot at -10,-10.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testMove() {
    // up right
    this.baseModel.move(2, 0, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, baseModel.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, baseModel.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, baseModel.getSlotAt(2, 0));

    // right
    this.baseModel.move(2, 2, 2, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, baseModel.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, baseModel.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, baseModel.getSlotAt(2, 2));

    // up left
    this.baseModel.move(4, 4, 2, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, baseModel.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, baseModel.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, baseModel.getSlotAt(4, 4));

    // down right
    this.baseModel.move(1, 1, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, baseModel.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, baseModel.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, baseModel.getSlotAt(1, 1));

    // down left
    this.changeModel.move(1, 1, 3, 1);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, changeModel.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, changeModel.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, changeModel.getSlotAt(1, 1));

    this.changeModel.move(4, 3, 2, 1);
    this.changeModel.move(4, 1, 4, 3);

    // left
    this.changeModel.move(4, 4, 4, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, changeModel.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, changeModel.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, changeModel.getSlotAt(4, 4));

    this.varyModel.move(5, 3, 3, 1);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, varyModel.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, varyModel.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, varyModel.getSlotAt(5, 3));
  }

  @Test
  public void testMoveExceptions() {
    try {
      this.baseModel.move(-10, 0, -10, 2);
      fail("Illegally moved from -10, 0, to -10, 2");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.baseModel.move(0, 2, -2, 2);
      fail("Illegally moved from 0, 2, to -2, 2");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.baseModel.move(0, 0, 0, 2);
      fail("Illegally moved from 0, 0, to 0, 2");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.baseModel.move(0, 2, 0, 0);
      fail("Illegally moved from 0, 2, to 0, 0");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.baseModel.move(0, 0, 6, 6);
      fail("Illegally moved from 0, 0, to 4, 4");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.baseModel.move(2, 2, 0, 0);
      this.baseModel.move(0, 0, 2, 2);
      fail("Illegally moved from 2, 2, to 0, 0 with no middle marble.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testGetScore() {
    assertEquals(14, this.baseModel.getScore());
    this.baseModel.move(2, 2, 0, 0);
    assertEquals(13, this.baseModel.getScore());
  }

  @Test
  public void testIsGameOver() {
    assertFalse(this.baseModel.isGameOver());
    this.baseModel.move(2, 0, 0, 0);
    this.baseModel.move(4, 2, 2, 0);
    this.baseModel.move(3, 0, 1, 0);
    this.baseModel.move(0, 0, 2, 0);
    this.baseModel.move(4, 0, 4, 2);
    this.baseModel.move(4, 3, 4, 1);
    this.baseModel.move(2, 1, 4, 3);
    this.baseModel.move(4, 4, 4, 2);
    this.baseModel.move(4, 1, 4, 3);
    assertTrue(this.baseModel.isGameOver());

  }

  @Test
  public void testGameAfterMove() {
    this.baseModel.move(2, 2, 0, 0);
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 1));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 2));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 3));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 4));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 0));
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(1, 2));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(1, 3));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(1, 4));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 1));
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(2, 2));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(2, 3));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(2, 4));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 3));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(3, 4));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 4));
  }

  @Test
  public void testGetBoardSize() {
    assertEquals(5, this.baseModel.getBoardSize());
    assertEquals(5, this.changeModel.getBoardSize());
    assertEquals(7, this.thickModel.getBoardSize());
    assertEquals(6, this.varyModel.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 1));
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 0));
  }

  @Test
  public void testRenderBoard() {
    Interaction[] interactions = new Interaction[]{
        new PrintInteraction(System.lineSeparator() +
                "    _\n" +
                "   O O\n" +
                "  O O O\n" +
                " O O O O\n" +
                "O O O O O\n" +
                "\nScore: 14" +
                System.lineSeparator()),
        new InputInteraction("q\n"),
        new PrintInteraction(System.lineSeparator() +
                "What is your next move, formatted \"fromRow fromCol toRow toCol\": " +
                System.lineSeparator() +
                "Game quit!" +
                System.lineSeparator() +
                "State of game when quit:" +
                System.lineSeparator() +
                "    _\n" +
                "   O O\n" +
                "  O O O\n" +
                " O O O O\n" +
                "O O O O O\n" +
                "\nScore: 14")
    };
    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    this.input = new StringReader(fakeUserInput.toString());

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(baseModel,
            baseView, input);
    controller.playGame();

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

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