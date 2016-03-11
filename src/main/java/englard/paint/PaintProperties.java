package englard.paint;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class PaintProperties {

	private Color color;
	private int weight;
	private boolean filled;
	private int width; // of canvas
	private int height; // of canvas
	private BufferedImage image;

	public PaintProperties() {
		this.width = 800;
		this.height = 600;
		this.color = Color.BLACK;
		this.image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		this.weight =1;
		
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
