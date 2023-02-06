import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Tests for the {@code EuropeanSolitaireModel} class. Ensures that all functionality works
 * well, including the constructors, exceptions, and inherited methods.
 */
public class EuropeanSolitaireModelTest {
  private EuropeanSolitaireModel baseModel;
  private EuropeanSolitaireModel changeModel;
  private EuropeanSolitaireModel thickModel;
  private EuropeanSolitaireModel varyModel;
  private MarbleSolitaireView baseView;
  private Appendable actualOutput;
  private StringBuilder fakeUserInput;
  private StringBuilder expectedOutput;
  private Readable input;

  @Before
  public void init() {
    this.baseModel = new EuropeanSolitaireModel();
    this.changeModel = new EuropeanSolitaireModel(4, 4);
    this.thickModel = new EuropeanSolitaireModel(5);
    this.varyModel = new EuropeanSolitaireModel(5, 4, 4);

    this.actualOutput = new StringBuilder();
    this.fakeUserInput = new StringBuilder();
    this.expectedOutput = new StringBuilder();
    this.input = new StringReader(fakeUserInput.toString());

    this.baseView = new MarbleSolitaireTextView(baseModel, actualOutput);
  }

  // test isGameOver for when game is over
  // test isGameover for when game is won
  // test isGameOver for when game is starting (false)

