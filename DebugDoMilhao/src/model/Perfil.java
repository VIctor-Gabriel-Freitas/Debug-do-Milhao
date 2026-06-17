package model;

import java.util.ArrayList;
import java.util.List;

public class Perfil extends Jogador {
    private List<String> conquistas;
    private int ranking;

    public Perfil(String nome) {
        super(nome);
        this.conquistas = new ArrayList<>();
        this.ranking = 99;
    }

    public void adicionarConquista(String conquista) {
        this.conquistas.add(conquista);
    }

    public void atualizarRanking(int novoRanking) {
        this.ranking = novoRanking;
    }
}