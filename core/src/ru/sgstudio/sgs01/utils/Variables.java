package ru.sgstudio.sgs01.utils;

import com.badlogic.gdx.Gdx;

/**
 * Глобальные переменные, используемые в разных классах
 * <p>Методы: <b>updateResolution</b></p>
 * @author Yarik
 * @version 1.0
 * 
 */

public class Variables {
	private static float WORLD_WIDTH = Gdx.graphics.getWidth();
	private static float WORLD_HEIGHT = Gdx.graphics.getHeight();
	
	public static void updateResolution(int width, int height){
		WORLD_WIDTH = width;
		WORLD_HEIGHT = height;
	}
	
	public static float getWorldWidth(){ return WORLD_WIDTH; }
	public static float getWorldHeight(){ return WORLD_HEIGHT; }
}
