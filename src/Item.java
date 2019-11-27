
public abstract class Item {
	
	private int width;
	private int height;
	
	Item(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
