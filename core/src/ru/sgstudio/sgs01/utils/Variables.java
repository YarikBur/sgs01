package ru.sgstudio.sgs01.utils;

import com.badlogic.gdx.Gdx;

public class Variables {
	private static float division = 1.2f;
	private static float WORLD_WIDTH = Gdx.graphics.getWidth()/division;
	private static float WORLD_HEIGHT = Gdx.graphics.getHeight()/division;
	
	public void updateResolution(int width, int height){
		WORLD_WIDTH = width/division;
		WORLD_HEIGHT = height/division;
	}
	
	public float getWorldWidth(){ return WORLD_WIDTH; }
	public float getWorldHeight(){ return WORLD_HEIGHT; }
}