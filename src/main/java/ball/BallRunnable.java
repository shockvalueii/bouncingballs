package ball;

public class BallRunnable implements Runnable {
	public static final int STEPS = 10000;
	public static final int DELAY = 3;
	private BallComponent panel;
	private Ball ball;

	public BallRunnable(BallComponent panel, Ball ball) {
		super();
		this.panel = panel;
		this.ball = ball;
	}

	public void run() {
		try {
			for (int i = 0; i < STEPS; i++) {
				ball.move(panel.getBounds(), (double)DELAY / 100);
				panel.repaint();
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {
		}
	}

}
