package game.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class TetrisView extends JPanel {
    private final String BACKGROUD_IMG_PATH = "res" + File.separator + "Tetriminos" + File.separator + "Board" + File.separator + "Board.png";
    private final String BLOCK_IMG_PATH = "res" + File.separator + "Tetriminos" + File.separator + "Single Blocks" + File.separator;
    private Tetris tetris;
    private Board board;
    private ActionListener gameLoop;
    private Timer timer;
    int boxSize = 30;

    private Image bg;
    private Image[] blockImg;
    public TetrisView() {
        tetris = new Tetris();
        board = tetris.board;

        //init images
        bg = getBlockImg(BACKGROUD_IMG_PATH, 12 * boxSize, 22 * boxSize);
        blockImg = new Image[7];
        blockImg[0] = getBlockImg(BLOCK_IMG_PATH + "Blue.png", boxSize, boxSize);
        blockImg[1] = getBlockImg(BLOCK_IMG_PATH + "Green.png", boxSize, boxSize);
        blockImg[2] = getBlockImg(BLOCK_IMG_PATH + "LightBlue.png", boxSize, boxSize);
        blockImg[3] = getBlockImg(BLOCK_IMG_PATH + "Orange.png", boxSize, boxSize);
        blockImg[4] = getBlockImg(BLOCK_IMG_PATH + "Purple.png", boxSize, boxSize);
        blockImg[5] = getBlockImg(BLOCK_IMG_PATH + "Red.png", boxSize, boxSize);
        blockImg[6] = getBlockImg(BLOCK_IMG_PATH + "Yellow.png", boxSize, boxSize);

        gameLoop = actionEvent -> {
            tetris.down();
            repaint();
        };
        timer = new Timer(1000, gameLoop);
        timer.setInitialDelay(1000);
        timer.start();
    };

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bg, 0, 0, 12 * boxSize, 22 * boxSize,this);

        for(int i=0; i<Board.HEIGHT;i++){
            for(int j=0; j<Board.WIDTH;j++){
                int type = board.map[i][j];
                g.drawImage(blockImg[type], (j+1) * boxSize, (i+1) * boxSize,  this);
            }
        }
    }

    private Image getBlockImg (String imgPath, int width, int height){
        return Toolkit.getDefaultToolkit()
                .getImage(imgPath)
                .getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    }
}

//tetris
//    int[][] map = new int[Board.HEIGHT][Board.WIDTH];
//    blocks = new JLabel[Board.HEIGHT][Board.WIDTH];
//    blueImgIcon = new ImageIcon();
//    greenImgIcon = new ImageIcon("res"+File.separator+"Tetriminos"+File.separator+"Single Blocks"+File.separator+"Green.png");
//
//    for (int i = 0; i < map.length; i++) {
//      for (int j = 0; j < map[i].length; j++) {
//        JLabel block = new JLabel();
//        block.setBounds((j + 1) * boxSize, (i + 1) * boxSize, boxSize - 1, boxSize - 1);
//        LineBorder b2 = new LineBorder(Color.orange, 1);
//        block.setBorder(b2);
//        block.setHorizontalAlignment(JLabel.CENTER);
//        // wall
//        if (map[i][j] == 1) {
//          block.setIcon(blueImgIcon);
//        } else {
//          block.setIcon(greenImgIcon);
//        }
//        blocks[i][j] = block;
//        layeredPane.add(block, 0);
//      }
//    }
//
