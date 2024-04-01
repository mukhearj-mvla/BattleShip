
public class BattleShipRunner {
	private BattleShipView view;
	private boolean moveOn;
	public BattleShipRunner() {
		view = new BattleShipView(10);
		moveOn = false;
		while(!moveOn) {
			System.out.println(moveOn);
			moveOn = view.isPlacingDone();
			
		}

		for(int i =0;i<5;i++) {
			view.getCpu().choseShip();
		}
		while(!view.isGameOver()) {
			if(!view.isTurn()) {
				view.getCpu().Attack();
				if(view.isGameOver(true)) {
					break;
				}
				
			}
		}
		view.gameOver();
	}
}
