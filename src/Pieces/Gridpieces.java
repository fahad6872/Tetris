package Pieces;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author fahad
 * @version November 15th.
 */
public class Gridpieces
{
  /**
   * Make four grids.
   */
  private static final int GRID_FOUR = 4;
  /**
   * Next Line.
   */
  private static final String NEXT_LINE = "\n";
  /**
   * Get the piece of x direction.
   */
  private int my_x;

  /**
   * Get the piece of y direction.
   */
  private int my_y;
  /**
   * my_piece_list have piece information.
   */
  private final List<List<Point>> my_piece_list;
  /**
   * my_cur_pos store the current position.
   */
  private int my_cur_pos;

  /**
   * my_color is the color of the pieces.
   */
  private final Color my_color;
  /**
   * The constructor.
   * @param the_color of the pieces.
   * @param the_list of the object.
   */
  public Gridpieces(final Color the_color, final List<List<Point>> the_list)
  {
    my_piece_list = new ArrayList<List<Point>>(the_list);
    my_color = the_color;
    this.my_x = 0;
    this.my_y = 0;
    this.my_cur_pos = 0;
  }
  /**
   * My_piece_list get the current position.
   * @return my_piece.
   */
  public List<Point> getPiece()
  {
    return my_piece_list.get(my_cur_pos);
  }
/**
 * This method move the pieces to down.
 * Move the object down.
 */
  public void movedown()
  {
    my_y++;
  }

  /**
   * This method move the pieces to left.
   * Move the object to the left.
   */
  public void moveleft()
  {
    my_x--;
  }
/**
 * This method move the pieces to right.
 * Move the object to the right.
 */
  public void moveright()
  {
    my_x++;
  }
/**
 *  This method rotate the pieces to clockwise.
 */
  public void rotateCW()
  {
    my_cur_pos = (my_cur_pos + 1) % my_piece_list.size();
  }

  /**
   * This method rotate the pieces to clockwise. 
   */
  public void roateCCW()
  {
    rotateCW();
    rotateCW();
    rotateCW();
  }

  /**
   * This method will display the pieces.
   * @return the display for the grid.
   */
  @Override
  public String toString()
  {

    final StringBuffer display = new StringBuffer();

    for (int i = 0; i < GRID_FOUR; i++)
    {
      for (int j = 0; j < GRID_FOUR; j++)
      {
        if (my_piece_list.get(my_cur_pos).contains(new Point(i, j)))
        {
          display.append("[]");
        }
        else
        {
          display.append("  ");
        }
      }
      display.append(NEXT_LINE);

    }
    return display.toString();
  }
/**
 * This method return values of x.
 * @return my_x the value of x.
 */
  public int x()
  {
    return my_x;
  }
  /**
   * This method return value of y.
   * 
   * @return my_y the value of y.
   */
  public int y()
  {
    return my_y;
  }
  /**
   * Set x.
   * @param an_x get the x.
   */
  public void setX(final int an_x)
  {
    my_x = an_x;
  }
  
  /**
   * Set y.
   * @param an_y get the y.
   */
  public void setY(final int an_y)
  {
    my_y = an_y;
  }

  /**
   * 
   * @return color of the pieces.
   */
  public Color getcolor()
  {
    return my_color;
  }
}
