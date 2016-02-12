package englard.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PaintFrame extends JFrame {

	public PaintFrame() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		final Canvas canvas = new Canvas();
		container.add(canvas, BorderLayout.CENTER);
		
		JButton clearBtn = new JButton("CLEAR");
		clearBtn.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				canvas.clearCanvas();
				canvas.repaint();
				
			}
			
		});
		
		JButton redColor = new JButton("RED");
		redColor.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		add(clearBtn, BorderLayout.NORTH);

	}

	public static void main(String[] args) {
		PaintFrame f = new PaintFrame();
		f.setVisible(true);

	}
}
