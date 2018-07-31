package Pieces;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author fahad
 * @version November 2nd.
 */
public class Opiece extends Gridpieces
{
  /**
   * The color of an I piece.
   */
  public static final Color COLOR = Color.yellow;
  /**
   * Store point 1.
   */
  private static final Point P1 = new Point(0, 0);
  /**
   * Store point 2.
   */
  private static final Point P2 = new Point(1, 0);
  /**
   * Store point 3.
   */
  private static final Point P3 = new Point(0, 1);
  /**
   * Store point 4.
   */
  private static final Point P4 = new Point(1, 1);

  /**
   * Display O1.
   */
  private static final List<Point> O1 = new ArrayList<Point>(Arrays.asList(P1, P2, P3, P4));

  /**
   * 
   */
  public Opiece()
  {
    super(COLOR, Arrays.asList(O1));
  }
}


