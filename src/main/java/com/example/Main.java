package com.example;

import com.example.controller.LoginController;
import com.example.view.Login;

public class Main {
    public static void main(String[] args) {
        // Inicializando a aplicação
        // Criar a instância do controlador de login
        LoginController controller = new LoginController();

        // Criar a interface de login
        Login loginView = new Login();
        loginView.setController(controller);

        // Associar a interface com o controlador
        controller.setView(loginView);
    }
}
