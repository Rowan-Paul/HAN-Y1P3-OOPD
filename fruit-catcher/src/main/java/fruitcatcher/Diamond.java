package fruitcatcher;

import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Diamond extends SpriteObject implements ICollidableWithTiles, ICollidableWithGameObjects {
	
	private FruitCatcher fruitCatcher;
	
	private int size = 96;

	public Diamond(FruitCatcher fruitCatcher) {
		super(new Sprite(FruitCatcher.MEDIA_URL.concat("diamond.png")));
		this.fruitCatcher = fruitCatcher;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		// TODO Auto-generated method stub
		
	}
	
}
