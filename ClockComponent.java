/**
 * ClockComponent.java - Instantiates the graphics2d class and calls draw method for components
 * @author Max Petts / eeub35
 * @version 0.1
 * @since 15/10/18
 */

package assess;

import java.awt.*;
import javax.swing.*;

public class ClockComponent extends JComponent{
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		Clock c1 = new Clock(g2, 00, 15);
	}
}
