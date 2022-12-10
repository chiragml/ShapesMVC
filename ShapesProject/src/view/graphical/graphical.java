package view.graphical;

import java.awt.*;

import javax.swing.*;

import model.album.IAlbum;
import model.shapes.I2DShape;
import model.snapshot.snaps.ISnapshot;

/**
 * The type Graphical.
 */
public class graphical extends JComponent {

  private ISnapshot snap;

  /**
   * Instantiates a new Graphical.
   *
   * @param snap the snap
   */
  public graphical(ISnapshot snap) {
    this.snap = snap;
    this.setPreferredSize(new Dimension(500,500));
    this.setVisible(true);
  }

  /**
   * Sets snap.
   *
   * @param snap the snap
   */
  public void setSnap(ISnapshot snap) {
    this.snap = snap;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
//    g.setColor(Color.ORANGE);
//    g.fillRect(22,33,32,66);

    for(String shapeID : snap.shapeList().keySet()){
      I2DShape shape = snap.getShape(shapeID);

      int xPos = (int) Math.round(shape.getPosX());
      int yPos = (int)Math.round(shape.getPosY());
      int dim3 = (int)Math.round(shape.getDim3());
      int dim4 = (int)Math.round(shape.getDim4());

      int red = (int) Math.round(shape.getColor().getRed());
      int green = (int) Math.round(shape.getColor().getGreen());
      int blue = (int) Math.round(shape.getColor().getBlue());
      String type = shape.getType();
      if(type.equalsIgnoreCase("Rectangle")) {
        g.setColor(new Color(red,green,blue));
        g.fillRect(xPos,yPos,dim3,dim4);
      } else if (type.equalsIgnoreCase("Oval")) {
        g.setColor(new Color(red,green,blue));
        g.fillOval(xPos,yPos,dim3,dim4);
      }
    }
  }

}
