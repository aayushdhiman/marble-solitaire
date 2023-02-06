package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;
import java.util.List;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract class to represent marble solitaire models that have similar dispositions to the
 * English solitaire model. A chief example of this is the European solitaire model, as it has
 * the same grid-like shape to the board. This abstract class can be used to represent any
 * marble solitaire models that have a grid-like board shape, so long as they still comply by
 * the rules of marble solitaire.
 */
public abstract class AbstractModel implements MarbleSolitaireModel {

  protected int armThickness;
  protected int boardSize;
  protected ArrayList<List<SlotState>> board;
  protected int score;

  /**
   * Verifies that the arm thickness is odd.
   *
   * @param sideLength the specified arm thickness of the board
   * @return true if the side length is odd.
   * @throws IllegalArgumentException if the arm thickness is even.
   */
  protected boolean checkArmThickness(int sideLength) throws IllegalArgumentException {
    if (sideLength % 2 == 0) {
      throw new IllegalArgumentException("Arm thickness must be odd.");
    }
    return true;
  }

  /**
   * Calculates the board size based on the side length.
   *
   * @return the board size.
   */
  protected int calculateBoardSize(int armThickness) {
    return armThickness + (2 * (armThickness - 1));
  }

  /**
   * Calculates the starting score of the game, based on the side length and the board size.
   *
   * @return the starting score of the game.
   */
  protected abstract int calculateScore(int armThickness, int boardSize);

  /**
   * Builds the board for the marble solitiare game to be played on.
   *
   * @param sRow the specified row of the empty slot.
   * @param sCol the specified column of the empty slot.
   * @return an Arraylist of Lists of SlotStates that represent the board.
   */
  protected abstract ArrayList<List<SlotState>> createBoard(int sRow, int sCol);

