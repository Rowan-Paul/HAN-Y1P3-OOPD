package fruitcatcher;

import java.util.List;

import fruitcatcher.tiles.FloorTile;
import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PVector;

public class Diamond extends SpriteObject implements ICollidableWithTiles, ICollidableWithGameObjects, IAlarmListener {

	private FruitCatcher fruitCatcher;

	private final int HEIGHT = 66;
	private final int WIDTH = 66;

	public Diamond(FruitCatcher fruitCatcher) {
		super(new Sprite(FruitCatcher.MEDIA_URL.concat("diamond.png")));
		this.fruitCatcher = fruitCatcher;
		setGravity(0.2f);
		setHeight(HEIGHT);
		setWidth(WIDTH);
		startAlarm();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	private void doAction() {
		int points = fruitCatcher.getPoints();
		points += 20;
		fruitCatcher.setPoints(points);
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

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		PVector vector;
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof FloorTile) {
				if (ct.getCollisionSide() == CollisionSide.TOP) {
					vector = fruitCatcher.getTileMap().getTilePixelLocation(ct.getTile());
					setY(vector.y - getHeight());
				}
			}
		}
	}

	private void startAlarm() {
		Alarm alarm = new Alarm("Diamond", 3);
		alarm.addTarget(this);
		alarm.start();
	}

	@Override
	public void triggerAlarm(String alarmName) {
		fruitCatcher.deleteGameObject(this);
	}
}
