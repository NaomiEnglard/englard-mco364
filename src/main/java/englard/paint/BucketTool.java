package englard.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;


public class BucketTool extends Tool {

	
	private Piont originalPiont;
	private Queue<Piont> queue;
	 

	public BucketTool(PaintProperties properties) {
		super(properties);
	}

	
	public void mousePressed(int x, int y, Graphics g) {
		originalPiont = new Piont(x, y);
		BufferedImage img = properties.getImage();
		Color replacementColor = this.properties.getColor();
		int srcRGB = img.getRGB(x, y);
		queue = new LinkedList<Piont>();
		queue.add(originalPiont);
		//if original is the same color as chossen returnif()
		while (!queue.isEmpty()) {
			Piont upTo = queue.remove();
			int pX = upTo.getX();
			int pY = upTo.getY();
			if ((pX >= 0)
					&& (pX < img.getWidth() && (pY >= 0) && (pY < img
							.getHeight()))) {
				fill(upTo.getX(), upTo.getY(), srcRGB,
						replacementColor, img);
			}
		}

		
		super.properties.setImage(img);

	}

	public void fill(int x, int y, int srcColor, Color replacementColor, BufferedImage img) {

		if (img.getRGB(x, y) != srcColor)
			return;

		img.setRGB(x, y, replacementColor.getRGB());
		this.queue.add(new Piont(x - 1, y));
		this.queue.add(new Piont(x + 1, y));
		this.queue.add(new Piont(x, y - 1));
		this.queue.add(new Piont(x, y + 1));

		return;

	}

	

	
	public void mouseReleased(int x, int y, Graphics g) {
		// TODO Auto-generated method stub

	}


	public void mouseDragged(int x, int y, Graphics g) {
		// TODO Auto-generated method stub

	}

	public void drawPriview(Graphics g) {
		// TODO Auto-generated method stub

	}

}
