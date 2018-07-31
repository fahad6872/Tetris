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
public class Spiece extends Gridpieces
{
  /**
   * The color of an I piece.
   */
  public static final Color COLOR = Color.green;
  /**
   * Display S1.
   */
  private static final List<Point> S1 = new ArrayList<Point>(Arrays.asList(new Point(0, 2),
                                                                           new Point(0, 1),
                                                                           new Point(1, 1),
                                                                           new Point(1, 0)));
  /**
   * Display S2.
   */
  private static final List<Point> S2 = new ArrayList<Point>(Arrays.asList(new Point(0, 0),
                                                                           new Point(1, 0),
                                                                           new Point(1, 1),
                                                                           new Point(2, 1)));
  /**
   * constructor with no argument.
   * 
   */
  public Spiece()
  {
    super(COLOR, Arrays.asList(S1, S2));
  }
}