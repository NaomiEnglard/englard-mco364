package englard.paint;

import java.awt.Color;
import java.awt.Graphics;

public interface Tool {

	void mousePressed(int x, int y, Graphics g, Color c);

	void mouseReleased(int x, int y, Graphics g, Color c);

	void mouseDragged(int x, int y, Graphics g, Color c);

	void drawPriview(Graphics g, Color c);

}
