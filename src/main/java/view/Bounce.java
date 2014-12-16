package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import frame.BounceFrameMultiBall;

public class Bounce {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new BounceFrameMultiBall();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
