package englard.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Canvas extends JPanel {

	private BufferedImage buffer;
	private Piont prev = new Piont(0, 0);
	private Tool tool = new PencilTool();

	public Canvas() {

		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

		// draw tool mouse listener
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {
				tool.mouseDragged(e.getX(), e.getY(), buffer.getGraphics());
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
<<<<<<< HEAD
				tool.mousePressed(e.getX(), e.getY(), buffer.getGraphics());
				repaint();

=======
				buffer = tool.mousePressed(e.getX(), e.getY(), buffer);
>>>>>>> 6d0746e43871896a20c591f2cd70248020577d16
			}

			public void mouseReleased(MouseEvent e) {
				tool.mouseReleased(e.getX(), e.getY(), buffer.getGraphics());
<<<<<<< HEAD

				repaint();

=======
				repaint();
>>>>>>> 6d0746e43871896a20c591f2cd70248020577d16
			}

		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
		tool.drawPriview(g);

	}

	public void clearCanvas() {
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	}

	public void changeColor(Color color) {
		// buffer
	}

	public void toolSelected(Tool tool) {
		this.tool = tool;
	}

	public void bucketToolSelected() {
		// TODO Auto-generated method stub

	}

}
