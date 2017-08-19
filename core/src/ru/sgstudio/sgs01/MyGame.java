package ru.sgstudio.sgs01;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgstudio.sgs01.main.Main;
import ru.sgstudio.sgs01.map.Front;
import ru.sgstudio.sgs01.map.Generate;
import ru.sgstudio.sgs01.utils.Variables;

public class MyGame implements Screen {
	
	private SpriteBatch batch;
	
	private OrthographicCamera cam;
	
	@SuppressWarnings("unused")
	private Main main;
	@SuppressWarnings("unused")
	private Generate gen;
	private Variables var;
	private Front front;
	
	public MyGame(Main main) { this.main = main; }

	@Override
	public void show() {
		gen = new Generate();
		var = new Variables();
		front = new Front();
		
		batch = new SpriteBatch();
		cam = new OrthographicCamera(var.getWorldWidth(), var.getWorldHeight());
		cam.translate(var.getWorldWidth()/2, var.getWorldHeight()/2);
		cam.update();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		front.render(batch);
		batch.end();
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
