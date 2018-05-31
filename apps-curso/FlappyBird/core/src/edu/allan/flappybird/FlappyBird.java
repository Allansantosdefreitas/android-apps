package edu.allan.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {

    private int larguraDispositivo;
    private int alturaDispositivo;

    private SpriteBatch batch;
    private Texture fundo;
    private Texture[] passarosAnimacaoArray;

    private float variacaoAnimacaoPassaro = 0;
    private float variacaoQuedaPassaro = 0;
    private float alturaAtualPassaro = 0;
    private float posicaoHorizontalPassaro = 30;

    private float passaroHeightSize = 0;
    private float passaroWidthSize = 0;

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

        /* Dimensões do pássaro */
        passaroWidthSize = passarosAnimacaoArray[0].getWidth() * (float) 1.5;
        passaroHeightSize = passarosAnimacaoArray[0].getHeight() * (float) 1.5;

        /* Centralizar verticalmente o pássaro na tela */
        alturaAtualPassaro = alturaDispositivo / 2;


        //variacaoQuedaPassaro = 10;
    }

    @Override
    public void render() {

        /* Corrigir problema de aparecimento de vários pássaros ;) */
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        variacaoAnimacaoPassaro += Gdx.graphics.getDeltaTime() * 10;
        variacaoQuedaPassaro++;


        /* Animação do pássaro */
        if (variacaoAnimacaoPassaro > 2) {
            variacaoAnimacaoPassaro = 0;
        }

        /* Voada do pássaro */
        if (Gdx.input.justTouched()) {
            variacaoQuedaPassaro = variacaoQuedaPassaro - 30;
        }

        /* Queda do pássaro */
        if (alturaAtualPassaro >= 0 || variacaoQuedaPassaro < 0) {
            alturaAtualPassaro = alturaAtualPassaro - variacaoQuedaPassaro;
            Gdx.app.log("altura", "altura: " + alturaAtualPassaro);
        }
        /* Não pode ficar abaixo do chão ;) */
        if (alturaAtualPassaro < 0) {
            alturaAtualPassaro = 0;
            variacaoQuedaPassaro = 0;
        }

        /* Não pode passar do teto também ;) */
        if (alturaAtualPassaro > alturaDispositivo) {
            alturaAtualPassaro = alturaDispositivo - passaroHeightSize - 30;
            variacaoQuedaPassaro = 0;
            Gdx.app.log("PASSOU", "passou: " + alturaAtualPassaro);

        }

        batch.begin(); /* -------------------------------------------------- */

        /* Desenhar fundo ----------- */
        batch.draw(fundo, 0, 0, larguraDispositivo, alturaDispositivo);

        /* Animação (troca de imagens) do pássaro */
        batch.draw(passarosAnimacaoArray[(int) variacaoAnimacaoPassaro],
                posicaoHorizontalPassaro,
                alturaAtualPassaro,
                (passaroWidthSize),
                passaroHeightSize);

        batch.end(); /* -------------------------------------------------- */


        /* getDeltaTime obtém a variação de tempo entre cada chamada do método render()..
        * entre o frame atual e o último frame ;)
         * para fazer a animação mais lenta, multiplica-se por 7 */
//        variacaoAnimacaoPassaro += Gdx.graphics.getDeltaTime() * 7;

        /* Variação da altura do pássaro..enquanto não estiver no chão, cai */
        //Gdx.app.log("alturaPassaro", "quedaPAROU: " + alturaAtualPassaro);

//        if ( (alturaAtualPassaro -10) > 0 ){
//        /*  */
//           alturaAtualPassaro -= 10;
//           Gdx.app.log("alturaPassaro", "quedaCONTINUA: " + alturaAtualPassaro);
//        }else {
//            alturaAtualPassaro = 0;
//        }
//
//
//        if (Gdx.input.justTouched() ){
//            alturaAtualPassaro += 50;
//        }

    }


}
