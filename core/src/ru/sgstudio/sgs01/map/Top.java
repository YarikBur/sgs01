package ru.sgstudio.sgs01.map;

import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.sgstudio.sgs01.player.Player;
import ru.sgstudio.sgs01.utils.Tiles;

public class Top {
    private Map<String, TextureRegion> atlasTiles;
    
    private int lines = 1, columns = 10, numZ = 0, numY = 0, numX = 0;
	
	private Generate gen;
	private Tiles tiles;
	private Player player;
	
	private static int map[][][];
	
	private static boolean create=false;
	
	public Top(){
		if(!create) {
			gen = new Generate();
			tiles = new Tiles();
			player = new Player();
			
			tiles.createAtlas("atlas\\test.png", lines, columns);
			atlasTiles = tiles.getTextureRegion();
			
			map = gen.getMap();
			
			create = !create;
		}
	}
	
    public void render(SpriteBatch batch){
    	while(true) {
    		for(int z = 0; z < map.length; z++) {
    			for(int y = 0; y < map[0].length; y ++) {
    				for(int x = 0; x < map[0][0].length; x++) {
    					if(map[z][y][x] == 0) {
    						numZ++;
    						numY++;
    						numX++;
    					} else {
    						
    					}
    				}
    			}
    		}   
    	}
    	/* 
    	 надо доделать			
    	*/
    	
	}
}
