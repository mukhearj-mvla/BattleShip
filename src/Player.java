import java.awt.*;
public class Player {
	private Ship[] ships;
	private boolean[][] hasShip;
	private boolean[][] attacked;
	private BattleShipView view;
	private int shipLength; //length of current ship, subtract by one everytime a ship is placed
	public Player(BattleShipView view) {
		super();
		this.view = view;
		shipLength = 5;
		hasShip = new boolean[11][11];
		attacked = new boolean[11][11];
		ships = new Ship[5];
	}
	
	public void placeShips(Ship s) {
		if(!overlap(s)) {
			ships[shipLength-1] = s;
			for(int i =0;i<s.getLength();i++) {
				if(s.isRotated()) {
					view.ChangePlayerColor(Color.BLUE,s.getX(),s.getY()+i);
					hasShip[s.getX()][s.getY()+i] = true;
				}
				else {
					view.ChangePlayerColor(Color.BLUE,s.getX()+i,s.getY());
					hasShip[s.getX()+i][s.getY()] = true;
				}
			}
			shipLength--;
			if(shipLength == 0) {
				view.setPlacingDone(true);
			}
		}
		
	}
	
	public void Attack(int r, int c) {
		Computer cpu = view.getCpu();
		attacked[r][c] = true;
		if(cpu.getHasShip()[r][c]) {
			view.ChangeCPUColor(Color.RED, r, c);
		}
		else {
			view.ChangeCPUColor(Color.BLACK, r, c);
		}
	}
	
	public Ship[] getShips() {
		return ships;
	}

	public void setShips(Ship[] ships) {
		this.ships = ships;
	}

	public boolean[][] getHasShip() {
		return hasShip;
	}

	public void setHasShip(int r, int c) {
		hasShip[r][c] = true;
	}

	public boolean[][] getAttacked() {
		return attacked;
	}

	public void setAttacked(boolean[][] attacked) {
		this.attacked = attacked;
	}

	public boolean overlap(Ship s) {
		if((!s.isRotated() && s.getX() + shipLength > 10) || (s.isRotated() && s.getY() + shipLength > 10)) {
			return true;
		}
		for(int i =0;i<s.getLength();i++) {
			if(s.isRotated()) {
				if(hasShip[s.getX()][s.getY()+i]) {
					return true;
				}
			}
			else {
				if(hasShip[s.getX()+i][s.getY()]) {
					return true;
				}
			}
		}
		return false;
	}

	public BattleShipView getView() {
		return view;
	}


	public int getLength() {
		return shipLength;
	}

	public int getShipLength() {
		return shipLength;
	}

	public void setShipLength(int shipLength) {
		this.shipLength = shipLength;
	}
	

	
}
