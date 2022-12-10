package model.shapes;

/**
 * The type Rectangle.
 */
public class rectangle implements I2DShape {

  private Double posX;
  private Double posY;
  private Double width;
  private Double height;
  private String name;
  private Color col;




  /**
   * Instantiates a new Rectangle.
   *
   * @param xPos   the x pos
   * @param yPos   the y pos
   * @param width  the width
   * @param height the height
   * @param col    the col
   * @param name   the name
   * @throws IllegalArgumentException the illegal argument exception
   */
  public rectangle(Double xPos, Double yPos, Double width, Double height,
                   Color col, String name) throws IllegalArgumentException {
    if(xPos == null || yPos == null || width == null || height == null || col == null
            || name == null || width < 0 || height < 0 || name == "") {
      throw new IllegalArgumentException("Invalid parameters: rectangle");
    }
    this.posX = xPos;
    this.posY = yPos;
    this.width = width;
    this.height = height;
    this.col = col;
    this.name = name;
  }

  /**
   * Getter for X position.
   * @return Double.
   * @throws NullPointerException if position is null.
   */
  @Override
  public Double getPosX() throws NullPointerException {
    if(this.posX == null) {
      throw new NullPointerException("field is null: rectangle.");
    }
    return this.posX;
  }

  /**
   * Getter for Y position.
   * @return Double.
   * @throws NullPointerException if position is null.
   */
  @Override
  public Double getPosY() throws NullPointerException {
    if(this.posY == null) {
      throw new NullPointerException("field is null: rectangle.");
    }
    return this.posY;
  }

  /**
   * Getter for third dimension.
   * @return Double.
   * @throws NullPointerException if field is null.
   */
  @Override
  public Double getDim3() throws NullPointerException {
    if(this.width == null) {
      throw new NullPointerException("field is null: rectangle.");
    }
    return this.width;
  }

  /**
   * Getter for fourth dimension.
   * @return Double.
   * @throws NullPointerException if field is null.
   */
  @Override
  public Double getDim4() throws NullPointerException {
    if(this.height == null) {
      throw new NullPointerException("field is null: rectangle.");
    }
    return this.height;
  }

  /**
   * Getter for name field.
   * @return Double.
   * @throws NullPointerException if field is null.
   */
  @Override
  public String getName() throws NullPointerException {
    if(this.name == null) {
      throw new NullPointerException("field is null: rectangle.");
    }
    return this.name;
  }

  /**
   * Getter for color field.
   * @return Double.
   * @throws NullPointerException if field is null.
   */
  @Override
  public Color getColor() throws NullPointerException {
    if(this.col == null) {
      throw new NullPointerException("field is null: rectangle.");
    }
    return this.col;
  }

  /**
   * Setter for the X pos field.
   * @param posX new X position.
   * @throws IllegalArgumentException if input is null.
   */
  @Override
  public void setPosX(Double posX) throws IllegalArgumentException {
    if(posX == null) {
      throw new IllegalArgumentException("X cannot be null.");
    }
    this.posX = posX;
  }

  /**
   * Setter for the Y pos field.
   * @param posY new Y position.
   * @throws IllegalArgumentException if input is null.
   */
  @Override
  public void setPosY(Double posY) throws IllegalArgumentException {
    if(posY == null) {
      throw new IllegalArgumentException("Y cannot be null.");
    }
    this.posY = posY;
  }

  /**
   * Setter for the Width pos field.
   * @param width new Width position.
   * @throws IllegalArgumentException if input is null.
   */
  @Override
  public void setDim3(Double width) throws IllegalArgumentException {
    if(width == null || width < 0) {
      throw new IllegalArgumentException("Width cannot be less than 0 or null.");
    }
    this.width = width;
  }

  /**
   * Setter for the height field.
   * @param height new height position.
   * @throws IllegalArgumentException if input is null.
   */
  @Override
  public void setDim4(Double height) throws IllegalArgumentException {
    if(height == null || height < 0) {
      throw new IllegalArgumentException("height cannot be less than 0 or null.");
    }
    this.height = height;
  }

  /**
   * Setter for the name field.
   * @param name new name.
   * @throws IllegalArgumentException if input is null.
   */
  @Override
  public void setName(String name) throws IllegalArgumentException {
    if(name== null || name == "") {
      throw new IllegalArgumentException("name cannot be null or empty string.");
    }
    this.name = name;
  }

  /**
   * Setter for the color field.
   * @param col new color position.
   * @throws IllegalArgumentException if input is null.
   */
  @Override
  public void setColor(Color col) throws IllegalArgumentException {
    if(col == null) {
      throw new IllegalArgumentException("Color cannot be null.");
    }
    this.col = col;
  }

  /**
   * Overridden toString.
   * @return String.
   */
  @Override
  public String toString() {
    return "Type: Rectangle\n" + "Name: " + this.getName() + "\nMin corner: ("
            + this.getPosX() + ", " + this.getPosY() + ") ,"
            +  " Width: " + this.getDim3() + ", Height: " +
            this.getDim4() + ", Color: " + this.getColor() + "\n";
  }

  /**
   * Generate and return true copy.
   * @return I2DShape.
   */
  @Override
  public I2DShape copy() {
    return new rectangle(posX,posY,width,height,col,name);
  }

  @Override
  public String getType() {
    return "Rectangle";
  }
}
