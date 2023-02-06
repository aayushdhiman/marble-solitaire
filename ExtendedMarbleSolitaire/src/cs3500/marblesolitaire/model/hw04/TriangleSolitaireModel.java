package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a marble solitaire game on a triangle board. The default side length of this board
 * is 5, and the default empty slot is at the top (at 0, 0).
 */
public class TriangleSolitaireModel extends AbstractModel {
  private final int sideLength;
  private final int boardSize;
  private final double diagonalDistance = Math.sqrt(2) * 2;

  /**
   * Creates a {@code TriangleSolitaireModel} with a side length of 5 and an empty slot at the
   * top (at 0, 0).
   */
  public TriangleSolitaireModel() {
    this.sideLength = 5;
    super.armThickness = 5;
    this.boardSize = this.sideLength;
    super.boardSize = this.sideLength;
    this.board = this.createBoard(0, 0);
    super.board = this.createBoard(0, 0);
    this.score = this.calculateScore(this.sideLength, this.boardSize);
    super.score = this.calculateScore(this.sideLength, this.boardSize);
  }

  /**
   * Creates a {@code TriangleSolitaireModel} with a specified side length and an empty slot at
   * the top (0, 0).
   *
   * @param sideLength the side length of the model.
   */
  public TriangleSolitaireModel(int sideLength) {
    this.sideLength = sideLength;
    super.armThickness = this.sideLength;
    this.boardSize = sideLength;
    super.boardSize = this.sideLength;
    this.board = this.createBoard(0, 0);
    super.board = this.createBoard(0, 0);
    this.score = this.calculateScore(this.sideLength, this.boardSize);
    super.score = this.calculateScore(this.sideLength, this.boardSize);
  }

  /**
   * Creates a {@code TriangleSolitaireModel} with a side length of 5 and an empty slot at the
   * specified location.
   *
   * @param sRow the row of the empty slot.
   * @param sCol the column of the empty slot.
   */
  public TriangleSolitaireModel(int sRow, int sCol) {
    this.sideLength = 5;
    super.armThickness = 5;
    this.boardSize = this.sideLength;
    super.boardSize = this.sideLength;
    this.board = this.createBoard(sRow, sCol);
    super.board = this.createBoard(sRow, sCol);
    this.score = this.calculateScore(this.sideLength, this.boardSize);
    super.score = this.calculateScore(this.sideLength, this.boardSize);
  }

  /**
   * Creates a {@code TriangleSolitaireModel} with a specified side length and empty slot
   * position.
   *
   * @param sideLength the side length of the model.
   * @param sRow       the row of the empty slot.
   * @param sCol       the column of the empty slot.
   */
  public TriangleSolitaireModel(int sideLength, int sRow, int sCol) {
    this.sideLength = sideLength;
    super.armThickness = this.sideLength;
    this.boardSize = sideLength;
    super.boardSize = this.sideLength;
    this.board = this.createBoard(sRow, sCol);
    super.board = this.createBoard(sRow, sCol);
    this.score = this.calculateScore(this.sideLength, this.boardSize);
    super.score = this.calculateScore(this.sideLength, this.boardSize);
  }

  @Override
  protected int calculateScore(int armThickness, int boardSize) {
    int startingScore = 0;
    for (int i = 0; i <= this.boardSize; i += 1) {
      startingScore += this.boardSize - i;
    }
    return startingScore - 1;
  }

  /**
   * Builds the board for a triangle solitaire game. It is represented in the grid as half of a
   * rectangle, where (0, 0) is the top left corner and (side length, side length) is the bottom
   * right corner.
   *
   * @param sRow the specified row of the empty slot.
   * @param sCol the specified column of the empty slot.
   * @return the populated starting board with an empty slot at the indicated position.
   */
  protected ArrayList<List<SlotState>> createBoard(int sRow, int sCol) {
    ArrayList<List<SlotState>> tempBoard = new ArrayList<>();

    for (int i = 0; i < this.boardSize; i += 1) {
      tempBoard.add(new ArrayList<SlotState>());
    }

    for (int row = 0; row < this.boardSize; row += 1) {
      int marbleCounter = 0;
      for (int col = 0; col < this.boardSize; col += 1) {
        if (marbleCounter <= row) {
          tempBoard.get(row).add(SlotState.Marble);
          marbleCounter += 1;
        } else {
          tempBoard.get(row).add(SlotState.Invalid);
        }
      }
    }

    // Sets the empty slot.
    placeEmptySlot(tempBoard, sRow, sCol);

    return tempBoard;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    checkLegalMarbles(fromRow, fromCol, toRow, toCol);

    // check if to and from are two spots away (or 2 root 2)
    if (this.doubleDistanceTo(fromRow, fromCol, toRow, toCol) != ((2 * Math.sqrt(2)))
            && this.doubleDistanceTo(fromRow, fromCol, toRow, toCol) != 2.0) {
      System.out.println(this.doubleDistanceTo(fromRow, fromCol, toRow, toCol));
      throw new IllegalArgumentException("Positions are not within moving distance!");
    }

    operateMiddleMarble(fromRow, fromCol, toRow, toCol);
  }

  /**
   * Calculates the distance between the two provided points.
   *
   * @param fromRow the row that one is starting from (x1 in distance formula).
   * @param fromCol the col that one is starting from (y1 in distance formula).
   * @param toRow   the row that one is ending at (x2 in distance formula).
   * @param toCol   the col that one is ending at (y2 in distance formula).
   * @return the double value of the distance between the two points.
   */
  private double doubleDistanceTo(int fromRow, int fromCol, int toRow, int toCol) {
    return Math.sqrt(Math.pow(toRow - fromRow, 2) + Math.pow(toCol - fromCol, 2));
  }

  @Override
  protected int[] findMiddleMarble(int fromRow, int fromCol, int toRow, int toCol) {
    int[] coords = new int[2];

    if (this.doubleDistanceTo(fromRow, fromCol, toRow, toCol) == 2) {
      if (fromRow == toRow) {
        coords[0] = fromRow;
        if (toCol == fromCol + 2) {
          coords[1] = fromCol + 1;
          return coords;
        } else if (toCol == fromCol - 2) {
          coords[1] = fromCol - 1;
          return coords;
        }
      } else if (fromCol == toCol) {
        coords[1] = fromCol;
        if (toRow == fromRow + 2) {
          coords[0] = fromRow + 1;
          return coords;
        } else if (toRow == fromRow - 2) {
          coords[0] = fromRow - 1;
          return coords;
        }
      }
    } else if ((this.doubleDistanceTo(fromRow, fromCol, toRow, toCol) - diagonalDistance) < 0.1) {
      if (toRow == fromRow + 2 && toCol == fromCol + 2) {
        coords[0] = fromRow + 1;
        coords[1] = fromCol + 1;
        return coords;
      } else if (toRow == fromRow - 2 && toCol == fromCol - 2) {
        coords[0] = fromRow - 1;
        coords[1] = fromCol - 1;
        return coords;
      }
    }

    return coords;
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
            // If the marbles are two spaces or 2sqrt2 spaces apart,
            if (this.doubleDistanceTo(fromRow, fromCol, toRow, toCol) == 2.0 ||
                    this.doubleDistanceTo(fromRow, fromCol, toRow, toCol)
                            - diagonalDistance < 0.1) {
              // If there is a possible marble jump from start to end,
              if (checkMarbleJump(fromRow, fromCol, toRow, toCol)) {
                return false; // If there is a valid marble jump, the game is not over.
              }
            }
          }
        }
      }
    }
    return true; // Otherwise, the game is over. (no possible moves)
  }
}
