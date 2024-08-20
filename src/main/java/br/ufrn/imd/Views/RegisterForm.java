package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterForm extends MyFrame implements ActionListener {
    JTextField usernameField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField mailField = new JTextField();
    JTextField cpfField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField cepField = new JTextField();
    JTextField stateField = new JTextField();
    JTextField cityField = new JTextField();
    JTextField addressField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton registerButton = new JButton("Registrar");
    public RegisterForm() {
        super("Página de Registro");
        setSize(1280, 680);
        addUIcomponents();
    }

    private void addUIcomponents() {
        JLabel loginLabel = new JLabel("Cadastro");
        loginLabel.setBounds(370, 25, 520, 100);
        loginLabel.setForeground(Colors.TEXT_COLOR);
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);

        JLabel nameLabel = new JLabel("Nome Completo");
        nameLabel.setBounds(410, 130, 400, 25);
        nameLabel.setForeground(Colors.TEXT_COLOR);
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        nameField.setBounds(410, 165, 450, 25);
        nameField.setBackground(Colors.SECONDARY_COLOR);
        nameField.setForeground(Colors.TEXT_COLOR);
        nameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(nameLabel);
        add(nameField);

        //Interface para inserir o nome do novo usuário no registro
        JLabel usernameLabel = new JLabel("Nome de usuário");
        usernameLabel.setBounds(410, 200, 400, 25);
        usernameLabel.setForeground(Colors.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        usernameField.setBounds(410, 235, 220, 25);
        usernameField.setBackground(Colors.SECONDARY_COLOR);
        usernameField.setForeground(Colors.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(usernameLabel);
        add(usernameField);

        //Interface para inserir o usuário no registro
        JLabel cpfLabel = new JLabel("CPF");
        cpfLabel.setBounds(640, 200, 400, 25);
        cpfLabel.setForeground(Colors.TEXT_COLOR);
        cpfLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        cpfField.setBounds(640, 235, 220, 25);
        cpfField.setBackground(Colors.SECONDARY_COLOR);
        cpfField.setForeground(Colors.TEXT_COLOR);
        cpfField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(cpfLabel);
        add(cpfField);

        JLabel phoneLabel = new JLabel("Nº de telefone");
        phoneLabel.setBounds(410, 265, 400, 25);
        phoneLabel.setForeground(Colors.TEXT_COLOR);
        phoneLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        phoneField.setBounds(410, 295, 220, 25);
        phoneField.setBackground(Colors.SECONDARY_COLOR);
        phoneField.setForeground(Colors.TEXT_COLOR);
        phoneField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(phoneLabel);
        add(phoneField);

        JLabel cepLabel = new JLabel("CEP");
        cepLabel.setBounds(640, 265, 400, 25);
        cepLabel.setForeground(Colors.TEXT_COLOR);
        cepLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        cepField.setBounds(640, 295, 220, 25);
        cepField.setBackground(Colors.SECONDARY_COLOR);
        cepField.setForeground(Colors.TEXT_COLOR);
        cepField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(cepLabel);
        add(cepField);

        JLabel stateLabel = new JLabel("Estado:");
        stateLabel.setBounds(410, 325, 400, 25);
        stateLabel.setForeground(Colors.TEXT_COLOR);
        stateLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        stateField.setBounds(410, 355, 220, 25);
        stateField.setBackground(Colors.SECONDARY_COLOR);
        stateField.setForeground(Colors.TEXT_COLOR);
        stateField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(stateLabel);
        add(stateField);

        JLabel cityLabel = new JLabel("Cidade");
        cityLabel.setBounds(640, 325, 400, 25);
        cityLabel.setForeground(Colors.TEXT_COLOR);
        cityLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        cityField.setBounds(640, 355, 220, 25);
        cityField.setBackground(Colors.SECONDARY_COLOR);
        cityField.setForeground(Colors.TEXT_COLOR);
        cityField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(cityLabel);
        add(cityField);

        JLabel addressLabel = new JLabel("Endereço");
        addressLabel.setBounds(410, 385, 400, 25);
        addressLabel.setForeground(Colors.TEXT_COLOR);
        addressLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        addressField.setBounds(410, 415, 450, 25);
        addressField.setBackground(Colors.SECONDARY_COLOR);
        addressField.setForeground(Colors.TEXT_COLOR);
        addressField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(addressLabel);
        add(addressField);

        JLabel mailLabel = new JLabel("Seu e-mail");
        mailLabel.setBounds(410, (445), 400, 25);
        mailLabel.setForeground(Colors.TEXT_COLOR);
        mailLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        mailField.setBounds(410, (475), 450, 25);
        mailField.setBackground(Colors.SECONDARY_COLOR);
        mailField.setForeground(Colors.TEXT_COLOR);
        mailField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(mailLabel);
        add(mailField);

        JLabel passwordLabel = new JLabel("Senha");
        passwordLabel.setBounds(410, 505, 400, 25);
        passwordLabel.setForeground(Colors.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        passwordField.setBounds(410, 535, 450, 25);
        passwordField.setBackground(Colors.SECONDARY_COLOR);
        passwordField.setForeground(Colors.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passwordLabel);
        add(passwordField);

        registerButton.setFont(new Font("Dialog", Font.BOLD, 18));
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBackground(Colors.TERTIARY_COLOR);
        registerButton.setForeground(Colors.SECONDARY_COLOR);
        registerButton.setBounds(500, 600, 250, 50);
        add(registerButton);
        registerButton.addActionListener(this);
        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Do nothing
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton){
            JOptionPane.showMessageDialog(RegisterForm.this, "Cadastro realizado com sucesso!");
            RegisterForm.this.dispose();
            new LoginForm().setVisible(true);
        }
    }
}