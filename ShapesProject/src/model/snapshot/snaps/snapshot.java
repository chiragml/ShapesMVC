package model.snapshot.snaps;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import model.shapes.I2DShape;
import model.shapes.shape;
import model.shapes.Color;

/**
 * The type Snapshot.
 */
public class snapshot implements ISnapshot {

  /**
   * The Current time.
   */
  private String currentTime;
  private LinkedHashMap<String, I2DShape> shapesSnap = new LinkedHashMap<>();
  private String description;

  private boolean firstShapeHelper = true;
  private Integer currentShapeID = null;
  private String name;
//  private ISnapshot copy;

  /**
   * Instantiates a new Snapshot.
   *
   * @param description the description
   * @throws IllegalArgumentException the illegal argument exception
   */
  public snapshot(String description) throws  IllegalArgumentException {
    if(description == null ) {
      throw new IllegalArgumentException("Give some description");
    }
    this.description = description;
  }

  /**
   * Makes and gets the timestamp for the snapshot object.
   * @return String.
   */
  @Override
  public String getTimeStamp() {
    currentTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            .format(new Timestamp(System.currentTimeMillis()));
    return currentTime;
  }

  /**
   * Get the description of the snapshot.
   * @return String.
   */
  @Override
  public String getDescription() {
    return description;
  }

  /**
   * Get the ShapeList for the snap.
   * @return Hashmap that has all the shapes.
   */
  @Override
  public HashMap<String, I2DShape> shapeList() {
    return shapesSnap;
  }

  /**
   * The function adds the shape to the snapshot.
   * @param type type of the shape.
   * @param posX Get the X position.
   * @param posY Get the Y position.
   * @param dim3 Get the Third dimension.
   * @param dim4 Get the Fourth Dimension.
   * @param col Get the Color for the shape.
   * @param name Get the name of the shape.
   */
  @Override
  public void add_Shape(String type, Double posX, Double posY, Double dim3, Double dim4,
                       Color col, String name) {

    if (firstShapeHelper == true) {
      currentShapeID = 0;
      firstShapeHelper = false;
    }

    I2DShape shp = shape.createShape(type,posX,posY,dim3, dim4,col,name);
    this.name = name;
    shapesSnap.put(name, shp);
    currentShapeID++;
  }

  /**
   * Method overload for the add_Shape method.
   * @param shape object.
   */
  @Override
  public void add_Shape(I2DShape shape) {
    if(shape == null) {
      throw new IllegalArgumentException("Shape cannot be null");
    }
    if(firstShapeHelper == true) {
      currentShapeID = 0;
      firstShapeHelper = false;
    }
    this.name = shape.getName();
    shapesSnap.put(name, shape);
    currentShapeID++;
  }

  /**
   * Method that helps remove shape from the snap.
   * @param shapeID Get the ID of the shape to be removed.
   */
  @Override
  public void removeShape(String shapeID) {
    if(shapeID == null || !shapesSnap.containsKey(shapeID)) {
      throw new IllegalArgumentException("Shape not found in the snap");
    }
    shapesSnap.remove(shapesSnap.get(shapeID));
  }


  /**
   * Get current shape ID/
   * @return Integer ID.
   * @throws IllegalArgumentException if there is no shape in the snap.
   */
  @Override
  public int getCurrentShapeID() throws IllegalArgumentException {
    if(firstShapeHelper == true) {
      throw new IllegalArgumentException("No shape has been added yet.");
    }
    return this.currentShapeID;
  }

  /**
   * An overridden toString.
   * @return String.
   */
  @Override
  public String toString() {

    List<I2DShape> temp = shapesSnap.values().stream().collect(Collectors.toList());
    String temp1 = "Snap Description: "
            + this.getDescription() + "\n"
            + "Shape Information:\n";
    List<String> keys = shapesSnap.keySet().stream().collect(Collectors.toList());
    int i = 0;
    for(I2DShape s : temp) {
      temp1 = temp1
              + "ShapeID: "
              + keys.get(i) + "\n"
              + s.toString() + "\n";
      i++;
    }
    return temp1;
  }

  /**
   * Get a particular shape from the snap.
   * @param shapeID as input.
   * @return the requested I2DShape.
   * @throws IllegalArgumentException if teh shapeID is null or ID is invalid.
   */
  @Override
  public I2DShape getShape(String shapeID) throws IllegalArgumentException {
    if(shapeID == null || !shapesSnap.containsKey(shapeID)) {
      throw new IllegalArgumentException("Invalid shape ID!");
    }
    return this.shapesSnap.get(shapeID);
  }

}
