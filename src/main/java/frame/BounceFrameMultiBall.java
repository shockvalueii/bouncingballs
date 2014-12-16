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
import ball.BallRunnable;

public class BounceFrameMultiBall extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6619494923459864961L;
	
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;

	private BallComponent comp;

	public BounceFrameMultiBall() {
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
		Ball ball = new Ball(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		comp.add(ball);
		Runnable runnable = new BallRunnable(comp, ball);
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
