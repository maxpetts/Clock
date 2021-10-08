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
	
private LocalTime local_time = LocalTime.now();
private int hour = local_time.getHour();
private int min = local_time.getMinute();


	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		
		Clock c1 = new Clock(g2, hour, min);
	}
}
