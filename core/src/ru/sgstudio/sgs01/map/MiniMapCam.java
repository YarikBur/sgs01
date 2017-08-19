package ru.sgstudio.sgs01.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgstudio.sgs01.player.Player;

public class MiniMapCam  {
	private  OrthographicCamera camera;
	private SpriteBatch batch;
	private Top top;
	private Player player;
	public MiniMapCam() {
		top = new Top();
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		player = new Player();
		
	}
    public void MinMapCamera() {
    	batch.setProjectionMatrix(camera.combined);
    	camera.update();
    	batch.begin();
    	top.render(batch);
    	camera.position.set(player.getZPlayer(),player.getYPlayer(),0);
    	batch.end();
    	
    }
}
