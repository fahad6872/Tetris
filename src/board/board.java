package board;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import Pieces.Gridpieces;
import Pieces.Ipiece;
import Pieces.Jpiece;
import Pieces.Lpiece;
import Pieces.Opiece;
import Pieces.Spiece;
import Pieces.Tpiece;
import Pieces.Zpiece;
import tetris.audio.SoundPlayer;


/**
 * 
 * @author fahad
 * @version November 3 This class represents a Tetris board
 */
public class board extends Observable
{
  /**
   * Width of the board.
   */
  private static final int WIDTH_BOARD = 30;
  /**
   * Height of the board.
   */
  private static final int HEIGHT_BOARD = 30;
  /**
   * Next Line.
   */
  private static final String NEXT_LINE = "\n";
  /**
   * piece types of I.
   */
  private static final int IPIECE = 0;
  /**
   * piece types of J.
   */
  private static final int JPIECE = 1;
  /**
   * piece types of L.
   */
  private static final int LPIECE = 2;
  /**
   * piece types of O.
   */
  private static final int OPIECE = 3;
  /**
   * piece types of I.
   */
  private static final int SPIECE = 4;
  /**
   * piece types of I.
   */
  private static final int TPIECE = 5;
  /**
   * piece types of I.
   */
  private static final int ZPIECE = 6;
  /**
   * my_linenumber_points count the points each line.
   */
  private int my_linenumber_points;

  /**
   * Pre-defined sequence of pieces.
   */
  private List<Gridpieces> my_fixedsequence = new ArrayList<Gridpieces>();
  /**
   * array of piece types for randomly generating.
   */
  private final int my_piecetypes = 6;

  /**
   * current index of piece in fixed sequence.
   */
  private int my_current_index;
  /**
   * Random creator.
   */
  private final Random my_random = new Random(System.currentTimeMillis());

  /**
   * The grid[i][j] is filled.
   */
  private Color[][] my_grid;

  /**
   * current piece-in progress.
   */
  private Gridpieces my_currentpiece;
  /**
   * true if pieces is chosen from a specific sequence; false if random.
   */
  private boolean my_fixed_sequence;

  /**
   * 
   */
  private boolean my_gameover;
  /**
   * Next piece to show the piece.
   */
  private Gridpieces my_nextpiece;
  /**
   * Next 2nd piece to show the piece.
   */
  private Gridpieces my_nextpiece2;
 
  /**
   * Default constructor. Create a board with standard width and height
   */
  public board()
  {
    super();

    final SoundPlayer soundplayer = new SoundPlayer();
    soundplayer.loop("tetris/audio/changetheme_aoe_music1l.wav");
    
    my_grid = new Color[HEIGHT_BOARD][WIDTH_BOARD];

    for (int i = 0; i < HEIGHT_BOARD; i++)
    {
      for (int j = 0; j < WIDTH_BOARD; j++)
      {
        my_grid[i][j] = Color.white;
      }
      my_fixed_sequence = false;
    }
    newPieces();
    newPieces2();
  }

  /**
   * Constructor. Create a board with given width and height
   * 
   * @param an_h the hight.
   * @param an_w the width.
   */
  public board(final int an_h, final int an_w)
  {
    super();
    
    my_grid = new Color[an_h][an_w];
    for (int i = 0; i < an_h; i++)
    {
      for (int j = 0; j < an_w; j++)
      {
        my_grid[i][j] = Color.white;
      }
      my_fixed_sequence = false;
    }
    newPieces();
    newPieces2();
  }

  /**
   * Create new pieces (current and next piece).
   */
  private void newPieces()
  {
    if (my_nextpiece == null)
    {
      my_currentpiece = createNewPiece();
    }
    else
    {
      my_currentpiece = my_nextpiece;
    }
    my_nextpiece = createNewPiece();
  }
  /**
   * Create another new pieces (current and next piece).
  */
  private void newPieces2()
  {
    if (my_nextpiece2 == null)
    {
      my_nextpiece = createNewPiece();
    }
    else
    {
      my_nextpiece = my_nextpiece2;
    }
    my_nextpiece2 = createNewPiece();
  } 

