package model.snapshot.transformations;

import model.shapes.Color;
import model.shapes.I2DShape;

/**
 * The type Transform.
 */
public class transformImpl {
  /**
   * Transform 2 d shape.
   *
   * @param shape the shape
   * @param newX  the new x
   * @param newY  the new y
   * @return the 2 d shape
   * @throws IllegalArgumentException the illegal argument exception
   */
  public static I2DShape transform(I2DShape shape, Double newX, Double newY)
          throws IllegalArgumentException {
    if(shape == null || newX == null || newY == null) {
      throw new IllegalArgumentException("Invalid move parameters!");
    }
    return move.moveTransform(newX,newY,shape);
  }

  /**
   * Transform 2 d shape.
   *
   * @param shape    the shape
   * @param newColor the new color
   * @return the 2 d shape
   * @throws IllegalArgumentException the illegal argument exception
   */
  public static I2DShape transform(I2DShape shape, Color newColor) throws IllegalArgumentException {
    if(shape == null || newColor == null) {
      throw new IllegalArgumentException("Invalid color transformation arguments!");
    }
    return changeColor.colorChange(shape,newColor);
  }

  /**
   * Transform 2 d shape.
   *
   * @param shape   the shape
   * @param newSizeDim1 and newSizeDim2 the new size
   * @return the 2 d shape
   * @throws IllegalArgumentException the illegal argument exception
   */
  public static I2DShape transform(I2DShape shape, Double newSizeDim1, Double newSizeDim2,
                                   int scaleIdentifier) throws IllegalArgumentException {
    if(shape == null || newSizeDim1 == null || newSizeDim1.isInfinite()
            || newSizeDim1 < 0 || newSizeDim2 == null || newSizeDim2.isInfinite()
            || newSizeDim2 < 0) {
      throw new IllegalArgumentException("Invalid resize transformation arguments!");
    }
    return scale.scaleTransform(shape,newSizeDim1, newSizeDim2);
  }
}
