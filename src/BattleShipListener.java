import java.awt.event.*;
import java.awt.*;
public class BattleShipListener implements ActionListener{
	private BattleShipView view;
	private boolean isTurn;
	public BattleShipListener(BattleShipView view) {
		super();
		this.view = view;

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(view.isPlacingDone() == false) {
			for(int r = 0;r<10;r++) {
				for(int c = 0;c<10;c++) {
					if(e.getSource() == view.getPlayerGrid()[r][c]) {
						if((e.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {
							view.getPlayer().placeShips(new Ship(view.getPlayer().getLength(),true, r,c,view));
						}
						else {
							view.getPlayer().placeShips(new Ship(view.getPlayer().getLength(),false, r,c,view));
						}
						
					}
				}
			}
		}
		else if(view.isTurn()){
			for(int r = 0;r<10;r++) {
				for(int c = 0;c<10;c++) {
					if(e.getSource() == view.getCpuGrid()[r][c]) {
						if(view.getPlayer().getAttacked()[r][c] == false) {
							view.getPlayer().Attack(r, c);
							if(view.isGameOver(false)) {
								view.setGameOver(true);
							}
							view.setTurn(false);
						}
						
					}
				}
			}
		}
	}

}
