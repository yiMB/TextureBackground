package com.yi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

/*
Texture
use Texture store an image
 */
public class TextureBackground extends ApplicationAdapter {
	/*
	SpriteBatch is for drawing, libgdx make SpriteBatch a fast way to draw
	usage:
	draw Texture
	 */
	SpriteBatch batch;
	/*
	Texture is color pixel in 2d grid form in memory
	usage:
	store an image
	 */
	Texture textureBackground;
	Texture textureMoon;

	/**
	 * store current timestamp use TimeUtils.nanoTime()
	 */
	long lastTimeBg;
	/**
	 * use to tell which background image
	 */
	int bgNumber;
	/**
	 * moon image x position
	 */
	float moonXposition;

	@Override
	public void create () {
		batch = new SpriteBatch();
		/*
		assign image "Starry_sky.png" to background image and "moon.png" to moon image,
		 */
		textureBackground = new Texture(Gdx.files.internal("Starry_sky.png"));
		textureMoon = new Texture(Gdx.files.internal("moon.png"));

		lastTimeBg = TimeUtils.nanoTime();
		bgNumber = 1;
		moonXposition = 0;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		/*
		use SpriteBatch to draw Texture at x=0 y=0 which is bottom left corner to width and height of screen
		 */
		batch.draw(textureBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		/*
		without given width and height will use original image width and height,
		to put image at the center, use center coordinate of screen - center coordinate of image
		 */
		batch.draw(textureMoon, Gdx.graphics.getWidth() / 2 - textureMoon.getWidth() / 2, Gdx.graphics.getHeight() / 2 - textureMoon.getHeight() / 2);
//		batch.draw(textureMoon, moonXposition, Gdx.graphics.getHeight() / 2 - textureMoon.getHeight() / 2);
		batch.end();

		/*
		if(TimeUtils.nanoTime() - lastTimeBg > 5000000000l){
			textureBackground = new Texture(Gdx.files.internal("rainbg" + bgNumber + ".png"));
			lastTimeBg = TimeUtils.nanoTime();
			if(bgNumber >= 6){
				bgNumber = 1;
			}
			else{
				bgNumber++;
			}

			if(moonXposition + textureMoon.getWidth() >= Gdx.graphics.getWidth()){
				moonXposition = 0;
			}
			else{
				moonXposition += 200f;
			}
		}
		*/
	}
}
