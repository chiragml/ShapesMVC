package shapes;

import org.junit.Before;
import org.junit.Test;

import model.shapes.Color;

import static org.junit.Assert.assertEquals;

/**
 * The type Color test.
 */
public class ColorTest {

  private Color c1;
  private Color c2;

  /**
   * Initialize.
   */
  @Before
  public void initialize() {
    c1 = new Color(55.3,66.3,77.3);
    c2 = new Color(0.0,0.0,0.0);
  }

  /**
   * Invalid color null r.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidColorNullR() {
    c1 = new Color(null,0.0,0.0);
  }

  /**
   * Invalid color null g.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidColorNullG() {
    c1 = new Color(0.0,null,0.0);
  }

  /**
   * Invalid color null b.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidColorNullB() {
    c1 = new Color(0.0,0.0,null);
  }

  /**
   * Invalid color r less than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidColorRLessThan0() {
    c1 = new Color(-1.0,0.0,0.0);
  }

  /**
   * Invalid color g less than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidColorGLessThan0() {
    c1 = new Color(0.0,-1.0,0.0);
  }

  /**
   * Invalid color b less than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidColorBLessThan0() {
    c1 = new Color(0.0,0.0,-1.0);
  }

  /**
   * Invalid color r greater than 255.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidColorRGreaterThan255() {
    c1 = new Color(256.0,0.0,0.0);
  }

  /**
   * Invalid color g greater than 255.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidColorGGreaterThan255() {
    c1 = new Color(0.0,4654.56,0.0);
  }

  /**
   * Invalid color b greater than 255.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidColorBGreaterThan255() {
    c1 = new Color(0.0,0.0,255.1);
  }


  /**
   * Gets red.
   */
//  c1 = new Color(55.3,66.3,77.3);
////  c2 = new Color(0.0,0.0,0.0);
  @Test
  public void getRed() {
    assertEquals(55.3,c1.getRed(),0.01);
    assertEquals(0.0,c2.getRed(),0.01);
  }

  /**
   * Gets green.
   */
  @Test
  public void getGreen() {
    assertEquals(66.3,c1.getGreen(),0.01);
    assertEquals(0.0,c2.getGreen(),0.01);
  }

  /**
   * Gets blue.
   */
//  c1 = new Color(55.3,66.3,77.3);
////  c2 = new Color(0.0,0.0,0.0);
  @Test
  public void getBlue() {
    assertEquals(77.3,c1.getBlue(),0.01);
    assertEquals(0.0,c2.getBlue(),0.01);
  }

  /**
   * Sets red.
   */
//  c1 = new Color(55.3,66.3,77.3);
////  c2 = new Color(0.0,0.0,0.0);
  @Test
  public void setRed() {
    c1.setRed(0.01);
    assertEquals(0.01,c1.getRed(),0.01);

    c2.setRed(254.9);
    assertEquals(254.9,c2.getRed(),0.01);
  }

  /**
   * Invalid red null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidRedNull() {
    c1.setRed(null);
  }

  /**
   * Invalid red less than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidRedLessThan0() {
    c1.setRed(-0.000001);
  }

  /**
   * Invalid red greater than 255.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidRedGreaterThan255() {
    c1.setRed(255.0001);
  }

  /**
   * Sets green.
   */
  @Test
  public void setGreen() {
    c1.setGreen(0.01);
    assertEquals(0.01,c1.getGreen(),0.01);

    c2.setGreen(254.9);
    assertEquals(254.9,c2.getGreen(),0.01);
  }

  /**
   * Invalid green null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidGreenNull() {
    c1.setGreen(null);
  }

  /**
   * Invalid green less than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidGreenLessThan0() {
    c1.setGreen(-0.000001);
  }

  /**
   * Invalid green greater than 255.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidGreenGreaterThan255() {
    c1.setGreen(255.0001);
  }

  /**
   * Sets blue.
   */
  @Test
  public void setBlue() {
    c1.setBlue(0.01);
    assertEquals(0.01,c1.getBlue(),0.01);

    c2.setBlue(254.9);
    assertEquals(254.9,c2.getBlue(),0.01);
  }

  /**
   * Invalid blue null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidBlueNull() {
    c1.setBlue(null);
  }

  /**
   * Invalid blue less than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidBlueLessThan0() {
    c1.setBlue(-0.000001);
  }

  /**
   * Invalid blue greater than 255.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidBlueGreaterThan255() {
    c1.setBlue(255.0001);
  }
}