import java.awt.Color;
import java.awt.Image;

public class Ruby extends Jewel {
	static Image jewelImage;
	// I found the locations below by a little bit of guess and 
	// check to find a rectangle that bounded the image of the 
	// Ruby.
	static final int EM_X=1064, EM_Y=646, EM_W = 120, EM_H=100;
	
	public Ruby(int r, int co) {
		super(Color.RED, getImage(), r, co);
	}

	private static Image getImage() {
		if(jewelImage == null)
			jewelImage= openImageFromSpriteSheet(EM_X, EM_Y, EM_W, EM_H);
		return jewelImage;
	}

}
