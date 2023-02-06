package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Creates a visual representation for a {@code TriangleSolitaireModel}. Can either be appended
 * to an appendable object (given in constructor) or printed with toString.
 */
public class TriangleSolitaireTextView extends AbstractView {
  /**
   * Creates a {@code TriangleSolitaireTextView} with a state that it represents visually.
   *
   * @param state the state to be represented.
   * @throws IllegalArgumentException if the state is null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState state)
          throws IllegalArgumentException {
    if (state == null) {
      throw new IllegalArgumentException("State cannot be null.");
    }
    super.state = state;
  }

  /**
   * Creates a {@code TriangleSolitaireTextView} with a state and an Appendable object to add
   * the representation to.
   *
   * @param state      the state to be represented.
   * @param appendable the Appendable object to append the representation to.
   * @throws IllegalArgumentException if any of the parameters are null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState state, Appendable appendable)
          throws IllegalArgumentException {
    if (state == null || appendable == null) {
      throw new IllegalArgumentException("State and appendable cannot be null.");
    }
    super.state = state;
    super.appendable = appendable;
  }

  @Override
  public String toString() {
    StringBuilder toPrint = new StringBuilder();
    int numInvalids = state.getBoardSize() - 1;
    for (int row = 0; row < state.getBoardSize(); row += 1) {
      toPrint.append(" ".repeat(Math.max(0, numInvalids)));
      numInvalids -= 1;
      for (int col = 0; col < state.getBoardSize(); col += 1) {
        if (col != 0) {
          if (state.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Marble) {
            toPrint.append(" O");
          } else if (state.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Empty) {
            toPrint.append(" _");
          }
        } else {
          if (state.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Marble) {
            toPrint.append("O");
          } else if (state.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Empty) {
            toPrint.append("_");
          }
        }
      }
      toPrint.append("\n");
    }
    return toPrint.toString();
  }
}
