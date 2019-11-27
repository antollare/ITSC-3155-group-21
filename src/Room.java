import java.util.ArrayList;

public class Room {

	private int max_X_Coord;
	private int max_Y_Coord;
	private Item[] roomItems;
	private int wallColor;
	
	Room(int width, int height){
		max_X_Coord = width;
		max_Y_Coord = height;
		wallColor = 0;
		//create an array to store the items depending on the x and y coord
		roomItems = new Item[width*height];
	}
	
	public void addItem(int x_coord, int y_coord, Item item) {
		//check to see if there is an item already there
		if(itemIsThere(x_coord, y_coord)){
			return;
		}
		//check if there is enough space in room
		if(x_coord + item.getWidth() > max_X_Coord || x_coord < 0) {
			return;
		}
		if(y_coord + item.getHeight() > max_Y_Coord || y_coord < 0) {
			return;
		}
		for(int j = 0; j <= item.getHeight(); j++) {
			for(int i = 0; i <= item.getWidth(); i++) {
				roomItems[(x_coord + i)+(j+y_coord)*max_X_Coord] = item;
			}
		}
	}
	
	public Item getItem(int x, int y) {
		return roomItems[x+y*max_X_Coord];
	}
	
	public void setWalls(int color) {
		wallColor = color;
	}
	
	private boolean itemIsThere(int x, int y) {
		if(roomItems[x+y*max_X_Coord] != null) {
			return true;
		} else {
			return false;
		}
	}
}
