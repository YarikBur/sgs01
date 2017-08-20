package ru.sgstudio.sgs01.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import ru.sgstudio.sgs01.MyGame;

/**
 * √лавный класс, который ¬ключает кужный экран
 * @author Yarik
 * @version 1.0
 */

public class Main extends Game {
	public Screen game;
	private Screen load;

	@Override
	public void create() {
		game = new MyGame(this);
		load = new Load(this);
		
		this.setScreen(game);
	}
	
	public void setScr(Screen scr){ this.setScreen(scr); }
}
