package englard.paint;

import java.awt.Graphics;
import java.util.logging.Logger;

public class LineTool extends Tool {

	private Piont prev;
	private Piont previewPiont;
	private static final Logger LOG = Logger.getLogger(LineTool.class.getName());
	

	public LineTool(CanvasRepaintManager manger, PaintProperties properties) {
		super(manger,properties);
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
		String longMessage =  String.format("x1= %d", prev.getX());
		LOG.info(longMessage);
	}

}
