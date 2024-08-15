package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OwnerPage extends MyFrame implements ActionListener {

    JButton exitButton = new JButton("<-");
    JButton imovelButton = new JButton("Imovel1");
    public OwnerPage() {
        super("Página de Gerenciamento");
        setSize(1280, 768);
        addUIComponents();
    }

    private void addUIComponents() {
        exitButton.setFont(new Font("Dialog", Font.BOLD, 18));
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exitButton.setBackground(Colors.TERTIARY_COLOR);
        exitButton.setForeground(Colors.SECONDARY_COLOR);
        exitButton.setBounds(10, 10, 50, 50);
        add(exitButton);
        exitButton.addActionListener(this);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OwnerPage.this.dispose();
                new LoginForm().setVisible(true);
            }
        });

        imovelButton.setFont(new Font("Dialog", Font.BOLD, 18));
        imovelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imovelButton.setBackground(Colors.TERTIARY_COLOR);
        imovelButton.setForeground(Colors.SECONDARY_COLOR);
        imovelButton.setBounds(100, 100, 200, 200);
        add(imovelButton);
        imovelButton.addActionListener(this);
        imovelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OwnerPage.this.dispose();
                new ClientView().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            JOptionPane.showMessageDialog(OwnerPage.this, "Retornando!");
            OwnerPage.this.dispose();
            new LoginForm().setVisible(true);
        }
        if (e.getSource() == imovelButton) {
            JOptionPane.showMessageDialog(OwnerPage.this, "Retornando!");
            OwnerPage.this.dispose();
            new ClientView().setVisible(true);
        }
    }
}