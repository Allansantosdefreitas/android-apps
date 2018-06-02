package edu.allan.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {


    private SpriteBatch batch;
    private Texture[] passaros;
    private Texture fundo;
    private Texture canoSuperior;
    private Texture canoInferior;

    //Atributos de configuracao
    private int larguraDispositivo;
    private int alturaDispositivo;
    private float distanciaHorizontal = 30;

    private float variacao = 0;
    private float velocidadeQueda = 0;
    private float posicaoInicialVertical;

    /* Dimensões do pássaro */
    private float passaroHeightSize, passaroWidthSize = 0;


    /* Configurações dos canos ----- */

    private float distanciaHorizontalEntreCanos = 0;
    private float distanciaVerticalEntreCanos = 0;
    private float distanciaDoTetoCanoSuperior = 0; // igual ou maior que height do texture
    private float distanciaDoChaoCanoInferior = 0; // 0  ou menor que zero
    private float distanciaHorizontalUltimoCano = 0;
    private float distanciaHorizontalCanoAtual = 0;

    /* Game over */
    private boolean atingido = false;

    @Override
    public void create() {

        batch = new SpriteBatch();

        passaros = new Texture[3];
        passaros[0] = new Texture("passaro1.png");
        passaros[1] = new Texture("passaro2.png");
        passaros[2] = new Texture("passaro3.png");

        fundo = new Texture("fundo.png");

        canoSuperior = new Texture("cano_topo.png");
        canoInferior = new Texture("cano_baixo.png");

        larguraDispositivo = Gdx.graphics.getWidth();
        alturaDispositivo = Gdx.graphics.getHeight();

        posicaoInicialVertical = alturaDispositivo / 2;

        /* Aumentando um pouco as dimensões do pássaro */
        passaroHeightSize = (float) (passaros[0].getHeight() * 1.5);
        passaroWidthSize = (float) (passaros[0].getWidth() * 1.5);


    }

    @Override
    public void render() {

        variacao += Gdx.graphics.getDeltaTime() * 10;
        velocidadeQueda++;

        if (variacao > 2) variacao = 0;

        if (Gdx.input.justTouched()) {
            velocidadeQueda = -15;
        }

        if (posicaoInicialVertical > 0 || velocidadeQueda < 0) {
            posicaoInicialVertical = posicaoInicialVertical - velocidadeQueda;

        }

        /* Não pode ficar abaixo do chão ;) */
        if (posicaoInicialVertical < 0) {
            posicaoInicialVertical = 0;
            velocidadeQueda = 0;
        }


        /* Não pode passar do teto também ;) */
        if ((posicaoInicialVertical + passaroHeightSize) >= alturaDispositivo) {
            posicaoInicialVertical = alturaDispositivo - passaroHeightSize;
            velocidadeQueda = 0;
        }


        batch.begin();


        batch.draw(fundo, 0, 0, larguraDispositivo, alturaDispositivo);

        distanciaHorizontalEntreCanos = 600; // Randomico de no mínimo 600
        distanciaVerticalEntreCanos = 400; // Randomico de no mínimo 400?
        distanciaDoTetoCanoSuperior = canoSuperior.getHeight(); // igual ou maior que height do texture
        distanciaDoChaoCanoInferior = 0; // 0  ou menor que zero

        /* SUGESTÃO (I) de Miquéias: Colocar os canos se mexendo verticalmente,
        * mantendo a mesma distância vertical entre canos \0/

        * SUGESTÃO (II) de Miquéias: Usar toque prolongado para ganhar altura;
        * quando soltar, o pássaro volta a cair normalmente

        * SUGESTÃO (III): Variar distância entre canos, mantendo um valor mínimo aceitável;
        * SUGESTÃO (IV): Usar canos personalizados, de outras cores além de outros objetos,
        * em vez de canos, como fogo, pedra, árvores, emfim, coisas relacionadas à natureza.
        *  */
//
//        while ( atingido != true ){
//
//            distanciaHorizontalCanoAtual = 100;
//
//            batch.draw(canoSuperior, distanciaHorizontalCanoAtual, alturaDispositivo - canoSuperior.getHeight() );
//            //batch.draw(canoInferior, 100, 0);
//
//            distanciaHorizontalUltimoCano = distanciaHorizontalCanoAtual;
//
////        Random rand = new Random();
////        int  n = rand.nextInt(50) + 1;
////
//            distanciaHorizontalEntreCanos = 600;
//            distanciaHorizontalCanoAtual = distanciaHorizontalUltimoCano + distanciaHorizontalEntreCanos;
//
//            batch.draw(canoSuperior, distanciaHorizontalCanoAtual, alturaDispositivo - 500);
//
//            //batch.draw(canoInferior, 700, - 300);
//        }


        batch.draw(canoSuperior, 100, alturaDispositivo - canoSuperior.getHeight());
        batch.draw(canoInferior, 100, 0);

        batch.draw(passaros[(int) variacao],
                distanciaHorizontal,
                posicaoInicialVertical,
                passaroWidthSize,
                passaroHeightSize);

        batch.end();

    }

}


