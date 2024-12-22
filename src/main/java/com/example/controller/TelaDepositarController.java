package com.example.controller;

import com.example.model.ContaBancaria;
import com.example.view.TelaCaixaEletronico;
import com.example.view.TelaDepositar;

import javax.swing.*;

public class TelaDepositarController {
    private ContaBancaria conta;
    private TelaDepositar telaDepositar;

    public TelaDepositarController(ContaBancaria conta) {
        this.conta = conta;
        this.telaDepositar = new TelaDepositar(this);
    }

    public void realizarDeposito(double valor) {
        conta.depositar(valor);
        JOptionPane.showMessageDialog(telaDepositar, "Depósito de € " + valor + " realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void voltar() {
        telaDepositar.dispose();
        new TelaCaixaEletronico(conta);
    }
}

