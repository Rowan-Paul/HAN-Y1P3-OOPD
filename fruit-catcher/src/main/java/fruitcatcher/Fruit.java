package fruitcatcher;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Fruit extends SpriteObject implements ICollidableWithGameObjects {

	private FruitCatcher fruitCatcher;
	
	private int speed;

	public Fruit(FruitCatcher fruitCatcher) {
		// Use `.concat ()` to string 2 strings together.
		// The method returned a new String.
		super(new Sprite(FruitCatcher.MEDIA_URL.concat("apple.png")));
		this.fruitCatcher = fruitCatcher;
		this.speed = 1;
	}

	@Override
	public void update() {
		if (this.y > 0) {
			setDirectionSpeed(180, speed);
		}   
		if (this.y > fruitCatcher.getHeight()) {
			fruitCatcher.deleteGameObject(this);
		}
	}
	
	//@Override
	public void gameObjectCollisionOccurred(List<GameObject>collidedGameObjects) { 
		 for (GameObject go: collidedGameObjects) { 
			 if (go instanceof Player) { 
				 fruitCatcher.deleteGameObject(this);
			 } 
		 } 
	 }
}