public class Cell {
  private boolean isMine;
  private boolean isRevealed;
  private int adjacentMines;

  public Cell() {
      this.isMine = false;
      this.isRevealed = false;
      this.adjacentMines = 0;
  }

  public boolean isMine() {
      return isMine;
  }

  public void setMine(boolean isMine) {
      this.isMine = isMine;
  }

  public boolean isRevealed() {
      return isRevealed;
  }

  public void reveal() {
      this.isRevealed = true;
  }

  public int getAdjacentMines() {
      return adjacentMines;
  }

  public void setAdjacentMines(int adjacentMines) {
      this.adjacentMines = adjacentMines;
  }

  public void flag() {
      // Implement flagging logic if needed
  }
}