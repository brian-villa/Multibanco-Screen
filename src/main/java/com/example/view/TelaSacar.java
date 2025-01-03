package com.example.view;

import com.example.controller.TelaSacarController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSacar extends JFrame implements ActionListener {
    private TelaSacarController controller;
    private JButton btnSacar10, btnSacar20, btnSacar50, btnSacar100, btnOutras, btnVoltar;

    public TelaSacar(TelaSacarController controller) {
        this.controller = controller;

        // Configuração da janela
        setTitle("Saque Multibanco");
        setSize(800, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Centraliza a janela na tela
        getContentPane().setBackground(Color.white);

        // Label para o título
        JLabel lblTitulo = new JLabel("Escolha o valor do saque:", JLabel.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lblTitulo, BorderLayout.NORTH);

        // Painel central com os botões
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(3, 2, 20, 20)); // 3 linhas, 2 colunas, espaçamento 20px
        painelCentral.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100)); // Margens

        // Botões
        btnSacar10 = new JButton("€ 10");
        btnSacar10.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSacar10.addActionListener(this);
        painelCentral.add(btnSacar10);

        btnSacar20 = new JButton("€ 20");
        btnSacar20.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSacar20.addActionListener(this);
        painelCentral.add(btnSacar20);

        btnSacar50 = new JButton("€ 50");
        btnSacar50.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSacar50.addActionListener(this);
        painelCentral.add(btnSacar50);

        btnSacar100 = new JButton("€ 100");
        btnSacar100.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSacar100.addActionListener(this);
        painelCentral.add(btnSacar100);

        btnOutras = new JButton("Outros valores");
        btnOutras.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnOutras.addActionListener(this);
        painelCentral.add(btnOutras);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnVoltar.addActionListener(this);
        painelCentral.add(btnVoltar);

        add(painelCentral, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSacar10) {
            controller.sacar(10);
        } else if (e.getSource() == btnSacar20) {
            controller.sacar(20);
        } else if (e.getSource() == btnSacar50) {
            controller.sacar(50);
        } else if (e.getSource() == btnSacar100) {
            controller.sacar(100);
        } else if (e.getSource() == btnOutras) {
            controller.sacarOutroValor();
        } else if (e.getSource() == btnVoltar) {
            dispose();
            controller.voltar();
        }
    }
}

