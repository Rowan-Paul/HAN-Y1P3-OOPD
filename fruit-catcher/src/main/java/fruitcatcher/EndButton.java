package fruitcatcher;

public class EndButton extends Button {
	
	private FruitCatcher fruitCatcher;

	EndButton(FruitCatcher fruitCatcher, int x, int y, int width, int height) {
		super(x, y, width, height, "END");
		this.fruitCatcher = fruitCatcher;
	}

	@Override
	public void doAction() {
		System.out.println("y");
		
	}
}