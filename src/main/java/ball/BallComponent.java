package ball;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BallComponent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4396393204868865518L;

	private ArrayList<Ball> balls;

	public BallComponent() {
		this.balls = new ArrayList<Ball>();
	}

	/**
	 * Add <code>ball</code> to component
	 * 
	 * @param ball
	 */
	public void add(Ball ball) {
		this.balls.add(ball);
	}

	/**
	 * 
	 * @param graphics
	 */
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		for (Ball ball : balls) {
			graphics2d.fill(ball.getShape());
		}
	}
}
