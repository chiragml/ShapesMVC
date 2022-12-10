package view.web;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.album.IAlbum;
import model.album.albumImpl;
import model.shapes.Color;

import static org.junit.Assert.*;

/**
 * The type Web test.
 */
public class webTest {

  private web w;
  private IAlbum a1;
  private File f;

  /**
   * Initialize.
   */
  @Before
  public void initialize() {
    a1 = new albumImpl();
    IAlbum album = new albumImpl();
//
    album.addShape("Oval", 500.0,500.0,30.0,30.0,
            new Color(5.0,60.0,10.0),"Oval 1");
    album.addShape("Rectangle", 500.0,500.0,30.0,30.0,
            new Color(5.0,60.0,10.0),"Rect 1");
    album.takeSnap("snap 1");

    try {
      Thread.sleep(5);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    album.addShape("Oval", 550.0,500.0,30.0,30.0,
            new Color(5.0,60.0,10.0),"Oval 2");

    album.takeSnap("Snap 2");
    System.out.println(album.getAlbum().size());

    f = new File("D:\\1761424\\courses\\OOD\\module8\\HW7\\hw7\\buildingsOutbuildingsOut.html");
    w = new web(album,f,800,800);
  }

  /**
   * Compare string.
   *
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void compareString() throws FileNotFoundException {
    String temp = w.getHtml();
    String temp2 = "";
    Scanner scan = new Scanner(f);
    while(scan.hasNextLine()) {
      String input = scan.nextLine();
      temp2 = temp2 + input + "\n";
    }
    assertEquals(temp,temp2);
//    System.out.println(temp2);
  }

}