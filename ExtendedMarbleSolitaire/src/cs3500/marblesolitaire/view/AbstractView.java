package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Abstract class that contains shared code between different styles of views. Contains the
 * renderBoard and renderMessage methods, as well as protected fields for the state and the
 * appendable.
 */
public abstract class AbstractView implements MarbleSolitaireView {
  protected MarbleSolitaireModelState state;
  protected Appendable appendable;

  @Override
  public void renderBoard() throws IOException {
    if (this.appendable == null) {
      throw new IOException("Appendable object is null.");
    }

    if (this.toString() == null) {
      throw new IOException("toString is null.");
    }
    this.appendable.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    if (this.appendable == null) {
      throw new IOException("Appendable object is null.");
    } else if (message == null) {
      throw new IOException("Message is null.");
    }
    appendable.append(message);
  }

}
