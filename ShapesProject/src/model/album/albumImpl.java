package model.album;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.snapshot.snaps.ISnapshot;
import model.shapes.Color;
import model.shapes.I2DShape;
import model.snapshot.snaps.snapshot;
import model.snapshot.transformations.transformImpl;

/**
 * The type Album.
 */
public class albumImpl implements IAlbum{

  private LinkedHashMap<String, ISnapshot> album;
  private List<String> snapshotIDs = new ArrayList<>();
  private List<I2DShape> shapeList = new ArrayList<>();

  private ISnapshot canvas =  new snapshot("Current Canvas Status...!");
//  private boolean snapTaken = true;

  /**
   * Instantiates a new Album.
   */
  public albumImpl() {
    album = new LinkedHashMap<>();
  }

  /**
   * This method creates a Shape and adds it to the shapeList ArrayList.
   */
  @Override
  public void addShape(String type, Double posX, Double posY, Double dim3, Double dim4,
                       Color col, String name) {
    // Create attributes these will store concrete action classes, have setters for concrete
    // action classes

    I2DShape shape = model.shapes.shape.createShape(type,posX,posY,dim3,dim4,col,name);
    shapeList.add(shape);
    canvas.add_Shape(shape);
  }


  /**
   * This is more or less to string method of album.
   * @return String.
   */
  @Override
  public String printAlbum() {
    if(snapshotIDs == null) {
      return "";
    }
    String result = "";
    for(String id : snapshotIDs) {
      result = result
              + "Snapshot ID: "
              + id
              + "\n"
              + album.get(id).toString();
    }
    return result;
  }

  /**
   * The createCopy creates a copy of all the shapes in the shapeList at present.
   * And add a copy of those shapes to the snapshot instance.
   * @param desc to get the description of the new snap to be added.
   * @return ISnapshot instance.
   */
  private ISnapshot createDeepCopy(String desc) {

    ISnapshot snap = new snapshot(desc);

    for(I2DShape shape : shapeList) {
      snap.add_Shape(shape.copy());
    }
    return snap;
  }

  /**
   * Take snapshot calls createCopy that returns an instance of ISnapshot.
   */
  @Override
  public void takeSnap(String desc) throws IllegalArgumentException {
    if(desc == null) {
      throw  new IllegalArgumentException("Description cannot be null!");
    }
    try {
      Thread.sleep(5);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    String snpID = this.generateSnapID();
    ISnapshot snap = createDeepCopy(desc);
    album.put(snpID,snap);
    snapshotIDs.add(snpID);
  }

  /**
   * generates the ID for the snapshot.
   * @return String.
   */
  private String generateSnapID() {
    return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
            .format(new Timestamp(System.currentTimeMillis()));
  }

  /**
   * Helps remove the snap.
   * @param snapID takes a String as an ID.
   * @throws IllegalArgumentException if ID is null or not on the album.
   */
  @Override
  public void removeSnap(String snapID) throws IllegalArgumentException {
    if(snapID == null || !album.containsKey(snapID)) {
      throw new IllegalArgumentException("Invalid ID to remove!");
    }
    album.remove(snapID);
    snapshotIDs.remove(snapID);
  }

  /**
   * Move Transformation.
   * @param shapeID Gets the integer ID of shape an Input.
   * @param newX new X position.
   * @param newY new Y position.
   */
  @Override
  public void transform(String shapeID, Double newX, Double newY) {
    I2DShape shape = this.canvas.shapeList().get(shapeID);
    I2DShape newShape = transformImpl.transform(shape,newX,newY);
    this.canvas.shapeList().replace(shapeID,newShape);
  }

  /**
   * Color transformation method overload.
   * @param shapeID takes the shape ID as input.
   * @param newColor Takes new color.
   */
  @Override
  public void transform(String shapeID, Color newColor) {
    I2DShape shape = this.canvas.shapeList().get(shapeID);
    I2DShape newShape = transformImpl.transform(shape,newColor);
    this.canvas.shapeList().replace(shapeID,newShape);
  }

  /**
   * Scale transformation method overload.
   * @param shapeID Takes shape ID as an input.
   * @param newSizeDim1 gets the scale size.
   */
  @Override
  public void transform(String shapeID, Double newSizeDim1, Double newSizeDim2, int identifier) {
    I2DShape shape = this.canvas.shapeList().get(shapeID);
    I2DShape newShape = transformImpl.transform(shape, newSizeDim1, newSizeDim2,3);
    this.canvas.shapeList().replace(shapeID,newShape);
  }

  /**
   * Getter for a particular snap.
   * @param snapID Takes snapId as input.
   * @return Returns the requested snap.
   */
  @Override
  public ISnapshot getSnap(String snapID) {
    if(snapID == null || !this.album.containsKey(snapID)) {
      throw new IllegalArgumentException("Invalid snapID!");
    }
    return this.album.get(snapID);
  }

  /**
   * Gets a list of snap ID.
   * @return a list of string containing snap IDs.
   * @throws NullPointerException if the album is empty.
   */
  @Override
  public List<String> getSnapIDs() throws NullPointerException {
    if(this.snapshotIDs.isEmpty()) {
      throw new NullPointerException("The album is empty");
    }
    return this.snapshotIDs;
  }

  /**
   * Gets the actual Album.
   * @return Map of the album.
   */
  @Override
  public Map<String, ISnapshot> getAlbum() {
    return this.album;
  }

  /**
   * Get the canvas where everything is being done.
   * @return ISnapshot object.
   */
  @Override
  public ISnapshot getCurrentCanvas() {
    return this.canvas;
  }

  @Override
  public void removeShape(String ShapeID) {
    for(I2DShape s: shapeList) {
      if(s.getName().equalsIgnoreCase(ShapeID)) {
        shapeList.remove(s);
        break;
      }
    }
//    shapeList.remove(shapeList.get(ShapeID));
  }

}
