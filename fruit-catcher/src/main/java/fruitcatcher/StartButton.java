package fruitcatcher;

public class StartButton extends Button {
	
	private FruitCatcher fruitCatcher;

	StartButton(FruitCatcher fruitCatcher, int x, int y, int width, int height) {
		super(x, y, width, height, "START");
		this.fruitCatcher = fruitCatcher;
	}

	@Override
	public void doAction() {
		fruitCatcher.startPlaying();
		fruitCatcher.deleteGameObject(this);
	}
}
