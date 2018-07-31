package tetrisframe;
import board.board;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * Tetries panel is main panel that hold the tetris pieces 
 * and tetries body.
 * @author fahad
 * @version December 5th.
 */
@SuppressWarnings("serial")
public class Tetrispanel extends JPanel implements Observer
{  /**
   * 
   */
  public static final int BLOCK_WIDTH = 30;
  /**
   * 
   */
  public static final int BLOCK_HEIGHT = 30;
  /**
   * Gride of the board.
   */
  private static final int GRIDE1 = 1000;  
  
  /**
   * the board of tetris.
   */
  private final board my_board;
  /**
   * 
   * @param an_board the board represenation.
   * 
   */
  public Tetrispanel(final board an_board)
  {
    super();
    this.my_board = an_board;
    final int width = an_board.width() * BLOCK_WIDTH;
    final int height = an_board.height() * BLOCK_HEIGHT;
    setPreferredSize(new Dimension(width, height));
    setBackground(Color.white);    
  }
  /**
   * @param an_g the graph the Tetris panel.
   */
  @Override
  public void paintComponent(final Graphics an_g)
  {
    super.paintComponent(an_g);
        
    final Color[][] grid = my_board.getGrid();
    int row;
    int col;
    final Graphics2D g2d = (Graphics2D) an_g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                          RenderingHints.VALUE_ANTIALIAS_ON);
    
    //g2d.setColor(Color.blue);
    for (row = 0; row < grid.length; row++)
    {
      for (col = 0; col < grid[row].length; col++)
      {
        if (grid[row][col] != Color.white)
        {
          g2d.setColor(grid[row][col]);
          g2d.fill3DRect(col * Tetrispanel.BLOCK_WIDTH, row * Tetrispanel.BLOCK_HEIGHT, 
                         Tetrispanel.BLOCK_WIDTH, Tetrispanel.BLOCK_HEIGHT, true);
        }
      }
    }
    
    g2d.setColor(Color.black);
    for (int i = 0; i < GRIDE1; i++) 
    {
      g2d.setStroke(new BasicStroke(1 / 2));
      g2d.draw(new Line2D.Double(new Point(i * BLOCK_HEIGHT, 0), 
                                 new Point(i * BLOCK_HEIGHT, GRIDE1)));
      g2d.draw(new Line2D.Double(new Point(0, i * BLOCK_HEIGHT), 
                                 new Point(GRIDE1, i * BLOCK_HEIGHT)));
      repaint();
    }

    final List<Point> points = my_board.currentPiece().getPiece();
    an_g.setColor(my_board.currentPiece().getcolor());
    for (Point p : points)
    {
      row = p.x + my_board.currentPiece().y();
      col = p.y + my_board.currentPiece().x();
      an_g.fill3DRect(col * BLOCK_WIDTH, row * BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT, true);
    }
    
    if (my_board.gameOver())
    {
      g2d.setColor(Color.black);
      g2d.setFont(new Font("Arial", Font.BOLD, BLOCK_WIDTH));
      g2d.drawString("GAME OVER", BLOCK_WIDTH, this.getSize().height / 2);
    }
  }
  /**
   * @param an_arg0 observed.
   * @param an_arg1 object.
   */
  @Override
  public void update(final Observable an_arg0, final Object an_arg1)
  {
    repaint();
  }
}
