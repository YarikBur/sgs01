package ru.sgstudio.sgs01.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgstudio.sgs01.player.Player;
import ru.sgstudio.sgs01.utils.Variables;

/**
 * Ётот класс нужен дл€ рисовки миникарты(рисовка карты сверху)
 * @author Yarik
 * @version 1.1
 */

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

	/**
	 * ћетод позвол€ющий нарисовать миникарту
	 * @param batch - ƒл€ рисовки миникарты
	 */
	
	public void MinMapCamera(SpriteBatch batch) {
		int i=-55, ii=-240, iii=player.getZPlayer(), iiii=player.getXPlayer();
		camera.position.set(i, ii, 0);
		
    	if(iii!=player.getZPlayer()) {
    		if(iii>player.getZPlayer()) i-=player.getZPlayer()*16;
    		if(iii<player.getZPlayer()) i+=player.getZPlayer()*16;
    		camera.translate(i, ii);
    	}
    	if(iiii!=player.getXPlayer()) {
    		if(iiii>player.getXPlayer()) ii-=player.getXPlayer()*16;
    		if(iiii<player.getXPlayer()) ii+=player.getXPlayer()*16;
    		camera.translate(i, ii);
    	}
    	
    	camera.update();
    	
    	batch.setProjectionMatrix(camera.combined);
    	batch.begin();
    	
    	top.render(batch);
    	player.drawTop(batch);
    	batch.end();    
    }
}
