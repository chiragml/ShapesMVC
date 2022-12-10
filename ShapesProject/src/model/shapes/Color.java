package model.shapes;

/**
 * The type Color.
 */
public class Color {
  private Double red;
  private Double green;
  private Double blue;

  /**
   * Instantiates a new Color.
   *
   * @param red   the red
   * @param green the green
   * @param blue  the blue
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Color (Double red, Double green, Double blue) throws IllegalArgumentException {
    if (red == null || green == null || blue == null) {
      throw new IllegalArgumentException(" color fields cannot be null");
    }
    if(red < 0 || green < 0 || blue < 0) {
      throw new IllegalArgumentException("color fields cannot be negative");
    }
    if(red > 255 || green > 255 || blue > 255) {
      throw new IllegalArgumentException("Color field cannot be greater than 255");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Gets red.
   *
   * @return the red
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Double getRed() throws IllegalArgumentException {
    if(this.red == null) {
      throw new IllegalArgumentException("Cannot access null color field");
    }
    return red;
  }

  /**
   * Gets green.
   *
   * @return the green
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Double getGreen() throws IllegalArgumentException {
    if(this.green == null) {
      throw new IllegalArgumentException("Cannot access null color field");
    }
    return green;
  }

  /**
   * Gets blue.
   *
   * @return the blue
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Double getBlue() throws IllegalArgumentException {
    if(this.blue == null) {
      throw new IllegalArgumentException("Cannot access null color field");
    }
    return blue;
  }

  /**
   * Sets red.
   *
   * @param red the red
   * @throws IllegalArgumentException the illegal argument exception
   */
  public void setRed(Double red) throws IllegalArgumentException {
    if(red == null || red < 0 || red > 255) {
      throw new IllegalArgumentException("Invalid input to red color.");
    }
    this.red = red;
  }

  /**
   * Sets green.
   *
   * @param green the green
   * @throws IllegalArgumentException the illegal argument exception
   */
  public void setGreen(Double green) throws IllegalArgumentException {
    if(green == null || green < 0 || green > 255) {
      throw new IllegalArgumentException("Invalid input to green color.");
    }
    this.green = green;
  }

  /**
   * Sets blue.
   *
   * @param blue the blue
   * @throws IllegalArgumentException the illegal argument exception
   */
  public void setBlue(Double blue) throws IllegalArgumentException {
    if(blue == null || blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Invalid input to blue color.");
    }
    this.blue = blue;
  }

  @Override
  public String toString() {
    return "(" + this.getRed() + ", " + this.getGreen()
            + ", " + this.getBlue() + ") \n";
  }
}
