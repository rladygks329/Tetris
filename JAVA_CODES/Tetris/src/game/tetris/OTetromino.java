package game.tetris;

public class OTetromino extends Tetromino {
    /*
    *  point point
    *  center point
    * */
    public OTetromino(int x, int y){
        points[0] = new Point();
        points[1] = new Point();
        points[2] = new Point();
        points[3] = new Point();
    }
}
