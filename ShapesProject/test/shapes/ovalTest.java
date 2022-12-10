package shapes;

import org.junit.Before;
import org.junit.Test;

import model.shapes.Color;
import model.shapes.I2DShape;
import model.shapes.oval;

import static org.junit.Assert.*;

/**
 * The type Oval test.
 */
public class ovalTest {
  private I2DShape s1;
  private I2DShape s2;
  private I2DShape s3;
  private Color col1;
  private Color col2;
  private Color col3;

  /**
   * Initialize.
   */
  @Before
  public void initialize() {
    col1 = new Color(12.0,23.0,66.5);
    col2 = new Color(232.0,56.5,66.0);
    col3 = new Color(5.2,6.7,99.99);
    s1 = new oval(25.2,55.6,56.0,45.0,col1,"oval 1");
    s2 = new oval(897.5,7878.6,99.99,66.55,col2,"oval 2");
    s3 = new oval(78.66,-95.5,0.0,0.0,col3,"oval 3");
  }


  /**
   * Test x pos null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testXPosNull() {
    s1 = new oval(null,55.6,56.0,45.0,col1,"oval 1");
  }

  /**
   * Test y pos null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testYPosNull() {
    s1 = new oval(546.0,null,56.0,45.0,col1,"oval 1");
  }

  /**
   * Test width null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testWidthNull() {
    s1 = new oval(48.5,55.6,null,45.0,col1,"oval 1");
  }

  /**
   * Test height null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testHeightNull() {
    s1 = new oval(65.5,55.6,56.0,null,col1,"oval 1");
  }

  /**
   * Test color null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testColorNull() {
    s1 = new oval(89.5,55.6,56.0,45.0,null,"oval 1");
  }

  /**
   * Test name null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNameNull() {
    s1 = new oval(78.9,55.6,56.0,45.0,col1,null);
  }

  /**
   * Test negative width.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeWidth() {
    s1 = new oval(5646.5,55.6,-56.0,45.0,col1,"oval 1");
  }

  /**
   * Test negative height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeHeight() {
    s1 = new oval(5646.5,55.6,56.0,-45.0,col1,"oval 1");
  }

  /**
   * Test empty name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyName() {
    s1 = new oval(5646.5,55.6,-56.0,45.0,col1,"");
  }


//  s1 = new rectangle(25.2,55.6,56.0,45.0,col1,"Rect 1");
//  s2 = new rectangle(897.5,7878.6,99.99,66.55,col2,"Rect 2");
//  s3 = new rectangle(78.66,-95.5,0.0,0.0,col3,"Rect 3");

  /**
   * Gets pos x.
   */
  @Test
  public void getPosX() {
    assertEquals(25.2, s1.getPosX(),0.01);
    assertEquals(897.5,s2.getPosX(),0.01);
    assertEquals(78.66,s3.getPosX(), 0.01);
    assertNotEquals(65.23,s1.getPosX(),0.001);
  }

  /**
   * Gets pos y.
   */
//  s1 = new rectangle(25.2,55.6,56.0,45.0,col1,"Rect 1");
  //  s2 = new rectangle(897.5,7878.6,99.99,66.55,col2,"Rect 2");
  //  s3 = new rectangle(78.66,-95.5,0.0,0.0,col3,"Rect 3");
  @Test
  public void getPosY() {
    assertEquals(55.6, s1.getPosY(),0.01);
    assertEquals(7878.6,s2.getPosY(),0.01);
    assertEquals(-95.5,s3.getPosY(), 0.01);
    assertNotEquals(65.23,s1.getPosY(),0.001);
  }

  /**
   * Gets dim 3.
   */
//  s1 = new rectangle(25.2, 55.6, 56.0, 45.0, col1, "Rect 1");
  //  s2 = new rectangle(897.5, 7878.6, 99.99, 66.55, col2, "Rect 2");
  //  s3 = new rectangle(78.66, -95.5, 0.0, 0.0, col3, "Rect 3");
  @Test
  public void getDim3() {
    assertEquals(56.0, s1.getDim3(),0.01);
    assertEquals(99.99,s2.getDim3(),0.01);
    assertEquals(0.0,s3.getDim3(), 0.01);
    assertNotEquals(65.23,s1.getDim3(),0.001);
  }

  /**
   * Gets dim 4.
   */
//  s1 = new rectangle(25.2, 55.6, 56.0, 45.0, col1, "Rect 1");
  //  s2 = new rectangle(897.5, 7878.6, 99.99, 66.55, col2, "Rect 2");
  //  s3 = new rectangle(78.66, -95.5, 0.0, 0.0, col3, "Rect 3");
  @Test
  public void getDim4() {
    assertEquals(45.0, s1.getDim4(),0.01);
    assertEquals(66.55,s2.getDim4(),0.01);
    assertEquals(0.0,s3.getDim4(), 0.01);
    assertNotEquals(65.23,s1.getDim4(),0.001);
  }

