package fruitcatcher;

/**
 * @author Sjaak Kok
 * @author Rowan Paul Flynn
 */
public class StartButton extends Button {
	
	private FruitCatcher fruitCatcher;

	/**
	 * Creates start button
	 * @param fruitCatcher
	 * @param x The x coordinate of the button
	 * @param y The y coordinate of the button
	 * @param width The width of the button
	 * @param height The height of the button
	 */
	StartButton(FruitCatcher fruitCatcher, int x, int y, int width, int height) {
		super(x, y, width, height, "START");
		this.fruitCatcher = fruitCatcher;
	}

	/**
	 * Does action
	 * in this case: start the game and remove objects
	 */
	@Override
	public void doAction() {
		fruitCatcher.startPlaying();
		fruitCatcher.deleteGameObject(this);
	}
}
