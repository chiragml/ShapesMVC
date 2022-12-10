import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import model.album.IAlbum;
import model.album.albumImpl;
import controller.Controller;
//import view.*;
import view.graphical.swingView;
import view.web.web;

/**
 * The type Main.
 */
public class PhotoAlbumMain {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws FileNotFoundException the file not found exception
   */
  public static void main(String[] args) throws FileNotFoundException {
    // Split string on the basis of space. Make it an arraylist.
    // Check if it contains a particular string.
    // eg: if program has "-in" then find its index and index+1 will be the input file.

    ArrayList<String> arguments = (ArrayList<String>) Arrays.stream(args).collect(Collectors.toList());
    File inFile = null;
    File out = null;
    String viewType = null;
    int xMax = -1;
    int yMax = -1;
    IAlbum album = new albumImpl();

    if(!arguments.contains("-in") ||(!arguments.contains("-v") && !arguments.contains("-view"))) {
      System.out.println("Mandatory Command line arguments missing!");
      System.exit(2);
    }

    if(arguments.contains("-in")) {
      int index = 0;
      for(;index < args.length; index++) {
        if(arguments.get(index).equalsIgnoreCase("-in")) {
          break;
        }
      }
      inFile = new File(arguments.get(index + 1));
    }

    if(arguments.contains("-out")) {
      int index = 0;
      for(;index < args.length; index++) {
        if(arguments.get(index).equalsIgnoreCase("-out")) {
          break;
        }
      }
      out = new File(arguments.get(index + 1));
    }

    if(arguments.contains("-v") || arguments.contains("-view")) {
      int index = 0;
      for(;index < args.length; index++) {
        if(arguments.get(index).equalsIgnoreCase("-v") || arguments.get(index).equalsIgnoreCase("-view")) {
          break;
        }
      }
      int viewInd = index;
      viewType = arguments.get(index + 1);

      if(viewType.equalsIgnoreCase("web")) {
        if(!arguments.contains("-out")){
          System.out.println("Mandatory Command line arguments missing!");
          System.exit(2);
        }
        for(;index < args.length; index++) {
          if (arguments.get(index).equalsIgnoreCase("-out")) {
            break;
          }

        }
        out = new File(arguments.get(index + 1));
        if(arguments.size() > 6) {
          xMax = Integer.parseInt(arguments.get(viewInd + 2));
          yMax = Integer.parseInt(arguments.get(viewInd + 3));
        }
      } else if(viewType.equalsIgnoreCase("graphical")) {
        if(arguments.size() > 4) {
          xMax = Integer.parseInt(arguments.get(viewInd + 2));
          yMax = Integer.parseInt(arguments.get(viewInd + 3));
        }
      }

    }

//    String filePath = "D:\\1761424\\courses\\OOD\\module8\\HW7\\hw7\\ShapesProject\\src\\buildings.txt";
    Controller cnt = new Controller(inFile, xMax,yMax,album,out,viewType);
//    album = cnt.Control();
//    System.out.println(album.printAlbum());
//    if(viewType != null && viewType.equalsIgnoreCase("web") && out != null) {
//      web w = new web(album,out,xMax,yMax);
//    } else if(viewType != null && viewType.equalsIgnoreCase("graphical")) {
//      swingView s = new swingView(album,xMax,yMax);
//    }

  }
}
