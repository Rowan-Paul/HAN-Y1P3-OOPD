package fruitcatcher;

import java.util.List;

import nl.han.ica.oopg.objects.GameObject;

public class Fruit extends FallingObject {

	public Fruit(FruitCatcher fruitCatcher) {
		// Use `.concat ()` to string 2 strings together.
		// The method returned a new String.
		super(fruitCatcher);
	}

	// @Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Player) {
				fruitCatcher.deleteGameObject(this);
			}
		}
	}
}