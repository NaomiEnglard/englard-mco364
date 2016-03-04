package englard.paint;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolButton extends JButton {

	private Tool tool;

	public ToolButton(Tool tool, String iconName) {
		this.tool = tool;
		this.setIcon(new ImageIcon(getClass().getResource(iconName)));
	}

	public Tool getTool() {
		return this.tool;
	}

}
