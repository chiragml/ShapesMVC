package model.snapshot.snaps;


import java.util.HashMap;

import model.shapes.Color;
import model.shapes.I2DShape;

/**
 * The interface Snapshot.
 */
public interface ISnapshot {
  /**
   * Gets time stamp.
   *
   * @return the time stamp
   */
  public String getTimeStamp();

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription();

  /**
   * Shape list hash map.
   *
   * @return the hash map
   */
  public HashMap<String, I2DShape> shapeList();

  /**
   * Add shape.
   *
   * @param type the type
   * @param a    the a
   * @param b    the b
   * @param c    the c
   * @param d    the d
   * @param col  the col
   * @param name the name
   */
  public void add_Shape(String type, Double a, Double b, Double c, Double d,
                       Color col, String name);

  /**
   * Remove shape.
   *
   * @param shapeID the shape id
   */
//  public I2DShape transform(String type, Integer shapeID);
  public void removeShape(String shapeID);

  /**
   * Gets current shape id.
   *
   * @return the current shape id
   */
  public int getCurrentShapeID();

  /**
   * Add shape.
   *
   * @param shape the shape
   */
  public void add_Shape(I2DShape shape);

  public String toString();

  /**
   * Gets shape.
   *
   * @param shapeID the shape id
   * @return the shape
   */
  public I2DShape getShape(String shapeID);
}
