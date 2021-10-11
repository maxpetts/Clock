/**
 * ClockComponent.java - Instantiates the graphics2d class and calls draw method for components
 * @author Max Petts / eeub35
 * @version 0.1
 * @since 15/10/18
 */

import java.awt.*;
import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class ClockComponent extends JComponent{
	
	// Will instantiating time here speed up component painting?
	private LocalTime local_time;
	private int hour;
	private int minute;
	
	// TODO Extract time out of clockcomponent
	public ClockComponent() {
		getCurrentTime();
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
				
		new Clock(g2, hour, minute);
	}
	
	public String displayTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

		return local_time.format(formatter);
	}
	
	public void getCurrentTime() {
		local_time = LocalTime.now();
		hour = local_time.getHour();
		minute = local_time.getMinute();
	}
}
