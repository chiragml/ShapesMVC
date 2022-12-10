package view.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.album.IAlbum;
import model.album.albumImpl;
import model.shapes.Color;
import model.shapes.I2DShape;
import model.snapshot.snaps.ISnapshot;

/**
 * The type Web.
 */
public class web {
//  public static void main(String[] args) {
//
//    IAlbum album = new albumImpl();
//
//    album.addShape("Oval", 500.0,500.0,30.0,30.0,
//            new Color(5.0,60.0,10.0),"Oval 1");
//    album.addShape("Rectangle", 500.0,500.0,30.0,30.0,
//            new Color(5.0,60.0,10.0),"Rect 1");
//    album.takeSnap("snap 1");
//
//    try {
//      Thread.sleep(5);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
//
//    album.addShape("Oval", 550.0,500.0,30.0,30.0,
//            new Color(5.0,60.0,10.0),"Oval 2");
//
//    album.takeSnap("Snap 2");
//    System.out.println(album.getAlbum().size());
//
//    File f = new File("D:\\1761424\\courses\\OOD\\module8\\HW7\\hw7\\buildingsOut.html");
//
//    web w = new web();
//    w.createView(album, f);
//
//  }
  private String html;

  /**
   * Instantiates a new Web.
   *
   * @param album the album
   * @param out   the out
   * @param xMax  the x max
   * @param yMax  the y max
   */
  public web(IAlbum album, File out, int xMax, int yMax) {
    createView(album,out,xMax,yMax);
  }

  /**
   * Gets html.
   *
   * @return the html
   */
  public String getHtml() {
    return this.html;
  }

  private void createView(IAlbum album, File out, int xMax, int yMax) {
//    File f = new File("D:\\1761424\\courses\\OOD\\module8\\HW7\\hw7\\buildingsOut.html");
    File f = out;
    int xM = 1000;
    int yM = 1000;

    if(xMax > 0) {
      xM = xMax;
    }
    if(yMax > 0) {
      yM = yMax;
    }

    html = "<html>\n" +
            "    <head>\n" +
            "        <title>Web View</title>\n" +
            "        <style>\n" +
            "            .snapshot {\n" +
            "                border: 5px outset red;\n" +
            "                background-color: lightblue;\n" +
            "            }\n" +
            "        </style>\n" +
            "    </head>\n" +
            "    <body>\n";




    Map<String, ISnapshot> map = album.getAlbum();
//    int i = 1;
    for(String id : map.keySet()) {
      html = html + "\t\t<div class = " + " \"Snapshot\">\n" +
              "\t\t\t<h2>"+ map.get(id).getDescription() +" </h2>\n" +
              "\t\t\t<h2>"+ id + "</h2>\n" +
              "\t\t\t\t<svg width= \""  + xM +"\" height=\" " + yM + "\">\n";
      Map<String, I2DShape> shapeMap = map.get(id).shapeList();
      for(String shapeID : shapeMap.keySet()) {
        I2DShape temp = shapeMap.get(shapeID);
        if(temp.getType().equalsIgnoreCase("Rectangle")) {
          html = html + "\t\t\t\t\t<rect id = \"" + temp.getName() +
                  "\" x=\"" + temp.getPosX() + "\" y=\"" + temp.getPosY() +
                  "\" width= \"" + temp.getDim3() + "\" height= \"" + temp.getDim4() +
                  "\" fill= \" rgb(" + temp.getColor().getRed() + ", " +
                  temp.getColor().getGreen() + ", " + temp.getColor().getBlue() + ")\" ></rect>\n";
        } else if (temp.getType().equalsIgnoreCase("Oval")) {
          html = html + "\t\t\t\t\t<ellipse id = \"" + temp.getName() +
                  "\" cx=\"" + temp.getPosX() + "\" cy=\"" + temp.getPosY() +
                  "\" rx= \"" + temp.getDim3() + "\" ry = \"" + temp.getDim4() +
                  "\" fill= \" rgb(" + temp.getColor().getRed() + ", " +
                  temp.getColor().getGreen() + ", " + temp.getColor().getBlue() + ")\" ></ellipse>\n";
        }
      }
      html = html + "\t\t\t\t</svg>\n" +
              "\t\t\t</div>\n" +
              "\t\t<p></p>\n";
//      i++;
    }
    html = html + "\t</body>\n" +
            "</html> \n";
//    System.out.println(html);

//    File f = new File("out.html");
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(f));
      bw.write(html);
      bw.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
