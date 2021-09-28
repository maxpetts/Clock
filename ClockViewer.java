/**
 * ClockViewer.java - Creates a new JFrame and calls the clock component
 * @author Max Petts / eeub35
 * @version 0.1
 * @since 15/10/18
 */

package assess;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class ClockViewer {
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		final int FRAME_DIMENSION = 400;
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		frame.setTitle("Clock");
		frame.setResizable(false);
		// center the window on the screen
		frame.setLocation((screenWidth - FRAME_DIMENSION)/2, (screenHeight - FRAME_DIMENSION)/2);

		// set content pane size instead of frame size
		frame.getContentPane().setPreferredSize(new Dimension(400, 400));
		frame.pack();
		
		ClockComponent clock = new ClockComponent();
		frame.add(clock);
		
		frame.setVisible(true);
	}
}