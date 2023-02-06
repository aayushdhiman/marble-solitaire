package cs3500.marblesolitaire;

import java.io.InputStreamReader;
import java.util.ArrayList;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Runnable file for a marble solitaire game. Allows a user to play the game, and specify what
 * type of game they want to play.
 */
public final class MarbleSolitaire {

  /**
   * Main method for the runnable marble solitaire game. Parses the input from the args
   * parameter, which determines which board type, size, and where the hole is going to be.
   *
   * @param args command line arguments specifying "english", "european", or "triangular" for
   *             the board type, "-size int" if the size is to be custom, and "-hole int int"
   *             if the hole is to be custom.
   */
  public static void main(String[] args) {
    StringBuilder modelType = new StringBuilder();
    ArrayList<Integer> size = new ArrayList<Integer>();
    ArrayList<Integer> hole = new ArrayList<Integer>();

    for (int i = 0; i < args.length; i += 1) {
      if (args[i].equalsIgnoreCase("english")
              || args[i].equalsIgnoreCase("european")
              || args[i].equalsIgnoreCase("triangular")) {
        modelType.append(args[i]);
      }

      if (args[i].equalsIgnoreCase("-size")) {
        size.add(Integer.parseInt(args[i + 1]));
      }

      if (args[i].equalsIgnoreCase("-hole")) {
        hole.add(Integer.parseInt(args[i + 1]));
        hole.add(Integer.parseInt(args[i + 2]));
      }
    }

    MarbleSolitaireModel model = null;
    MarbleSolitaireView view = null;
    Appendable appendable = System.out;

    switch (modelType.toString()) {
      case "english":
        if (size.size() == 1 && hole.size() == 2) {
          model = new EnglishSolitaireModel(size.get(0), hole.get(0) - 1, hole.get(1) - 1);
        } else if (size.size() == 1) {
          model = new EnglishSolitaireModel(size.get(0));
        } else if (hole.size() == 2) {
          model = new EnglishSolitaireModel(hole.get(0) - 1, hole.get(1) - 1);
        } else {
          model = new EnglishSolitaireModel();
        }
        view = new MarbleSolitaireTextView(model, appendable);
        break;
      case "european":
        if (size.size() == 1 && hole.size() == 2) {
          model = new EuropeanSolitaireModel(size.get(0), hole.get(0) - 1, hole.get(1) - 1);
        } else if (size.size() == 1) {
          model = new EuropeanSolitaireModel(size.get(0));
        } else if (hole.size() == 2) {
          model = new EuropeanSolitaireModel(hole.get(0) - 1, hole.get(1) - 1);
        } else {
          model = new EuropeanSolitaireModel();
        }
        view = new MarbleSolitaireTextView(model, appendable);
        break;
      case "triangular":
        if (size.size() == 1 && hole.size() == 2) {
          model = new TriangleSolitaireModel(size.get(0), hole.get(0) - 1, hole.get(1) - 1);
        } else if (size.size() == 1) {
          model = new TriangleSolitaireModel(size.get(0));
        } else if (hole.size() == 2) {
          model = new TriangleSolitaireModel(hole.get(0) - 1, hole.get(1) - 1);
        } else {
          model = new TriangleSolitaireModel();
        }
        view = new TriangleSolitaireTextView(model, appendable);
        break;
      default:
        break;
    }

    Readable readable = new InputStreamReader(System.in);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, readable);
    controller.playGame();
  }
}
