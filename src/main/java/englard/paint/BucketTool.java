package englard.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class BucketTool implements Tool {

	private Piont originalPiont;
	private Queue<Piont> queue;

	@Override
	public BufferedImage mousePressed(int x, int y, BufferedImage img) {
		originalPiont = new Piont(x, y);

		Color replacementColor = Color.RED;
		int targetRGB = img.getRGB(x, y);
		/*
		 * queue = new LinkedList<Piont>();
		 * 
		 * queue.add(originalPiont); while (!queue.isEmpty()) { Piont upTo =
		 * queue.remove(); floodFillTwo(upTo.getX(), upTo.getY(), targetRGB,
		 * replacementColor, img); } JOptionPane.showMessageDialog(null,
		 * "DOme");
		 */

		floodFill(x, y, targetRGB, replacementColor, img);
		return img;

	}

	public void floodFillTwo(int x, int y, int targetColor,
			Color replacementColor, BufferedImage img) {

		if (img.getRGB(x, y) != targetColor)
			return;

		img.setRGB(x, y, replacementColor.getRGB());
		this.queue.add(new Piont(x - 1, y));
		this.queue.add(new Piont(x + 1, y));
		this.queue.add(new Piont(x, y - 1));
		this.queue.add(new Piont(x, y + 1));

		return;

	}

	public void floodFill(int x, int y, int targetColor,
			Color replacementColor, BufferedImage img) {

		if (img.getRGB(x, y) != targetColor)
			return;

		img.setRGB(x, y, replacementColor.getRGB());
		floodFill(x - 1, y, targetColor, replacementColor, img);
		floodFill(x + 1, y, targetColor, replacementColor, img);
		floodFill(x, y - 1, targetColor, replacementColor, img);
		floodFill(x, y + 1, targetColor, replacementColor, img);

		return;

	}

	@Override
	public void mouseReleased(int x, int y, Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(int x, int y, Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPriview(Graphics g) {
		// TODO Auto-generated method stub

	}

}
