package game.tetris;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public class ReplayFileManager {
  public static final String DIR_PATH = "Replay";
  public static final String EXTENTION = ".replay";

  private ReplayFileManager() {}

  public static String getFilePath(int userId, String fileName) {
    return DIR_PATH + File.separator + userId + File.separator + fileName + EXTENTION;
  }

  public static int save(int userId, String fileName, List<ReplayAtom> list) {
    String userDirPath = DIR_PATH + File.separator + userId;
    String filePath = getFilePath(userId, fileName);

    File replayDir = new File(DIR_PATH);
    File userIdDir = new File(userDirPath);
    File file = new File(filePath);

    if (!replayDir.exists()) {
      replayDir.mkdir();
    }

    if (!userIdDir.exists()) {
      userIdDir.mkdir();
    }

    if (!file.exists()) {
      try {
        if (file.createNewFile()) {
          System.out.println("파일 생성");
        } else {
          System.out.println("파일을 만들지 못했음");
        }
      } catch (IOException e) {
        e.printStackTrace();
        System.out.println(file.getAbsolutePath());
      }
    }

    try (OutputStream out = new FileOutputStream(file);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        ObjectOutputStream oout = new ObjectOutputStream(bout);) {
      oout.writeObject(list);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return 1;
  }

  public static List<ReplayAtom> load(String filePath) {
    List<ReplayAtom> result = new LinkedList<>();
    try (InputStream in = new FileInputStream(filePath);
        BufferedInputStream bin = new BufferedInputStream(in);
        ObjectInputStream oin = new ObjectInputStream(bin)) {
      result = (LinkedList<ReplayAtom>) oin.readObject();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}
