import java.awt.*;
import javax.swing.*;
public class Ship {
	private BattleShipView view;
	private int length; 
	private boolean alive;
	private boolean rotated;//false = horizontal, true = vertical
	private int x; //top left coordinates
	private int y;
	
	public Ship(int length, boolean rotated, int x, int y, BattleShipView view) {
		super();
		this.length = length;
		alive = true;
		this.rotated = rotated;
		this.x = x;
		this.y = y;
		this.view = view;
	}
	public void colorShip() {
		for(int i =0;i<length;i++) {
			if(rotated) {
				view.ChangePlayerColor(Color.BLACK,x,y+i);
			}
			else {
				view.ChangePlayerColor(Color.BLACK,x+i,y);
			}
		}
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean isAlive) {
		this.alive = isAlive;
	}
	public boolean isRotated() {
		return rotated;
	}
	public void setRotated(boolean rotated) {
		this.rotated = rotated;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
