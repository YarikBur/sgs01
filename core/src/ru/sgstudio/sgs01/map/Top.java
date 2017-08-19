package ru.sgstudio.sgs01.map;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.sgstudio.sgs01.player.Player;
import ru.sgstudio.sgs01.utils.Tiles;

public class Top {
    private Map<String, TextureRegion> atlasTiles;
    
    private int lines = 1, columns = 10;
	
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
			player.setXPlayer(15);
			player.setYPlayer(5);
			
			tiles.createAtlas("atlas\\test.png", lines, columns);
			atlasTiles = tiles.getTextureRegion();
			
			map = gen.getMap();
			
			create = !create;
		}
	}
	
    public void render(SpriteBatch batch){
    	for(int z=0;z<map.length;z++){
    		//---------------------------------------
    		for(int x=0;x<map[0][0].length;x++){
    			//-----------------------------------
    			for(int y=0;y<map[0].length;y++){
    				//-------------------------------
    				if(map[z][y][x]!=0){
    					System.out.format("%4dz  %4dy  %4dx   %4dBlock", z, y, x, map[z][y][x]);
    					batch.draw(atlasTiles.get("tiles0_" + map[z][y][x]), x*16, z*16);
    					break;
    				} else {
    					System.out.format("%4dZ  %4dY  %4dX", z, y, x);
    				}
    				//------------------------------
    			}
    			System.out.print('\n');
    			//----------------------------------
    		}
    		System.out.print('\n');
    		//--------------------------------------
    	}
	}
}
