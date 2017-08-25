package ru.sgstudio.sgs01.map;

import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.sgstudio.sgs01.player.Player;
import ru.sgstudio.sgs01.utils.RGBA;
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
		for(int z=map.length-1;z>=player.getZPlayer();z--) {
			for (int y = map[0].length - 1; y >= 0; y--) {
				for (int x = 0; x < map[0][0].length; x++) {
					int dispX = x * 16;
					int dispY = (map[0].length - y - 1) * 16;

					if(map[z][y][x]==0) {
						texture(batch, atlasTiles.get("tiles0_0"), dispX, dispY, z);
//						batch.draw(atlasTiles.get("tiles0_0"), dispX, dispY);
					}
					else if(map[z][y][x]==1) {
						texture(batch, atlasTiles.get("tiles0_1"), dispX, dispY, z);
//						batch.draw(atlasTiles.get("tiles0_1"), dispX, dispY);
					}
					else if(map[z][y][x]==2) {
						texture(batch, atlasTiles.get("tiles0_2"), dispX, dispY, z);
//						batch.draw(atlasTiles.get("tiles0_2"), dispX, dispY);
					}
					else if(map[z][y][x]==3) {
						texture(batch, atlasTiles.get("tiles0_3"), dispX, dispY, z);
//						batch.draw(atlasTiles.get("tiles0_3"), dispX, dispY);
					}
					else if(map[z][y][x]==4) {
						texture(batch, atlasTiles.get("tiles0_4"), dispX, dispY, z);
//						batch.draw(atlasTiles.get("tiles0_4"), dispX, dispY);
					}
					else if(map[z][y][x]==5) {
						texture(batch, atlasTiles.get("tiles0_5"), dispX, dispY, z);
//						batch.draw(atlasTiles.get("tiles0_5"), dispX, dispY);
					}
					else if(map[z][y][x]==6) {
						texture(batch, atlasTiles.get("tiles0_6"), dispX, dispY, z);
//						batch.draw(atlasTiles.get("tiles0_6"), dispX, dispY);
					}
					else if(map[z][y][x]==7) {
						texture(batch, atlasTiles.get("tiles0_7"), dispX, dispY, z);
//						batch.draw(atlasTiles.get("tiles0_7"), dispX, dispY);
					}
					else if(map[z][y][x]==8) {
						texture(batch, atlasTiles.get("tiles0_8"), dispX, dispY, z);
//						batch.draw(atlasTiles.get("tiles0_8"), dispX, dispY);
					}
					else {
						texture(batch, atlasTiles.get("tiles0_9"), dispX, dispY, z);
//						batch.draw(atlasTiles.get("tiles0_9"), dispX, dispY);
					}
					
//					System.out.format("%4d", map[z][y][x]);
				}
//				System.out.print('\n');
			}
//			System.out.print('\n');
		}
	}
	
	private void texture(SpriteBatch batch, TextureRegion textureRegion, int x, int y, int z) {
		Sprite fog = new Sprite(textureRegion);
		Sprite tex = new Sprite(textureRegion);
		fog.setColor(RGBA.rgba(200,200,200,alpha(z)));
		fog.setPosition(x, y);
		tex.setPosition(x, y);
		batch.enableBlending();
//		tex.draw(batch);
		fog.draw(batch);
	}
	
	private float alpha(float z) {
		float zPlayer = player.getZPlayer();
		float fZ = (z-zPlayer);
		return fZ;
	}
}
