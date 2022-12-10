package snapshot.transformations;

import org.junit.Before;
import org.junit.Test;

import model.shapes.Color;
import model.shapes.I2DShape;
import model.shapes.oval;
import model.snapshot.transformations.transformImpl;

import static org.junit.Assert.*;

/**
 * The type Transform impl test.
 */
public class transformImplTest {

  private Color c1;
  private I2DShape s1;
  private Color c2;

  /**
   * Initialize.
   */
  @Before
  public void initialize() {
    c1 = new Color(0.00,23.00,6.00);
    s1 = new oval(66.00,55.0,10.0,10.0,c1,"Oval 1");
    c2 = new Color(0.002,55.0,33.0);
  }

  /**
   * Move transform.
   */
  @Test
  public void MoveTransform() {
    transformImpl.transform(s1,100.0,3000.0);
    assertNotEquals(66.00,s1.getPosX(),0.01);
  }

  /**
   * Invalid move.
   */
  @Test(expected = IllegalArgumentException.class)
  public void InvalidMove() {
    transformImpl.transform(null,465.0,66.0);
  }

  /**
   * Invalid move 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void InvalidMove2() {
    transformImpl.transform(s1,null,56.00);
  }

  /**
   * Invalid move 3.
   */
  @Test(expected = IllegalArgumentException.class)
  public void InvalidMove3() {
    transformImpl.transform(s1,66.0,null);
  }

  /**
   * Color transform.
   */
  @Test
  public void ColorTransform() {
    transformImpl.transform(s1,c2);
    assertEquals(c2, s1.getColor());
  }

  /**
   * Invalid color 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void InvalidColor1() {
    transformImpl.transform(null,c1);
  }

  /**
   * Scale transform.
   */
  @Test
  public void ScaleTransform() {
    transformImpl.transform(s1,3.0, 4.0, 3);
    assertEquals(30.0,s1.getDim3(),0.01);
  }

  /**
   * Invalid scale 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void InvalidScale1() {
    transformImpl.transform(null,3.00, 6.00,3);
  }

  /**
   * Invalid scale 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void InvalidScale2() {
    transformImpl.transform(s1,-3.0,3.0,6);
  }
}