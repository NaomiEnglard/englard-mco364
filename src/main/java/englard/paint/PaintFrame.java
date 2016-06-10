package englard.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	public PaintFrame(Canvas canvas, PaintToolBar toolBar) {
		setTitle("Paint");
		setSize(1120, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		setIconImage(new ImageIcon("./paintIcon.png").getImage());
		add(toolBar, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame f = injector.getInstance(PaintFrame.class);
		f.setVisible(true);

	}
}
