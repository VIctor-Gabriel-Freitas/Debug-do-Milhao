package model;

import java.util.ArrayList;

public class Questao extends Alternativa{
    private String enunciado;
    private ArrayList<Alternativa> alternativas;

    public Questao(String enunciado) {
        this.enunciado = enunciado;
        this.alternativas = new ArrayList<>();
    }

    public void adicionarAlternativa(Alternativa alt) {
        if (this.alternativas.size() < 4) {
            this.alternativas.add(alt);
        }
    }

    public void exibirQuestao() {
        System.out.println(enunciado);
    }

    public boolean validarResposta(int indice) {
        if (indice >= 0 && indice < alternativas.size()) {
            return alternativas.get(indice).isCorreta();
        }
        return false;
    }

    public String getEnunciado() { return enunciado; }
    public ArrayList<Alternativa> getAlternativas() { return alternativas; }
}