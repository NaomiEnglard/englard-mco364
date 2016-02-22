package englard.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

public class BoxTool implements Tool {

	private Piont prev;
	private Piont previewPiont;

	public void mousePressed(int x, int y, Graphics g) {

		g.setColor(Color.BLUE);
		prev = new Piont(x, y);

	}

	public void mouseReleased(int x, int y, Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(prev.getX(), prev.getY(), Math.abs(prev.getX() - x),
				Math.abs(prev.getY() - y));
	}

	public void mouseDragged(int x, int y, Graphics g) {

		previewPiont = new Piont(x, y);

	}

	public void drawPriview(Graphics g) {

		g.setColor(Color.BLUE);
		g.drawRect(prev.getX(), prev.getY(),
				Math.abs(prev.getX() - previewPiont.getX()),
				Math.abs(previewPiont.getY() - prev.getY()));

	}

}
