package game.tetris;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

class TetrisSoundManager {
  private final String BGM_FILE_PATH = "res" + File.separator + "Tetrominos" + File.separator
      + "BGM" + File.separator + "BGM_Bradinsky.wav";
  private static TetrisSoundManager instance;
  private Clip clip;

  public static TetrisSoundManager getInstance() {
    if (instance == null) {
      instance = new TetrisSoundManager();
    }
    return instance;
  }

  private TetrisSoundManager() {
    init();
  }

  private void init() {
    File bgm;
    AudioInputStream stream;
    AudioFormat format;
    DataLine.Info info;

    bgm = new File(BGM_FILE_PATH);
    try {
      stream = AudioSystem.getAudioInputStream(bgm);
      format = stream.getFormat();
      info = new DataLine.Info(Clip.class, format);
      clip = (Clip) AudioSystem.getLine(info);
      clip.open(stream);
      clip.loop(Clip.LOOP_CONTINUOUSLY);
      clip.stop();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }// end init()

  public void reStart() {
    if (clip == null) {
      return;
    }

    clip.setFramePosition(0);
    clip.start();
  } // end reStart()

  public void resume() {
    if (clip == null) {
      return;
    }
    clip.start();
  } // end resume()

  public void stop() {
    if (clip == null) {
      return;
    }
    clip.stop();
  } // end stop()
}
