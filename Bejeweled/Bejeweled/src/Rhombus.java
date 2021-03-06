import java.awt.Color;
import java.awt.Image;

public class Rhombus extends Jewel {
	static Image jewelImage;
	// I found the locations below by a little bit of guess and 
	// check to find a rectangle that bounded the image of the 
	// Ruby.
	static final int EM_X=1195, EM_Y=880, EM_W = 120, EM_H=100;
	
	public Rhombus(int r, int co) {
		super(Color.YELLOW, getImage(), r, co);
	}

	private static Image getImage() {
		if(jewelImage == null)
			jewelImage= openImageFromSpriteSheet(EM_X, EM_Y, EM_W, EM_H);
		return jewelImage;
	}

}
