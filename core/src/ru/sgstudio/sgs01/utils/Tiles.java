package ru.sgstudio.sgs01.utils;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * ������������ ��� ���������� ��������
 * @author Yarik
 * @version 1.0
 *
 */

public class Tiles {
	
	
	private static Texture texture = null;
	private static int Lines = 0;
	private static int Columns = 0;
	
	private static Map<String, TextureRegion> textureRegions = null;
	
	/**
	 * ��������� ������� �����(textureRegions)
	 * @param tiles - ���� �� ��������
	 * @param lines - ���-�� �����
	 * @param columns - ���-�� ��������
	 */
	
	public void createAtlas(String tiles, int lines, int columns){
		texture = new Texture(tiles);
		textureRegions = null;
		textureRegions = new HashMap<String, TextureRegion>();
		Lines = lines;
		Columns = columns;
		createAtlas();
	}
	
	private void createAtlas(){
		TextureRegion tmp[][] = TextureRegion.split(texture, texture.getWidth()/Columns, texture.getHeight()/Lines);
		for(int y=0;y<Lines;y++) for(int x=0;x<Columns;x++) textureRegions.put("tiles"+y+"_"+x, tmp[y][x]);
		Lines=0; Columns=0; texture=null;
	}
	
	/**
	 * ���������� ����������� �����
	 * @return textureRegions
	 */
	
	public Map<String, TextureRegion> getTextureRegion(){ return textureRegions; }
}
