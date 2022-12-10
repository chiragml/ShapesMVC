package model.snapshot.transformations;

import model.shapes.Color;
import model.shapes.I2DShape;

/**
 * The type Change color.
 */
public class changeColor {
  /**
   * Color change 2 d shape.
   *
   * @param oldShape the old shape
   * @param color    the color
   * @return the 2 d shape
   */
  public static I2DShape colorChange(I2DShape oldShape, Color color) {
    oldShape.setColor(color);
    return oldShape;
  }
}
