package view.graphical;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.album.IAlbum;
import model.album.albumImpl;
import model.shapes.I2DShape;
import model.snapshot.snaps.ISnapshot;


/**
 * The type Swing view.
 */
public class swingView extends JComponent implements ActionListener{

  private JButton nextButton;
  private JButton prevButton;

  private JComboBox menuCombo;

  private JButton quit;

  private int currentIndex = 0;

  private int maxIndex;
  private IAlbum album;
  private ISnapshot currentSnap;
//  JFrame frame;
  private JPanel snapPanel;
  private graphical display;
  private JLabel displayLabel;
  private JFrame frame;

  private static final int menuPanelWidth = 120;

//  public static void main(String[] args) {
//
//    IAlbum album = new albumImpl();
//
//
//    album.addShape("Rectangle", 100.0,250.0,30.0,30.0,
//            new model.shapes.Color(5.0,60.0,10.0),"Rect 1");
//    album.addShape("Rectangle", 160.0,140.0,30.0,30.0,
//            new model.shapes.Color(50.0,255.0,10.0),"Rect 2");
//
//    album.addShape("Oval", 155.0,144.0,60.0,30.0,
//            new model.shapes.Color(255.0,25.0,10.0),"Oval 1");
//
//    album.takeSnap("snap 1");
//
//    try {
//      Thread.sleep(5);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
//
//    album.transform("Rect 1", 500.0,300.0);
//    album.takeSnap("Snap ");
//    try {
//      Thread.sleep(5);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
//    album.addShape("Oval", 600.0,300.0,30.0,45.0,new model.shapes.Color(0.0,0.0,0.0),"Oval test 2");
//
//    album.takeSnap("Snap 3");
//
//    swingView v = new swingView(album);
//
//  }

  /**
   * Instantiates a new Swing view.
   *
   * @param album the album
   * @param maxX  the max x
   * @param maxY  the max y
   */
  public swingView(IAlbum album, int maxX, int maxY) {
    this.album = album;
    maxIndex = album.getAlbum().size();
    currentSnap = album.getSnap(album.getSnapIDs().get(currentIndex));
    display = new graphical(currentSnap);
//    displayLabel = snapLabel(temp.getDescription(),id);
//    displaySnap();
//    displayLabel = snapLabel(currentSnap.getDescription(),album.getSnapIDs().get(currentIndex));
    System.out.println(maxIndex);
    displayLabel = new JLabel();
    this.createView(maxX, maxY);
  }

  private void createView(int maxX, int maxY) {

    int mX =1000;
    int mY = 1000;
//    System.out.println(temp.toString());
    if(maxX > 0) {
      mX = maxX + menuPanelWidth;
    }
    if(maxY > 0) {
      mY = maxY;
    }
    //----------------------------------------------- Creating the Frame ----------------------
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setPreferredSize(new Dimension(1000,800));
    frame.setSize(mX,mY);
//    frame.setLocation(400,20);
    frame.setResizable(false);
    frame.setLayout(new BorderLayout());

    // ----------------------------- Creating the title Panel and adding it to frame ----------
    JPanel panel1 = this.titlePanel();
    JLabel label1 = this.label();
    panel1.add(label1);
    frame.add(panel1, BorderLayout.NORTH);


    //-------------------------Creating a menu panel and adding it to the frame -----------------
    JPanel menu = this.menuPanel();

    nextButton = nextButton();
    menu.add(nextButton);

    prevButton = prevButton();
    menu.add(prevButton);

    //-----------------------------Creating and adding Quit Button -----------------------------
    quit = quitButton();
    menu.add(quit);
    // -----------------------------Creating and adding panel for snapshot  ---------------------



    snapPanel = this.graphicalPanel();
//    JPanel snapDesc  = this.snapLabelPanel(); //Description sub panel.
//    snapDesc.add(snapLabel(temp.getDescription(), id));
//    String id = album.getSnapIDs().get(currentIndex);
//    ISnapshot temp = album.getSnap(id);

    snapLabel();
//    snapPanel.add(snapDesc,BorderLayout.NORTH);
    snapPanel.add(display);
//    snapPanel.add(displaySnap());
    frame.add(snapPanel);
    // -------------------Creating and adding ComboBox ---------------------------------------

    this.menuCombo = menuCombo();
    JPanel menuComboPanel = menuComboPanel();
//    menuCombo.addItem();
//    menu.add(menuCombo);
    menuComboPanel.add(menuCombo);
    menu.add(menuComboPanel);
    frame.add(menu, BorderLayout.WEST);


    // -------------------------Setting visibility = true to display everything ----------------
    frame.setVisible(true);

  }

  private JLabel label() {
    JLabel label = new JLabel();
    label.setText("Album");
    label.setBounds(575,5,100,50);
    label.setForeground(Color.DARK_GRAY);
    label.setFont(new Font("MV Boli",Font.ROMAN_BASELINE,28));
    return label;
  }

