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
	@SuppressWarnings("unused")
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
	
    @SuppressWarnings("unused")
	public void render(SpriteBatch batch){
    	int i=0, ii=0;
    	
//    	if(player.getZPlayer()-5<0) i=0;
//    	else i=player.getZPlayer()-5;
//    	if(player.getZPlayer()+5>map.length) ii=map.length;
//    	else ii=player.getZPlayer()+5;
//    	System.out.println(ii);
    	
    	for(int z=i;z<map.length;z++){
    		
//    		if(player.getXPlayer()-10<0) i=0;
//        	else i=player.getXPlayer()-10;
//    		if(player.getXPlayer()+10>map[0][0].length) ii=map[0][0].length;
//        	else ii=player.getXPlayer()+10;
    		
    		for(int x=i;x<map[0][0].length;x++){
    			for(int y=0;y<map[0].length;y++){
    				if(map[z][y][x]!=0){
//    					System.out.format("%4dz  %4dy  %4dx   %4dBlock", z, y, x, map[z][y][x]);
    					batch.draw(atlasTiles.get("tiles0_" + map[z][y][x]), x*16, z*16);
    					break;
    				} else {
//    					System.out.format("%4dZ  %4dY  %4dX", z, y, x);

    				}
    			}
//    			System.out.print('\n');
    		}
//    		System.out.print('\n');
    	}
	}
}
