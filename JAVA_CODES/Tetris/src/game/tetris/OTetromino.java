package game.tetris;

public class OTetromino extends Tetromino {
    /*
    *  point point
    *  center point
    * */
    public OTetromino(int x, int y){
        this.center = new Point(x, y);

        Point[] points = new Point[3];
        points[0] = new Point(x + 1, y);
        points[1] = new Point(x, y -1);
        points[2] = new Point(x + 1, y - 1);
        this.others = points;
    }
    @Override
    public Tetromino rotateLeft() {
        return this;
    }
    @Override
    public Tetromino rotateRight() {
        return this;
    }

    @Override
    public Tetromino down() {
        Tetromino result = new OTetromino(center.x, center.y + 1);
        return result;
    }
}
