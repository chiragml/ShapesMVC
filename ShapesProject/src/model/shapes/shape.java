package model.shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Shape.
 */
public class shape {
  /**
   * The Available shapes.
   */
  public List<I2DShape> availableShapes = new ArrayList<>();

  /**
   * Create shape 2 d shape.
   *
   * @param type the type
   * @param a    the a
   * @param b    the b
   * @param c    the c
   * @param d    the d
   * @param col  the col
   * @param name the name
   * @return the 2 d shape
   * @throws IllegalArgumentException the illegal argument exception
   * @throws NoSuchElementException   the no such element exception
   */
  public static I2DShape createShape(String type, Double a, Double b, Double c, Double d,
                                     Color col, String name)
          throws IllegalArgumentException, NoSuchElementException{

    if(type.equalsIgnoreCase("rectangle")) {
      return new rectangle(a,b,c,d,col,name);
    } else if (type.equalsIgnoreCase("Oval")) {
      return new oval(a,b,c,d,col,name);
    } else {
      throw new NoSuchElementException("This type of shape doesn't exist!");
    }
  }
}
