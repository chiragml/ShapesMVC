package model.snapshot.transformations;

import model.shapes.I2DShape;

/**
 * The type Move.
 */
public class move {
  /**
   * Move transform 2 d shape.
   *
   * @param x        the x
   * @param y        the y
   * @param oldShape the old shape
   * @return the 2 d shape
   */
  public static I2DShape moveTransform(Double x, Double y, I2DShape oldShape) {
    oldShape.setPosX(x);
    oldShape.setPosY(y);
    return oldShape;
  }
}
