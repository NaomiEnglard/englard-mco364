package englard.paint;

import java.awt.Color;
import java.awt.Graphics;

public class BoxTool implements Tool {

	private Piont prev;
	private Piont previewPiont;

	public void mousePressed(int x, int y, Graphics g) {

		g.setColor(Color.BLUE);
		prev = new Piont(x, y);

	}

	public void mouseReleased(int x, int y, Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(prev.getX(), prev.getY(), x, y);
	}

	public void mouseDragged(int x, int y, Graphics g) {

		previewPiont = new Piont(x, y);

	}

	public void drawPriview(Graphics g) {

		g.setColor(Color.BLUE);
		g.drawRect(prev.getX(), prev.getY(), previewPiont.getX(), previewPiont.getY());

	}

}
