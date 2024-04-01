import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BattleShipView extends JFrame{
	private JFrame frame = new JFrame();
	private JPanel cpuPanel = new JPanel();
	private JPanel playerPanel = new JPanel();
	//JPanel gamePanel = new JPanel();
	private JButton[][] playerGrid;
	private JButton[][] cpuGrid;
	private Player player = new Player(this);
	private Computer cpu = new Computer(this);
	private boolean placingDone;
	private boolean isTurn;
	private boolean gameOver;
	private JPanel spacer;
	BattleShipView(int dimension) {
		playerGrid = new JButton[dimension][dimension];
		playerPanel.setLayout(new GridLayout(dimension,dimension));
		playerPanel.setVisible(true); 
		
		makeGrid(playerGrid,playerPanel, player);
		
		cpuGrid = new JButton[dimension][dimension];
		cpuPanel.setLayout(new GridLayout(dimension,dimension)); 
		cpuPanel.setVisible(true); 
		
		makeGrid(cpuGrid,cpuPanel,cpu);
		
		frame.setPreferredSize( new Dimension(1400,600) );
		frame.setLayout(new GridLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.pack(); 
		frame.add(playerPanel);
		spacer = new JPanel();
		spacer.setPreferredSize( new Dimension(100,100));
		frame.add(spacer);
		frame.add(cpuPanel);
		frame.setVisible(true); 
		placingDone = false;
		isTurn = true;
		gameOver = false;
		//ChangeCPUColor(Color.GREEN,1,1);
	}
	
	public void makeGrid(JButton[][] grid, JPanel panel, Player player) {
		for(int r = 0;r<10;r++) {
			for(int c = 0;c<10;c++) {
				JButton button = new JButton();
				grid[r][c] = button;
		        //button.setBackground(Color.BLUE));
				button.setOpaque(true);
		        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		        button.addActionListener(new BattleShipListener(this));
		        //button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		        button.setPreferredSize(new java.awt.Dimension(34, 34));
		        panel.add(button);
			}
		}
		
	}
	public boolean isGameOver(boolean turn) {
		if(turn) {
			for(int r =0;r<11;r++) {
				for(int c =0;c<11;c++) {
					if(player.getHasShip()[r][c] && !cpu.getAttacked()[r][c]) {
						return false;
					}
				}
			}
		}
		else {
			for(int r =0;r<11;r++) {
				for(int c =0;c<11;c++) {
					if(cpu.getHasShip()[r][c] && !player.getAttacked()[r][c]) {
						return false;
					}
				}
			}
		}
		
		return true; 
	}
	public void gameOver() {
		System.out.println("The game is over");
		JLabel label = new JLabel("The game is over");
		spacer.add(label);
		label.setOpaque(true);
		frame.repaint();
	}
	public void ChangePlayerColor(Color color,int x, int y) {
		playerGrid[x][y].setBackground(color);
		playerPanel.repaint();
	}
	
	public void ChangeCPUColor(Color color,int x, int y) {
		cpuGrid[x][y].setBackground(color);
		cpuPanel.repaint();
	}
	public JButton[][] getPlayerGrid() {
		return playerGrid;
	}

	public JButton[][] getCpuGrid() {
		return cpuGrid;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JPanel getCpuPanel() {
		return cpuPanel;
	}
	public void setCpuPanel(JPanel cpuPanel) {
		this.cpuPanel = cpuPanel;
	}
	public JPanel getPlayerPanel() {
		return playerPanel;
	}
	public void setPlayerPanel(JPanel playerPanel) {
		this.playerPanel = playerPanel;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Computer getCpu() {
		return cpu;
	}
	public void setCpu(Computer cpu) {
		this.cpu = cpu;
	}
	public boolean isPlacingDone() {
		return placingDone;
	}
	public void setPlacingDone(boolean placingDone) {
		this.placingDone = placingDone;
	}
	public void setPlayerGrid(JButton[][] playerGrid) {
		this.playerGrid = playerGrid;
	}
	public void setCpuGrid(JButton[][] cpuGrid) {
		this.cpuGrid = cpuGrid;
	}
	public boolean isTurn() {
		return isTurn;
	}
	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}
	public boolean isGameOver() {
		return gameOver;
	}
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	
	
}
