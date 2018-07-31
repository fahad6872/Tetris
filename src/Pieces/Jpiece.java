package Pieces;

/**
 * This is milestone.
 * 
 * @author fahad muzaffar
 * @version November 2nd.
 */
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author fahad muzaffar
 * @version Novemebr 2nd.
 */
public class Jpiece extends Gridpieces
{
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
  private static final Point P4 = new Point(1, 2);
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
  private static final Point P8 = new Point(2, 0);

  /**
   * Collect all the point and display.
   */
  private static final List<Point> J1 = new ArrayList<Point>(Arrays.asList(P1, P2, P3, P4));
  /**
   * Collect all the point and display.
   */
  private static final List<Point> J2 = new ArrayList<Point>(Arrays.asList(P5, P6, P3, P7));
  /**
   * Collect all the point and display.
   */
  private static final List<Point> J3 = new ArrayList<Point>(Arrays.asList(P1, P5, P6, P4));
  /**
   * Collect all the point and display.
   */
  private static final List<Point> J4 = new ArrayList<Point>(Arrays.asList(P5, P3, P7, P8));  /**
   * The color of an I piece.
   */
  public static final Color COLOR = Color.blue;

  /**
   * constructor with no argument.
   * 
   */
  public Jpiece()
  {
    super(COLOR, Arrays.asList(J1, J2, J3, J4));
  }
}