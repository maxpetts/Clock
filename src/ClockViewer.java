/**
 * ClockViewer.java - Creates a new JFrame and calls the clock component
 * @author Max Petts / eeub35
 * @version 0.1
 * @since 15/10/18
 */

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ClockViewer {
	public static void main(String[] args) {

		JFrame frame = new JFrame("Clock");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		final Dimension FRAME_DIMENSION = new Dimension(400, 400);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Center the window on the screen
		frame.setLocation((screenSize.width - FRAME_DIMENSION.width)/2, (screenSize.height - FRAME_DIMENSION.height)/2);
		
		ClockComponent clock = new ClockComponent();
		clock.setPreferredSize(FRAME_DIMENSION);
		JLabel digital_time = new JLabel(clock.displayTime(), SwingConstants.CENTER);		
		digital_time.setFont(new Font("Serif", Font.PLAIN, 70));
				
		frame.add(clock, BorderLayout.CENTER);
		frame.add(digital_time, BorderLayout.PAGE_END);

		frame.pack();
		
		frame.setVisible(true);
		
		// Repaint clock component every minute
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				digital_time.setText(clock.displayTime());
				clock.updateTime();
				clock.repaint();
			}
		}, 0, 60000);
	}
}