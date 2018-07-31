package tetrisframe;
import board.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;


/**
 * 
 * @author fahad
 * @version December 4.
 * Draw pieces.
 */
@SuppressWarnings("serial")
public class Secondpieces extends JPanel implements Observer
{
  /**
   * Grid of the piece.
   */
  private static final int GRID_FIVE = 5;
  /**
   * Tetris board.
   */
  private final board my_board;
/**
 * 
 * @param an_board of the pieces.
 */
  public Secondpieces(final board an_board)
  {
    super();
    this.my_board = an_board;
    final int width = GRID_FIVE * Tetrispanel.BLOCK_WIDTH;
    final int height = (GRID_FIVE + 1) * Tetrispanel.BLOCK_HEIGHT;
    setPreferredSize(new Dimension(width, height)); 
  }
/**
 * @param an_g draw a piece.
 */
  @Override
  public void paintComponent(final Graphics an_g)
  {
    int row;
    int col;
    super.paintComponent(an_g);    
    final Graphics2D g2d = (Graphics2D) an_g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                          RenderingHints.VALUE_ANTIALIAS_ON);
    
    g2d.setColor(my_board.nextPiece2().getcolor());
    final List<Point> points = my_board.nextPiece2().getPiece();


    for (Point p : points)
    {
      row = p.x + 1;
      col = p.y + 1;
      g2d.fill3DRect(col * Tetrispanel.BLOCK_WIDTH, row * Tetrispanel.BLOCK_HEIGHT, 
                 Tetrispanel.BLOCK_WIDTH, Tetrispanel.BLOCK_HEIGHT, true);
    }    
  }
/**
 * @param an_arg0 observed.
 * @param an_arg1 to repaint.
 */
  @Override
  public void update(final Observable an_arg0, final Object an_arg1)
  {
    repaint();

  }
}
