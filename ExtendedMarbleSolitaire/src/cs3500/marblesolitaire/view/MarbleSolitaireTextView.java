package cs3500.marblesolitaire.view;

import java.io.PrintStream;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

/**
 * Creates a view for a marble solitaire game. It will be able to accurately represent the
 * board state by using Os to represent marbles, underscores to represent empty spaces, and
 * spaces to represent invalid spaces.
 */
public class MarbleSolitaireTextView extends AbstractView {
  /**
   * Creates a {@code MarbleSolitaireTextView} with a state to represent and an {@code
   * Appendable} appendable for output.
   *
   * @param state       the state of the model to represent.
   * @param appendable the appendable for the output of the model.
   * @throws IllegalArgumentException if the state or the model is null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state, Appendable appendable)
          throws IllegalArgumentException {
    if (state == null || appendable == null) {
      throw new IllegalArgumentException("Neither the model nor the appendable can be null.");
    }

    super.appendable = appendable;
    super.state = state;
  }

  /**
   * Creates a {@code MarbleSolitiareTextView} object with a state to represent.
   *
   * @param state the {@code MarbleSolitaireModelState} to represent.
   * @throws IllegalArgumentException if the state is null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state)
          throws IllegalArgumentException {
    // The model cannot be null.
    if (null == state) {
      throw new IllegalArgumentException("Model cannot be null.");
    }
    super.appendable = new PrintStream(System.out);
    super.state = state;
  }

  /**
   * Determines what string should be added to be used in the toString function.
   *
   * @param col  the column of the cell that is being represented as a String.
   * @param slot the current SlotState of the cell.
   * @return the String that should be added, or nothing if none of the criteria are met.
   */
  private String determineAddedString(int col, SlotState slot) {
    // If this is the first column, a space should not be added before the symbol.
    if (col == 0) {
      if (slot == SlotState.Invalid) {
        return " "; // Invalid spots are represented by spaces.
      } else if (slot == SlotState.Marble) {
        return "O"; // Marbles are represented by Os
      } else if (slot == SlotState.Empty) {
        return "_"; // Empty slots are represented by underscores.
      }
    } else { // If this is not the first column, there should be a space before the symbol.
      if (slot == SlotState.Invalid) {
        return "  ";
      } else if (slot == SlotState.Marble) {
        return " O";
      } else if (slot == SlotState.Empty) {
        return " _";
      }
    }
    return ""; // If none of these criteria are met, add nothing to the String.
  }

  @Override
  public String toString() {
    StringBuilder toPrint = new StringBuilder();

    // Loops through every location on the board.
    for (int row = 0; row <= state.getBoardSize(); row += 1) {
      for (int col = 0; col <= state.getBoardSize(); col += 1) {
        // If this is past the final row, then end the method and return the completed string.
        if (row == state.getBoardSize()) {
          return toPrint.substring(0, toPrint.length() - 1);
        }
        // If the column is past the end, and there is still a next row, add a new line.
        if (col == state.getBoardSize() && row != state.getBoardSize()) {
          toPrint.append("\n");
        }
        // Otherwise, if this is an invalid slot past the last marble position (determined
        // mathematically), then add nothing.
        else if (state.getSlotAt(row, col) == SlotState.Invalid
                && col >= (state.getBoardSize() / 2)) {
          toPrint.append("");
        }
        /* Otherwise, if this is an invalid slot, use .determineAddedString to determine what
         * string to add.
         */
        else if (state.getSlotAt(row, col) == SlotState.Invalid) {
          toPrint.append(this.determineAddedString(col, SlotState.Invalid));
        }
        /* Otherwise, if this is an empty slot, use .determineAddedString to determine what
         * string to add.
         */
        else if (state.getSlotAt(row, col) == SlotState.Empty) {
          toPrint.append(this.determineAddedString(col, SlotState.Empty));
        }
        /* Otherwise, if this is a marble slot, use .determineAddedString to determine what
         * string to add.
         */
        else if (state.getSlotAt(row, col) == SlotState.Marble) {
          toPrint.append(this.determineAddedString(col, SlotState.Marble));
        }
        // Otherwise, if the next slot is an invalid slot, then add a new line.
        else if (state.getSlotAt(row, col + 1) == SlotState.Invalid) {
          toPrint.append("\n");
        }
      }
    }
    return toPrint.toString(); // return the String of the StringBuilder
  }
}
