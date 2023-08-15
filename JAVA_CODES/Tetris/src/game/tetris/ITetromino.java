package game.tetris;

public class ITetromino extends Tetromino{
    public ITetromino(int x, int y){
        this.center = new Point(x, y);

        Point[] points = new Point[3];
        points[0] = new Point(x, y - 1);
        points[1] = new Point(x, y - 1);
        points[2] = new Point(x, y + 1);
        this.others = points;
    }

    public ITetromino(Point center, Point[] others){
        this.center = center;
        this.others = others;
    }
    @Override
    public Tetromino rotateLeft() {
        Point[] points = new Point[3];
        for(int i=0;i<3;i++){
            points[i] = new Point(-others[i].y, others[i].x);
        }
        Tetromino result = new ITetromino(center, points);
        return result;
    }

    @Override
    public Tetromino rotateRight() {
        Point[] points = new Point[3];
        for(int i=0;i<3;i++){
            points[i] = new Point(others[i].y, others[i].x);
        }
        Tetromino result = new ITetromino(center, points);
        return result;
    }

    @Override
    public Tetromino down() {
        Point[] points = new Point[3];
        for(int i=0;i<3;i++){
            points[i] = new Point(others[i].x-1, others[i].y-1);
        }
        Tetromino result = new ITetromino(new Point(center.x-1, center.y-1), points);
        return result;
    }

}
