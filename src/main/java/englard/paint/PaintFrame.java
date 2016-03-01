package englard.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class PaintFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	private JButton clearBtn;
	private JButton pencilTool;
	private JButton boxTool;
	private JButton lineTool;
	private JPanel buttonPanel;
	private JButton paintTool;
	private JButton elipseTool;
	private JButton undo;
	private JButton redo;
	private JScrollPane scroll;
	private JColorChooser chooser;
	private JButton color;
	private JPanel east;
	private JButton colorChoice;

	public PaintFrame() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		createComponents();
		setProperties();
		addComponents();
		addListeners();

	}

	private void addComponents() {
		buttonPanel.add(clearBtn);
		buttonPanel.add(pencilTool);
		buttonPanel.add(boxTool);
		buttonPanel.add(lineTool);
		buttonPanel.add(paintTool);
		buttonPanel.add(elipseTool);
		buttonPanel.add(undo);
		buttonPanel.add(redo);
		buttonPanel.add(color);
		east.add(chooser);
		east.add(colorChoice);
		add(buttonPanel, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(east, BorderLayout.EAST);

	}

	private void createComponents() {
		canvas = new Canvas();
		clearBtn = new JButton("CLEAR");
		pencilTool = new JButton("Pencil Tool");
		boxTool = new JButton("Box Tool");
		lineTool = new JButton("Line Tool");
		buttonPanel = new JPanel();
		scroll = new JScrollPane(canvas,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		paintTool = new JButton("Paint Bucket");
		elipseTool = new JButton("Elipse Tool");
		undo = new JButton("undo");
		redo = new JButton("redo");
		chooser = new JColorChooser();
		color = new JButton("Choose Color");
		colorChoice = new JButton("Choose color");
		east = new JPanel();
	}

	private void setProperties() {
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		buttonPanel.setLayout(new GridLayout(1, 5));
		ImageIcon pencil = new ImageIcon(this.getClass().getResource(
				"./paintBrush.png"));
		Image resized = pencil.getImage().getScaledInstance(15, 20,
				Image.SCALE_SMOOTH);
		pencil = new ImageIcon(resized);
		pencilTool.setIcon(pencil);
		east.setLayout(new FlowLayout());
		east.setVisible(false);

	}

	private void addListeners() {
		clearBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.clearCanvas();
				canvas.repaint();

			}

		});
		boxTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				canvas.toolSelected(new BoxTool());
			}

		});

		pencilTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.toolSelected(new PencilTool());

			}

		});
		lineTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				canvas.toolSelected(new LineTool());
			}

		});

		paintTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.toolSelected(new BucketTool(canvas));
			}
		});

		elipseTool.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.toolSelected(new ElipseTool());
			}
		});

		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.undo();
			}
		});

		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.redo();
			}
		});

		color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				east.setVisible(true);
				east.setSize(new Dimension(100,100));

				repaint();
			}
		});
		
		colorChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(chooser.getColor());
				east.setVisible(false);
				east.setSize(new Dimension(0,0));
				repaint();
			}
		});
		


	}

	public static void main(String[] args) {
		PaintFrame f = new PaintFrame();
		f.setVisible(true);

	}
}
