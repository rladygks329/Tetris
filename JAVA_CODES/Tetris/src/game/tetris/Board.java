package game.tetris;

public class Board {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;
    public int[][] map;

    public Board() {
        map = new int[HEIGHT][WIDTH];
    }

    public void mark(Point p, int value){
        int x = p.x;
        int y = p.y;
        map[y][x] = value;
    }

    public boolean isValid(Point p){
        if(p.x < 0 || p.x >= WIDTH || p.y < 0 || p.y >=HEIGHT){
            return false;
        }

        return map[p.y][p.x] == 0;
    }
}
