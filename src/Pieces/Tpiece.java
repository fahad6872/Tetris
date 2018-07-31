package Pieces;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * This is milestone.
 * 
 * @author fahad muzaffar
 * @version Spring 2011
 *
 */
public class Tpiece extends Gridpieces
{
  /**
   * The color of an I piece.
   */
  public static final Color COLOR = Color.magenta;
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
  private static final Point P3 = new Point(1, 1);
  /**
   * Store point 4.
   */
  private static final Point P4 = new Point(2, 0);
  /**
   * Store point 5.
   */
  private static final Point P5 = new Point(0, 1);
  /**
   * Store point 6.
   */
  private static final Point P6 = new Point(0, 2);
  /**
   * Store point 7.
   */
  private static final Point P7 = new Point(2, 1);
  /**
   * Store point 8.
   */
  private static final Point P8 = new Point(1, 2);
  /**
   * 
   */
  private static final List<Point> T1 = new ArrayList<Point>(Arrays.asList(P1, P2, P3, P4));
  /**
   * 
   */
  private static final List<Point> T2 = new ArrayList<Point>(Arrays.asList(P1, P5, P6, P3));
  /**
   * 
   */
  private static final List<Point> T3 = new ArrayList<Point>(Arrays.asList(P5, P3, P2, P7));
  /**
   * 
   */
  private static final List<Point> T4 = new ArrayList<Point>(Arrays.asList(P5, P2, P3, P8));
/**
 * 
 */
  public Tpiece()
  {
    super(COLOR, Arrays.asList(T1, T2, T3, T4));
  }

}
