package ru.sgstudio.sgs01;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgstudio.sgs01.main.Main;
import ru.sgstudio.sgs01.map.Front;
import ru.sgstudio.sgs01.map.Generate;
import ru.sgstudio.sgs01.map.MiniMapCam;
import ru.sgstudio.sgs01.player.Player;
import ru.sgstudio.sgs01.text.Text;
import ru.sgstudio.sgs01.utils.Variables;
import ru.sgstudio.sgs01.utils.conntroller.KeyManager;

/**
 * Главный экран(класс) игры
 * @author Yarik
 * @version 1.2
 */

public class MyGame implements Screen {
	private static float time = 0;
	private static long startTime;
	
	private SpriteBatch batch;
	
	private OrthographicCamera cam;
	
	@SuppressWarnings("unused")
	private Main main;
	private Generate gen;
	private Front front;
	private Player player;
	private KeyManager manager;
	private MiniMapCam mimimap;
	private Text text;
	
	public MyGame(Main main) { this.main = main; }

	@Override
	public void show() {
		startTime = System.currentTimeMillis();
		
		gen = new Generate();
		front = new Front();
		player = new Player();
		manager = new KeyManager();
		mimimap = new MiniMapCam();
		text = new Text();
		
		batch = new SpriteBatch();
		cam = new OrthographicCamera(Variables.getWorldWidth(), Variables.getWorldHeight());
		cam.translate(Variables.getWorldWidth()/2, Variables.getWorldHeight()/2);
		cam.update();
	}

	@Override
	public void render(float delta) {
		if(time!=(System.currentTimeMillis() - startTime) / 100){
			pressed();
			time++;
		}
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		batch.begin();		
		
		front.render(batch);
		player.drawFront(batch);
		
		textDraw();
		batch.end();
		
		mimimap.MinMapCamera(batch);
	}
	
	private void textDraw() {
		text.leftUp(batch, "FPS: "+Gdx.graphics.getFramesPerSecond(), "Z: "+player.getZPlayer(), "Y: "+player.getYPlayer(), "X: "+player.getXPlayer());
	}
	
	private void pressed(){
		if(manager.getPressedUp())
			if(gen.getMap().length-1>player.getZPlayer()) 
				player.setZPlayer(player.getZPlayer()+1);
		if(manager.getPressedDown())
			if(player.getZPlayer()>0)
				player.setZPlayer(player.getZPlayer()-1);
		
		if(manager.getPressedLeft()) 
			if(player.getXPlayer()>0)
				player.setXPlayer(player.getXPlayer()-1);
		if(manager.getPressedRight()) 
			if(gen.getMap()[0][0].length-1>player.getXPlayer())
				player.setXPlayer(player.getXPlayer()+1);
	}

	@Override
	public void resize(int width, int height) {
		Variables.updateResolution(width, height);
		cam.viewportWidth = Variables.getWorldWidth();
		cam.viewportHeight = Variables.getWorldHeight();
		cam.update();
//		System.out.println(cam.viewportHeight + "  " +cam.viewportWidth);
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
	}
}
