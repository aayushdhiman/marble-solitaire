package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * The implementation of a controller for a Marble Solitaire game. It sends inputs to the model
 * to be interpreted and it tells the view when to update/what to write out.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView view;
  private final Readable readable;

  /**
   * Creates a {@code MarbleSolitaireControllerImpl} object with a model, view, and a Readable
   * that contains the inputs from the user.
   *
   * @param model    the model that implements the rules of Marble Solitaire.
   * @param view     the view that displays Marble Solitaire.
   * @param readable the {@code Readable} object that contains input from the user.
   * @throws IllegalArgumentException if any of the parameters are null.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable readable) throws IllegalArgumentException {
    if (model == null || view == null || readable == null) {
      throw new IllegalArgumentException("Neither the model, view, nor readable can be null.");
    }
    this.model = model;
    this.view = view;
    this.readable = readable;
  }

  @Override
  public void playGame() throws IllegalStateException {
    // Create a Scanner to read the inputs.
    Scanner sc = new Scanner(readable);

    // Create a boolean to determine if the game is over or not (should the loop stop?).
    boolean endGame = this.model.isGameOver();

    // Create an integer counter to determine how far into the coordinates ArrayList we are.
    int count = 0;

    // Create an ArrayList of all the inputted coordinates to move to/from.
    ArrayList<Integer> coordinates = new ArrayList<Integer>();

    // Plan:
    // render current state of game
    // display score
    // obtain user input
    // make move
    // repeat until quit or win

    // Continue running the program as long as the game is not over.
    while (!endGame) {
      // First, render the game board with the score beneath it.
      try {
        this.view.renderMessage(System.lineSeparator());
        this.view.renderBoard();
        this.view.renderMessage("\nScore: " + this.model.getScore()
                + System.lineSeparator());
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }

      // Check if the game is over. If it is, exit the loop and start the post-game print.
      if (this.model.isGameOver()) {
        break;
      }

      // Next, ask the user for an input.
      try {
        this.view.renderMessage(System.lineSeparator() + "What is your next move, formatted " +
                "\"fromRow fromCol toRow toCol\": ");
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }

      // Now, read and process the user's input.
      try {
        String inputLine = sc.nextLine();

        // Split the input into an array
        String[] input = inputLine.split(" ");

        // Process each input
        for (String in : input) {

          // Try to turn the input into an Integer. If it works, then continue until there are
          // 4 coordinates in the ArrayList. Once there are 4 coordinates, then try to perform
          // the move. If the input is not an Integer, then check if it is a "q". If it is
          // neither an Integer nor a "q", then ignore it.
          try {
            coordinates.add(Integer.parseInt(in));
            if (coordinates.size() % 4 == 0) {
              int fromRow = coordinates.get(0 + count) - 1;
              int fromCol = coordinates.get(1 + count) - 1;
              int toRow = coordinates.get(2 + count) - 1;
              int toCol = coordinates.get(3 + count) - 1;
              count += 4;

              try {
                this.model.move(fromRow, fromCol, toRow, toCol);
              } catch (IllegalArgumentException e) {
                try {
                  this.view.renderMessage("Invalid move. Play again. " + e.getMessage()
                          + System.lineSeparator());
                } catch (IOException ioEx) {
                  System.out.println("Error in rendering invalid move text.");
                }
              }
            }
          } catch (Exception e) {
            // If the input is a "q", then begin the quit game sequence and leave the loop.
            if (in.equalsIgnoreCase("q")) {
              try {
                this.view.renderMessage(System.lineSeparator() + "Game quit!"
                        + System.lineSeparator() + "State of game when quit:"
                        + System.lineSeparator());
                this.view.renderBoard();
                this.view.renderMessage("\nScore: "
                        + this.model.getScore());
                endGame = true;
                break;
              } catch (IOException ioEx) {
                System.out.println("Error in rendering after quitting game.");
              }
            }
          }
        }
      } catch (NoSuchElementException noElementEx) {
        // The Scanner is looking for another element, but it doesn't exist, so it ran out of
        // inputs to process.
        throw new IllegalStateException("Out of inputs.");
      }
    }

    // If the game is over, then carry out the end-of-game sequence.
    if (this.model.isGameOver()) {
      try {
        this.view.renderMessage(System.lineSeparator() + "Game over!" + System.lineSeparator());
        this.view.renderBoard();
        this.view.renderMessage(System.lineSeparator() + "Score: " + this.model.getScore());
      } catch (IOException e) {
        System.out.println("Error in rendering after game over.");
      }
    }
  }

}
