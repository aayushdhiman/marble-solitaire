import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests for {@code EnglishSolitaireModel}.
 */
public class EnglishSolitaireModelTest {
  private EnglishSolitaireModel baseModel;
  private EnglishSolitaireModel baseModel2;
  private EnglishSolitaireModel changeModel;
  private EnglishSolitaireModel thickModel;
  private EnglishSolitaireModel varyModel;

  private MarbleSolitaireTextView baseMarbleView;
  private MarbleSolitaireTextView changeMarbleView;
  private MarbleSolitaireTextView thickMarbleView;
  private MarbleSolitaireTextView varyMarbleView;

  @Before
  // initializes the variables needed for the tests
  public void init() {
    this.baseModel = new EnglishSolitaireModel();
    this.baseModel2 = new EnglishSolitaireModel();
    this.changeModel = new EnglishSolitaireModel(4, 3);
    this.thickModel = new EnglishSolitaireModel(5);
    this.varyModel = new EnglishSolitaireModel(5, 4, 4);

    this.baseMarbleView = new MarbleSolitaireTextView(this.baseModel);
    this.changeMarbleView = new MarbleSolitaireTextView(this.changeModel);
    this.thickMarbleView = new MarbleSolitaireTextView(this.thickModel);
    this.varyMarbleView = new MarbleSolitaireTextView(this.varyModel);

  }

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
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 4));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(1, 5));
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
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(5, 1));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 2));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(5, 4));
    assertEquals(SlotState.Invalid, this.baseModel.getSlotAt(5, 5));
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
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(1, 2));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(1, 3));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(1, 4));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(1, 5));
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
    assertEquals(SlotState.Empty, this.changeModel.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 5));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 6));

    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(5, 0));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(5, 1));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(5, 2));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(5, 3));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(5, 4));
    assertEquals(SlotState.Invalid, this.changeModel.getSlotAt(5, 5));
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
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(1, 8));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 9));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 10));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 11));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(1, 12));

    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 0));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 1));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 2));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(2, 8));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 9));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 10));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 11));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(2, 12));

    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(3, 0));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(3, 1));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(3, 2));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(3, 8));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(3, 9));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(3, 10));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(3, 11));
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
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(9, 1));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(9, 2));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(9, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(9, 8));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(9, 9));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(9, 10));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(9, 11));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(9, 12));

    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(10, 0));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(10, 1));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(10, 2));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(10, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(10, 8));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(10, 9));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(10, 10));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(10, 11));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(10, 12));

    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(11, 0));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(11, 1));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(11, 2));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(11, 3));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(11, 4));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(11, 5));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(11, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(11, 7));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(11, 8));
    assertEquals(SlotState.Invalid, this.thickModel.getSlotAt(11, 9));
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
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(1, 8));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 9));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 10));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 11));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(1, 12));

    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 0));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 1));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 2));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 8));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 9));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 10));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 11));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(2, 12));

    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(3, 0));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(3, 1));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(3, 2));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(3, 8));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(3, 9));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(3, 10));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(3, 11));
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
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(9, 1));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(9, 2));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(9, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(9, 8));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(9, 9));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(9, 10));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(9, 11));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(9, 12));

    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(10, 0));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(10, 1));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(10, 2));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(10, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(10, 8));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(10, 9));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(10, 10));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(10, 11));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(10, 12));

    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(11, 0));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(11, 1));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(11, 2));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(11, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(11, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(11, 5));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(11, 6));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(11, 7));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(11, 8));
    assertEquals(SlotState.Invalid, this.varyModel.getSlotAt(11, 9));
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

  @Test
  // tests exceptions in the constructor and prints caught exceptions
  public void testConstructorExceptions() {
    try {
      this.changeModel = new EnglishSolitaireModel(8, 8);
      fail("EnglishSolitaireModel with empty slot at 0, 1 created illegally.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    try {
      this.changeModel = new EnglishSolitaireModel(-1, 0);
      fail("EnglishSolitaireModel with empty slot at 1, 0 created illegally.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    try {
      this.thickModel = new EnglishSolitaireModel(4);
      fail("EnglishSolitaireModel with arm thickness 4 created illegally.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    try {
      this.varyModel = new EnglishSolitaireModel(4, 3, 3);
      fail("EnglishSolitaireModel with arm thickness 4 and empty slot at 3, 3 created illegally" +
              ".");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    try {
      this.varyModel = new EnglishSolitaireModel(3, 0, 1);
      fail("EnglishSolitaireModel with arm thickness 3 and empty slot at 0, 1 created illegally" +
              ".");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    try {
      this.varyModel = new EnglishSolitaireModel(3, 3, 7);
      fail("EnglishSolitaireModel with  arm thickness 3 and empty slot at 1, 0 created " +
              "illegally" +
              ".");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  // tests moving on each board
  public void testMove() {
    this.baseModel.move(1, 3, 3, 3);
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(1, 3));
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(3, 3));

    this.changeModel.move(2, 3, 4, 3);
    assertEquals(SlotState.Empty, this.changeModel.getSlotAt(2, 3));
    assertEquals(SlotState.Empty, this.changeModel.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(4, 3));

    this.thickModel.move(4, 6, 6, 6);
    assertEquals(SlotState.Empty, this.thickModel.getSlotAt(4, 6));
    assertEquals(SlotState.Empty, this.thickModel.getSlotAt(5, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(6, 6));

    this.varyModel.move(4, 2, 4, 4);
    assertEquals(SlotState.Empty, this.varyModel.getSlotAt(4, 2));
    assertEquals(SlotState.Empty, this.varyModel.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(4, 4));

    try {
      this.changeModel.move(-10, 0, 0, 0);
      fail("Illegally moved from -10, 0, to 0, 0");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.changeModel.move(1, 3, -1, 3);
      fail("Illegally moved from 1, 3, to -1, 3");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.changeModel.move(0, 0, 0, 2);
      fail("Illegally moved from 0, 0 to 0, 2");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.changeModel.move(3, 3, 5, 3);
      fail("Illegally moved from 3, 3 to 5, 3");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.changeModel.move(2, 3, 4, 3);
      this.changeModel.move(4, 3, 2, 3);
      fail("Illegally moved from 4, 3 to 2, 3, when there is no marble in middle.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.changeModel.move(2, 3, 6, 3);
      fail("Illegally moved from 2, 3 to 6, 3");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      this.changeModel.move(3, 2, 4, 3);
      fail("Illegally moved from 3, 2 to 4, 3");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

  }

  @Test
  public void testViewExceptions() {
    try {
      this.baseMarbleView = new MarbleSolitaireTextView(null);
      fail("Illegally created view with null model.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testViewAfterOneMove() {
    this.baseModel.move(1, 3, 3, 3);
    assertEquals("    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            this.baseMarbleView.toString());
  }

  @Test
  // tests if the game is over at the beginning of the game, after beating the game, and if
  // there are no possible moves left
  public void testIsGameOver() {
    assertFalse(this.baseModel.isGameOver());
    assertFalse(this.changeModel.isGameOver());
    assertFalse(this.thickModel.isGameOver());
    assertFalse(this.varyModel.isGameOver());

    this.baseModel2.move(3, 1, 3, 3);
    this.baseModel2.move(5, 2, 3, 2);
    this.baseModel2.move(4, 0, 4, 2);
    this.baseModel2.move(4, 3, 4, 1);
    this.baseModel2.move(4, 5, 4, 3);
    this.baseModel2.move(6, 4, 4, 4);
    this.baseModel2.move(3, 4, 5, 4);
    this.baseModel2.move(6, 2, 6, 4);
    this.baseModel2.move(6, 4, 4, 4);
    this.baseModel2.move(2, 2, 4, 2);
    this.baseModel2.move(0, 2, 2, 2);
    this.baseModel2.move(1, 4, 3, 4);
    this.baseModel2.move(3, 4, 5, 4);
    this.baseModel2.move(5, 4, 5, 2);
    this.baseModel2.move(5, 2, 3, 2);
    this.baseModel2.move(3, 2, 1, 2);
    this.baseModel2.move(2, 0, 4, 0);
    this.baseModel2.move(4, 0, 4, 2);
    this.baseModel2.move(4, 2, 4, 4);
    this.baseModel2.move(2, 6, 2, 4);
    this.baseModel2.move(2, 3, 2, 5);
    this.baseModel2.move(4, 6, 2, 6);
    this.baseModel2.move(2, 6, 2, 4);
    this.baseModel2.move(0, 4, 0, 2);
    this.baseModel2.move(0, 2, 2, 2);
    this.baseModel2.move(2, 1, 2, 3);
    this.baseModel2.move(2, 3, 2, 5);
    this.baseModel2.move(2, 5, 4, 5);
    this.baseModel2.move(4, 5, 4, 3);
    this.baseModel2.move(4, 3, 2, 3);
    this.baseModel2.move(1, 3, 3, 3);
    assertTrue(this.baseModel2.isGameOver());

    this.baseModel.move(1, 3, 3, 3);
    this.baseModel.move(4, 3, 2, 3);
    this.baseModel.move(6, 3, 4, 3);
    this.baseModel.move(3, 1, 3, 3);
    this.baseModel.move(3, 3, 1, 3);
    this.baseModel.move(1, 2, 3, 2);
    this.baseModel.move(4, 2, 2, 2);
    this.baseModel.move(2, 1, 2, 3);
    this.baseModel.move(4, 0, 4, 2);
    this.baseModel.move(2, 0, 4, 0);
    this.baseModel.move(5, 2, 3, 2);
    this.baseModel.move(1, 4, 1, 2);
    this.baseModel.move(0, 2, 2, 2);
    this.baseModel.move(2, 2, 4, 2);
    this.baseModel.move(4, 3, 4, 1);
    this.baseModel.move(4, 0, 4, 2);
    this.baseModel.move(0, 4, 0, 2);
    this.baseModel.move(2, 4, 2, 2);
    this.baseModel.move(2, 6, 2, 4);
    this.baseModel.move(3, 5, 3, 3);
    this.baseModel.move(4, 5, 4, 3);
    this.baseModel.move(4, 2, 4, 4);
    this.baseModel.move(5, 4, 3, 4);
    this.baseModel.move(2, 4, 4, 4);
    this.baseModel.move(4, 6, 2, 6);
    assertTrue(this.baseModel.isGameOver());

  }

  @Test
  // tests the math for getBoardSize
  public void testGetBoardSize() {
    assertEquals(7, this.baseModel.getBoardSize());
    assertEquals(7, this.changeModel.getBoardSize());
    assertEquals(13, this.thickModel.getBoardSize());
    assertEquals(13, this.varyModel.getBoardSize());
  }

  @Test
  // tests all three slot states for getSlotAt
  public void testGetSlotAt() {
    assertEquals(SlotState.Empty, this.baseModel.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, this.baseModel.getSlotAt(1, 3));

    assertEquals(SlotState.Empty, this.changeModel.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, this.changeModel.getSlotAt(2, 3));

    assertEquals(SlotState.Empty, this.thickModel.getSlotAt(6, 6));
    assertEquals(SlotState.Marble, this.thickModel.getSlotAt(4, 5));

    assertEquals(SlotState.Empty, this.varyModel.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, this.varyModel.getSlotAt(2, 4));
  }

  @Test
  // tests the score at the start of the game and when a move is made
  public void testGetScore() {
    assertEquals(32, this.baseModel.getScore());
    this.baseModel.move(1, 3, 3, 3);
    assertEquals(31, this.baseModel.getScore());
  }

  @Test
  // tests the visual representation of the game
  public void testToString() {
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            this.baseMarbleView.toString());
    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "    O O O\n" +
                    "    O O O",
            this.changeMarbleView.toString());
    assertEquals("        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O",
            this.thickMarbleView.toString());
    assertEquals("        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O _ O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O",
            this.varyMarbleView.toString());
  }
}