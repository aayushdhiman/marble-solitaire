package cs3500.marblesolitaire.controller;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Runfile for a marble solitaire game. Creates the model, view, and controller, and allows the
 * game to be played.
 */
public class MarbleSolitaireProgram {
  /**
   * Main method for a marble solitaire game.
   * @param args input arguments for the main method.
   */
  public static void main(String[] args) {
    MarbleSolitaireModel model = new EnglishSolitaireModel(2, 2);
    Readable readable = new InputStreamReader(System.in);
    Appendable ap = System.out;
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, ap);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view,
            readable);
    controller.playGame();
  }
}
