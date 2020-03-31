package fruitcatcher;

import java.util.List;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.objects.GameObject;

/**
 * @author Sjaak Kok
 * @author Rowan Paul Flynn
 */
public class Train extends FallingObject implements IAlarmListener {

	/**
	 * Adds train image to object
	 * @param fruitCatcher
	 */
	public Train(FruitCatcher fruitCatcher) {
		super(fruitCatcher, "train.png");
	}
	
	/**
	 * Does action
	 * in this case: increase speed 
	 * and set alarm
	 */
	@Override
	public void doAction() {
		setSpeed(3);
		startAlarm();
	}

	/**
	 * Checks if objects collides with player
	 * and do action
	 */
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Player) {
				doAction();
				fruitCatcher.deleteGameObject(this);
			}
		}
	}
	
	/**
	 * Starts alarm
	 */
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