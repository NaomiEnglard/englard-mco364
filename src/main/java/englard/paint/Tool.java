package englard.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public interface Tool {

	BufferedImage mousePressed(int x, int y, BufferedImage img);

	void mouseReleased(int x, int y, Graphics g);

	void mouseDragged(int x, int y, Graphics g);

	void drawPriview(Graphics g);

}
