package View;

import Controller.Partida;
import Model.Questão;
import Model.Perfil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame{
    private JLabel labelQuestão;
    private JLabel labelAlternativa;
    private JLabel labelTitulo;
    private JLabel label1;
    private JLabel label2;
    private JPanel painelPrincipal;
    private JPanel tela1;
    private JPanel tela2;
    private JButton alternativa;
    private JButton iniciar;
    private JButton sair;
    private JButton voltar;
    private CardLayout cardLayout;

    public void JanelaJogo(){
        initComponents();
    }

    private void initComponents(){
        labelTitulo = new JLabel();
        labelQuestão = new JLabel();
        labelAlternativa = new JLabel();
        alternativa = new JButton();
        iniciar = new JButton();
        sair = new JButton();
        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);
        tela1 = new JPanel();
        label1 = new JLabel("Esta é a Tela 1");
        tela1.add(label1);
        tela2 = new JPanel();
        label2 = new JLabel("Esta é a Tela 2");
        voltar = new JButton();
        tela2.add(label2);
        tela2.add(voltar);
        painelPrincipal.add(tela1, "TELA_1");
        painelPrincipal.add(tela2, "TELA_2");



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DEBUG DO MILHÃO");
        setLayout(null);

        labelTitulo.setText("DEBUG DO MILHÃO");
        labelTitulo.setBounds(900,90 ,200,200);
        add(labelTitulo);

        iniciar.setText("Iniciar");
        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(painelPrincipal, "TELA_2");
            }
        });
        iniciar.setBounds(900,540,100,40);
        add(iniciar);

        voltar.setText("Voltar");
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(painelPrincipal,"TELA_1");
            }
        });
        voltar.setBounds(900,540,100,40);
        add(voltar);

        sair.setText("Sair");

        sair.setBounds(900,600,100,50);
        add(sair);

        setSize(1920, 1080);
        add(painelPrincipal);
        setLocationRelativeTo(null);
    }
}

