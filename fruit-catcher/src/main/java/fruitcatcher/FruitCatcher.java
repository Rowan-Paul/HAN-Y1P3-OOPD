package fruitcatcher;

import fruitcatcher.tiles.FloorTile;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;
import nl.han.ica.oopg.tile.TileMap;
import nl.han.ica.oopg.tile.TileType;
import nl.han.ica.oopg.view.View;
import fruitcatcher.Player;

public class FruitCatcher extends GameEngine {
    
	private Player player;
	private Fruit fruit;
	private FallingObjectSpawner fallingObjectSpawner;
	private DiamondSpawner diamondSpawner;
	private int points;
	private int droppedFruits;
	private Diamond diamond;
	private TextObject dashboardText;
	private StartButton startButton;
	
    public static String MEDIA_URL = "src/main/java/fruitcatcher/media/";
    
    public static void main(String[] args) {
        FruitCatcher fruitCatcher = new FruitCatcher();
        fruitCatcher.runSketch();
    }

    @Override
    public void setupGame() {
        int worldWidth = 800;
        int worldHeight = 600;
        
        // of course it is best to add new game objects
        // in a separate method instead of making the update so large.
        player = new Player(this);
        addGameObject(getPlayer(), 200, 500);
        
        fruit = new Fruit(this, "apple.png");
        addGameObject(fruit, 500, 100);
        
        fallingObjectSpawner = new FallingObjectSpawner(this);
        diamondSpawner = new DiamondSpawner(this);
        
        diamond = new Diamond(this);
        addGameObject(diamond, 500, 500);
        
        startButton = new StartButton(50, 50, 100, 100);
        addGameObject(startButton);
        
        View view = new View(worldWidth, worldHeight);

        setView(view);
        size(worldWidth, worldHeight);
        view.setBackground(loadImage(FruitCatcher.MEDIA_URL.concat("background.png")));
        initializeTileMap();
        createDashboard(worldWidth, 26);
        //initializeSound();
    }

    @Override
    public void update() {
    
    }
    
    private void initializeTileMap() {
        // Load Sprites
        Sprite floorSprite = new Sprite(FruitCatcher.MEDIA_URL.concat("grass.png"));
        // Create tile types with the right Tile class and sprite
        TileType<FloorTile> floorTileType = new TileType<>(FloorTile.class, floorSprite);
        @SuppressWarnings("rawtypes")
        TileType[] tileTypes = {floorTileType};
        int tileSize = 64;
        int tilesMap[][] = {
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},          
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
        };
        tileMap = new TileMap(tileSize, tileTypes, tilesMap);
    }
    
    private void createDashboard(int dashboardWidth, int dashboardHeight) {
        Dashboard dashboard = new Dashboard(0, 0, dashboardWidth, dashboardHeight);
        dashboardText = new TextObject("Points: 0          " + "Highscore: 0          " + "Fruits dropped: 0          ");
        dashboard.addGameObject(dashboardText);
        addDashboard(dashboard);
    }

	public Player getPlayer() {
		return player;
	}
	

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getDroppedFruits() {
		return droppedFruits;
	}

	public void setDroppedFruits(int droppedFruits) {
		this.droppedFruits = droppedFruits;
	}

    
	/*
	 * private void initializeSound() { backgroundMusic = new Sound(this,
	 * MEDIA_URL.concat("jump_08.mp3")); backgroundMusic.loop(-1); }
	 */
    

}