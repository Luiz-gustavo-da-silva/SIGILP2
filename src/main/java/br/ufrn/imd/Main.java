package br.ufrn.imd;
import javax.swing.*;
import br.ufrn.imd.Views.LoginForm;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new LoginForm().setVisible(true);
            }
        });
    }
}