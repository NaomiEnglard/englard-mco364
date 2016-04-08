package englard.paint;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.Test;
import org.mockito.Mockito;

public class PencilTest {
	
	@Test
	public void testMousePressed() {
		PaintProperties properites = Mockito.mock(PaintProperties.class);
		Mockito.when(properites.getColor()).thenReturn(Color.RED);
		CanvasRepaintManager manger = Mockito.mock(CanvasRepaintManager.class);

		PencilTool tool = new PencilTool(manger,properites);
		Graphics g = Mockito.mock(Graphics.class);
		tool.mousePressed(1, 2, g);
	

		// check that g.drawLine(5,5,10,10) was called
		Mockito.verify(g).drawLine(1, 2,1, 2);
		Mockito.verify(g).setColor(Color.RED);

	}
	
	@Test
	public void testMouseDragged(){
		PaintProperties properites = Mockito.mock(PaintProperties.class);
		Mockito.when(properites.getColor()).thenReturn(Color.RED);
		CanvasRepaintManager manger = Mockito.mock(CanvasRepaintManager.class);

		PencilTool tool = new PencilTool(manger,properites);
		Graphics g = Mockito.mock(Graphics.class);
		tool.mousePressed(5, 10, g);
		tool.mouseDragged(6, 11, g);
		// check that g.drawLine(5,5,10,10) was called
		Mockito.verify(g).drawLine(5, 10,6, 11);
		Mockito.verify(g, Mockito.atLeastOnce()).setColor(Color.RED);
	}

	

}
