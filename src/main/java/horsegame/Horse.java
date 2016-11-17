package horsegame;

import java.util.Observable;

import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

public class Horse extends Subject {
	private RunningStrategy runningStrategy;
	private String name;
	private JLabel horseLabel;
	private Running running;
	private ChooseStrategy chooseStrategy;
	
	private int Energy = 100;
	public int getEnergy() {
		return Energy;
	}

	public void setEnergy(int energy) {
		Energy = energy;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public Horse(JLabel horseLabel) {
		this.horseLabel = horseLabel;
		setRunningStrategy(new BasicRunning(this));
	}

	public RunningStrategy getRunningStrategy() {
		return runningStrategy;
	}

	public void setRunningStrategy(RunningStrategy runningStrategy) {
		this.runningStrategy = runningStrategy;
		notifyObservers();
	}

	public JLabel getHorseLabel() {
		return horseLabel;
	}

	public int getX() {
		return horseLabel.getX();
	}

	public int getY() {
		return horseLabel.getY();
	}

	public void setLocation(int x, int y) {
		horseLabel.setLocation(x, y);
	}

	public void stop() {
		running.interrupt();
		chooseStrategy.interrupt();
	}

	public void run() {
		running = new Running(this);
		chooseStrategy = new ChooseStrategy(this);
		chooseStrategy.start();
		running.start();

	}

}
