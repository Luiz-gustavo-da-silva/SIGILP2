package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;
import br.ufrn.imd.Controllers.RegisterController;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class LoginForm extends MyFrame implements ActionListener {

    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JLabel registerLabel = new JLabel("Não possui uma conta? Registre-se aqui.");

    private final RegisterController registerController;

    public LoginForm() {
        super("Página de Login");
        this.registerController = new RegisterController("src/main/java/br/ufrn/imd/Files/owners.json");
        addUIComponents();
    }

    private void addUIComponents() {
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(0, 25, 520, 100);
        loginLabel.setForeground(Colors.TEXT_COLOR);
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);

        JLabel usernameLabel = new JLabel("Usuário:");
        usernameLabel.setBounds(30, 150, 400, 25);
        usernameLabel.setForeground(Colors.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        usernameField.setBounds(30, 185, 450, 55);
        usernameField.setBackground(Colors.SECONDARY_COLOR);
        usernameField.setForeground(Colors.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(usernameLabel);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(30, 335, 400, 25);
        passwordLabel.setForeground(Colors.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        passwordField.setBounds(30, 365, 450, 55);
        passwordField.setBackground(Colors.SECONDARY_COLOR);
        passwordField.setForeground(Colors.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passwordLabel);
        add(passwordField);

        loginButton.setFont(new Font("Dialog", Font.BOLD, 18));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBackground(Colors.TERTIARY_COLOR);
        loginButton.setForeground(Colors.SECONDARY_COLOR);
        loginButton.setBounds(125, 520, 250, 50);
        add(loginButton);
        loginButton.addActionListener(this);


        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setForeground(Colors.TEXT_COLOR);
        registerLabel.setBounds(125, 600, 250, 30);
        add(registerLabel);
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginForm.this.dispose();
                new RegisterForm().setVisible(true);
            }
        });
    }

    private Boolean checkUsernameAndPassword(String username, String password) {
        // Use a instância de userController para chamar loadJsonFile
        JSONArray users = registerController.loadJsonFile();

        for (int i = 0; i < users.length(); i++) {
            JSONObject user = users.getJSONObject(i);
            if (user.has("username") && user.getString("username").equals(username)) {
                String storedPassword = user.getString("password");
                return storedPassword.equals(password);
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (checkUsernameAndPassword(username, password)) {
                JOptionPane.showMessageDialog(LoginForm.this, "Login feito com sucesso!");
                LoginForm.this.dispose();
                new ContractsPage().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(LoginForm.this, "Usuário ou senha incorretos!");
            }
        }
    }
}