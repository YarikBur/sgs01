package ru.sgstudio.sgs01.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgstudio.sgs01.player.Player;
import ru.sgstudio.sgs01.utils.Variables;
import ru.sgstudio.sgs01.utils.conntroller.KeyManager;

public class MiniMapCam  {
	private  OrthographicCamera camera;
	private Top top;
	private Player player;
	private KeyManager key;
	
	public MiniMapCam() {
		top = new Top();
		camera = new OrthographicCamera(Variables.getWorldWidth() * 2, Variables.getWorldHeight() * 2);
		player = new Player();
		key = new KeyManager();
		
	}
    public void MinMapCamera(SpriteBatch batch) {
    	camera.position.set(player.getZPlayer(), player.getYPlayer(), 0);
    	if(key.getPressedX()) {
    		camera.zoom -= 1f;
    		System.out.println("camera -");
    	}
    	if(key.getPressedZ()) {
    		camera.zoom += 1f;
    		System.out.println("camera +");
    	}
    	
    	camera.update();
    	
    	batch.setProjectionMatrix(camera.combined);
    	batch.begin();
    	top.render(batch);
    	batch.end();    	
    }
}
