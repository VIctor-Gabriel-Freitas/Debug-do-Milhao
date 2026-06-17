package controller;

import model.Jogador;
import model.Questao;
import model.Alternativa;
import java.util.ArrayList;
import java.util.List;

public class Partida {
    private List<Jogador> jogadores;
    private List<Questao> questoes;
    private int indiceAtual;
    private boolean lendo;
    private double tempoResposta;
    private int escolha;

    private final int[] PREMIOS = {1000, 10000, 100000, 500000, 1000000};

    public Partida(Jogador jogador) {
        this.jogadores = new ArrayList<>();
        this.jogadores.add(jogador);
        this.questoes = new ArrayList<>();
        this.indiceAtual = 0;
        this.lendo = true;

        gerarQuestoesPadrao();
    }

    private void gerarQuestoesPadrao() {
        Questao q1 = new Questao("Qual erro ocorre ao acessar um índice inexistente em um Array?");
        q1.alternativa("NullPointerException", false);
        q1.alternativa("ArrayIndexOutOfBoundsException", true);
        q1.alternativa("StackOverflowError", false);
        q1.alternativa("ClassNotFoundException", false);
        questoes.add(q1);

        Questao q2 = new Questao("Qual palavra-chave impede que uma classe seja herdada em Java?");
        q2.alternativa("static", false);
        q2.alternativa("abstract", false);
        q2.alternativa("final", true);
        q2.alternativa("volatile", false);
        questoes.add(q2);

        Questao q3 = new Questao("PERGUNTA DO MILHÃO: Qual das opções NÃO é uma interface do Java Collections?");
        q3.alternativa("List", false);
        q3.alternativa("Set", false);
        q3.alternativa("Map", false);
        q3.alternativa("Vector", true);
        questoes.add(q3);
    }

    public void calcularResultados() {
        this.lendo = false;
    }

    public boolean responderRodada(int indiceEscolhido) {
        Questao q = getQuestaoAtual();
        if (q != null && q.validarResposta(indiceEscolhido)) {
            jogadores.get(0).atualizarPontuacao(PREMIOS[indiceAtual]);
            indiceAtual++;
            return true;
        }
        return false;
    }

    public Questao getQuestaoAtual() {
        return (indiceAtual < questoes.size()) ? questoes.get(indiceAtual) : null;
    }

    public int getNumeroAtual() { return indiceAtual + 1; }
    public int getTotalQuestoes() { return questoes.size(); }
    public int getPremioAtual() {
        return (indiceAtual == 0) ? 0 : PREMIOS[indiceAtual - 1];
    }
}