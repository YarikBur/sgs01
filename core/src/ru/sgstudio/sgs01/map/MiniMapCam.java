package ru.sgstudio.sgs01.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgstudio.sgs01.player.Player;
import ru.sgstudio.sgs01.utils.Variables;
import ru.sgstudio.sgs01.utils.conntroller.KeyManager;

/**
 * Ётот класс нужен дл€ рисовки миникарты(рисовка карты сверху)
 * @author Yarik
 * @version 1.1
 */

public class MiniMapCam  {
	private static float time = 0;
	private static long startTime;
	
	private static OrthographicCamera camera;
	private static Top top;
	private static Player player;
	private static KeyManager key;
	private static Generate gen;
	
	private static boolean created = false;
	
	private static float w = Variables.getWorldWidth() * 2, h = Variables.getWorldHeight() * 2;
	
	public MiniMapCam() {
		if(!created) {
			startTime = System.currentTimeMillis();
			top = new Top();
			camera = new OrthographicCamera(w, h);
			player = new Player();
			camera.position.set(-160, -220, 0);
			key = new KeyManager();
			gen = new Generate();
			
			created=!created;
		}
	}

	/**
	 * ћетод позвол€ющий нарисовать миникарту
	 * @param batch - ƒл€ рисовки миникарты
	 */
	
	public void MinMapCamera(SpriteBatch batch) {
		if(time!=(System.currentTimeMillis() - startTime) / 100){
			pressed();
			time++;
		}
    	
    	camera.update();
    	
    	batch.setProjectionMatrix(camera.combined);
    	batch.begin();
    	
    	top.render(batch);
    	player.drawTop(batch);
    	batch.end();    
    }
	
	private void pressed() {
		if(key.getPressedUp()) 
			if(gen.getMap().length-1>player.getZPlayer())
				camera.translate(0, 16);
		if(key.getPressedDown())
			if(player.getZPlayer()>0)
				camera.translate(0, -16);
		if(key.getPressedLeft())
			if(player.getXPlayer()>0)
				camera.translate(-16, 0);
		if(key.getPressedRight())
			if(gen.getMap()[0][0].length-1>player.getXPlayer())
				camera.translate(16, 0);
	}
}
