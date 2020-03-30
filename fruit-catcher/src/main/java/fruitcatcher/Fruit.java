package fruitcatcher;

import java.util.List;

import nl.han.ica.oopg.objects.GameObject;

public class Fruit extends FallingObject {
	
	public Fruit(FruitCatcher fruitCatcher, String fruitObject) {
		super(fruitCatcher, fruitObject);
	}
	
	@Override
	public void doAction() {
		int points = fruitCatcher.getPoints();
		points++;
		fruitCatcher.setPoints(points);
	}

	// @Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Player) {
				doAction();
				fruitCatcher.deleteGameObject(this);
			}
		}
	}

}