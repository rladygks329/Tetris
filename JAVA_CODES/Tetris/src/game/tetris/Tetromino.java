package game.tetris;


abstract class Tetromino {
    protected Point center;
    protected Point[] others;
    public Tetromino() {}
    public Tetromino rotateLeft(){
        return null;
    };
    public Tetromino rotateRight(){
        return null;
    };
    public Tetromino down(){
        Point nextCenter = new Point(center.x, center.y-1);
        Point[] points = new Point[3];

        for(int i=0;i<3;i++){
            points[i] = new Point(others[i].x, others[i].y-1);
        }
        return null;
    };

    public Tetromino left(){
        return null;
    };

    public Tetromino right(){
        return null;
    };
}
