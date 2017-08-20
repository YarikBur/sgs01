package ru.sgstudio.sgs01.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgstudio.sgs01.player.Player;
import ru.sgstudio.sgs01.utils.Variables;

public class MiniMapCam  {
	private  OrthographicCamera camera;
	private Top top;
	private Player player;
	
	private float w = Variables.getWorldWidth() * 2, h = Variables.getWorldHeight() * 2;
	
	public MiniMapCam() {
		top = new Top();
		camera = new OrthographicCamera(w, h);
		player = new Player();
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
