package englard.paint;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class CanvasRepaintManager {

	private Canvas canvas;

	@Inject
	public CanvasRepaintManager(Canvas c) {

		this.canvas = c;

	}

	public void repaint(int x1, int y1, int x2, int y2) {
		int x, y, width, height;
		width = Math.abs(x1 - x2);
		height = Math.abs(y1 - y2);
		x = Math.min(x1, x2);
		y = Math.min(y1, y2);

		canvas.repaint(x, y, width, height);
	}
}
