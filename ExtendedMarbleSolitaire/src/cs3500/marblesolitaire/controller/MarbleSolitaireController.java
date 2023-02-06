package cs3500.marblesolitaire.controller;

/**
 * Interface for a controller for a Marble Solitaire game. Delegates tasks to the model and
 * view, and reads and processes inputs from the user.
 */
public interface MarbleSolitaireController {
  /**
   * Plays a new game of Marble Solitaire.
   *
   * @throws IllegalStateException if the controller is unable to successfully read the input
   *                               or transmit output.
   */
  void playGame() throws IllegalStateException;
}
