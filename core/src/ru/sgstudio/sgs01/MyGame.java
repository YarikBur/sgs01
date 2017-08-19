package ru.sgstudio.sgs01;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgstudio.sgs01.main.Main;
import ru.sgstudio.sgs01.map.Front;
import ru.sgstudio.sgs01.map.Generate;
import ru.sgstudio.sgs01.map.Top;
import ru.sgstudio.sgs01.player.Player;
import ru.sgstudio.sgs01.utils.Variables;
import ru.sgstudio.sgs01.utils.conntroller.KeyManager;

public class MyGame implements Screen {
	private static float time = 0;
	private static long startTime;
	
	private SpriteBatch batch;
	
	private OrthographicCamera cam;
	
	@SuppressWarnings("unused")
	private Main main;
	private Generate gen;
	private Variables var;
	private Front front;
	private Top top;
	private Player player;
	private KeyManager manager;
	
	public MyGame(Main main) { this.main = main; }

	@Override
	public void show() {
		startTime = System.currentTimeMillis();
		
		gen = new Generate();
		var = new Variables();
		front = new Front();
		top = new Top();
		player = new Player();
		manager = new KeyManager();
		
		batch = new SpriteBatch();
		cam = new OrthographicCamera(var.getWorldWidth(), var.getWorldHeight());
		cam.translate(var.getWorldWidth()/2, var.getWorldHeight()/2);
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
		
//		front.render(batch);
		top.render(batch);
		batch.end();
	}
	
	private void pressed(){
		if(manager.getPressedUp())
			if(gen.getMap().length-1>player.getZPlayer()) 
				player.setZPlayer(player.getZPlayer()+1);
		if(manager.getPressedDown())
			if(player.getZPlayer()>0)
				player.setZPlayer(player.getZPlayer()-1);
		
		if(manager.getPressedLeft()) player.setYPlayer(player.getYPlayer()-1);
		if(manager.getPressedRight()) player.setYPlayer(player.getYPlayer()+1);
	}

	@Override
	public void resize(int width, int height) {
		var.updateResolution(width, height);
		cam.viewportWidth = var.getWorldWidth();
		cam.viewportHeight = var.getWorldHeight();
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