  /**
   * Gets name.
   */
//  s1 = new rectangle(25.2, 55.6, 56.0, 45.0, col1, "Rect 1");
  //  s2 = new rectangle(897.5, 7878.6, 99.99, 66.55, col2, "Rect 2");
  //  s3 = new rectangle(78.66, -95.5, 0.0, 0.0, col3, "Rect 3");
  @Test
  public void getName() {
    assertEquals("oval 1", s1.getName());
    assertEquals("oval 2", s2.getName());
    assertEquals("oval 3", s3.getName());
    assertNotEquals("Oval", s1.getName());
  }

  /**
   * Gets color.
   */
//  s1 = new rectangle(25.2, 55.6, 56.0, 45.0, col1, "Rect 1");
  //  s2 = new rectangle(897.5, 7878.6, 99.99, 66.55, col2, "Rect 2");
  //  s3 = new rectangle(78.66, -95.5, 0.0, 0.0, col3, "Rect 3");
  @Test
  public void getColor() {
    assertEquals(col1, s1.getColor());
    assertEquals(col2, s2.getColor());
    assertEquals(col3,s3.getColor());
    assertNotEquals(col3, s1.getColor());
  }

  /**
   * Sets pos x.
   */
//  s1 = new rectangle(25.2, 55.6, 56.0, 45.0, col1, "Rect 1");
  //  s2 = new rectangle(897.5, 7878.6, 99.99, 66.55, col2, "Rect 2");
  //  s3 = new rectangle(78.66, -95.5, 0.0, 0.0, col3, "Rect 3");
  @Test
  public void setPosX() {
    s1.setPosX(66.66);
    assertEquals(66.66,s1.getPosX(),0.01);

    s2.setPosX(98.01);
    assertEquals(98.01,s2.getPosX(),0.01);
  }

  /**
   * Invalid x set.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidXSet() {
    s1.setPosX(null);
  }

  /**
   * Sets pos y.
   */
  @Test
  public void setPosY() {
    s1.setPosY(66.66);
    assertEquals(66.66,s1.getPosY(),0.01);

    s2.setPosY(98.01);
    assertEquals(98.01,s2.getPosY(),0.01);
  }

  /**
   * Invalid y set.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidYSet() {
    s1.setPosY(null);
  }

  /**
   * Sets dim 3.
   */
  @Test
  public void setDim3() {
    s1.setDim3(6656.3);
    assertEquals(6656.3,s1.getDim3(),0.01);

    s2.setDim3(0.0);
    assertEquals(0.0,s2.getDim3(),0.01);
  }

  /**
   * Invalid set dim 3 less than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetDim3LessThan0() {
    s1.setDim3(-1.0);
  }

  /**
   * Invalid set dim 3 null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetDim3Null() {
    s1.setDim3(null);
  }

  /**
   * Sets dim 4.
   */
  @Test
  public void setDim4() {
    s1.setDim4(6656.3);
    assertEquals(6656.3,s1.getDim4(),0.01);

    s2.setDim4(0.0);
    assertEquals(0.0,s2.getDim4(),0.01);
  }

  /**
   * Invalid set dim 4 less than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetDim4LessThan0() {
    s1.setDim4(-1.0);
  }

  /**
   * Invalid set dim 4 null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetDim4Null() {
    s1.setDim4(null);
  }

  /**
   * Sets name.
   */
  @Test
  public void setName() {
    s1.setName("Ho gaya.");
    assertEquals("Ho gaya.", s1.getName());

    s3.setName("IO");
    assertEquals("IO", s3.getName());
  }

  /**
   * Invalid set name null case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetNameNullCase() {
    s2.setName(null);
  }

  /**
   * Invalid set name empty case.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidSetNameEmptyCase() {
    s2.setName("");
  }

  /**
   * Sets color.
   */
  @Test
  public void setColor() {
    s3.setColor(col2);
    assertEquals(col2,s3.getColor());
  }

  /**
   * Invalid set color null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void invalidSetColorNull() {
    s1.setColor(null);
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    String res = "Type: Oval\nX Position: " + s1.getPosX() + "\nY Position: " + s1.getPosY() +
            "\nName: " + s1.getName() + "\nRadius 1: " + s1.getDim3() + "\nRadius 2: " +
            s1.getDim4() + "\nColor: " + s1.getColor() + "\n";

    assertEquals(res, s1.toString());
  }

}