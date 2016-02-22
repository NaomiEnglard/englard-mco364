package englard.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PaintFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	private JButton clearBtn;
	private JButton pencilTool;
	private JButton boxTool;
	private JButton redColor;
	private JButton lineTool;
	private JPanel buttonPanel;
	JScrollPane scroll;

	public PaintFrame() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createComponents();
		setProperties();
		addComponents();

	}

	private void addComponents() {
		buttonPanel.add(clearBtn);
		buttonPanel.add(pencilTool);
		buttonPanel.add(boxTool);
		buttonPanel.add(lineTool);
		add(buttonPanel, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		
	}

	private void createComponents() {
		canvas = new Canvas();
		clearBtn = new JButton("CLEAR");
		pencilTool = new JButton("Pencil Tool");
		boxTool = new JButton("Box Tool");
		redColor = new JButton("RED");
		lineTool = new JButton("Line Tool");
		buttonPanel = new JPanel();
		scroll = new JScrollPane(canvas,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

	}

	private void setProperties() {
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		buttonPanel.setLayout(new GridLayout(1, 5));
		ImageIcon pencil = new ImageIcon(this.getClass().getResource("./paintBrush.png"));
		Image resized = pencil.getImage().getScaledInstance(15, 20, Image.SCALE_SMOOTH);
		pencil = new ImageIcon(resized);
		pencilTool.setIcon(pencil);
		clearBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.clearCanvas();
				canvas.repaint();

			}

		});
		boxTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				canvas.boxToolSelected();
			}

		});

		pencilTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.pencilToolSelected();

			}

		});
		lineTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				canvas.lineToolSelected();
			}

		});

		redColor.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

	}

	public static void main(String[] args) {
		PaintFrame f = new PaintFrame();
		f.setVisible(true);

	}
}
