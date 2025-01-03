package com.example.view;

import com.example.controller.TelaDepositarController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDepositar extends JFrame implements ActionListener {
    private TelaDepositarController controller;

    private JButton btnDepositar10, btnDepositar20, btnDepositar50, btnDepositar100, btnDepOutras, btnVoltar;

    public TelaDepositar(TelaDepositarController controller) {
        this.controller = controller;

        // Configuração da janela
        setTitle("Depositar Multibanco");
        setSize(800, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        // Label para o título
        JLabel lblTitulo = new JLabel("Escolha o valor do Depósito:", JLabel.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lblTitulo, BorderLayout.NORTH);

        // Painel central com os botões
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(3, 2, 20, 20));
        painelCentral.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        // Botões
        btnDepositar10 = new JButton("€ 10");
        btnDepositar10.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDepositar10.addActionListener(this);
        painelCentral.add(btnDepositar10);

        btnDepositar20 = new JButton("€ 20");
        btnDepositar20.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDepositar20.addActionListener(this);
        painelCentral.add(btnDepositar20);

        btnDepositar50 = new JButton("€ 50");
        btnDepositar50.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDepositar50.addActionListener(this);
        painelCentral.add(btnDepositar50);

        btnDepositar100 = new JButton("€ 100");
        btnDepositar100.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDepositar100.addActionListener(this);
        painelCentral.add(btnDepositar100);

        btnDepOutras = new JButton("Outros valores");
        btnDepOutras.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDepOutras.addActionListener(this);
        painelCentral.add(btnDepOutras);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnVoltar.addActionListener(this);
        painelCentral.add(btnVoltar);

        add(painelCentral, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDepositar10) {
            controller.realizarDeposito(10);
        } else if (e.getSource() == btnDepositar20) {
            controller.realizarDeposito(20);
        } else if (e.getSource() == btnDepositar50) {
            controller.realizarDeposito(50);
        } else if (e.getSource() == btnDepositar100) {
            controller.realizarDeposito(100);
        } else if (e.getSource() == btnDepOutras) {
            String input = JOptionPane.showInputDialog("Digite o valor a Depositar:");
            try {
                double valor = Double.parseDouble(input);
                controller.realizarDeposito(valor);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnVoltar) {
            controller.voltar();
        }
    }
}
