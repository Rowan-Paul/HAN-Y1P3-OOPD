package fruitcatcher;

import java.util.Random;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

public class DiamondSpawner implements IAlarmListener {

	private FruitCatcher fruitCatcher;
	private Random random;
	private double newDiamondWait;
	private boolean stopAlarm = false;

	public DiamondSpawner(FruitCatcher fruitCatcher) {
		this.fruitCatcher = fruitCatcher;
		this.random = new Random();
		this.newDiamondWait = 10;
		startAlarm();
	}

	public void startAlarm() {
		if (!stopAlarm) {
			Alarm alarm = new Alarm("New Diamond", newDiamondWait);
			alarm.addTarget(this);
			alarm.start();
		}
	}

	@Override
	public void triggerAlarm(String alarmName) {
		Diamond diamond = new Diamond(fruitCatcher);
		fruitCatcher.addGameObject(diamond, random.nextInt(fruitCatcher.width - (int) diamond.getWidth()), 500);
		startAlarm();
	}

	public void setStopAlarm(boolean stopAlarm) {
		this.stopAlarm = stopAlarm;
	}

}
