package englard.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class BoxTool implements Tool {

	private Piont prev;
	private Piont previewPiont;

	public BufferedImage mousePressed(int x, int y, BufferedImage img) {

		img.getGraphics().setColor(Color.BLUE);
		prev = new Piont(x, y);
		return img;

	}

	public void mouseReleased(int x, int y, Graphics g) {
		g.setColor(Color.BLUE);
<<<<<<< HEAD
		g.drawRect(prev.getX(), prev.getY(), x, y);
=======
		g.drawRect(prev.getX(), prev.getY(), Math.abs(prev.getX() - x),
				Math.abs(prev.getY() - y));
>>>>>>> 6d0746e43871896a20c591f2cd70248020577d16
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