  /**
   * Create new piece.
   * 
   * @return piece of the shape.
   */
  private Gridpieces createNewPiece()
  {
    Gridpieces piece = null;

    if (my_fixed_sequence)
    {
      if (my_current_index >= my_fixedsequence.size())
      {
        my_current_index = 0;
      }
      piece = my_fixedsequence.get(my_current_index);
      my_current_index++;
    }
    else
    {
      final int index = my_random.nextInt(my_piecetypes);
      
      if (index == IPIECE)
      {
        piece = new Ipiece();
      }
      else if (index == JPIECE)
      {
        piece = new Jpiece();
      }
      else if (index == LPIECE)
      {
        piece = new Lpiece();
      }
      else if (index == OPIECE)
      {
        piece = new Opiece();
      }
      else if (index == SPIECE)
      {
        piece = new Spiece();
      }
      else if (index == TPIECE)
      {
        piece = new Tpiece();
      }
      else if (index == ZPIECE)
      {
        piece = new Zpiece();
      }

      if (piece != null)
      {
        piece.setX(width() / 2 - 1);
      }
      
    }
    return piece;
  }

  /**
   * Return the index of a fulfilled line.
   * 
   * @return -1 if not found.
   */
  private int findFullLine()
  {
    int index = -1;
    for (int i = 0; i < height(); i++)
    {
      boolean isfull = true;
      for (int j = 0; j < width(); j++)
      {
        if (my_grid[i][j] == Color.white)
        {
          isfull = false;
          break;
        }
      }
      if (isfull)
      {
        index = i;
      }
    }
    return index;
  }

  /**
   * Return the bottom most row of current piece.
   * 
   * @return row + my_currentpiece.y().
   */
  private int getBottomMost()
  {
    int row;
    final List<Point> points = my_currentpiece.getPiece();
    row = points.get(0).x;
    for (int i = 1; i < points.size(); i++)
    {
      if (row < points.get(i).x)
      {
        row = points.get(i).x;
      }
    }
    return row + my_currentpiece.y();
  }

  /**
   * Return a grid which is a copy of the board grid.
   * 
   * @return copy of the grid.
   */
  public Color[][] getGrid()
  {
    final Color[][] copy = new Color[height()][width()];
    for (int i = 0; i < height(); i++)
    {
      for (int j = 0; j < width(); j++)
      {
        copy[i][j] = my_grid[i][j];
      }
    }
    return copy;
  }

  /**
   * Return the left most column of current piece.
   * 
   * @return column + my_currentpiece.x()
   */
  private int getLeftMost()
  {
    int col;
    final List<Point> points = my_currentpiece.getPiece();
    col = points.get(0).y;
    for (int i = 1; i < points.size(); i++)
    {
      if (col > points.get(i).y)
      {
        col = points.get(i).y;
      }
    }
    return col + my_currentpiece.x();
  }

  /**
   * Return the right most column of current piece.
   * 
   * @return columns + my current piece of x direction.
   */
  private int getRightMost()
  {
    int col;
    final List<Point> points = my_currentpiece.getPiece();
    col = points.get(0).y;
    for (int i = 1; i < points.size(); i++)
    {
      if (col < points.get(i).y)
      {
        col = points.get(i).y;
      }
    }
    return col + my_currentpiece.x();
  }

  /**
   * Return height of the board.
   * 
   * @return the gride of board.
   */
  public int height()
  {
    return my_grid.length;
  }

