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
    System.out.println("down start");
    Tetromino next = tetromino.down();
    markOff(tetromino);

    if(isValid(next)){
      markOn(next);
      tetromino = next;
    }else {
      markOn(tetromino);
      tetromino = tmpFactory();
    }
    System.out.println("down end");
  }
  public void handleUserInput(int userInput) {
    if(!(userInput == 37 || userInput == 39)){
      return;
    }
    Tetromino next = tetromino;
    //left
    if(userInput == 37){
      next = tetromino.rotateLeft();
      //right
    } else if (userInput == 39) {
      next = tetromino.rotateRight();
    }
    if(isValid(next)){
      markOn(next);
      tetromino = next;
    }else {
      markOn(tetromino);
      tetromino = tmpFactory();
    }
  }

  private void hanldeClear(){

  }
  private void reStrat(){

  }

  private boolean isValid(Tetromino t) {
    if(!board.isValid(t.center)){
      return false;
    }
    for(Point p: t.others){
      if(!board.isValid(p)){
        return false;
      }
    }
    return true;
  }

  private void markOn(Tetromino t){
    board.mark(t.center, 1);
    for(Point p: t.others){
      board.mark(p, 1);
    }
  }

  private void markOff(Tetromino t){
    board.mark(t.center, 0);
    for(Point p: t.others){
      board.mark(p, 0);
    }
  }

  private OTetromino tmpFactory(){
    return new OTetromino(5, 1);
  }
  
}
