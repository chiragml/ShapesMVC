package model.album;
import model.snapshot.snaps.ISnapshot;
import model.shapes.Color;

import java.util.List;
import java.util.Map;

/**
 * The interface Album.
 */
public interface IAlbum {
  /**
   * Add shape.
   *
   * @param type the type
   * @param posX the pos x
   * @param posY the pos y
   * @param dim3 the dim 3
   * @param dim4 the dim 4
   * @param col  the col
   * @param name the name
   */
  public void addShape(String type, Double posX, Double posY, Double dim3, Double dim4,
                       Color col, String name);

  /**
   * Print album string.
   *
   * @return the string
   */
  public String printAlbum();

  /**
   * Take snap.
   *
   * @param desc the desc
   */
  public void takeSnap(String desc);

  /**
   * Remove snap.
   *
   * @param snapID the snap id
   */
  public void removeSnap(String snapID);
//  public void move(Integer shapeID, Double newX, Double newY);
//  public void scale(Integer shapeID, Double scale);
//  public void changeColor(Integer shapeID, Color newColor);

  /**
   * Transform.
   *
   * @param shapeID the shape id
   * @param newX    the new x
   * @param newY    the new y
   */
  public void transform(String shapeID, Double newX, Double newY);

  /**
   * Transform.
   *
   * @param shapeID  the shape id
   * @param newColor the new color
   */
  public void transform(String shapeID, Color newColor);

  /**
   * Transform.
   *
   * @param shapeID the shape id
   * @param newSize the new size
   */
  public void transform(String shapeID, Double newSizeDim1, Double newSizeDim2, int identifier);

  /**
   * Gets snap.
   *
   * @param snapID the snap id
   * @return the snap
   */
  public ISnapshot getSnap(String snapID);

  /**
   * Gets snap i ds.
   *
   * @return the snap i ds
   */
  public List<String> getSnapIDs();

  /**
   * Gets album.
   *
   * @return the album
   */
  public Map<String, ISnapshot> getAlbum();

  /**
   * Gets current canvas.
   *
   * @return the current canvas
   */
  public ISnapshot getCurrentCanvas();
  public void removeShape(String ShapeID);

}
