
public abstract class Game {
	protected Board board = new Board();
	public boolean isFinish;
	protected int presentNumber;
	
	abstract public void play();
	
	abstract public boolean isCorrect();
	
	abstract public void gameOver();
}
