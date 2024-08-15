package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientView extends MyFrame implements ActionListener{
    JButton bugButton = new JButton("Teste :D");
    public ClientView() {
        super("Página de Gerenciamento");
        setSize(1280, 768);
        addUIComponents();
    }

    private void addUIComponents() {
        bugButton.setFont(new Font("Dialog", Font.BOLD, 18));
        bugButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bugButton.setBackground(Colors.TERTIARY_COLOR);
        bugButton.setForeground(Colors.SECONDARY_COLOR);
        bugButton.setBounds(100, 100, 200, 200);
        add(bugButton);
        bugButton.addActionListener(this);
        bugButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ClientView.this.dispose();
                new LoginForm().setVisible(true);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bugButton) {
            JOptionPane.showMessageDialog(ClientView.this, "planilha aqui :D");
        }
    }
}