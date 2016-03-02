package englard.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

	public PaintFrame() {
		setTitle("Paint");
		setSize(1120, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		createComponents();
		setProperties();
		addComponents();
		addListeners();

	}

	private void addComponents() {
		simplfyChooser();
		buttonPanel.add(clearBtn);
		buttonPanel.add(pencilTool);
		buttonPanel.add(boxTool);
		buttonPanel.add(lineTool);
		buttonPanel.add(paintTool);
		buttonPanel.add(elipseTool);
		buttonPanel.add(undo);
		buttonPanel.add(redo);
		buttonPanel.add(chooser);
		add(buttonPanel, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);

	}

	private void simplfyChooser() {
		AbstractColorChooserPanel[] oldPanels = chooser.getChooserPanels();
		for (int i = 0; i < oldPanels.length; i++) {
			String clsName = oldPanels[i].getClass().getName();
			if (!clsName
					.equals("javax.swing.colorchooser.DefaultSwatchChooserPanel")) {
				chooser.removeChooserPanel(oldPanels[i]);
			} else { // if is swatches{
				oldPanels[i].setBackground(Color.WHITE);
			}
		}

		chooser.setPreviewPanel(new JPanel());

	}

	private void createComponents() {
		canvas = new Canvas();
		clearBtn = new JButton("CLEAR");
		pencilTool = new JButton();
		boxTool = new JButton();
		lineTool = new JButton();
		buttonPanel = new JPanel();
		scroll = new JScrollPane(canvas,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		paintTool = new JButton();
		elipseTool = new JButton();
		undo = new JButton();
		redo = new JButton();
		chooser = new JColorChooser();

	}

	private void setProperties() {
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setPreferredSize(new Dimension(1100, 120));
		pencilTool.setIcon(new ImageIcon("./pencilIcon.png"));
		boxTool.setIcon(new ImageIcon("./boxIcon.png"));
		lineTool.setIcon(new ImageIcon("./lineIcon.png"));
		paintTool.setIcon(new ImageIcon("./paintBucketIcon.png"));
		elipseTool.setIcon(new ImageIcon("./elipseIcon.png"));
		undo.setIcon(new ImageIcon("./undoIcon.png"));
		redo.setIcon(new ImageIcon("./redoIcon.png"));

		setButtonOpaque(pencilTool);
		setButtonOpaque(boxTool);
		setButtonOpaque(lineTool);
		setButtonOpaque(elipseTool);
		setButtonOpaque(paintTool);
		setButtonOpaque(undo);
		setButtonOpaque(redo);
		setIconImage(new ImageIcon("./paintIcon.png").getImage());

	}

	private void setButtonOpaque(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);

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

		chooser.getSelectionModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				canvas.setColor(chooser.getColor());
			}

		});

	}

	public static void main(String[] args) {
		PaintFrame f = new PaintFrame();
		f.setVisible(true);

	}
}