  private JPanel titlePanel() {
    JPanel p1 = new JPanel();
//    p1.setLayout(new BorderLayout());
    p1.setBackground(Color.cyan);
    p1.setPreferredSize(new Dimension(100,50));
    return p1;
  }

  private JPanel graphicalPanel() {
    JPanel p1 = new JPanel();
    p1.setLayout(new BorderLayout());
    p1.setBackground(Color.WHITE);
    return p1;
  }

  private JPanel menuPanel() {
    JPanel p1 = new JPanel();
    p1.setBackground(new Color(63,102,219));
    p1.setPreferredSize(new Dimension(menuPanelWidth,100));
    p1.setLayout(new GridLayout(4,1,10,20));
    return  p1;
  }
  private JButton nextButton() {
    JButton b1 = new JButton();
//    b1.setBounds(100,300,100,100);

    ImageIcon i = new ImageIcon("D:\\1761424\\courses\\OOD\\module8\\HW7\\hw7\\ShapesProject\\src\\view\\graphical\\nextIcon.png");
    b1.setIcon(i);
//    b1.setBorder(BorderFactory.createLineBorder(new Color(0,93,187)));
    b1.setPreferredSize(new Dimension(70,30));
    b1.addActionListener(this);
    return b1;
  }

  private JButton prevButton() {
    JButton b1 = new JButton();
//    b1.setBounds(100,300,100,100);
    ImageIcon i = new ImageIcon("D:\\1761424\\courses\\OOD\\module8\\HW7\\hw7\\ShapesProject\\src\\view\\graphical\\prevIcon.png");
    b1.setIcon(i);
    b1.setPreferredSize(new Dimension(70,70));
    b1.addActionListener(this);
    b1.setEnabled(false);
    return b1;
  }

//  private JPanel snapLabelPanel() {
//    JPanel p = new JPanel();
//    String id = album.getSnapIDs().get(currentIndex);
//    ISnapshot temp = album.getSnap(id);
//
//    p.setPreferredSize(new Dimension(100,50));
//    p.setBackground(Color.LIGHT_GRAY);
//    return p;
//  }

  private void snapLabel() {
    String id = album.getSnapIDs().get(currentIndex);
    ISnapshot temp = album.getSnap(id);
    displayLabel.setText(temp.getDescription() + "   " + id);
    displayLabel.setHorizontalAlignment(0);
    displayLabel.setForeground(Color.DARK_GRAY);
    displayLabel.setFont(new Font("MV Boli",Font.TYPE1_FONT,20));
    snapPanel.add(displayLabel, BorderLayout.NORTH);
    snapPanel.setVisible(true);
  }


  private JPanel menuComboPanel() {
    JPanel p = new JPanel();
    p.setLayout(new FlowLayout());
    p.setBackground(new Color(63,102,219));
    return p;
  }

  private JComboBox menuCombo(){
    JComboBox c = new JComboBox(album.getSnapIDs().toArray());
    c.setPreferredSize(new Dimension(100,50));
    c.addActionListener(this);
    return c;
  }

  private JButton quitButton() {
    JButton q = new JButton();
    ImageIcon i = new ImageIcon("D:\\1761424\\courses\\OOD\\module8\\HW7\\hw7\\ShapesProject\\src\\view\\graphical\\Quit.jpg");
    q.setBackground(new Color(63,102,219));
    q.setIcon(i);
    q.addActionListener(e -> frame.dispose());
    return q;
  }

  private void displaySnap() {
    display.setSnap(currentSnap);
    snapPanel.add(display);
    snapPanel.setVisible(true);
  }


  private void validatePos() {
    if(currentIndex >= maxIndex - 1) {
      nextButton.setEnabled(false);
      prevButton.setEnabled(true);
    } else if (currentIndex <= 0) {
      prevButton.setEnabled(false);
      nextButton.setEnabled(true);
    } else {
      prevButton.setEnabled(true);
      nextButton.setEnabled(true);
    }
  }


  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {

    if(e.getSource() == nextButton) {
      currentIndex++;
      validatePos();
//      snapPanel.removeAll();

      snapPanel.setVisible(false);
      System.out.println(currentIndex);
      String id = album.getSnapIDs().get(currentIndex);
      currentSnap = album.getSnap(id);
      snapLabel();
//      nextButton.setEnabled(true);
      displaySnap();

      System.out.println(currentSnap);



    } else if(e.getSource() == prevButton) {
      currentIndex--;
      validatePos();
      snapPanel.setVisible(false);
      System.out.println(currentIndex);
      String id = album.getSnapIDs().get(currentIndex);
      currentSnap = album.getSnap(id);
//      prevButton.setEnabled(true);
      displaySnap();
      snapLabel();


    } else if (e.getSource() == menuCombo) {
      currentIndex = menuCombo.getSelectedIndex();
      validatePos();
      snapPanel.setVisible(false);
      System.out.println(currentIndex);
      String id = album.getSnapIDs().get(currentIndex);
      currentSnap = album.getSnap(id);
//      prevButton.setEnabled(true);
      displaySnap();
      snapLabel();
    }

  }

}
