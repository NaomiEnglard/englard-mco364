package englard.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class LineTool implements Tool {

	private Piont prev;
	private Piont previewPiont;

	public BufferedImage mousePressed(int x, int y, BufferedImage img) {
		prev = new Piont(x, y);
		return img;
	}

	public void mouseReleased(int x, int y, Graphics g) {

		g.setColor(Color.blue);
		g.drawLine(prev.getX(), prev.getY(), x, y);
	}

	public void mouseDragged(int x, int y, Graphics g) {
		
		previewPiont = new Piont(x,y);
	
	

	}

	public void drawPriview(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawLine(prev.getX(), prev.getY(), previewPiont.getX(), previewPiont.getY());

	}

}
