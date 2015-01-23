package trees.panel.style;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Rectangle;

public class Fixed extends Size {
	
	private int width, height;

	public Fixed(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean hasMaximum() {
		return true;
	}

	@Override
	public boolean hasMinimum() {
		return true;
	}

	@Override
	public Dimension getMaximum() {
		return new Dimension(width, height);
	}

	@Override
	public Dimension getMinimum() {
		return new Dimension(width, height);
	}

	@Override
	protected int getWidth(boolean hasVerticalOrientation, boolean hasPointerBoxes, Dimension label) {
		// Ignore Label
		return width;
	}

	@Override
	protected int getHeight(boolean hasVerticalOrientation, boolean hasPointerBoxes, Dimension label) {
		// Ignore Label
		return height;
	}
//
//	@Override
//	public String[] getLabel(FontMetrics metrics, Rectangle area, String label) {
//		return null; //trimLabel(metrics, area, label);
//	}
	
}
