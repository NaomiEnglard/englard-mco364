1 package englard.paint; 
2 
 
3 import java.awt.Color; 
4 import java.awt.Graphics; 
5 
 
6 public class BoxTool implements Tool { 
7 
 
8 	private Piont prev; 
9 	private Piont previewPiont; 
10 
 
11 	public void mousePressed(int x, int y, Graphics g, Color c) { 
12 
 
13 		g.setColor(c); 
14 		prev = new Piont(x, y); 
15 		previewPiont = new Piont(x, y); 
16 
 
17 	} 
18 
 
19 	public void mouseReleased(int x, int y, Graphics g, Color c) { 
20 		g.setColor(c); 
21 		g.drawRect(prev.getX(), prev.getY(), Math.abs(prev.getX() - x), 
22 				Math.abs(prev.getY() - y)); 
23 	} 
24 
 
25 	public void mouseDragged(int x, int y, Graphics g, Color c) { 
26 
 
27 		previewPiont = new Piont(x, y); 
28 
 
29 	} 
30 
 
31 	public void drawPriview(Graphics g, Color c) { 
32 
 
33 		g.setColor(c); 
34 		g.drawRect(prev.getX(), prev.getY(), 
35 				Math.abs(prev.getX() - previewPiont.getX()), 
36 				Math.abs(previewPiont.getY() - prev.getY())); 
37 
 
38 	} 
39 
 
40 } 
