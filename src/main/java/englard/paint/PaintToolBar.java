package englard.paint;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Singleton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.google.inject.Inject;

@Singleton
public class PaintToolBar extends Container {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ToolButton[] toolButtons;
	private PaintProperties properites;
	private JButton clearBtn;
	private PaintToolBar toolBar;
	private JButton undo;
	private JButton redo;
	private JColorChooser chooser;
	private ActionListener listener;
	private Canvas canvas;

	@Inject
	public PaintToolBar(Canvas c, CanvasRepaintManager manager) {
		this.canvas = c;

		// create components
		clearBtn = new JButton("CLEAR");
		undo = new JButton();
		redo = new JButton();
		chooser = new JColorChooser();
		toolButtons = new ToolButton[] { 
				new ToolButton(new PencilTool(manager,canvas.getProperties()), "/pencilIcon.png"),
				new ToolButton(new BoxTool(manager,canvas.getProperties()), "/boxIcon.png"),
				new ToolButton(new LineTool(manager,canvas.getProperties()), "/lineIcon.png"),
				new ToolButton(new BucketTool(manager,canvas.getProperties()), "/paintBucketIcon.png"),
				new ToolButton(new ElipseTool(manager,canvas.getProperties()), "/elipseIcon.png"), };

		// Properties
		this.setLayout(new FlowLayout());
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(1100, 120));
		simplfyChooser();
		undo.setIcon(new ImageIcon(getClass().getResource("/undoIcon.png")));
		redo.setIcon(new ImageIcon(getClass().getResource("/redoIcon.png")));
		setButtonOpaque(undo);
		setButtonOpaque(redo);

		// add components
		this.add(clearBtn);

		for (ToolButton button : toolButtons) {
			this.add(button);
			this.setButtonOpaque(button);

		}
		this.add(undo);
		this.add(redo);
		this.add(chooser);

		// listener
		this.addListeners();
		for (ToolButton button : toolButtons) {
			button.addActionListener(listener);

		}

	}

	private void setButtonOpaque(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);

	}

	private void simplfyChooser() {
		AbstractColorChooserPanel[] oldPanels = chooser.getChooserPanels();
		for (int i = 0; i < oldPanels.length; i++) {
			String clsName = oldPanels[i].getClass().getName();
			if (!clsName.equals("javax.swing.colorchooser.DefaultSwatchChooserPanel")) {
				chooser.removeChooserPanel(oldPanels[i]);
			} else {
				oldPanels[i].setBackground(Color.WHITE);
			}
		}

		chooser.setPreviewPanel(new JPanel());

	}

	private void addListeners() {
		listener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ToolButton button = (ToolButton) e.getSource();
				canvas.toolSelected(button.getTool());

			}

		};
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

}
