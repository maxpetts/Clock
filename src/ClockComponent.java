/**
 * ClockComponent.java - Instantiates the graphics2d class and calls draw method for components
 * @author Max Petts / eeub35
 * @version 0.1
 * @since 15/10/18
 */

import java.awt.*;
import javax.swing.*;
import java.time.LocalTime;

@SuppressWarnings("serial")
public class ClockComponent extends JComponent{
	
	private LocalTime local_time;

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		local_time = LocalTime.now();
		
		System.out.println("time: " + local_time);
		
		Clock c1 = new Clock(g2, local_time.getHour(), local_time.getMinute());
	}
}
