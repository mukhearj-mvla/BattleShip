import java.awt.Color;

public class Computer extends Player{
	public Computer(BattleShipView view) {
		super(view);
	}
	
	public void choseShip() {
		Ship s;
		do {
			int length = super.getLength();
			int random = (int)(Math.random() * (2));
			boolean rotated;
			if(random == 0) {
				rotated = false;
			}
			else {
				rotated = true;
			}
			int x = (int)(Math.random() * (12-length));  
			int y = (int)(Math.random() * (12-length));
			s = new Ship(length,rotated,x,y,super.getView());
		} while(super.overlap(s));
		
		for(int i =0;i<s.getLength();i++) {
			if(s.isRotated()) {
				super.setHasShip(s.getX(),s.getY()+i);
				//super.getView().ChangeCPUColor(Color.BLUE,s.getX(),s.getY()+i);
			}
			else {
				super.setHasShip(s.getX()+i,s.getY());
				//super.getView().ChangeCPUColor(Color.BLUE,s.getX()+i,s.getY());
			}
		}
		super.getShips()[super.getShipLength()-1] = s;
		super.setShipLength(super.getShipLength()-1);
		
	}
	
	public void Attack() {
		
		int x;
		int y;
		do {
			x = (int)(Math.random()*10);
			y = (int)(Math.random()*10);
		} while(super.getAttacked()[x][y]);
		Player player = super.getView().getPlayer();
		super.getAttacked()[x][y] = true;
		if(player.getHasShip()[x][y]) {
			super.getView().ChangePlayerColor(Color.RED, x, y);
		}
		else {
			super.getView().ChangePlayerColor(Color.BLACK, x, y);
		}
		super.getView().setTurn(true);
		
		
	}

}
