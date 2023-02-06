package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;
import java.util.List;

import cs3500.marblesolitaire.model.hw04.AbstractModel;

/**
 * Represents the English version of the marble solitaire game. This is a board that is
 * built using a cross with the arm thickness of 3.
 */
public class EnglishSolitaireModel extends AbstractModel {
  private final int armThickness;
  private final int boardSize;

  /**
   * Creates an {@code EnglishSolitaireModel} with an {@code armThickness} of 3 and a board
   * with the empty slot at the center.
   */
  public EnglishSolitaireModel() {
    this.armThickness = 3;
    super.armThickness = 3;

    this.boardSize = this.calculateBoardSize(this.armThickness);
    super.boardSize = this.calculateBoardSize(this.armThickness);

    super.board = this.createBoard(this.boardSize / 2, this.boardSize / 2);

    super.score = this.calculateScore(this.armThickness, this.boardSize);

  }

  /**
   * Creates an {@code EnglishSolitaireModel} with an {@code armThickness} of 3 and a board
   * with the empty slot at ({@code sRow}, {@code sCol}).
   *
   * @param sRow The row of the empty slot.
   * @param sCol The column of the empty slot.
   * @throws IllegalArgumentException The {@code sRow} and {@code sCol} parameters must be
   *                                  within range of the board, or the constructor will
   *                                  throw an IllegalArgumentException.
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this.armThickness = 3;
    super.armThickness = 3;
    this.boardSize = this.calculateBoardSize(this.armThickness);
    super.boardSize = this.calculateBoardSize(this.armThickness);
    super.board = this.createBoard(sRow, sCol);
    super.score = this.calculateScore(this.armThickness, this.boardSize);

  }

  /**
   * Creates an {@code EnglishSolitaireModel} with an {@code armThickness} of {@code
   * armThickness} and a board with the empty slot at the center.
   *
   * @param armThickness The arm thickness of the board.
   * @throws IllegalArgumentException The arm thickness must be an odd number, or an
   *                                  IllegalArgumentException will be thrown.
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    // Checks if armThickness is even
    checkArmThickness(armThickness);

    this.armThickness = armThickness;
    super.armThickness = armThickness;
    this.boardSize = this.calculateBoardSize(this.armThickness);
    super.boardSize = this.calculateBoardSize(this.armThickness);
    super.board = this.createBoard(this.boardSize / 2, this.boardSize / 2);
    super.score = this.calculateScore(this.armThickness, this.boardSize);

  }

  /**
   * Creates an {@code EnglishSolitaireModel} with an {@code armThickness} of {@code
   * armThickness} and a board with the empty slot at ({@code sRow},{@code sCol}).
   *
   * @param armThickness The arm thickness of the board.
   * @param sRow         The row of the empty slot.
   * @param sCol         The column of the empty slot.
   * @throws IllegalArgumentException The arm thickness must be an odd number, or an
   *                                  IllegalArgumentException will be thrown, and the location
   *                                  of the empty slot must be within board range.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {

    // Checks if armThickness is even
    checkArmThickness(armThickness);

    this.armThickness = armThickness;
    super.armThickness = armThickness;
    this.boardSize = this.calculateBoardSize(this.armThickness);
    super.boardSize = this.calculateBoardSize(this.armThickness);
    super.board = this.createBoard(sRow, sCol);
    super.score = this.calculateScore(this.armThickness, this.boardSize);
  }

  @Override
  protected int calculateScore(int armThickness, int boardSize) {
    return (int) (Math.pow(this.armThickness, 2) +
            (4 * ((this.armThickness - 1) * this.armThickness)) - 1);
  }

  /**
   * Builds the board for the marble solitaire game to be played on.
   *
   * @param sRow The row that the empty slot should be in.
   * @param sCol The column that the empty slot should be in.
   * @return The board as an ArrayList of ArrayLists of Strings.
   */
  @Override
  protected ArrayList<List<SlotState>> createBoard(int sRow, int sCol)
          throws IllegalArgumentException {
    ArrayList<List<SlotState>> tempBoard = new ArrayList<List<SlotState>>();

    // Add rows to the tempBoard.
    for (int i = 0; i < this.boardSize; i += 1) {
      tempBoard.add(new ArrayList<SlotState>());
    }

    // Fills in SlotState.Invalid and SlotState.Marble in the correct locations on the board.
    for (int row = 0; row < this.boardSize; row += 1) {
      for (int col = 0; col < this.boardSize; col += 1) {
        if (col <= this.armThickness - 2
                && row <= this.armThickness - 2) {
          tempBoard.get(row).add(SlotState.Invalid);
        } else if (col <= this.armThickness - 2
                && row >= (this.boardSize / 2) + (this.armThickness - this.armThickness / 2)) {
          tempBoard.get(row).add(SlotState.Invalid);
        } else if (col >= ((this.boardSize / 2) + (this.armThickness - this.armThickness / 2))
                && row >= (this.boardSize / 2) + (this.armThickness - this.armThickness / 2)) {
          tempBoard.get(row).add(SlotState.Invalid);
        } else if (col >= (this.boardSize / 2) + (this.armThickness - this.armThickness / 2)
                && row <= this.armThickness - 2) {
          tempBoard.get(row).add(SlotState.Invalid);
        } else {
          tempBoard.get(row).add(SlotState.Marble);
        }
      }
    }

    this.placeEmptySlot(tempBoard, sRow, sCol);
    return tempBoard;
  }

  /**
   * Checks if the rows and columns are valid positions on the board.
   * Used when a true/false is needed, rather than a thrown exception.
   *
   * @param row The row of the proposed board position.
   * @param col The column of the proposed board position.
   * @return true if the position is valid, false otherwise.
   */
  private boolean checkPositionIsValid(int row, int col) {
    if (row < 0 || col < 0) {
      return false;
    }

    if (row >= this.boardSize || col >= this.boardSize) {
      return false;
    }

    return this.getSlotAt(row, col) != SlotState.Invalid;
  }
}
