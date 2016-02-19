package englard.paint;

import java.awt.Graphics;

public interface Tool {

	void mousePressed(int x, int y, Graphics g);

	void mouseReleased(int x, int y, Graphics g);

	void mouseDragged(int x, int y, Graphics g);
	
	void drawPriview(Graphics g);

}
