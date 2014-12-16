package ball;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Ball implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2835829938975070158L;

	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private static final double DEFAULT_V = 1;
	private static final double DEFAULT_A = 1;
	private double x;
	private double y;
	private double dx;
	private double dy;
	private double v;
	private int signX;

	public Ball(int frameWidth, int frameHeight) {
		this.x = (Math.random() * 1000) % frameWidth;
		this.y = (Math.random() * 1000) % frameHeight;
		this.dx = DEFAULT_V;
		this.dy = DEFAULT_V;
		v = DEFAULT_V;
		signX = 1;
	}

	/**
	 * Move the ball to next position. reversing if it hit one of the egdes
	 * 
	 * @param rectangle2d
	 */
	public void move(Rectangle2D rectangle2d, double time) {

		dx = signX
				* ((double) v * time + (double) (signX * DEFAULT_A * time * time) / 2.0d);

		v += signX * DEFAULT_A * time;
		x += dx;
		y += dy;

		if (v <= 0) {
			v = 0;
			signX = -signX;
		}

		if (x < rectangle2d.getMinX()) {
			x = rectangle2d.getMinX();
			signX = -signX;
		}

		if (x + XSIZE >= rectangle2d.getMaxX()) {
			x = rectangle2d.getMaxX() - XSIZE;
			signX = -signX;
		}
		if (y < rectangle2d.getMinY()) {
			y = rectangle2d.getMinY();
			dy = -dy;
		}

		if (y + YSIZE >= rectangle2d.getMaxY()) {
			y = rectangle2d.getMaxY() - YSIZE;
			dy = -dy;
		}
	}

	/**
	 * Get shape of the ball at its current position
	 * 
	 * @return
	 */
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
	}
}
