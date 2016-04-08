package englard.paint;

import java.awt.Graphics;

public class ElipseTool extends Tool {

	public ElipseTool(CanvasRepaintManager manger, PaintProperties properties) {
		super(manger,properties);
	}

	private Piont prev;
	private Piont previewPiont;

	public void mousePressed(int x, int y, Graphics g) {

		prev = new Piont(x, y);
		previewPiont = new Piont(x, y);

	}

	public void mouseReleased(int x, int y, Graphics g) {
		g.setColor(super.properties.getColor());
		g.drawOval(prev.getX(), prev.getY(), Math.abs(prev.getX() - x), Math.abs(prev.getY() - y));
	}

	public void mouseDragged(int x, int y, Graphics g) {

		previewPiont = new Piont(x, y);

	}

	public void drawPriview(Graphics g) {

		g.setColor(super.properties.getColor());
		g.drawOval(prev.getX(), prev.getY(), Math.abs(prev.getX() - previewPiont.getX()),
				Math.abs(previewPiont.getY() - prev.getY()));
	}

}