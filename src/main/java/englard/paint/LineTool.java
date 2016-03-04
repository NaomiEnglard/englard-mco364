package englard.paint;

import java.awt.Graphics;

public class LineTool extends Tool {

	private Piont prev;
	private Piont previewPiont;
	

	public LineTool(PaintProperties properties) {
		super(properties);
	}

	public void mousePressed(int x, int y, Graphics g) {
		prev = new Piont(x, y);
		previewPiont = new Piont(x, y);
	}

	public void mouseReleased(int x, int y, Graphics g) {

		g.setColor(super.properties.getColor());
		g.drawLine(prev.getX(), prev.getY(), x, y);
	}

	public void mouseDragged(int x, int y, Graphics g) {

		previewPiont = new Piont(x, y);

	}

	public void drawPriview(Graphics g) {
		g.setColor(super.properties.getColor());
		g.drawLine(prev.getX(), prev.getY(), previewPiont.getX(), previewPiont.getY());

	}

}
