package shapes;

import org.junit.Test;

import java.util.NoSuchElementException;

import model.shapes.Color;
import model.shapes.I2DShape;
import model.shapes.shape;

import static org.junit.Assert.assertEquals;

/**
 * The type Shape test.
 */
public class shapeTest {

  private Color c1 = new Color(0.00,55.6,254.995);
  private Color c2 = new Color(0.00,56.02,25.95);

  /**
   * Create shape.
   */
  @Test
  public void createShape() {
    I2DShape s1 = shape.createShape
            ("rectangle",23.2,33.5,56.4,99.0,c1,"Rect 1");

    assertEquals(33.5, s1.getPosY(),0.01);

    s1.setDim3(66.3);
    assertEquals(66.3,s1.getDim3(),0.01);


    I2DShape s2 = shape.createShape
            ("Oval",33.11,-99.96,6.6,3.32,c2,"Oval 1");

    assertEquals(6.6, s2.getDim3(),0.01);
  }

  /**
   * Invalid oval test.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidOvalTest() {
    I2DShape s2 = shape.createShape("Oval", 99.99,88.85,-9.6,5.5,c1,"Oval2");
  }

  /**
   * No such element.
   */
  @Test(expected = NoSuchElementException.class)
  public void noSuchElement() {
    I2DShape s3 = shape.createShape
            ("Circle", 56.6,45.2,848.3,1515.3,c2,"C 1");
  }
}