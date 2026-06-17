package App;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Teste {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de Telas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Painel principal que gerencia as cartas (telas)
        CardLayout cardLayout = new CardLayout();
        JPanel painelPrincipal = new JPanel(cardLayout);

        // Tela 1
        JPanel tela1 = new JPanel();
        JLabel label1 = new JLabel("Esta é a Tela 1");
        JButton btnIrParaTela2 = new JButton("Ir para Tela 2");
        tela1.add(label1);
        tela1.add(btnIrParaTela2);

        // Tela 2
        JPanel tela2 = new JPanel();
        JLabel label2 = new JLabel("Esta é a Tela 2");
        JButton btnVoltarParaTela1 = new JButton("Voltar para Tela 1");
        tela2.add(label2);
        tela2.add(btnVoltarParaTela1);

        // Adiciona as telas ao painel principal com um nome identificador
        painelPrincipal.add(tela1, "TELA_1");
        painelPrincipal.add(tela2, "TELA_2");

        // Evento do botão da Tela 1 para ir para a Tela 2
        btnIrParaTela2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(painelPrincipal, "TELA_2");
            }
        });

        // Evento do botão da Tela 2 para voltar
        btnVoltarParaTela1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(painelPrincipal, "TELA_1");
            }
        });

        frame.add(painelPrincipal);
        frame.setVisible(true);
    }
}
