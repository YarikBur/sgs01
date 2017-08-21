package ru.sgstudio.sgs01.text;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgstudio.sgs01.utils.Variables;

/**
 * Класс предназначенный для рисовки текста
 * <p>Методы: <b>leftUp</b>, <b>leftDown</b></p>
 * @author Yarik
 * @version 1.0
 */

public class Text {
	private static BitmapFont font;
	
	private static boolean created=false;
	
	public Text() {
		if(!created) {
			font = new BitmapFont();
			
			created=!created;
		}
	}
	
	/**
	 * Метод рисующий текст слева вверху
	 * @param batch - Для рисовки текста
	 * @param args - Строки, которые нужно написать
	 */
	
	public void leftUp(SpriteBatch batch, String... args) {
		int i=15;
		for(String s : args) {
			font.draw(batch, s, 15, Variables.getWorldHeight()-i);
			i+=15;
		}
	}
	
	/**
	 * Метод рисующий текст слева внизу
	 * @param batch - Для рисовки текста
	 * @param args - Строки, которые нужно написать
	 */
	
	public void leftDown(SpriteBatch batch, String... args) {
		int i=15;
		for(String s : args) {
			font.draw(batch, s, 15, i);
			i+=15;
		}
	}
}
