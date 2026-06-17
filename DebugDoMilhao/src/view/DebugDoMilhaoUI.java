package view;

import model.Jogador;
import model.Questao;
import controller.Partida;

import javax.swing.*;
import java.awt.*;

public class DebugDoMilhaoUI extends JFrame {

    private Partida partida;
    private Jogador jogadorAtual;

    private JLabel txtPergunta, txtStatus, txtPremio;
    private JButton[] botoesAlternativas;

    public DebugDoMilhaoUI() {
        jogadorAtual = new Jogador("Dev_Estudante");
        partida = new Partida(jogadorAtual);
        jogadorAtual.entrarPartida();

        setTitle("Debug do Milhão - Baseado no Diagrama UML");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel painelTopo = new JPanel(new GridLayout(1, 2));
        txtStatus = new JLabel("", SwingConstants.LEFT);
        txtPremio = new JLabel("", SwingConstants.RIGHT);
        painelTopo.add(txtStatus);
        painelTopo.add(txtPremio);
        painelTopo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(painelTopo, BorderLayout.NORTH);

        txtPergunta = new JLabel("", SwingConstants.CENTER);
        txtPergunta.setFont(new Font("Arial", Font.BOLD, 14));
        add(txtPergunta, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new GridLayout(2, 2, 5, 5));
        botoesAlternativas = new JButton[4];
        for (int i = 0; i < 4; i++) {
            botoesAlternativas[i] = new JButton();
            final int idx = i;
            botoesAlternativas[i].addActionListener(e -> computarClique(idx));
            painelBotoes.add(botoesAlternativas[i]);
        }
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(painelBotoes, BorderLayout.SOUTH);

        atualizarTela();
    }

    private void atualizarTela() {
        Questao q = partida.getQuestaoAtual();

        if (q != null) {
            txtStatus.setText("Jogador: " + jogadorAtual.getNome() + " | Questão: " + partida.getNumeroAtual() + "/" + partida.getTotalQuestoes());
            txtPremio.setText("Pontuação acumulada: R$ " + partida.getPremioAtual());
            txtPergunta.setText("<html><body style='text-align: center; width: 450px;'>" + q.getEnunciado() + "</body></html>");

            for (int i = 0; i < 4; i++) {
                botoesAlternativas[i].setText(q.getAlternativas().get(i).getText());
            }
        } else {
            partida.calcularResultados();
            JOptionPane.showMessageDialog(this, "Excepcional! Você limpou todos os bugs e ganhou R$ 1.000.000!");
            reiniciarSessao();
        }
    }

    private void computarClique(int indiceBotao) {
        jogadorAtual.responderPergunta();
        boolean correto = partida.responderRodada(indiceBotao);

        if (correto) {
            JOptionPane.showMessageDialog(this, "Acerto Crítico! Próxima linha de código.");
            atualizarTela();
        } else {
            JOptionPane.showMessageDialog(this, "Erro de Sintaxe! O programa crashou.");
            reiniciarSessao();
        }
    }

    private void reiniciarSessao() {
        jogadorAtual.sairPartida();
        jogadorAtual = new Jogador("Dev_Estudante");
        partida = new Partida(jogadorAtual);
        jogadorAtual.entrarPartida();
        atualizarTela();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DebugDoMilhaoUI().setVisible(true));
    }
}