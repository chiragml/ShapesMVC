package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import model.album.IAlbum;
import model.shapes.Color;
import view.graphical.swingView;
import view.web.web;


/**
 * The type Controller.
 */
public class Controller {
  private static final int DEFAULT_X_HEIGHT = 1000;
  private static final int DEFAULT_Y_WIDTH = 1000;

  private static final int INDEX_ID_NAME = 1;
  private static final int INDEX_SHAPE_TYPE = 2;
  private static final int INDEX_X_POS = 3;
  private static final int INDEX_Y_POS = 4;
  private static final int INDEX_DIM1 = 5;
  private static final int INDEX_DIM2 = 6;
  private static final int INDEX_RED = 7;
  private static final int INDEX_GREEN = 8;
  private static final int INDEX_BLUE = 9;
  private static  final int resizeIdentifier = 3;

  private IAlbum album;
  /**
   * The Scan.
   */
  private static Scanner scan;
  /**
   * The File.
   */
  private File file;
  /**
   * The Out.
   */
  private File out = null;
  private String filePath;
  private String viewType;
  private int maxHeight;
  private int maxWidth;

  // Instantiate model
//  IAlbum album = new albumImpl();
//  ICanvas canvas = album.createCanvas("canvas");


  /**
   * Instantiates a new Controller.
   *
   * @param file      the file
   * @param maxHeight the max height
   * @param maxWidth  the max width
   * @param album     the album
   * @param out       the out
   * @param viewType  the view type
   * @throws IllegalArgumentException the illegal argument exception
   * @throws FileNotFoundException    the file not found exception
   */
  public Controller(File file, int maxHeight, int maxWidth, IAlbum album, File out, String viewType)
          throws IllegalArgumentException, FileNotFoundException {


    if (file == null) {
      throw new FileNotFoundException("File cannot be null");
    }
    if(album == null) {
      throw new IllegalArgumentException("Album cannot be null");
    }
    this.file = file;
    this.album = album;
    this.out = out;
    this.viewType = viewType;
    // Default if inputs are not valid based on prompt: "a default value of 1000 is used for both x (width) and y (height)";
    if (maxHeight <= 0) {
      maxHeight = DEFAULT_X_HEIGHT;
    }
    if (maxWidth <= 0) {
      maxWidth = DEFAULT_Y_WIDTH;
    }
//    this.file = file;
//    this.filePath = filePath;
    this.maxHeight = maxHeight;
    this.maxWidth = maxWidth;
    this.Control();
  }

  private void Control() throws FileNotFoundException {


    // Find current directory and pass that
//      file = new File(this.filePath);

    scan = new Scanner(file);
    System.out.println(scan.toString());
    while(scan.hasNextLine()) {
      String input = scan.nextLine().trim();
//      System.out.println(input);
      String[] inputSp = input.split(" ");
      ArrayList<String> inputSplit = new ArrayList<>();
      for(String s : inputSp) {
        if(!s.equalsIgnoreCase("")) {
          inputSplit.add(s);
        }
      }
      System.out.println(inputSplit);
//      inputSplit = (String[]) Arrays.stream(inputSplit).toArray();


//      ArrayList<String> temp = new ArrayList<>();
//      for(String s : inputSplit) {
//        temp.add(s);
//      }
//      Iterator<String> i = Arrays.stream(inputSplit).iterator();
//      int j = 0;
//      while(i.hasNext()) {
//        if(temp.get(j).equalsIgnoreCase("")) {
//          temp.remove(temp.get(j));
//          j++;
//        }
//        i.next();
//      }
//      for(j = 0; j < temp.size(); j++) {
//        inputSplit[j] = temp.get(j);
//      }
      if (inputSplit.size() == 0 || inputSplit.get(0).equalsIgnoreCase("#")) {
        continue;
      }

      if (inputSplit.get(0).equalsIgnoreCase("shape")) {

        //      Point2D position = new Point2D.Double(Double.parseDouble(inputSplit[INDEX_X_POS]), Double.parseDouble(inputSplit[INDEX_Y_POS]));
        String idAndName = "";
        String shapeType = "";
//        for(int i = 0 ; i < inputSplit.length; i++) {
//          if(inputSplit[i].equals("")) {
//            continue;
//          }
//          idAndName = inputSplit[i];
//        }

        Double xPos = Double.parseDouble(inputSplit.get(INDEX_X_POS));
        Double yPos = Double.parseDouble(inputSplit.get(INDEX_Y_POS));
        idAndName = inputSplit.get(INDEX_ID_NAME);
        double dim1 = Double.parseDouble(inputSplit.get(INDEX_DIM1));
        double dim2 = Double.parseDouble(inputSplit.get(INDEX_DIM2));
        double red = Double.parseDouble(inputSplit.get(INDEX_RED));
        double green = Double.parseDouble(inputSplit.get(INDEX_GREEN));
        double blue = Double.parseDouble(inputSplit.get(INDEX_BLUE));
        Color c = new Color(red, green, blue);
        shapeType = inputSplit.get(INDEX_SHAPE_TYPE);

        // Call model to create shape
        album.addShape(shapeType, xPos, yPos, dim1, dim2, c, idAndName);
        //      IShape newShape = canvas.createShape(idAndName, idAndName, position, dim1, dim2, color, shapeType);
        //      canvas.createShape(newShape);
      }

      if (inputSplit.get(0).equalsIgnoreCase("move")) {
        String idAndName = inputSplit.get(INDEX_ID_NAME);
        album.transform(idAndName, Double.parseDouble(inputSplit.get(2)), Double.parseDouble(inputSplit.get(3)));
        //      IShape shape = canvas.getShape(idAndName);
        //      Point2D position = new Point2D.Double(Double.parseDouble(inputSplit[2]), Double.parseDouble(inputSplit[3]));
        //      canvas.move(shape, position);
      }

      if (inputSplit.get(0).equalsIgnoreCase("resize")) {
        String idAndName = inputSplit.get(INDEX_ID_NAME);
        //    IShape shape = canvas.getShape(idAndName);

        double dim1 = Double.parseDouble(inputSplit.get(2));
        double dim2 = Double.parseDouble(inputSplit.get(3));
        album.transform(idAndName, dim1, dim2, resizeIdentifier);
        //    canvas.scale(shape, dim1, dim2);
      }

      if (inputSplit.get(0).equalsIgnoreCase("color")) {
        String idAndName = inputSplit.get(INDEX_ID_NAME);

        Double red = Double.valueOf(inputSplit.get(2));
        Double green = Double.valueOf(inputSplit.get(3));
        Double blue = Double.valueOf(inputSplit.get(4));
        Color c = new Color(red, green, blue);
        album.transform(idAndName, c);
      }

      if (inputSplit.get(0).equalsIgnoreCase("remove")) {
        String idAndName = inputSplit.get(INDEX_ID_NAME);
        album.removeShape(idAndName);
      }
      ;

      if (inputSplit.get(0).equalsIgnoreCase("snapshot")) {
        String description = "";
        if(inputSplit.size() > 1) {
          for(String s : inputSplit) {
            if(s == inputSplit.get(0)) {
              continue;
            }
            description = description + s + " ";
          }
//          description = input.substring(1, inputSplit.length - 1);
        }

        // Get all the words after the first one for description

        album.takeSnap(description);
      }
    }

    if(viewType != null && viewType.equalsIgnoreCase("web") && out != null) {
      web w = new web(album,out,maxWidth,maxHeight);
    } else if(viewType != null && viewType.equalsIgnoreCase("graphical")) {
      swingView s = new swingView(album,maxWidth,maxHeight);
    }

//    return album;
  }
}
