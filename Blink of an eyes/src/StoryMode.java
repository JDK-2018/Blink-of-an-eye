import java.util.Timer;

public class StoryMode extends Game {
	Timer timer = new Timer();
	int stage;
	
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
	
	public void setStage() {
		
	}
	
	public Timer getTime() {
		return timer;
	}
	
	public int getStage() {
		return stage;
	}
}