  /**
   * Return true if current piece collides with a previously frozen piece.
   * 
   * @return value of Collided.
   */
  private boolean isCollided()
  {
    int row;
    int col;
    for (Point p : my_currentpiece.getPiece())
    {
      row = p.x + my_currentpiece.y();
      col = p.y + my_currentpiece.x();
      if (my_grid[row][col] != Color.white)
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Return true if current piece is off the board.
   * 
   * @return value.
   */
  private boolean isOff()
  {
    return (getLeftMost() < 0) || (getRightMost() >= width()) || (getBottomMost() >= height());
  }

  /**
   * Move the current piece down.
   */
  public void movedown()
  {
    my_currentpiece.movedown();

    if (isOff() || isCollided())
    {
      my_currentpiece.setY(my_currentpiece.y() - 1);
      return;
    }
    notifyObservers();
  }

  /**
   * Move the current piece to the left.
   */
  public void moveleft()
  {
    my_currentpiece.moveleft();

    if (isOff() || isCollided())
    {
      my_currentpiece.moveright();
      return;
    }
    notifyObservers();
  }

  /**
   * Move the current piece to the right.
   */
  public void moveright()
  {
    my_currentpiece.moveright();

    if (isOff() || isCollided())
    {
      my_currentpiece.moveleft();
      return;
    }
    notifyObservers();
  }

  /**
   * Remove a line with the given index.
   * 
   * @param an_index of grid.
   */
  private void removeLine(final int an_index)
  {
    for (int i = an_index; i > 0; i--)
    {
      for (int j = 0; j < width(); j++)
      {
        my_grid[i][j] = my_grid[i - 1][j];
      }
    }
    for (int j = 0; j < width(); j++)
    {
      my_grid[0][j] = Color.white;
    }
    my_linenumber_points++;
  }

  /**
   * Rotate the current piece counter clockwise.
   */
  public void rotateCCW()
  {
    my_currentpiece.roateCCW();

    if (isOff() || isCollided())
    {
      my_currentpiece.rotateCW();
      return;
    }
    notifyObservers();
  }

  /**
   * Rotate the current piece clockwise.
   */
  public void rotateCW()
  {
    my_currentpiece.rotateCW();

    if (isOff() || isCollided())
    {
      my_currentpiece.roateCCW();
      return;
    }
    notifyObservers();
  }

  /**
   * Set sequence of pieces.
   * 
   * @param an_sequence of the piece.
   */
  public void setFixedSequence(final List<Gridpieces> an_sequence)
  {
    my_fixedsequence = new ArrayList<Gridpieces>(an_sequence);
    my_fixed_sequence = true;
    newPieces();
    newPieces2();
  }

  /**
   * Set randomly generate the pieces or chosen from fixed sequence.
   * 
   * @param an_randomlygenerate .
   */
  public void setRandom(final boolean an_randomlygenerate)
  {
    my_fixed_sequence = !an_randomlygenerate;
  }

  /**
   * Return true if the current piece should be freezed, i.e. it is resting on
   * top of existing filled squares
   * 
   * @return freeze piece.
   */
  private boolean shouldFreeze()
  {
    int row;
    int col;
    for (Point p : my_currentpiece.getPiece())
    {
      row = p.x + my_currentpiece.y();
      col = p.y + my_currentpiece.x();
      
      if (row == height() - 1)
      {
        return true;
      }
      if (my_grid[row + 1][col] != Color.white)
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Produce a 2D text drawing of the entire board.
   * 
   * @return display.toString() the display of the board.
   */
  @Override
  public String toString()
  {
    final StringBuffer display = new StringBuffer();

    display.append(my_currentpiece.toString());
    display.append(NEXT_LINE);
    for (int i = 0; i < height(); i++)
    {
      for (int j = 0; j < width(); j++)
      {
        if (my_grid[i][j] == Color.white)
        {
          display.append("  ");
        }
        else
        {
          display.append("[]");
        }
      }
      display.append(NEXT_LINE);
    }
    return display.toString();
  }

  /**
   * Update the game state by one step.
   */
  public void update()
  {
    if (my_gameover)
    {
      return;
    }
    if (shouldFreeze())
    {
      int row;
      int col;
      for (Point p : my_currentpiece.getPiece())
      {
        row = p.x + my_currentpiece.y();
        col = p.y + my_currentpiece.x();
        my_grid[row][col] = my_currentpiece.getcolor();
      }
      int lineindex;
      
      while ((lineindex = findFullLine()) != -1)
      {
        removeLine(lineindex);
      }
      newPieces();
      notifyObservers();
      newPieces2();
      notifyObservers();
    }
    movedown();
    my_gameover = isCollided();
  }

  /**
   * Return width of the board.
   * 
   * @return my_gride width of the board.
   */
  public int width()
  {
    return my_grid[0].length;
  }

  /**
   * Return current piece.
   * 
   * @return my_currentpiece of the tetris.
   */
  public Gridpieces currentPiece()
  {
    return my_currentpiece;
  }

  /**
   * Return true if the current game is over; otherwise return false.
   * 
   * @return my_gameover when tetris is full.
   */
  public boolean gameOver()
  {
    return my_gameover;
  }

  /**
   * Return next piece.
   * 
   * @return my_nextpiece of the tetris.
   */
  public Gridpieces nextPiece()
  {
    return my_nextpiece;
  }
  /**
   * Return next piece.
   * 
   * @return my_nextpiece of the tetris.
   */
  public Gridpieces nextPiece2()
  {
    return my_nextpiece2;
  }
  /**
   * 
   * @return line number
   */
  public int linenumber()
  {
    return my_linenumber_points;
  }
  /**
   * Clear the board.
   */
  public void clear()
  {
   // my_grid = new boolean[HEIGHT_BOARD][WIDTH_BOARD];

    for (int i = 0; i < HEIGHT_BOARD; i++)
    {
      for (int j = 0; j < WIDTH_BOARD; j++)
      {
        my_grid[i][j] = Color.white;
      }
      my_fixed_sequence = false;
    }
    newPieces();
    newPieces2();
    newPieces();
    newPieces2();
    my_linenumber_points = 0;
    my_gameover = false;
  }
}
