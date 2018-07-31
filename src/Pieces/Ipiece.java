package Pieces;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * This is milestone.
 * @author fahad
 * @version November 1
 */
public class Ipiece extends Gridpieces
{
  /**
   * The color of an I piece.
   */
  public static final Color COLOR = Color.cyan;
  /**
   * Give the one solid image I piece.
   */
  private static final List<Point> I1 = new ArrayList<Point>(Arrays.asList(new Point(0, 1),
                                                                           new Point(1, 1),
                                                                           new Point(2, 1),
                                                                           new Point(3, 1)));
  /**
   * Give the one solid image I piece.
   */
  private static final List<Point> I2 = new ArrayList<Point>(Arrays.asList(new Point(1, 0),
                                                                           new Point(1, 1),
                                                                           new Point(1, 2),
                                                                           new Point(1, 3)));

  /**
   * constructor with no argument.
   * 
   */
  public Ipiece()
  {
	 
    super(COLOR, Arrays.asList(I1, I2));
  }
}
