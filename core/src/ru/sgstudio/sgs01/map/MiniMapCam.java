package ru.sgstudio.sgs01.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgstudio.sgs01.player.Player;
import ru.sgstudio.sgs01.utils.conntroller.KeyManager;

public class MiniMapCam  {
	private  OrthographicCamera camera;
//	private SpriteBatch batch;
	private Top top;
	private Player player;
	private KeyManager key;
	
	public MiniMapCam() {
		top = new Top();
//		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		player = new Player();
		key = new KeyManager();
		
	}
    public void MinMapCamera(SpriteBatch batch) {
    	batch.setProjectionMatrix(camera.combined);
    	batch.begin();
    	camera.position.set(player.getZPlayer(),player.getYPlayer(),0);
    	top.render(batch);
    	if(key.getPressedX()) {
    		camera.zoom -= 1f;
    		camera.update();
    		System.out.println("camera -");
    	}
    	if(key.getPressedZ()) {
    		camera.zoom += 1f;
    		camera.update();
    		System.out.println("camera +");
    	}
    	camera.update();
    	batch.end();
    	
    }
}
