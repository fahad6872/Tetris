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
public class Zpiece extends Gridpieces
{
  /**
   * The color of an I piece.
   */
  public static final Color COLOR = Color.red;
  /**
   * 
   */
  private static final Point P1 = new Point(0, 0);
  /**
   * 
   */
  private static final Point P2 = new Point(0, 1);
  /**
   * 
   */
  private static final Point P3 = new Point(1, 1);
  /**
   * 
   */
  private static final Point P4 = new Point(1, 2);
  /**
   * 
   */
  private static final Point P5 = new Point(1, 0);
  /**
   * 
   */
  private static final Point P6 = new Point(2, 0);
  

/**
 * 
 */
  private static final List<Point> Z1 = new ArrayList<Point>(Arrays.asList(P1, P2, P3, P4));
  /**
   * 
   */
  private static final List<Point> Z2 = new ArrayList<Point>(Arrays.asList(P2, P3, P5, P6));

  /**
   * 
   * 
   */
  public Zpiece()
  {
    super(COLOR, Arrays.asList(Z1, Z2));
  }
}
