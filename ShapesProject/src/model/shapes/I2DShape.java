package model.shapes;

/**
 * The interface 2 d shape.
 */
public interface I2DShape {
//  public I2DShape createShape(String type, Double a, Double b, Double c, Double d,
//                           Color col, String name);
//
//  // Keeping this (|create Shape|) here for now until I figure out how to actually do what I'm thinking of doing.


  /**
   * Gets pos x.
   *
   * @return the pos x
   */
  public Double getPosX();

  /**
   * Gets pos y.
   *
   * @return the pos y
   */
  public Double getPosY();

  /**
   * Gets dim 3.
   *
   * @return the dim 3
   */
  public Double getDim3();

  /**
   * Gets dim 4.
   *
   * @return the dim 4
   */
  public Double getDim4();

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName();

  /**
   * Gets color.
   *
   * @return the color
   */
  public Color getColor();

  /**
   * Sets pos x.
   *
   * @param posX the pos x
   */
  public void setPosX(Double posX);

  /**
   * Sets pos y.
   *
   * @param posY the pos y
   */
  public void setPosY(Double posY);

  /**
   * Sets dim 3.
   *
   * @param dim3 the dim 3
   */
  public void setDim3(Double dim3);

  /**
   * Sets dim 4.
   *
   * @param dim4 the dim 4
   */
  public void setDim4(Double dim4);

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name);

  /**
   * Sets color.
   *
   * @param col the col
   */
  public void setColor(Color col);
  @Override
  public String toString();

  /**
   * Copy 2 d shape.
   *
   * @return the 2 d shape
   */
  public I2DShape copy();
  String getType();
}
