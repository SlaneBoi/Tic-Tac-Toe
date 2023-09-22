
public abstract class Player {
	
	protected String name;
	protected char marker;
	
	public abstract int move(char[][] board);
	
//	public abstract void move();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getMarker() {
		return marker;
	}

	public void setMarker(char marker) {
		this.marker = marker;
	}
	
	
	

}
