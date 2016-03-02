package englard.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PencilTool implements Tool {

	private Piont prev ;

	public void mousePressed(int x, int y, Graphics g, Color c) {
	
		g.setColor(c);
		prev = new Piont(x, y);
		g.drawLine(x, y, x, y);
		
	}

	public void mouseReleased(int x, int y, Graphics g, Color c) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(int x, int y, Graphics g, Color c) {

		g.setColor(c);
		g.drawLine(prev.getX(), prev.getY(), x, y);
		prev = new Piont(x, y);
	}

	public void drawPriview(Graphics g, Color c) {
		
	}

}
