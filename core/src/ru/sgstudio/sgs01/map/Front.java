package ru.sgstudio.sgs01.map;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.sgstudio.sgs01.player.Player;
import ru.sgstudio.sgs01.utils.Tiles;

 /**
 * Класс позволяет рисовать 3-ех мерную матрицу сбоку
 * @author Yarik
 * @version 1.1
 */

public class Front {
	
	private Map<String, TextureRegion> atlasTiles;
	
	private Generate gen;
	private Tiles tiles;
	private Player player;
	
	private static int map[][][];
	
	private static boolean create=false;
	
	public Front(){
		if(!create){
			gen = new Generate();
			tiles = new Tiles();
			player = new Player();
			
			tiles.createAtlas("atlas\\test.png", 1, 10);
			atlasTiles = tiles.getTextureRegion();
			
			map = gen.getMap();
			
			create=!create;
		}
	}
	
	/**
	 * Риует 3-ех мерный массив сбоку
	 * @param batch - Для рисовки текстур
	 */
	
	public void render(SpriteBatch batch){
//		System.out.print('\n');
		for (int y = map[0].length - 1; y >= 0; y--) {
			for (int x = 0; x < map[0][0].length; x++) {
				int dispX = x * 16;
				int dispY = (map[0].length - y - 1) * 16;

				if(map[player.getZPlayer()][y][x]==0) batch.draw(atlasTiles.get("tiles0_0"), dispX, dispY);
				if(map[player.getZPlayer()][y][x]==1) batch.draw(atlasTiles.get("tiles0_1"), dispX, dispY);
				if(map[player.getZPlayer()][y][x]==2) batch.draw(atlasTiles.get("tiles0_2"), dispX, dispY);
				if(map[player.getZPlayer()][y][x]==3) batch.draw(atlasTiles.get("tiles0_3"), dispX, dispY);
				if(map[player.getZPlayer()][y][x]==4) batch.draw(atlasTiles.get("tiles0_4"), dispX, dispY);
				if(map[player.getZPlayer()][y][x]==5) batch.draw(atlasTiles.get("tiles0_5"), dispX, dispY);
				if(map[player.getZPlayer()][y][x]==6) batch.draw(atlasTiles.get("tiles0_6"), dispX, dispY);
				if(map[player.getZPlayer()][y][x]==7) batch.draw(atlasTiles.get("tiles0_7"), dispX, dispY);
				if(map[player.getZPlayer()][y][x]==8) batch.draw(atlasTiles.get("tiles0_8"), dispX, dispY);
				if(map[player.getZPlayer()][y][x]==9) batch.draw(atlasTiles.get("tiles0_9"), dispX, dispY);
				
//				System.out.format("%4d", map[player.getZPlayer()][y][x]);
			}
//			System.out.print('\n');
		}
	}
}
