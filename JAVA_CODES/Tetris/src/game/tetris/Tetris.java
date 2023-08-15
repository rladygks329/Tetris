package game.tetris;

public class Tetris {
  public int gameState; // pause, normal, over,
  public int score;
  private Tetromino tetromino;
  public Board board;

  public Tetris(){
    this.board = new Board();
    tetromino = tmpFactory();
    markOn(tetromino);
  }
  public void down(){
  }
  public void handleUserInput(int userInput) {
  }

  private void hanldeClear(){

  }
  private void reStrat(){

  }

  private boolean isValid(Tetromino t) {
    return true;
  }

  private void markOn(Tetromino t){
  }

  private void markOff(Tetromino t){
  }

  private OTetromino tmpFactory(){
    return new OTetromino(5, 1);
  }
  
}
