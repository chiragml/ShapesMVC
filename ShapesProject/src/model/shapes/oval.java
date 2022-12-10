package model.shapes;

/**
 * The type Oval.
 */
public class oval implements I2DShape {

  private Double posX;
  private Double posY;
  private Double rad1;
  private Double rad2;
  private String name;

  private Color col;


  /**
   * Instantiates a new Oval.
   *
   * @param PosX the pos x
   * @param PosY the pos y
   * @param rad1 the rad 1
   * @param rad2 the rad 2
   * @param col  the col
   * @param name the name
   * @throws IllegalArgumentException the illegal argument exception
   */
  public oval(Double PosX, Double PosY, Double rad1, Double rad2,
              Color col, String name) throws IllegalArgumentException {
    if(PosX == null || PosY == null || rad1 == null || rad2 == null || col == null
            || name == null || rad1 < 0 || rad2 < 0 || name == "") {
      throw new IllegalArgumentException("Invalid parameters: oval");
    }

    this.posX = PosX;
    this.posY = PosY;
    this.rad1 = rad1;
    this.rad2 = rad2;
    this.name = name;
    this.col = col;
  }

  /**
   * Gets pos x.
   *
   * @return the pos x
   */
  @Override
  public Double getPosX() throws NullPointerException {
    if(this.posX == null) {
      throw new NullPointerException("field is null: Oval");
    }
    return this.posX;
  }

  /**
   * Gets pos y.
   *
   * @return the pos y
   */
  @Override
  public Double getPosY() throws NullPointerException {
    if(this.posY == null) {
      throw new NullPointerException("field is null: Oval");
    }
    return this.posY;
  }

  /**
   * Gets dim 3.
   *
   * @return the dim 3
   */
  @Override
  public Double getDim3() throws NullPointerException {
    if(this.rad1 == null) {
      throw new NullPointerException("field is null: Oval");
    }
    return this.rad1;
  }

  /**
   * Gets dim 4.
   *
   * @return the dim 4
   */
  @Override
  public Double getDim4() throws NullPointerException {
    if(this.rad2 == null) {
      throw new NullPointerException("field is null: Oval");
    }
    return this.rad2;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  @Override
  public String getName() throws NullPointerException {
    if(this.name == null) {
      throw new NullPointerException("field is null: Oval");
    }
    return this.name;
  }

  /**
   * Gets color.
   *
   * @return the color
   */
  @Override
  public Color getColor() throws NullPointerException {
    if(this.col == null) {
      throw new NullPointerException("field is null: Oval");
    }
    return this.col;
  }

  /**
   * Sets pos x.
   *
   * @param posX the pos x
   */
  @Override
  public void setPosX(Double posX) throws IllegalArgumentException {
    if(posX == null) {
      throw new IllegalArgumentException("X cannot be null.");
    }
    this.posX = posX;
  }

  /**
   * Sets pos y.
   *
   * @param posY the pos y
   */
  @Override
  public void setPosY(Double posY) throws IllegalArgumentException {
    if(posY == null) {
      throw new IllegalArgumentException("Y cannot be null.");
    }
    this.posY = posY;
  }

  /**
   * Sets dim 3.
   *
   * @param rad1 the dim 3
   */
  @Override
  public void setDim3(Double rad1) throws IllegalArgumentException {
    if(rad1 == null || rad1 < 0) {
      throw new IllegalArgumentException("Radius 1 cannot be less than 0 or null.");
    }
    this.rad1 = rad1;
  }

  /**
   * Sets dim 4.
   *
   * @param rad2 the dim 4
   */
  @Override
  public void setDim4(Double rad2) throws IllegalArgumentException {
    if(rad2 == null || rad2 < 0) {
      throw new IllegalArgumentException("rad2 cannot be less than 0 or null.");
    }
    this.rad2 = rad2;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  @Override
  public void setName(String name) throws IllegalArgumentException {
    if(name== null || name == "") {
      throw new IllegalArgumentException("name cannot be null or empty string.");
    }
    this.name = name;
  }

  /**
   * Sets color.
   *
   * @param col the col
   */
  @Override
  public void setColor(Color col) throws IllegalArgumentException {
    if(col == null) {
      throw new IllegalArgumentException("Color cannot be null.");
    }
    this.col = col;
  }


  @Override
  public String toString() {
    return "Type: Oval\n"+"Name: " + this.getName()+ "\nCenter: ("
            + this.getPosX() + ", " + this.getPosY() + "), "
            + "X Radius: " + this.getDim3() + ", Y Radius: "
            + this.getDim4() + ", Color: " + this.getColor() + "\n";
  }

  /**
   * Generate deep copy.
   * @return I2DShape.
   */
  @Override
  public I2DShape copy() {
    return new oval(posX,posY,rad1,rad2,col,name);
  }

  @Override
  public String getType() {
    return "Oval";
  }
}
