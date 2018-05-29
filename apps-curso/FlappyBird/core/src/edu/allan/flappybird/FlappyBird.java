package edu.allan.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {

    private int larguraDispositivo;
    private  int alturaDispositivo;

    private SpriteBatch batch;
    private Texture fundo;
    private Texture[] passarosAnimacaoArray;

    private  float variacaoAnimacaoPassaro = 0;
    private  float variacaoQuedaPassaro = 0;
    private  float alturaAtualPassaro = 0;

    @Override
    public void create() {

        larguraDispositivo = Gdx.graphics.getWidth();
        alturaDispositivo = Gdx.graphics.getHeight();

        batch = new SpriteBatch();
        fundo = new Texture("fundo.png");
        
        passarosAnimacaoArray = new Texture[3];

        passarosAnimacaoArray[0] = new Texture("passaro1.png");
        passarosAnimacaoArray[1] = new Texture("passaro2.png");
        passarosAnimacaoArray[2] = new Texture("passaro3.png");

        /* Centralizar verticalmente o pássaro na tela */
        alturaAtualPassaro = alturaDispositivo / 2;

        variacaoQuedaPassaro = 7;
    }

    @Override
    public void render() {
        /* Corrigir problema de aparecimento de vários pássaros ;) */
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);




        batch.begin(); /* -------------------------------------------------- */

        /* Desenhar fundo ----------- */
        batch.draw(fundo, 0, 0, larguraDispositivo, alturaDispositivo);

        if( variacaoAnimacaoPassaro > 2 ){
            variacaoAnimacaoPassaro = 0;
        }


        /* Animação do pássaro mais lenta ;) */
        batch.draw(passarosAnimacaoArray[ (int) variacaoAnimacaoPassaro], 30,
                alturaAtualPassaro);



        batch.end(); /* -------------------------------------------------- */


        /* getDeltaTime obtém a variação de tempo entre cada chamada do método render()..
        * entre o frame atual e o último frame ;)
         * para fazer a animação mais lenta, multiplica-se por 7 */
        variacaoAnimacaoPassaro += Gdx.graphics.getDeltaTime() * 7;

        /* Variação da altura do pássaro..enquanto não estiver no chão, cai */
        //Gdx.app.log("alturaPassaro", "quedaPAROU: " + alturaAtualPassaro);

        if ( (alturaAtualPassaro -= variacaoQuedaPassaro)  > 0 ){
        /*  */
            Gdx.app.log("alturaPassaro", "quedaCONTINUA: " + alturaAtualPassaro);
            alturaAtualPassaro -= variacaoQuedaPassaro;
            Gdx.app.log("alturaPassaro", "quedaCONTINUA: " + alturaAtualPassaro);
        }else {
            alturaAtualPassaro = 0;
        }



//        Gdx.app.log("variacao", "variacaoAnimacao: "+ variacaoAnimacaoPassaro);

    }


}
