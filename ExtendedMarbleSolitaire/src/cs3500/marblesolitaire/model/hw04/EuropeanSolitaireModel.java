package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a European Solitaire Model. This is a solitaire model that is arranged as an octagon
 * . The board will, by default, have a side length of three with the empty slot in the middle.
 */
public class EuropeanSolitaireModel extends AbstractModel {
  private final int armThickness;
  private final int boardSize;

  /**
   * Creates an {@code EuropeanSolitaireModel} with a side length of three and the empty slot in
   * the middle.
   */
  public EuropeanSolitaireModel() {
    this.armThickness = 3;
    super.armThickness = 3;

    this.boardSize = calculateBoardSize(this.armThickness);
    super.boardSize = calculateBoardSize(this.armThickness);

    super.board = this.createBoard(this.boardSize / 2, this.boardSize / 2);

    super.score = calculateScore(this.armThickness, this.boardSize);
  }

  /**
   * Creates an {@code EuropeanSolitaireModel} with a specified side length and the empty slot in
   * the middle.
   *
   * @param armThickness the side length of the model.
   * @throws IllegalArgumentException if the side length is not even.
   */
  public EuropeanSolitaireModel(int armThickness) throws IllegalArgumentException {
    if (this.checkArmThickness(armThickness)) {
      this.armThickness = armThickness;
      super.armThickness = armThickness;
    } else {
      throw new IllegalArgumentException("Side length is invalid.");
    }

    this.boardSize = calculateBoardSize(this.armThickness);
    super.boardSize = calculateBoardSize(this.armThickness);
    super.board = this.createBoard(this.boardSize / 2, this.boardSize / 2);
    super.score = calculateScore(this.armThickness, this.boardSize);
  }

  /**
   * Creates an {@code EuropeanSolitaireModel} with a side length of three and the empty slot
   * at the specified position.
   *
   * @param sRow the specified row of the empty slot.
   * @param sCol the specified column of the empty slot.
   * @throws IllegalArgumentException if the specified position is out of bounds.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this.armThickness = 3;
    super.armThickness = 3;
    this.boardSize = this.calculateBoardSize(this.armThickness);
    super.boardSize = this.calculateBoardSize(this.armThickness);
    super.board = this.createBoard(this.boardSize / 2, this.boardSize / 2);
    super.board = this.createBoard(sRow, sCol);
    super.score = calculateScore(this.armThickness, this.boardSize);
  }

  /**
   * Creates an {@code EuropeanSolitaireModel} with a specified side length and specified empty
   * slot position.
   *
   * @param armThickness the specified side length of the board.
   * @param sRow         the specified row of the empty slot.
   * @param sCol         the specified column of the empty slot.
   * @throws IllegalArgumentException if any of the parameters are invalid.
   */
  public EuropeanSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    if (this.checkArmThickness(armThickness)) {
      this.armThickness = armThickness;
      super.armThickness = armThickness;
    } else {
      throw new IllegalArgumentException("Side length is invalid.");
    }

    this.boardSize = calculateBoardSize(this.armThickness);
    super.boardSize = calculateBoardSize(this.armThickness);
    super.board = this.createBoard(sRow, sCol);
    super.score = calculateScore(this.armThickness, this.boardSize);
  }

  @Override
  protected int calculateScore(int armThickness, int boardSize) {
    return (int) (Math.pow(boardSize - 2, 2) + 4 * armThickness) - 1;
  }

  /**
   * Builds the board into an {@code ArrayList} of a list of {@code SlotState}.
   *
   * @param sRow the row of the empty slot.
   * @param sCol the column of the empty slot.
   * @return the filled starting board.
   */
  @Override
  protected ArrayList<List<SlotState>> createBoard(int sRow, int sCol)
          throws IllegalArgumentException {
    ArrayList<List<SlotState>> tempBoard = new ArrayList<>();
    for (int i = 0; i < this.boardSize; i += 1) {
      tempBoard.add(new ArrayList<SlotState>());
    }

    int numInvalids = this.armThickness - 1;
    for (int row = 0; row < this.boardSize; row += 1) {
      if (row < (this.boardSize / 2) - (this.armThickness / 2)) {
        this.addInvalidSlots(tempBoard, row, numInvalids);
        numInvalids--;
      } else if (row > (this.boardSize / 2) + (this.armThickness / 2)) {
        numInvalids += 1;
        this.addInvalidSlots(tempBoard, row, numInvalids);
      } else {
        for (int col = 0; col < this.boardSize; col += 1) {
          tempBoard.get(row).add(SlotState.Marble);
        }
      }
    }

    placeEmptySlot(tempBoard, sRow, sCol);
    return tempBoard;
  }

  private void addInvalidSlots(ArrayList<List<SlotState>> tempBoard, int row, int numInvalids) {
    for (int col = 0; col < this.boardSize; col += 1) {
      if (col < numInvalids || col > this.boardSize - numInvalids - 1) {
        tempBoard.get(row).add(SlotState.Invalid);
      } else {
        tempBoard.get(row).add(SlotState.Marble);
      }
    }
  }
}