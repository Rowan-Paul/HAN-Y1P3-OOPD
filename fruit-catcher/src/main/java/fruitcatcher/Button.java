package fruitcatcher;

import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.userinput.IMouseInput;
import processing.core.PGraphics;

public abstract class Button extends GameObject implements IMouseInput {
	
	private String text;
	
	Button(int x, int y, int width, int height, String text) {
		super(x, y, width, height);
		this.text = text;
	}

	@Override
	public void update() {
		
	}
	
	public void mouseClicked(int x, int y, int button) {
		if (this.x < x && this.y < y && this.x + this.getWidth() > x && this.y + this.getHeight() > y)
		doAction();
	}
	
	public abstract void doAction();

	@Override
	public void draw(PGraphics g) {
		g.fill(9, 130, 55);
		g.rect(this.x, this.y, this.width, this.height);
		g.fill(0);
		g.textSize(20);
		g.textAlign(CENTER, CENTER);
		g.text(text, this.x + this.width / 2, this.y + this.height / 2);
	}

}
