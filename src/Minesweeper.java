public class Minesweeper {
  private Board board;
  private boolean gameOver;

  public Minesweeper(int rows, int cols, int mines) {
      board = new Board(rows, cols, mines);
      gameOver = false;
  }

  public void startGame() {
      board.initializeBoard();
      // Additional game setup can be added here
  }

  public void makeMove(int row, int col) {
      if (gameOver) {
          System.out.println("Game is over. Please restart to play again.");
          return;
      }

      if (board.revealCell(row, col)) {
          if (board.checkWin()) {
              System.out.println("Congratulations! You've won!");
              gameOver = true;
          }
      } else {
          System.out.println("Game Over! You hit a mine.");
          gameOver = true;
      }
  }

  public boolean isGameOver() {
      return gameOver;
  }

  public void resetGame(int rows, int cols, int mines) {
      board = new Board(rows, cols, mines);
      gameOver = false;
      startGame();
  }
}