package tetrisframe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * A frame that uses a menu bar and Tool bar to change colors.
 * 
 * @author fahad muzaffar
 * @author TCSS 305A Class
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Frame extends JFrame
{
  /**
   * my_menu_bar all the buttons.
   */
  private final JMenuBar my_menu_bar = new JMenuBar();
  /**
   * my+panel to draw a picture.
   */
  private Tetrisframe my_tetrisframe;
  /**
   * boolean focus key is to make sure the keyboard should work.
   */
  private boolean my_focuskey;
  /**
   */
  private final JPanel my_panel_tetrisframe = new JPanel();
  /**
   * Constructs a new ToolBarFrame with all its controls.
   */
  public Frame()
  {
    super("Welcome");

    file(); 
    my_panel_tetrisframe.add(my_tetrisframe);
    
    add(my_panel_tetrisframe, BorderLayout.CENTER);
    my_tetrisframe.setFocusable(my_focuskey);
    setJMenuBar(my_menu_bar);
    pack();
  }
  /**
   * 
   * @return my_menu_bar of the files.
   */
  private JMenuBar file()
  {
   // my_panell = new JPanel();
    my_focuskey = true;
    my_tetrisframe = new Tetrisframe();
    
    final JMenu toom_menu = new JMenu("File");
    toom_menu.setMnemonic(KeyEvent.VK_F);

    final JMenuItem newgame = new JMenuItem("New Game");
    
    final JMenuItem quit = new JMenuItem("Quit");
    
    final JMenuItem end = new JMenuItem("End Game");


    toom_menu.add(newgame);
    newgame.addActionListener(new ActionListener()
    {
      /**
       * @param an_event
       * @return the thickness.
       */
      public void actionPerformed(final ActionEvent an_event)
      {
        my_focuskey = true;
        my_tetrisframe.restart();
     //   my_tetrisframe.setFocusable(my_focuskey);
      //  setFocusCycleRoot(my_focuskey);
      //  setFocusTraversalKeysEnabled(my_focuskey);
       // setFocusTraversalPolicyProvider(my_focuskey);
       // setFocusable(my_focuskey);
        repaint();
      }
    });
    
    toom_menu.addSeparator();
    
    toom_menu.add(end);
    end.addActionListener(new ActionListener()
    {
      /**
       * @param an_event
       * @return the thickness.
       */
      public void actionPerformed(final ActionEvent an_event)
      {
        my_tetrisframe.pause();
        final int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit");
        if (i == JOptionPane.YES_OPTION)
        {
          my_focuskey = false;
          my_tetrisframe.setFocusTraversalKeysEnabled(my_focuskey);    
        }
        else
        {
          my_tetrisframe.start();
        }
      }
    });

    toom_menu.addSeparator();
    
    toom_menu.add(quit);
    quit.addActionListener(new ActionListener()
    {
      /**
       * @param an_event
       * @return the thickness.
       */
      public void actionPerformed(final ActionEvent an_event)
      {
        my_tetrisframe.pause();
        dispose();
      }
    });
    
    my_menu_bar.add(toom_menu);

    return my_menu_bar;
  }
  /**
   * 
   * @param the_args run the program.
   * main method to run the program.
   */
  public static void main(final String... the_args)
  {
    final Frame toolbar_frame = new Frame();
    toolbar_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    toolbar_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    
    toolbar_frame.setVisible(true);
  }
}
