
package tetrisframe;
import board.board;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * 
 * @author fahad
 * @version December 5th.
 */

@SuppressWarnings("serial")
public class Tetrisframe extends JPanel implements ActionListener
{
  /**
   * Initial speed of the tetris.
   */
  private static final int SPEED = 320;
  /**
   * 
   */
  private static final int MY_LEVLE_CHANGE = 20;
  /**
   * my_board is the board of tetris.
   */
  private final board my_board;
  /**
   * After 20 line the level of difficulty increase.
   */
  private int my_level;
  /**
   * LevelLabel to display at GUI.
   */
  private final JLabel my_levellabel;
  /**
   * ScoreLabel to display at GUI.
   */
  private final JLabel my_scorelabel;
  /**
   * my_timmer tell about the time to start or stop the game.
   */
  private final Timer my_timmer;

  /**
   * Tetries frame of the game.
   */
  public Tetrisframe()
  {
    super();
  
    final JPanel pane = new JPanel();
    my_board = new board();
    final Tetrispanel tetrispanelgame = new Tetrispanel(my_board);
    final Piecepanel piecepanel = new Piecepanel(my_board);
    final Secondpieces piecepane2 = new Secondpieces(my_board);

    final JPanel panealinformation = new JPanel();

    panealinformation.setLayout(new BoxLayout(panealinformation, BoxLayout.Y_AXIS));
    pane.setBackground(Color.pink);
    panealinformation.add(piecepanel);
    panealinformation.add(piecepane2);

    pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));

    pane.add(tetrispanelgame);

    my_levellabel = new JLabel("Level: 1");
    panealinformation.add(new JLabel("Level incresase after 20 line"));
    panealinformation.add(my_levellabel);

    my_scorelabel = new JLabel("Score: 0");
    panealinformation.add(new JLabel("Score for each line"));
    panealinformation.add(my_scorelabel);

    panealinformation.add(new JLabel("Move Left: LEFT_ARROW "));
    panealinformation.add(new JLabel("Move Right: RIGHT_ARROW"));
    panealinformation.add(new JLabel("Rotate: UP_ARROW"));
    panealinformation.add(new JLabel("Rotate CounterClok Wise: C_Button"));
    panealinformation.add(new JLabel("Move Down: DOWN_ARROW"));
    panealinformation.add(new JLabel("P: Pause"));
    pane.add(panealinformation);
    add(pane);
  
  
    my_timmer = new Timer(SPEED, this);
    my_timmer.restart();
    
    addKeyListener(new KeyAdapter()
    {
      @Override
      public void keyPressed(final KeyEvent an_e)
      {
        handleKeyPressed(an_e);
        timeupdate();
      }
    });
  }
  /**
   * @param an_arg to update the board.
   */
  @Override
  public void actionPerformed(final ActionEvent an_arg)
  {
    if (my_board.gameOver())
    {
      my_timmer.stop();
    }
    else
    {
      my_board.update();
      my_levellabel.setText(String.valueOf(levelnumber()));
      my_scorelabel.setText(my_board.linenumber() + " ");
    }
    repaint();
  }
  /**
   * 
   * @param an_e to do event when keyboard is pressed.
   */
  private void handleKeyPressed(final KeyEvent an_e)
  {
    if (my_timmer.isRunning())
    {
      switch (an_e.getKeyCode())
      {
        case KeyEvent.VK_LEFT:
          my_board.moveleft();
          break;
        case KeyEvent.VK_RIGHT:
          my_board.moveright();
          break;
        case KeyEvent.VK_UP:
          my_board.rotateCW();
          break;
        case KeyEvent.VK_C:
          my_board.rotateCCW();
          break;
        case KeyEvent.VK_DOWN:
          my_board.movedown();
          break;
        case KeyEvent.VK_P:
          pause();
          break;
        case KeyEvent.VK_S:
          start();
          break;
        case KeyEvent.VK_SPACE:
          for (int i = 0; i <= my_board.height(); i++)
          {
            my_board.movedown();
          }
          break;
        default:
          break;
      }
    }
    else
    {
      switch (an_e.getKeyCode())
      {
        case KeyEvent.VK_S:
          start();
      }
    }
    repaint();
  }

  /**
   * 
   * @return level
   */
  private int levelnumber()
  {
    my_level = my_board.linenumber() / MY_LEVLE_CHANGE + 1;
    return my_level;
  }

  /**
   * Stop the timer.
   */
  public void pause()
  {
    my_timmer.stop();
  }
  /**
   * Restart the board.
   */
  public void restart()
  {
    my_board.clear();
    my_level = 0;
    my_timmer.restart();
   
  }
  /**
   * start the timer.
   */
  public void start()
  {
    my_timmer.start();
  }
  /**
   * Delay of the game.
  */
  private void timeupdate()
  {
    final int dealy = SPEED - (my_level * MY_LEVLE_CHANGE);
    my_timmer.setDelay(dealy);
  } 
}
