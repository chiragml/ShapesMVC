package model.snapshot.transformations;

import model.shapes.I2DShape;

/**
 * The type Scale.
 */
public class scale {
  /**
   * Scale transform 2 d shape.
   *
   * @param shape    the shape
   * @param newScale1 and newScale2 the new scale
   * @return the 2 d shape
   */
  public static I2DShape scaleTransform(I2DShape shape, Double newScale1,Double newScale2) {
    shape.setDim3(newScale1);
    shape.setDim4(newScale2);
    return shape;
  }
}
