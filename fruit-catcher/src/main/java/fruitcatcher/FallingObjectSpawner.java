package fruitcatcher;

import java.util.Random;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

public class FallingObjectSpawner implements IAlarmListener {

	private FruitCatcher fruitCatcher;
	private Random random;
	private int objectsPerSecond;

	public FallingObjectSpawner(FruitCatcher fruitCatcher, int objectsPerSecond) {
		// Use `.concat ()` to string 2 strings together.
		// The method returned a new String.
		this.fruitCatcher = fruitCatcher;
		this.random = new Random();
		this.objectsPerSecond = objectsPerSecond;
		startAlarm();
	}

	private String generateFruitObject() {
		int randomNumber;
		randomNumber = random.nextInt(4);

		if (randomNumber == 0) {
			return "apple.png";
		} else if (randomNumber == 1) {
			return "banana.png";
		} else if (randomNumber == 2) {
			return "orange.png";
		} else if (randomNumber == 3) {
			return "watermelon.png";
		}
		return null;
	}

	private void generateFallingObject() {
		int randomNumber;
		randomNumber = random.nextInt(10);

		if (randomNumber == 0 || randomNumber == 1 || randomNumber == 3 || randomNumber == 5 
				|| randomNumber == 6 || randomNumber == 8) {
			Fruit fruit = new Fruit(fruitCatcher, generateFruitObject());
			fruitCatcher.addGameObject(fruit, random.nextInt(fruitCatcher.width - fruit.getSize()), 50);
		} else if (randomNumber == 4) {
			Horse horse = new Horse(fruitCatcher);
			fruitCatcher.addGameObject(horse, random.nextInt(fruitCatcher.width - horse.getSize()), 50);
		} else if (randomNumber == 7) {
			Train train = new Train(fruitCatcher);
			fruitCatcher.addGameObject(train, random.nextInt(fruitCatcher.width - train.getSize()), 50);
		} else if (randomNumber == 9) {
			Bomb bomb = new Bomb(fruitCatcher);
			fruitCatcher.addGameObject(bomb, random.nextInt(fruitCatcher.width - bomb.getSize()), 50);
		}

	}

	private void startAlarm() {
		Alarm alarm = new Alarm("New Object", 1 / objectsPerSecond);
		alarm.addTarget(this);
		alarm.start();
	}

	@Override
	public void triggerAlarm(String alarmName) {
		generateFallingObject();
		startAlarm();
	}

	public void setObjectsPerSecond(int objectsPerSecond) {
		this.objectsPerSecond = objectsPerSecond;
	}

}
