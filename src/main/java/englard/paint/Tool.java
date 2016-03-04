package englard.paint;

import java.awt.Graphics;

abstract public class Tool {

	protected PaintProperties properties;

	public Tool(PaintProperties properties) {

		this.properties = properties;
	}

	abstract void mousePressed(int x, int y, Graphics g);

	abstract void mouseReleased(int x, int y, Graphics g);

	abstract void mouseDragged(int x, int y, Graphics g);

	abstract void drawPriview(Graphics g);

}
