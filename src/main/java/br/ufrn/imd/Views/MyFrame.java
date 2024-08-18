package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame(String title){
        super(title);
        setSize(520, 680);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(50, 50); //Fazem as telas aparecerem no lado superior esquerdo
        setResizable(false);
        getContentPane().setBackground(Colors.PRIMARY_COLOR);
    }
}
