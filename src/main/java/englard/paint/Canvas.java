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
	private BufferedImage buffer;
	private Tool tool;
	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private Color color;

	public Canvas() {
		tool = new PencilTool();
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();
		color = Color.BLACK;
		// draw tool mouse listener
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {
				tool.mouseDragged(e.getX(), e.getY(), buffer.getGraphics(), color);
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
				tool.mousePressed(e.getX(), e.getY(), buffer.getGraphics(), color);
				repaint();
			}

			public void mouseReleased(MouseEvent e) {
				tool.mouseReleased(e.getX(), e.getY(), buffer.getGraphics(), color);
				repaint();

			}

		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
		tool.drawPriview(g, color);

	}

	public void clearCanvas() {
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		repaint();
	}

	public void changeColor(Color color) {
		// buffer
	}

	public void toolSelected(Tool tool) {
		this.tool = tool;
	}

	public BufferedImage getImage() {
		return this.buffer;
	}

	public void setImage(BufferedImage image) {
		this.buffer = image;
	}

	public void undo() {
		if (undo.isEmpty()) {
			return;
		}
		pushImageToStack(redo);
		buffer = undo.pop();
		repaint();

	}

	public void redo() {
		if (redo.isEmpty()) {
			return;
		}
		pushImageToStack(undo);
		buffer = redo.pop();
		repaint();
	}

	private void pushImageToStack(Stack<BufferedImage> stack) {
		BufferedImage stackImage = new BufferedImage(buffer.getWidth(), buffer.getHeight(), buffer.getType());
		Graphics2D g2d = stackImage.createGraphics();
		g2d.drawImage(buffer, 0, 0, null);
		stack.push(stackImage);

	}

	public void setColor(Color color) {
		this.color = color;
	}
}
