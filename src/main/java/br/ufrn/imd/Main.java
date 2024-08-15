package br.ufrn.imd;

import br.ufrn.imd.Views.LoginForm;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //Login.login(); // Chama o método de login!

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new LoginForm().setVisible(true);
            }
        });
    }
}