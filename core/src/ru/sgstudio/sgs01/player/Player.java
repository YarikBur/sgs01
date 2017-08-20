package ru.sgstudio.sgs01.player;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.sgstudio.sgs01.utils.Tiles;

public class Player {
	private static int zPlayer=3, yPlayer=9, xPlayer=15;
	
	private static Tiles tiles;
	
	private static boolean created=false;
	
	private static Map<String, TextureRegion> atlasPlayer;
	
	public int getZPlayer(){ return zPlayer; }
	public int getYPlayer(){ return yPlayer; }
	public int getXPlayer(){ return xPlayer; }
	
	public void setZPlayer(int zPlayer){ Player.zPlayer = zPlayer; }
	public void setYPlayer(int yPlayer){ Player.yPlayer = yPlayer; }
	public void setXPlayer(int xPlayer){ Player.xPlayer = xPlayer; }
	
	public Player() {
		if(!created) {
			tiles = new Tiles();
			tiles.createAtlas("test.png", 1, 1);
			atlasPlayer = tiles.getTextureRegion();
			
			created=!created;
		}
	}
	
	public void drawFront(SpriteBatch batch) {
		batch.draw(atlasPlayer.get("tiles0_0"), xPlayer*16, yPlayer*16);
	}
	
	public void drawTop(SpriteBatch batch) {
		batch.draw(atlasPlayer.get("tiles0_0"), xPlayer*16, zPlayer*16);
	}
}
