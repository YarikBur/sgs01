package ru.sgstudio.sgs01.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player {
	private static int zPlayer, yPlayer, xPlayer;
	private static Sprite spritePlayer;
	
	public int getZPlayer(){ return zPlayer; }
	public int getYPlayer(){ return yPlayer; }
	public int getXPlayer(){ return xPlayer; }
	
	public void setZPlayer(int zPlayer){ Player.zPlayer = zPlayer; }
	public void setYPlayer(int yPlayer){ Player.yPlayer = yPlayer; }
	public void setXPlayer(int xPlayer){ Player.xPlayer = xPlayer; }
	
	public void setPlayer(Sprite sprite) {
		Player.spritePlayer = sprite;
	}
	public void draw(Batch spriteBatch) {
		update(Gdx.graphics.getDeltaTime());
		spritePlayer.draw(spriteBatch);
	}
	public void update(float deltaTime) {
		
	}
}
