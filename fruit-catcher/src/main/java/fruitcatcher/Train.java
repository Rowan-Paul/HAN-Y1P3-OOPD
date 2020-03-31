package fruitcatcher;

import java.util.List;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.objects.GameObject;

public class Train extends FallingObject implements IAlarmListener {

	public Train(FruitCatcher fruitCatcher) {
		super(fruitCatcher, "train.png");
	}
	
	@Override
	public void doAction() {
		setSpeed(3);
		startAlarm();
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Player) {
				doAction();
				fruitCatcher.deleteGameObject(this);
			}
		}
	}
	
	private void startAlarm() {
		Alarm alarm = new Alarm("Train", 3);
		alarm.addTarget(this);
		alarm.start();
	}

	@Override
	public void triggerAlarm(String alarmName) {
		setSpeed(1);
	}

}