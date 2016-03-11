package englard.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tool tool;
	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private PaintProperties properties;

	public Canvas(final PaintProperties properties) {
		this.properties = properties;
		properties.setImage(new BufferedImage(properties.getWidth(), properties.getHeight(),
				BufferedImage.TYPE_INT_ARGB));
		this.properties.setColor(Color.BLACK);
		tool = new PencilTool(properties);
		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();

		// draw tool mouse listener
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {
				tool.mouseDragged(e.getX(), e.getY(), properties.getImage().getGraphics());
				repaint();

			}

			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub0

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				pushImageToStack(undo);
				tool.mousePressed(e.getX(), e.getY(), properties.getImage().getGraphics());
				repaint();
			}

			public void mouseReleased(MouseEvent e) {
				tool.mouseReleased(e.getX(), e.getY(), properties.getImage().getGraphics());
				repaint();

			}

		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.properties.getImage(), 0, 0, null);
		tool.drawPriview(g);

	}

	public void clearCanvas() {
		this.properties.setImage(new BufferedImage(properties.getWeight(), properties.getHeight(),
				BufferedImage.TYPE_INT_ARGB));

		repaint();
	}

	public void changeColor(Color color) {
		// buffer
	}

	public void toolSelected(Tool tool) {
		this.tool = tool;
	}

	public BufferedImage getImage() {
		return this.properties.getImage();
	}

	public void setImage(BufferedImage image) {
		this.properties.setImage(image);
	}

	public void undo() {
		if (undo.isEmpty()) {
			return;
		}
		pushImageToStack(redo);
		properties.setImage(undo.pop());
		repaint();

	}

	public void redo() {
		if (redo.isEmpty()) {
			return;
		}
		pushImageToStack(undo);
		this.properties.setImage(redo.pop());
		repaint();
	}

	private void pushImageToStack(Stack<BufferedImage> stack) {
		BufferedImage stackImage = new BufferedImage(properties.getImage().getWidth(), properties.getImage()
				.getHeight(), properties.getImage().getType());
		Graphics2D g2d = stackImage.createGraphics();
		g2d.drawImage(properties.getImage(), 0, 0, null);
		stack.push(stackImage);

	}

	public void setColor(Color color) {
		this.properties.setColor(color);
	}

	public PaintProperties getProperties() {
		return this.properties;
	}
}
