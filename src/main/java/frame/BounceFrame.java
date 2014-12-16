package frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ball.Ball;
import ball.BallComponent;

public class BounceFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5546449921560537024L;

	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;

	private BallComponent comp;

	public BounceFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		JPanel buttonPanel = new JPanel();
		setTitle("Bounce");

		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);

		addButton(buttonPanel, "Start", new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addBall();
			}
		});

		addButton(buttonPanel, "Close", new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
	}

	private void addButton(Container c, String title,
			ActionListener actionListener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(actionListener);
	}

	private void addBall() {
		try {
			Ball ball = new Ball(DEFAULT_WIDTH, DEFAULT_HEIGHT);
			comp.add(ball);
			for (int i = 0; i < STEPS; i++) {
				ball.move(comp.getBounds(), (double) DELAY / 100);
				comp.paint(comp.getGraphics());
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {
		}
	}
}
