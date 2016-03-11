package englard.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

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
	private ToolButton[] toolButtons;
	private ActionListener listener;
	

	@Inject
	public PaintFrame(PaintProperties p) {
		setTitle("Paint");
		setSize(1120, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		createComponents(p);
		setProperties();
		addComponents();
		addListeners();

	}

	private void addComponents() {
		simplfyChooser();
		for (ToolButton button : toolButtons) {
			buttonPanel.add(button);
			this.setButtonOpaque(button);

		}
		buttonPanel.add(clearBtn);
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
			if (!clsName.equals("javax.swing.colorchooser.DefaultSwatchChooserPanel")) {
				chooser.removeChooserPanel(oldPanels[i]);
			} else { // if is swatches{
				oldPanels[i].setBackground(Color.WHITE);
			}
		}

		chooser.setPreviewPanel(new JPanel());

	}

	private void createComponents(PaintProperties properties ) {
		Injector injector = Guice.createInjector(new PaintModule());
		properties =injector.getInstance(PaintProperties.class);
		//properties = new PaintProperties();
		properties.setWidth(1120);
		properties.setHeight(600);
		canvas = new Canvas(properties);
		clearBtn = new JButton("CLEAR");
		buttonPanel = new JPanel();
		scroll = new JScrollPane(canvas, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		undo = new JButton();
		redo = new JButton();
		chooser = new JColorChooser();
		toolButtons = new ToolButton[] { new ToolButton(new PencilTool(canvas.getProperties()), "/pencilIcon.png"),
				new ToolButton(new BoxTool(canvas.getProperties()), "/boxIcon.png"),
				new ToolButton(new LineTool(canvas.getProperties()), "/lineIcon.png"),
				new ToolButton(new BucketTool(canvas.getProperties()), "/paintBucketIcon.png"),
				new ToolButton(new ElipseTool(canvas.getProperties()), "/elipseIcon.png"), };

	}

	private void setProperties() {
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setPreferredSize(new Dimension(1100, 120));
		undo.setIcon(new ImageIcon(getClass().getResource("/undoIcon.png")));
		redo.setIcon(new ImageIcon(getClass().getResource("/redoIcon.png")));
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
		listener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ToolButton button = (ToolButton) e.getSource();
				canvas.toolSelected(button.getTool());

			}

		};
		for (ToolButton button : toolButtons) {
			button.addActionListener(listener);

		}

		clearBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.clearCanvas();
				canvas.repaint();

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

			public void stateChanged(ChangeEvent arg0) {
				canvas.setColor(chooser.getColor());
			}

		});

	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame f = injector.getInstance(PaintFrame.class);
		f.setVisible(true);

	}
}
