package fruitcatcher;

import java.util.List;

import nl.han.ica.oopg.objects.GameObject;

public class Bomb extends FallingObject {

	public Bomb(FruitCatcher fruitCatcher) {
		super(fruitCatcher, "bomb.png");
	}
	
	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Player) {
				fruitCatcher.deleteGameObject(this);
			}
		}
	}

}
