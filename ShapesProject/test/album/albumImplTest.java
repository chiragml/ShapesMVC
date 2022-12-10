package album;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.NoSuchElementException;

import model.album.IAlbum;
import model.album.albumImpl;
import model.shapes.Color;
import model.snapshot.snaps.ISnapshot;

import static org.junit.Assert.*;

/**
 * The type Album impl test.
 */
public class albumImplTest {

  private IAlbum a1;
  private IAlbum a2;

  private Color c1;
  private Color c2;

  /**
   * Initialize.
   */
  @Before
  public void initialize() {
    a1 = new albumImpl();
    a2 = new albumImpl();
    c1 = new Color(0.0,1.0,10.0);
    c2 = new Color(10.00,100.00,150.00);


    a1.addShape("Rectangle", 10.0,-10.0,50.00,50.00,c1,"Rect 1");
    a2.addShape("Oval", 50.0,-50.0,10.0,20.0,c2,"Oval 1");
  }

  /**
   * Add shape.
   */
  @Test
  public void addShape() {
    a1.addShape("Oval", 100.0,-100.0,10.00,15.00,c1,"Oval 1");

    assertEquals("", a1.printAlbum());

    a1.takeSnap("Snap1");

    assertEquals(1, a1.getAlbum().keySet().size());
    System.out.println(a1.printAlbum());
  }

  /**
   * Testing whether the album's add_shape throws the errors even when not explicitly declared.
   * In the albumImpl class. I.e. whether it throws the exceptions declared in shape class.
   */
  @Test(expected = NoSuchElementException.class)
  public void testingInvalidParameters() {
    a1.addShape("", 565.0,262.0,45.0,45.0,c1,"Name 1");
  }

  /**
   * Testing whether the album's add_shape throws the errors even when not explicitly declared.
   * In the albumImpl class. I.e. whether it throws the exceptions declared in shape class.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testingInvalidParameters2() {
    a1.addShape("rectangle", -88.00,66.00,-5.0,5.0,c2,"Name2");
  }

  /**
   * Print album.
   */
  @Test
  public void printAlbum() {
    a1.takeSnap("Test snap 1");
    String res = "Snapshot ID: " + a1.getSnapIDs().get(a1.getSnapIDs().size() - 1) + "\n"
            + "Snap Description: Test snap 1\n"
            + "Shape Information:\n"
            + "ShapeID: 0\nType: Rectangle\nName: Rect 1\n"
            + "Min corner: (10.0, -10.0) , Width: 50.0, Height: 50.0, Color: (0.0, 1.0, 10.0) " +
            "\n\n\n";

    assertEquals(res, a1.printAlbum());
  }

  /**
   * Take snap.
   */
  @Test
  public void takeSnap() {
    assertEquals(true, a1.getAlbum().isEmpty());
    a1.takeSnap("Snap Test 1");
    assertEquals(false, a1.getAlbum().isEmpty());
  }

  /**
   * Null desc test.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullDescTest() {
    a1.takeSnap(null);
  }

  /**
   * Remove snap.
   */
  @Test
  public void removeSnap() {
    a1.takeSnap("Test snap 1");
    assertEquals(false, a1.getAlbum().isEmpty());
    a1.removeSnap(a1.getSnapIDs().get(a1.getSnapIDs().size() - 1));
    assertEquals(true,a1.getAlbum().isEmpty());
  }

  /**
   * Invalid remove 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidRemove1() {
    a1.removeSnap(null);
  }

  /**
   * Invalid remove 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidRemove2() {
    a1.removeSnap("6");
  }

  /**
   * Test transform 2.
   */
  @Test
  public void testTransform2() {
    a1.transform("Rect 1",6.0, 5.0,3);
    a1.takeSnap("Snap 1");
    a1.transform("Rect 1",0.6,5.0,3);

    assertEquals(300.00
            ,a1.getSnap(a1.getSnapIDs().get(0)).getShape("Rect 1").getDim3(), 0.01);
  }

  /**
   * Test transform.
   */
  @Test
  public void testTransform() {
    a1.transform("Rect 1",66.23,999999.0);
    a1.takeSnap("Snap 1");
    a1.transform("Rect 1",0.00,0.00);

    assertEquals(66.23
            ,a1.getSnap(a1.getSnapIDs().get(0)).getShape("Rect 1").getPosX(), 0.01);

    System.out.println(a1.printAlbum()
            + " \n\nCurrent Canvas:\n" + a1.getCurrentCanvas().toString());
  }

  /**
   * Test transform 1.
   */
//  c1 = new Color(0.0,1.0,10.0);
//  c2 = new Color(10.00,100.00,150.00);
  @Test
  public void testTransform1() {

    a2.addShape("Oval", 0.00,0.00,6.0,6.0,c1,"Oval 2");
    a2.addShape("Oval", 55.00,55.00,20.0,6.0,c2,"Oval 3");
    Color testColor = new Color(255.0,255.0,255.0);
    a2.transform("Oval 3",testColor);
    a2.takeSnap("a2 Snap 1");
    a2.transform("Oval 3",c2);
    assertEquals(testColor, a2.getSnap(a2.getSnapIDs().get(a2.getSnapIDs().size() - 1))
                    .getShape("Oval 3").getColor());

    System.out.println(a2.printAlbum());
    System.out.println("Current Canvas: \n" + a2.getCurrentCanvas().toString());
  }

  /**
   * Gets snap test.
   */
  @Test
  public void getSnapTest() {
    a1.addShape("Oval", 55.00,66.00,100.00,1.00,c1,"MaAAa");
    a1.takeSnap("Test snap");
    ISnapshot s1 = a1.getSnap(a1.getSnapIDs().get(0));
    assertEquals(55.00,s1.shapeList().get(1).getPosX(),0.01);
  }

  /**
   * Invalid get snap 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidGetSnap1() {
    a1.takeSnap("dg");
    a1.getSnap(null);
  }

  /**
   * Invalid get snap 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidGetSnap2() {
    a1.takeSnap("d");
    a1.getSnap("jkjnk");
  }

  /**
   * Gets album.
   */
  @Test
  public void getAlbum() {
    Map<String,ISnapshot> s1 = a1.getAlbum();
    assertEquals(true, s1.isEmpty());

    a1.takeSnap("asfd");
    s1 = a1.getAlbum();
    assertEquals(false,s1.isEmpty());
  }

  /**
   * Gets current canvas test.
   */
  @Test
  public void getCurrentCanvasTest() {
    ISnapshot s1 = a1.getCurrentCanvas();
    assertEquals(10.0,s1.shapeList().get(0).getPosX(),0.01);
  }

  @Test
  public void numberOfSnaps() {
    IAlbum album = new albumImpl();
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

    assertEquals(2, album.getAlbum().size());
  }
}