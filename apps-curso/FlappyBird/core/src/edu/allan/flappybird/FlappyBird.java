package edu.allan.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {


    private SpriteBatch batch;
    private Texture fundo;
    private Texture passaro;
    private  int movimento = 0;
    private int larguraDispositivo;
    private  int alturaDispositivo;

    @Override
    public void create() {

        larguraDispositivo = Gdx.graphics.getWidth();
        alturaDispositivo = Gdx.graphics.getHeight();

        batch = new SpriteBatch();
        fundo = new Texture("fundo.png");
        passaro = new Texture("passaro1.png");

    }

    @Override
    public void render() {

        /* Corrigir problema de aparecimento de vários pássaros ;) */
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(fundo, 0, 0, larguraDispositivo, alturaDispositivo);
        batch.draw(passaro, movimento,  alturaDispositivo / 2);


        batch.end();

        movimento = movimento + 5;
    }


}
