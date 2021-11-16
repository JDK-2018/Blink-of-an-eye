import java.util.Timer;

public class TimeAttackMode extends Game{

	private Timer timer = new Timer();
	private int difficulty ;
	private int stage;
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCorrect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public void setTime() {
		
	}
	
	public Timer getTime() {
		return timer;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public int getStage() {
		return stage;
	}

}
