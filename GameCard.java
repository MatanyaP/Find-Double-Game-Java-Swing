import java.util.Random;

import javax.swing.JButton;

public class GameCard extends JButton{
	private int num;
	private boolean wasClicked;
	
	
	public GameCard() {
		num = 1+(int)(Math.random()*20);
		wasClicked = false;
		setText("");
	}
	
	public int getCardNum(GameCard card) {
		return card.num;
	}
	
	public boolean getWasClicked() {
		return wasClicked;
	}
	
	public void click() {
		setText("" + num);
		wasClicked = true;
	}

	public int getNum() {
		return num;
	}

	public void restart() {
		wasClicked = false;
		setText("");
		num = 1+(int)(Math.random()*20);
	}
}