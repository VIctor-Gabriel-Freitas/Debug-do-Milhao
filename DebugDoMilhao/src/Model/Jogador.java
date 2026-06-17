package Model;

public class Jogador {
    private String nome;
    private int pontuacaoTotal;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacaoTotal = 0;
    }

    public void entrarPartida() {
        System.out.println(nome + " entrou na partida.");
    }

    public void sairPartida() {
        System.out.println(nome + " saiu da partida.");
    }

    public void responderPergunta() {
    }

    public void atualizarPontuacao(int pontos) {
        this.pontuacaoTotal += pontos;
    }

    public String getNome() { return nome; }
    public int getPontuacaoTotal() { return pontuacaoTotal; }
}