/* <MY WAY> ------------------------------------------------ <my way>
//
//    private int larguraDispositivo;
//     */
//    private int alturaDispositivo;
//
//    private SpriteBatch batch;
//    private Texture fundo;
//    private Texture[] passarosAnimacaoArray;
//
//    private float variacaoAnimacaoPassaro = 0;
//    private float variacaoQuedaPassaro = 0;
//    private float alturaAtualPassaro = 0;
//    private float posicaoHorizontalPassaro = 30;
//
//    private float passaroHeightSize = 0;
//    private float passaroWidthSize = 0;
//
//    @Override
//    public void create() {
//
//        larguraDispositivo = Gdx.graphics.getWidth();
//        alturaDispositivo = Gdx.graphics.getHeight();
//
//        batch = new SpriteBatch();
//        fundo = new Texture("fundo.png");
//
//        passarosAnimacaoArray = new Texture[3];
//
//        passarosAnimacaoArray[0] = new Texture("passaro1.png");
//        passarosAnimacaoArray[1] = new Texture("passaro2.png");
//        passarosAnimacaoArray[2] = new Texture("passaro3.png");
//
//        /* Dimensões do pássaro */
//        passaroWidthSize = passarosAnimacaoArray[0].getWidth() * (float) 1.5;
//        passaroHeightSize = passarosAnimacaoArray[0].getHeight() * (float) 1.5;
//
//        /* Centralizar verticalmente o pássaro na tela */
//        alturaAtualPassaro = alturaDispositivo / 2;
//
//
//        //variacaoQuedaPassaro = 10;
//    }
//
//    @Override
//    public void render() {
//
//        /* Corrigir problema de aparecimento de vários pássaros ;) */
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        variacaoAnimacaoPassaro += Gdx.graphics.getDeltaTime() * 10;
//        variacaoQuedaPassaro++;
//
//
//        /* Animação do pássaro */
//        if (variacaoAnimacaoPassaro > 2) {
//            variacaoAnimacaoPassaro = 0;
//        }
//
//        /* Voada do pássaro */
//        if (Gdx.input.justTouched()) {
//            variacaoQuedaPassaro = variacaoQuedaPassaro - 20;
//        }
//
//        /* Queda do pássaro */
//        if (alturaAtualPassaro >= 0 || variacaoQuedaPassaro < 0) {
//            alturaAtualPassaro = alturaAtualPassaro - variacaoQuedaPassaro;
//            Gdx.app.log("altura", "altura: " + alturaAtualPassaro);
//        }
//        /* Não pode ficar abaixo do chão ;) */
//        if (alturaAtualPassaro < 0) {
//            alturaAtualPassaro = 0;
//            variacaoQuedaPassaro = 0;
//        }
//
//        /* Não pode passar do teto também ;) */
//        if (alturaAtualPassaro > alturaDispositivo) {
//            alturaAtualPassaro = alturaDispositivo - passaroHeightSize - 30;
//            variacaoQuedaPassaro = 0;
//            Gdx.app.log("PASSOU", "passou: " + alturaAtualPassaro);
//
//        }
//
//        batch.begin(); /* -------------------------------------------------- */
//
//        /* Desenhar fundo ----------- */
//        batch.draw(fundo, 0, 0, larguraDispositivo, alturaDispositivo);
//
//        /* Animação (troca de imagens) do pássaro */
//        batch.draw(passarosAnimacaoArray[(int) variacaoAnimacaoPassaro],
//                posicaoHorizontalPassaro,
//                alturaAtualPassaro,
//                (passaroWidthSize),
//                passaroHeightSize);
//
//        batch.end(); /* -------------------------------------------------- */
//
//
//        /* getDeltaTime obtém a variação de tempo entre cada chamada do método render()..
//        * entre o frame atual e o último frame ;)
//         * para fazer a animação mais lenta, multiplica-se por 7 */
////        variacaoAnimacaoPassaro += Gdx.graphics.getDeltaTime() * 7;
//
//        /* Variação da altura do pássaro..enquanto não estiver no chão, cai */
//        //Gdx.app.log("alturaPassaro", "quedaPAROU: " + alturaAtualPassaro);
//
////        if ( (alturaAtualPassaro -10) > 0 ){
////        /*  */
////           alturaAtualPassaro -= 10;
////           Gdx.app.log("alturaPassaro", "quedaCONTINUA: " + alturaAtualPassaro);
////        }else {
////            alturaAtualPassaro = 0;
////        }
////
////
////        if (Gdx.input.justTouched() ){
////            alturaAtualPassaro += 50;
////        }
//
//    }
//
//}
/* </MY WAY> ------------------------------------------------ <my way> */



