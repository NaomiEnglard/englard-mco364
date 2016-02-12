package englard.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private BufferedImage buffer;
	private Piont prev = new Piont(0, 0);

	public Canvas() {

		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {

				Graphics g = buffer.getGraphics();
				g.setColor(Color.blue);
				g.drawLine(prev.getX(), prev.getY(), e.getX(), e.getY());
				prev = new Piont(e.getX(), e.getY());
				
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
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				Graphics g = buffer.getGraphics();
				g.setColor(Color.BLUE);
				prev = new Piont(e.getX(), e.getY());
				g.drawLine(e.getX(), e.getY(), e.getX(), e.getY());
				repaint();

			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
	}

	public void clearCanvas() {
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	}

	public void changeColor(Color color) {
		// buffer
	}

}
