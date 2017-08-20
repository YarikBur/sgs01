package ru.sgstudio.sgs01.map;

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
	
	private float w = Variables.getWorldWidth() * 2, h = Variables.getWorldHeight() * 2;
	
	public MiniMapCam() {
		top = new Top();
		camera = new OrthographicCamera(w, h);
		player = new Player();
		key = new KeyManager();
		
	}
    public void MinMapCamera(SpriteBatch batch) {
    	camera.position.set(-55, -240, 0);
    	
    	camera.update();
    	
    	batch.setProjectionMatrix(camera.combined);
    	batch.begin();
    	
    	top.render(batch);
    	player.drawTop(batch);
    	batch.end();    	
    }
}
