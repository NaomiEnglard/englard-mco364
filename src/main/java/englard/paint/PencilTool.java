package englard.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PencilTool implements Tool {

	private Piont prev ;

	public BufferedImage mousePressed(int x, int y, BufferedImage img) {
		Graphics g = img.getGraphics();
		g.setColor(Color.BLUE);
		prev = new Piont(x, y);
		g.drawLine(x, y, x, y);
		return img;
	}

	public void mouseReleased(int x, int y, Graphics g) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(int x, int y, Graphics g) {

		g.setColor(Color.blue);
		g.drawLine(prev.getX(), prev.getY(), x, y);
		prev = new Piont(x, y);
	}

	public void drawPriview(Graphics g) {
		
	}

}
