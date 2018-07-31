package Pieces;
/**
 * This is milestone.
 * 
 * @author fahad muzaffar
 * @version November 3rd.
 *
 */
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author fahad muzaffar
 * @version November 3rd.
 */
public class Lpiece extends Gridpieces
{
  /**
   * The color of an I piece.
   */
  public static final Color COLOR = Color.orange;
  /**
   * Store point 1.
   */
  private static final Point P1 = new Point(0, 0);
  /**
   * Store point 2.
   */
  private static final Point P2 = new Point(0, 1);
  /**
   * Store point 3.
   */
  private static final Point P3 = new Point(0, 2);
  /**
   * Store point 4.
   */
  private static final Point P4 = new Point(1, 0);
  /**
   * Store point 5.
   */
  private static final Point P5 = new Point(1, 1);
  /**
   * Store point 6.
   */
  private static final Point P6 = new Point(1, 2);
  /**
   * Store point 7.
   */
  private static final Point P7 = new Point(2, 1);
  /**
   * Store point 8.
   */
  private static final Point P8 = new Point(2, 2);
  /**
   * Display L1.
   */
  private static final List<Point> L1 = new ArrayList<Point>(Arrays.asList(P3, P4, P5, P6));
  /**
   * Display L2.
   */
  private static final List<Point> L2 = new ArrayList<Point>(Arrays.asList(P2, P5, P7, P8));
  /**
   * Display L3.
   */
  private static final List<Point> L3 = new ArrayList<Point>(Arrays.asList(P1, P2, P3, P4));
  /**
   * Display L4.
   */
  private static final List<Point> L4 = new ArrayList<Point>(Arrays.asList(P1, P2, P5, P7));
  /**
   * constructor with no argument.
   */
  public Lpiece()
  {
    super(COLOR, Arrays.asList(L1, L2, L3, L4));
  }
}