  /**
   * Determines if the given coordinate is in bounds of the board.
   *
   * @param row the row of the coordinate.
   * @param col the column of the coordinate.
   * @throws IllegalArgumentException if the coordinate is out of bounds.
   */
  private void isInBounds(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row >= this.boardSize) {
      throw new IllegalArgumentException("Row is out of bounds.");
    }
    if (col < 0 || col >= this.boardSize) {
      throw new IllegalArgumentException("Col is out of bounds.");
    }
  }

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   *                                  if the from position is not a marble
   *                                  if the to position is not empty
   *                                  if the selected positions are not 2 positions away
   *                                  if there is no marble in the middle position
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    this.checkLegalMarbles(fromRow, fromCol, toRow, toCol);
    // check if from and to are two spots away
    if (this.distanceTo(fromRow, fromCol, toRow, toCol) != 2) {
      throw new IllegalArgumentException("Selected positions are not 2 positions away.");
    }
    // check if marble is in middle position
    this.operateMiddleMarble(fromRow, fromCol, toRow, toCol);
  }

  /**
   * Calculates the distance between the two provided points.
   *
   * @param fromRow the row that one is starting from (x1 in distance formula).
   * @param fromCol the col that one is starting from (y1 in distance formula).
   * @param toRow   the row that one is ending at (x2 in distance formula).
   * @param toCol   the col that one is ending at (y2 in distance formula).
   * @return the integer value of the distance between the two points.
   */
  private int distanceTo(int fromRow, int fromCol, int toRow, int toCol) {
    return (int) Math.sqrt(Math.pow(toRow - fromRow, 2) + Math.pow(toCol - fromCol, 2));
  }

  /**
   * Checks if there is a marble in the location that is being jumped over in a move.
   *
   * @param fromRow The row the move is originating from.
   * @param fromCol The column the move is originating from.
   * @param toRow   The row the move is ending at.
   * @param toCol   The column the move is ending at.
   * @return true if there is a marble, false if not.
   * @throws IllegalArgumentException if there is no marble in the jumped space.
   */
  protected boolean checkMarbleJump(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    int[] coords = findMiddleMarble(fromRow, fromCol, toRow, toCol);

    if (this.getSlotAt(fromRow, fromCol) != SlotState.Marble) { // the starting position should
      // be a marble.
      return false;
    }

    if (this.getSlotAt(toRow, toCol) != SlotState.Empty) { // the ending position should be empty.
      return false;
    }

    return this.getSlotAt(coords[0], coords[1]) == SlotState.Marble;
  }

  /**
   * Removes the marble in the middle of the marble jump and replaces it with an empty slot.
   *
   * @param fromRow the starting row of the jump.
   * @param fromCol the starting column of the jump.
   * @param toRow   the ending row of the jump.
   * @param toCol   the ending column of the jump.
   */
  private void consumeMarble(int fromRow, int fromCol, int toRow, int toCol) {
    int[] coords = this.findMiddleMarble(fromRow, fromCol, toRow, toCol);
    this.board.get(coords[0]).set(coords[1], SlotState.Empty);
  }

  /**
   * Finds the coordinates of the marble between the two marbles.
   *
   * @param fromRow the row of the starting position
   * @param fromCol the col of the starting position
   * @param toRow   the row of the ending position
   * @param toCol   the col of the ending position
   * @return the coordinates of the middle marble
   * @throws IllegalArgumentException if any of the given coordinates are invalid
   */
  protected int[] findMiddleMarble(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    int[] coords = new int[2]; // Creates the array to hold the coordinates
    this.isInBounds(fromRow, fromCol);
    this.isInBounds(toRow, toCol);

    /* The basic idea behind this code is the following:
     * Find the coordinate that is changing (either row or column)
     * Subtract the changing coordinates.
     * If the result is a positive number, the middle is the fromCoord + 1.
     * If the result is a negative number, the middle is the fromCoord - 1.
     */
    if (fromCol != toCol || fromRow != toRow) { // at least one must be the same, if not, throw
      if (fromCol == toCol) { // if the column is the same (the row is changing)
        coords[1] = fromCol;
        if (toRow - fromRow > 0) { // if the marble is moving DOWN the board
          coords[0] = fromRow + 1;
        } else { // the marble is moving UP the board
          coords[0] = fromRow - 1;
        }
        return coords;
      } else if (fromRow == toRow) { // if the rows are the same (the col is changing)
        coords[0] = fromRow;
        if (toCol - fromCol > 0) { // if the marble is moving to the RIGHT
          coords[1] = fromCol + 1;
        } else { // the marble is moving to the LEFT
          coords[1] = fromCol - 1;
        }
        return coords;
      }
    } else { // rows and columns are not the same
      throw new IllegalArgumentException("There is not a shared row or column between the given" +
              " coordinates!");
    }
    return coords; // this statement should not be reached
  }

  /**
   * Determines if the marbles provided are legal to be moved. Checks if they are within bounds
   * of the board and if the from position is a marble and if the to position is empty.
   *
   * @param fromRow the row of the from marble.
   * @param fromCol the column of the from marble.
   * @param toRow   the row of the to space.
   * @param toCol   the column of the to space.
   * @throws IllegalArgumentException if any of the provided positions are out of bounds
   *                                  if the from position is not a marble
   *                                  if the to position is not empty.
   */
  protected void checkLegalMarbles(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    // check if from position is in bounds
    this.isInBounds(fromRow, fromCol);

    // check if to position is in bounds
    this.isInBounds(toRow, toCol);

    // check if marble is at from position
    if (this.getSlotAt(fromRow, fromCol) != SlotState.Marble) {
      throw new IllegalArgumentException("From position is not a marble.");
    }

    // check if empty is at to position
    if (this.getSlotAt(toRow, toCol) != SlotState.Empty) {
      throw new IllegalArgumentException("To position is not empty.");
    }
  }

  /**
   * Checks if there is a marble between the positions provided. If there is, it will set the
   * from position to empty, the middle marble position to empty, and the to position to marble.
   *
   * @param fromRow the row of the from marble.
   * @param fromCol the column of the from marble.
   * @param toRow   the row of the to space.
   * @param toCol   the column of the to space.
   * @throws IllegalArgumentException if a marble jump is not possible.
   */
  protected void operateMiddleMarble(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    // check if there is a marble in the middle position
    if (this.checkMarbleJump(fromRow, fromCol, toRow, toCol)) {
      this.board.get(fromRow).set(fromCol, SlotState.Empty);
      this.consumeMarble(fromRow, fromCol, toRow, toCol);
      this.board.get(toRow).set(toCol, SlotState.Marble);
      this.score -= 1;
    } else {
      throw new IllegalArgumentException("There is no marble between the two positions.");
    }
  }

  /**
   * Determines if the position is a valid position on the board.
   *
   * @param row the row of the position.
   * @param col the column of the position.
   * @return true if the position is valid.
   * @throws IllegalArgumentException if the position is not valid.
   */
  private boolean isPositionValid(int row, int col) throws IllegalArgumentException {
    IllegalArgumentException invalidPosition = new IllegalArgumentException("The position is " +
            "invalid.");

    if (row < 0 || col < 0) {
      throw invalidPosition;
    } else if (row > this.boardSize || col > this.boardSize) {
      throw invalidPosition;
    }

    return true;
  }

  /**
   * Places the empty slot in the middle of the board.
   *
   * @param tempBoard the board to place the empty slot in.
   * @param sRow      the row of the empty slot.
   * @param sCol      the column of the empty slot.
   * @throws IllegalArgumentException if the specified location is invalid.
   */
  protected void placeEmptySlot(ArrayList<List<SlotState>> tempBoard, int sRow, int sCol)
          throws IllegalArgumentException {
    try {
      tempBoard.get(sRow).get(sCol);
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Row or Column of empty slot is out of bounds.");
    }

    if (tempBoard.get(sRow).get(sCol) == SlotState.Invalid) {
      throw new IllegalArgumentException("Specified empty slot in not on the board (invalid).");
    }

    tempBoard.get(sRow).set(sCol, SlotState.Empty);
  }

  @Override
  public boolean isGameOver() {
    // If there is only one marble left on the board, the game is over no matter what.
    if (this.score == 1) {
      return true;
    }

    // Loops through every possible from location and to location on the board.
    for (int fromRow = 0; fromRow < this.boardSize; fromRow += 1) {
      for (int fromCol = 0; fromCol < this.boardSize; fromCol += 1) {
        for (int toRow = 0; toRow < this.boardSize; toRow += 1) {
          for (int toCol = 0; toCol < this.boardSize; toCol += 1) {

            // If the marbles are two spaces apart,
            if (this.distanceTo(fromRow, fromCol, toRow, toCol) == 2) {
              // If the positions of both the start and end are valid locations,
              if (this.isPositionValid(fromRow, fromCol) &&
                      this.isPositionValid(toRow, toCol)) {
                // If there is a possible marble jump from start to end,
                if (checkMarbleJump(fromRow, fromCol, toRow, toCol)) {
                  return false; // If there is a valid marble jump, the game is not over.
                }
              }
            }
          }
        }
      }
    }
    return true; // Otherwise, the game is over. (no possible moves)
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row > this.boardSize) {
      throw new IllegalArgumentException("Row is out of bounds");
    }

    if (col < 0 || col > this.boardSize) {
      throw new IllegalArgumentException("Col is out of bounds.");
    }
    return this.board.get(row).get(col);
  }

  @Override
  public int getBoardSize() {
    return this.boardSize;
  }

  @Override
  public int getScore() {
    return this.score;
  }
}