  // test to make sure the board's representation is correct when it is constructed.
  @Test
  public void testDefaultConstructor() {
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(0, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(0, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(0, 4));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 5));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 6));

    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(1, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 4));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 5));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(1, 6));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 4));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 5));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 6));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 5));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 6));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 5));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 6));

    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(5, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 4));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 5));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(5, 6));

    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(6, 0));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(6, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(6, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(6, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(6, 4));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(6, 5));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(6, 6));
  }

  @Test
  public void testTwoArgConstructor() {
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(0, 1));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(0, 2));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(0, 3));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(0, 4));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(0, 5));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(0, 6));

    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(1, 0));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(1, 2));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(1, 3));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(1, 4));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(1, 5));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(1, 6));

    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(2, 0));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(2, 1));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(2, 2));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(2, 4));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(2, 5));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(2, 6));

    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(3, 0));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(3, 5));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(3, 6));

    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 0));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 1));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 3));
    assertEquals(SlotState.Empty, this.changeModel.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 5));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 6));

    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(5, 0));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(5, 1));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(5, 2));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(5, 3));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(5, 4));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(5, 5));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(5, 6));

    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(6, 0));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(6, 1));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(6, 2));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(6, 3));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(6, 4));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(6, 5));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(6, 6));
  }

  @Test
  public void testOneArgConstructor() {
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 1));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 2));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(0, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(0, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(0, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(0, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(0, 8));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 9));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 10));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 11));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(0, 12));

    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 0));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 8));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 9));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 10));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 11));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 12));

    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 0));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 8));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 9));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 10));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 11));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 12));

    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(3, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 8));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 9));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 10));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 11));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(3, 12));

    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 8));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 9));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 10));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 11));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 12));

    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 8));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 9));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 10));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 11));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(5, 12));

    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 5));
    assertEquals(SlotState.Empty, this.thickModel.getSlotAt(6, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 8));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 9));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 10));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 11));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 12));

    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 8));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 9));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 10));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 11));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(7, 12));

    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 8));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 9));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 10));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 11));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(8, 12));

    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(9, 0));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 8));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 9));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 10));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 11));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(9, 12));

    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(10, 0));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(10, 1));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 8));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 9));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 10));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(10, 11));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(10, 12));

    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(11, 0));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(11, 1));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(11, 2));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(11, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(11, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(11, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(11, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(11, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(11, 8));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(11, 9));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(11, 10));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(11, 11));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(11, 12));

    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(12, 0));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(12, 1));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(12, 2));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(12, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(12, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(12, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(12, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(12, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(12, 8));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(12, 9));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(12, 10));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(12, 11));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(12, 12));
  }

  @Test
  public void testThreeArgConstructor() {
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 1));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 2));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(0, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(0, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(0, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(0, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(0, 8));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 9));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 10));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 11));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(0, 12));

    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 0));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 8));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 9));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 10));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 11));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 12));

    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 0));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 8));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 9));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 10));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 11));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 12));

    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(3, 0));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 8));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 9));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 10));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 11));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(3, 12));

    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 0));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 3));
    assertEquals(SlotState.Empty, this.varyModel.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 8));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 9));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 10));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 11));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 12));

    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 0));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 8));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 9));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 10));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 11));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(5, 12));

    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 0));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 8));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 9));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 10));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 11));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(6, 12));

    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 0));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 8));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 9));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 10));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 11));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(7, 12));

    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 0));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 8));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 9));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 10));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 11));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(8, 12));

    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(9, 0));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 8));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 9));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 10));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 11));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(9, 12));

    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(10, 0));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(10, 1));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 8));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 9));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 10));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(10, 11));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(10, 12));

    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(11, 0));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(11, 1));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(11, 2));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(11, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(11, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(11, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(11, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(11, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(11, 8));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(11, 9));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(11, 10));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(11, 11));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(11, 12));

    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(12, 0));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(12, 1));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(12, 2));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(12, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(12, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(12, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(12, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(12, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(12, 8));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(12, 9));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(12, 10));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(12, 11));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(12, 12));
  }

  // tests to make sure the proper exceptions are thrown during construction of a
  // EuropeanSolitaireModel object.
  @Test
  public void testTwoArgConstructorExceptions() {
    try {
      this.changeModel = new EuropeanSolitaireModel(-10, -10);
      fail("Illegally created EuropeanSolitaireModel with empty slot at -10, -10");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.changeModel = new EuropeanSolitaireModel(10, 10);
      fail("Illegally created EuropeanSolitaireModel with empty slot at 10, 10");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testOneArgConstructorExceptions() {
    try {
      this.thickModel = new EuropeanSolitaireModel(-19);
      fail("Illegally created EuropeanSolitaireModel with arm thickness -19.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.changeModel = new EuropeanSolitaireModel(12);
      fail("Illegally created EuropeanSolitaireModel with arm thickness 12.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testThreeArgConstructorExceptions() {
    try {
      this.varyModel = new EuropeanSolitaireModel(3, -10, 40);
      fail("Illegally created EuropeanSolitaireModel with empty slot -10, -4.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.varyModel = new EuropeanSolitaireModel(32, 4, 4);
      fail("Illegally created EuropeanSolitaireModel with arm thickness 32.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.varyModel = new EuropeanSolitaireModel(-23, 4, 4);
      fail("Illegally created EuropeanSolitaireModel with arm thickness -23.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testBadArmThickness() {
    try {
      this.thickModel = new EuropeanSolitaireModel(2);
      fail("Illegally created European Model with arm thickness 2.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.thickModel = new EuropeanSolitaireModel(-13);
      fail("Illegally created European Model with arm thickness -13.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testBadEmptySlot() {
    try {
      this.changeModel = new EuropeanSolitaireModel(0, 0);
      fail("Illegally created European Model with empty slot at 0,0.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.changeModel = new EuropeanSolitaireModel(50, 50);
      fail("Illegally created European Model with empty slot at 50,50.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.changeModel = new EuropeanSolitaireModel(-10, -10);
      fail("Illegally created European Model with empty slot at -10,-10.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  // tests that the move command works properly and that the proper exceptions are thrown when
  // it is needed.
  @Test
  public void testMove() {
    // moving up
    this.baseModel.move(1, 3, 3, 3);
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(1, 3));
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 3));

    // moving left
    this.changeModel.move(6, 4, 4, 4);
    assertEquals(SlotState.Empty, this.changeModel.getSlotAt(6, 4));
    assertEquals(SlotState.Empty, this.changeModel.getSlotAt(5, 4));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 4));

    // moving right
    this.thickModel.move(4, 6, 6, 6);
    assertEquals(SlotState.Empty, this.thickModel.getSlotAt(4, 6));
    assertEquals(SlotState.Empty, this.thickModel.getSlotAt(5, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 6));

    // moving down
    this.varyModel.move(6, 4, 4, 4);
    assertEquals(SlotState.Empty, this.varyModel.getSlotAt(6, 4));
    assertEquals(SlotState.Empty, this.varyModel.getSlotAt(5, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 4));
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
      fail("Illegally moved from 0, 0, to 6, 6");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.baseModel.move(4, 4, 6, 6);
      fail("Illegally moved from 4, 4, to 6, 6");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.baseModel.move(5, 3, 3, 3);
      this.baseModel.move(3, 6, 3, 4);
      fail("Illegally moved from 3, 6, to 3, 4 with no middle marble.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

  }

  // tests that the view is working as intended
  @Test
  public void testViewExceptions() {
    try {
      this.baseView = new MarbleSolitaireTextView(null);
      fail("Illegally created view with null model");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.baseView = new MarbleSolitaireTextView(null, actualOutput);
      fail("Illegally created view with null model");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.baseView = new MarbleSolitaireTextView(this.baseModel, null);
      fail("Illegally created view with null appendable");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.baseView = new MarbleSolitaireTextView(null, null);
      fail("Illegally created view with null model and null appendable.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testViewAfterOneMove() {
    this.baseModel.move(1, 3, 3, 3);
    assertEquals("    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O",
            this.baseView.toString());
  }

  // tests that the score is reported properly.
  @Test
  public void testGetScore() {
    assertEquals(36, this.baseModel.getScore());
    this.baseModel.move(1, 3, 3, 3);
    assertEquals(35, this.baseModel.getScore());
  }

  // tests that the game over state is reported properly.
  @Test
  public void testIsGameOver() {
    // TODO: test game over when game is won
    // TODO: test game over when game is lost
    // TODO: test game over when game is started
    assertFalse(this.baseModel.isGameOver());
    assertFalse(this.changeModel.isGameOver());
    assertFalse(this.thickModel.isGameOver());
    assertFalse(this.varyModel.isGameOver());
  }

  // tests that the game's representation is correct after a move.
  @Test
  public void testGameAfterMove() {
    this.baseModel.move(1, 3, 3, 3);
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(0, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(0, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(0, 4));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 5));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 6));

    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(1, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 2));
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(1, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 4));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 5));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(1, 6));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 2));
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 4));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 5));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(2, 6));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 5));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 6));

    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 5));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(4, 6));

    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(5, 0));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 4));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 5));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(5, 6));

    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(6, 0));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(6, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(6, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(6, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(6, 4));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(6, 5));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(6, 6));
  }

  // tests that the board size is correct.
  @Test
  public void testGetBoardSize() {
    assertEquals(7, this.baseModel.getBoardSize());
    assertEquals(7, this.changeModel.getBoardSize());
    assertEquals(13, this.thickModel.getBoardSize());
    assertEquals(13, this.varyModel.getBoardSize());
  }

  // tests that the state of a slot is reported properly
  @Test
  public void testGetSlotAt() {
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(0, 0));
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 3));
  }

  // tests that the board is rendered correctly via the controller and view
  @Test
  public void testRenderBoard() {
    Interaction[] interactions = new Interaction[]{
        new PrintInteraction(System.lineSeparator() +
                "    O O O\n" +
                "  O O O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "  O O O O O\n" +
                "    O O O\n" +
                "Score: 36" +
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
                "  O O O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "  O O O O O\n" +
                "    O O O\n" +
                "Score: 36")
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