package ru.sgstudio.sgs01.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Load implements Screen {
	private Sprite line1[] = {new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite()};
	private Sprite line2[] = {new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite(), new Sprite()};
	
	private static float time = 0;
	private static long startTime;
	
	private SpriteBatch batch;
	private BitmapFont largeFont;
	
	private Main main;

	public Load(Main main) {
		this.main = main;
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		
		largeFont = new BitmapFont();
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("font/pixel.ttf"));
		FreeTypeFontParameter param = new FreeTypeFontParameter();
		param.size = 100;
		largeFont = gen.generateFont(param);
		gen.dispose();
		
		startTime = System.currentTimeMillis();
		
		for(int i=0;i<17;i++){
			line1[i] = new Sprite(new Texture("cube.png"));
			line1[i].setPosition(i*40+20, 100);
			
			line2[i] = new Sprite(new Texture("cube.png"));
			line2[i].setPosition(i*40+20, Gdx.graphics.getHeight()-100);
		}
	}
	
	float bg=1, speed=2;
	int num;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(bg, bg, bg, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		for(int i=0;i<17;i++){
			line1[i].draw(batch);
			line1[i].setX(line1[i].getX() - speed);
			num=0;
			while(true){
				if(line1[num].getX()+20 < Gdx.graphics.getWidth()) num++;
				else break;
			}
			if(line1[i].getX() <= -20) line1[i].setX( line1[num].getX() + 40 );
			
			line2[i].draw(batch);
			line2[i].setX(line2[i].getX() + speed);
			num=16;
			while(true){
				if(line2[num].getX() > 40) num--;
				else break;
			}
			if(line2[i].getX() >= Gdx.graphics.getWidth()) line2[i].setX( line2[num].getX() - 40 );
		}
		
		largeFont.draw(batch, "SGStudio", Gdx.graphics.getWidth()/2-200, Gdx.graphics.getHeight()/2+50);
		
		batch.end();

		if(time!=(System.currentTimeMillis() - startTime) / 1000) time++;
		if(bg>0 && time>=1 && time<3)bg-=.01;
		if(bg<1 && time>=6)bg+=.01;
		if(time==9) main.setScr(main.game);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		largeFont.dispose();
	}
}
