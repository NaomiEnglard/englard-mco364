package englard.paint;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.Test;
import org.mockito.Mockito;

public class LineToolTest {

	@Test
	public void testMouseReleased() {
		PaintProperties properites = Mockito.mock(PaintProperties.class);
		Mockito.when(properites.getColor()).thenReturn(Color.RED);
		CanvasRepaintManager manger = Mockito.mock(CanvasRepaintManager.class);
		LineTool tool = new LineTool(manger,properites);
		Graphics g = Mockito.mock(Graphics.class);
		tool.mousePressed(5, 5, g);
		tool.mouseReleased(10, 10, g);

		// check that g.drawLine(5,5,10,10) was called
		Mockito.verify(g).drawLine(5, 5, 10, 10);
		Mockito.verify(g).setColor(Color.RED);

	}

	@Test
	public void testDraw() {
		PaintProperties properites = Mockito.mock(PaintProperties.class);
		Mockito.when(properites.getColor()).thenReturn(Color.RED);
		CanvasRepaintManager manger = Mockito.mock(CanvasRepaintManager.class);
		LineTool tool = new LineTool(manger,properites);
		Graphics g = Mockito.mock(Graphics.class);
		tool.mousePressed(5, 5, g);
		tool.mouseReleased(10, 10, g);

		// check that g.drawLine(5,5,10,10) was called
		Mockito.verify(g).drawLine(5, 5, 10, 10);
		Mockito.verify(g).setColor(Color.RED);

	}
	
	@Test
	public void testRepaint(){
		//verify that repaint was called with perameter u want
	}
	

}
