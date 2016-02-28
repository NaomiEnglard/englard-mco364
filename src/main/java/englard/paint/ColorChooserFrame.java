package englard.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class ColorChooserFrame extends JDialog {

	private JColorChooser chooser;
	private JButton okayBtn;
	private Color color;
	private boolean choosen;

	public ColorChooserFrame() {
		
		setTitle("COLORS");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		chooser = new JColorChooser();
		okayBtn = new JButton("okay");
		choosen = false;

		setLayout(new BorderLayout());
		add(chooser, BorderLayout.CENTER);
		add(okayBtn, BorderLayout.SOUTH);

		okayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				color = (chooser.getColor());
				choosen = true;
				//dispose();

			}
		});
	}
	
	public Color getColor() {
	
		return this.color;
	}
	
}
