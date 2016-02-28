package englard.paint;

import java.awt.Color;
import java.awt.Graphics;


public class ElipseTool implements Tool {

	private Piont prev;
	private Piont previewPiont;

	public void mousePressed(int x, int y, Graphics g, Color c) {

		prev = new Piont(x, y);
		previewPiont = new Piont(x,y);

	}

	public void mouseReleased(int x, int y, Graphics g, Color c) {
		g.setColor(c);
		g.drawOval(prev.getX(), prev.getY(), Math.abs(prev.getX() - x),
				Math.abs(prev.getY() - y));
	}

	public void mouseDragged(int x, int y, Graphics g, Color c) {

		previewPiont = new Piont(x, y);

	}

	public void drawPriview(Graphics g, Color c) {

		g.setColor(c);
		g.drawOval(prev.getX(), prev.getY(),
				Math.abs(prev.getX() - previewPiont.getX()),
				Math.abs(previewPiont.getY() - prev.getY()));
	}

}