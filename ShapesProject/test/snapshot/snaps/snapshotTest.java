package snapshot.snaps;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import model.shapes.Color;
import model.shapes.I2DShape;
import model.shapes.oval;
import model.snapshot.snaps.snapshot;

import static org.junit.Assert.*;

/**
 * The type Snapshot test.
 */
public class snapshotTest {

  private snapshot s1;
  private snapshot s2;

  private Color c1;
  private Color c2;

  /**
   * Initialize.
   */
  @Before
  public void initialize() {
    s1 = new snapshot("Snap 1");
    s2 = new snapshot("Snap 2");
    c1 = new Color(0.00,0.00,0.00);
    c2 = new Color(255.0,255.0,255.0);
  }

  /**
   * Gets time stamp.
   */
  @Test
  public void getTimeStamp() {
    String timeNow = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            .format(new Timestamp(System.currentTimeMillis()));

    System.out.println(timeNow);
    assertEquals(s2.getTimeStamp(), timeNow);
  }

  /**
   * Add shape 1.
   */
  @Test
  public void add_Shape1() {
    s1.add_Shape("rectangle", 66.33,55.0,89.01,33.00,c1,"Rect 1");
    HashMap<String, I2DShape> list = s1.shapeList();
    System.out.println(list);
    assertEquals(false,list.isEmpty());

  }

  /**
   * Test add shape 2.
   */
  @Test
  public void testAdd_Shape2() {

    I2DShape shape = new oval(56.33,545.00,480.0,99.00,c1,"Oval 2");
    s1.add_Shape(shape);
    assertEquals(1,s1.shapeList().size());
  }

  /**
   * Test null shape add.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullShapeAdd() {
    s1.add_Shape(null);
  }

  /**
   * Gets description.
   */
  @Test
  public void getDescription() {
    assertEquals("Snap 1", s1.getDescription());
    assertEquals("Snap 2", s2.getDescription());
  }

  /**
   * Shape list.
   */
  @Test
  public void shapeList() {
    s1.add_Shape("Rectangle", 56.0,56.0,56.0,56.0,c1,"Rect 1");
    assertEquals(1,s1.shapeList().size());
  }

  /**
   * Remove shape.
   */
  @Test
  public void removeShape() {
    s1.add_Shape("Rectangle", 56.0,56.0,56.0,56.0,c1,"Rect 1");
    assertEquals(1,s1.shapeList().size());
    s1.removeShape("Rect 1");
    assertEquals(0,s1.shapeList().size());
  }

  /**
   * Invalid remove 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void InvalidRemove1() {
    s1.removeShape(null);
  }

  /**
   * Invalid remove 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void InvalidRemove2(){
    s1.removeShape("Rect");
  }

  /**
   * Gets current shape id.
   */
  @Test
  public void getCurrentShapeID() {
    s1.add_Shape("Rectangle", 56.0,56.0,56.0,56.0,c1,"Rect 1");
    assertEquals(1,s1.getCurrentShapeID());
  }

  /**
   * Invalid get current id.
   */
  @Test(expected = IllegalArgumentException.class)
  public void InvalidGetCurrentID() {
    s1.getCurrentShapeID();
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    String temp1 = "Snap Description: "
            + s1.getDescription() + "\n"
            + "Shape Information:\nShapeID: Rect 1\nType: Rectangle\nName: Rect 1" +
            "\nMin corner: (56.0, 56.0) , Width: 56.0, Height: 56.0, Color: (0.0, 0.0, 0.0) \n\n\n";
    s1.add_Shape("Rectangle", 56.0,56.0,56.0,56.0,c1,"Rect 1");
    assertEquals(temp1,s1.toString());
  }

  /**
   * Gets shape.
   */
  @Test
  public void getShape() {
    s1.add_Shape("Rectangle", 56.0,56.0,56.0,56.0,c1,"Rect 1");
    assertEquals(56.0,s1.getShape("Rect 1").getPosX(),0.01);
  }

  /**
   * Invalid get 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void InvalidGet1() {
    s1.getShape(null);
  }

  /**
   * Invalid get 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void InvalidGet2() {
    s1.getShape("");
  }
}