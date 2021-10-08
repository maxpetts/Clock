/**
 * ClockViewer.java - Creates a new JFrame and calls the clock component
 * @author Max Petts / eeub35
 * @version 0.1
 * @since 15/10/18
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ClockViewer {
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		final int FRAME_DIMENSION = 400;
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		frame.setTitle("Clock");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Center the window on the screen
		frame.setLocation((screenWidth - FRAME_DIMENSION)/2, (screenHeight - FRAME_DIMENSION)/2);

		// Set content pane size instead of frame size
		frame.getContentPane().setPreferredSize(new Dimension(400, 400));
		frame.pack();
		
		ClockComponent clock = new ClockComponent();
		JLabel digital_time = new JLabel(clock.hour + " : " + clock.minute);
		clock.add(digital_time);
		frame.add(clock);
		
		frame.setVisible(true);
		
		// Repaint clock component every minute
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				clock.repaint();
			}
		}, 0, 60000);
	}
}