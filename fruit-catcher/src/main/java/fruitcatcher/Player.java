package fruitcatcher;

import java.util.List;

import fruitcatcher.tiles.FloorTile;
import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PVector;

public class Player extends SpriteObject implements ICollidableWithTiles {

	private FruitCatcher fruitCatcher;

	private float gravity;
	final int size = 96;

	public Player(FruitCatcher fruitCatcher) {
		// Use `.concat ()` to string 2 strings together.
		// The method returned a new String.
		super(new Sprite(FruitCatcher.MEDIA_URL.concat("playerStanding.png")));
		this.fruitCatcher = fruitCatcher;
		gravity = 0.2f;
		setGravity(gravity);
	}

	@Override
	public void update() {
		if (getX() <= 0) {
			setxSpeed(0);
			setX(0);
		}

		if (getX() >= fruitCatcher.width - size) {
			setxSpeed(0);
			setX(fruitCatcher.width - size);
		}

	}

	@Override
	public void keyPressed(int keyCode, char key) {
		final int speed = 5;
		if (keyCode == fruitCatcher.LEFT) {
			setDirectionSpeed(270, speed);
		}
		if (keyCode == fruitCatcher.RIGHT) {
			setDirectionSpeed(90, speed);
		}

	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {

		PVector vector;
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof FloorTile) {
				if (ct.getCollisionSide() == CollisionSide.TOP) {
					try {
						vector = fruitCatcher.getTileMap().getTilePixelLocation(ct.getTile());
						setY(vector.y - getHeight());
					} catch (TileNotFoundException e) {
						e.printStackTrace();
					}
				}

			}
		}

	}

}