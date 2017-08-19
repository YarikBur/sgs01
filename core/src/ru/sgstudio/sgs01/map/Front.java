package ru.sgstudio.sgs01.map;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.sgstudio.sgs01.utils.Tiles;

public class Front {
	
	private Map<String, TextureRegion> atlasTiles;
	
	private Generate gen;
	private Tiles tiles;
	
	private static int map[][][];
	private static int zPlayer;
	
	private static boolean create=false;
	
	public Front(){
		if(!create){
			gen = new Generate();
			tiles = new Tiles();
			tiles.createAtlas("atlas\\test.png", 1, 10);
			atlasTiles = tiles.getTextureRegion();
			
			map = gen.getMap();
			
			zPlayer = map.length/2;
			
			create=!create;
		}
	}
	
	public void render(SpriteBatch batch){
		System.out.print('\n');
<<<<<<< Updated upstream
		for (int y = map[0].length - 1; y >= 0; y--) {
			for (int x = 0; x < map[0][0].length; x++) {
				int dispX = x * 16;
				int dispY = (map[0].length - y - 1) * 16;

				batch.draw(atlasTiles.get("tiles0_" + map[zPlayer][y][x]), dispX, dispY);
				// System.out.format("%2d", map[zPlayer][y][x]);
				// batch.draw(atlasTiles.get("tiles0_" + map[zPlayer][y][x]), 5 * 16, 0 * 16);
=======
		for(int y=map[0].length-1;y>=0;y--){
			for(int x=0;x<map[0][0].length;x++){
				batch.draw(atlasTiles.get("tiles0_"+map[zPlayer][y][x]), x*16, y*16);
				System.out.format("%2d", map[zPlayer][y][x]);
				batch.draw(atlasTiles.get("tiles0_"+map[zPlayer][y][x]), 5*16, 0*16);
>>>>>>> Stashed changes
			}
			System.out.print('\n');
		}
	}
}
