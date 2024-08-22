package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;
import br.ufrn.imd.Constants.CountryStates;
import br.ufrn.imd.Controllers.RegisterController;
import br.ufrn.imd.Models.Kitnet;
import br.ufrn.imd.Models.Owner;
import br.ufrn.imd.Models.Contract;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class RegisterForm extends MyFrame implements ActionListener {
    JTextField usernameField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField mailField = new JTextField();
    JTextField cpfField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField cepField = new JTextField();
    JComboBox<String> stateComboBox = new JComboBox<>(CountryStates.states);
    JTextField cityField = new JTextField();
    JTextField addressField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton registerButton = new JButton("Registrar");
    private final RegisterController userController;

    public RegisterForm() {
        super("Página de Registro");
        setSize(1280, 680);
        userController = new RegisterController();
        addUIcomponents();
    }

    private void addUIcomponents() {
        JLabel loginLabel = new JLabel("Cadastro");
        loginLabel.setBounds(370, 15, 520, 100);
        loginLabel.setForeground(Colors.TEXT_COLOR);
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);

        JLabel nameLabel = new JLabel("Nome Completo");
        nameLabel.setBounds(410, 120, 400, 25);
        nameLabel.setForeground(Colors.TEXT_COLOR);
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        nameField.setBounds(410, 155, 450, 25);
        nameField.setBackground(Colors.SECONDARY_COLOR);
        nameField.setForeground(Colors.TEXT_COLOR);
        nameField.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(nameLabel);
        add(nameField);

        JLabel usernameLabel = new JLabel("Nome de usuário");
        usernameLabel.setBounds(410, 190, 400, 25);
        usernameLabel.setForeground(Colors.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        usernameField.setBounds(410, 225, 220, 25);
        usernameField.setBackground(Colors.SECONDARY_COLOR);
        usernameField.setForeground(Colors.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(usernameLabel);
        add(usernameField);

        JLabel cpfLabel = new JLabel("CPF");
        cpfLabel.setBounds(640, 190, 400, 25);
        cpfLabel.setForeground(Colors.TEXT_COLOR);
        cpfLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(cpfLabel);

        JLabel phoneLabel = new JLabel("Nº de telefone");
        phoneLabel.setBounds(410, 255, 400, 25);
        phoneLabel.setForeground(Colors.TEXT_COLOR);
        phoneLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(phoneLabel);

        JLabel cepLabel = new JLabel("CEP");
        cepLabel.setBounds(640, 255, 400, 25);
        cepLabel.setForeground(Colors.TEXT_COLOR);
        cepLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(cepLabel);

        JLabel stateLabel = new JLabel("Estado:");
        stateLabel.setBounds(410, 315, 400, 25);
        stateLabel.setForeground(Colors.TEXT_COLOR);
        stateLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        stateComboBox.setBounds(410, 345, 220, 25);
        stateComboBox.setBackground(Colors.SECONDARY_COLOR);
        stateComboBox.setForeground(Colors.TEXT_COLOR);
        stateComboBox.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(stateLabel);
        add(stateComboBox);

        JLabel cityLabel = new JLabel("Cidade");
        cityLabel.setBounds(640, 315, 400, 25);
        cityLabel.setForeground(Colors.TEXT_COLOR);
        cityLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        cityField.setBounds(640, 345, 220, 25);
        cityField.setBackground(Colors.SECONDARY_COLOR);
        cityField.setForeground(Colors.TEXT_COLOR);
        cityField.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(cityLabel);
        add(cityField);

        JLabel addressLabel = new JLabel("Endereço");
        addressLabel.setBounds(410, 375, 400, 25);
        addressLabel.setForeground(Colors.TEXT_COLOR);
        addressLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        addressField.setBounds(410, 405, 450, 25);
        addressField.setBackground(Colors.SECONDARY_COLOR);
        addressField.setForeground(Colors.TEXT_COLOR);
        addressField.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(addressLabel);
        add(addressField);

        JLabel mailLabel = new JLabel("Seu e-mail");
        mailLabel.setBounds(410, 435, 400, 25);
        mailLabel.setForeground(Colors.TEXT_COLOR);
        mailLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        mailField.setBounds(410, 465, 450, 25);
        mailField.setBackground(Colors.SECONDARY_COLOR);
        mailField.setForeground(Colors.TEXT_COLOR);
        mailField.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(mailLabel);
        add(mailField);

        JLabel passwordLabel = new JLabel("Senha");
        passwordLabel.setBounds(410, 495, 400, 25);
        passwordLabel.setForeground(Colors.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        passwordField.setBounds(410, 525, 450, 25);
        passwordField.setBackground(Colors.SECONDARY_COLOR);
        passwordField.setForeground(Colors.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(passwordLabel);
        add(passwordField);

        try {
            MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
            cpfFormatter.setPlaceholderCharacter('_');
            cpfField = new JFormattedTextField(cpfFormatter);
            cpfField.setBounds(640, 225, 220, 25);
            cpfField.setBackground(Colors.SECONDARY_COLOR);
            cpfField.setForeground(Colors.TEXT_COLOR);
            cpfField.setFont(new Font("Dialog", Font.PLAIN, 18));
            add(cpfField);

            MaskFormatter phoneFieldFormatter = new MaskFormatter("(##)#####-####");
            phoneFieldFormatter.setPlaceholderCharacter('_');
            phoneField = new JFormattedTextField(phoneFieldFormatter);
            phoneField.setBounds(410, 285, 220, 25);
            phoneField.setBackground(Colors.SECONDARY_COLOR);
            phoneField.setForeground(Colors.TEXT_COLOR);
            phoneField.setFont(new Font("Dialog", Font.PLAIN, 18));
            add(phoneField);

            MaskFormatter cepFormatter = new MaskFormatter("#####-###");
            cepFormatter.setPlaceholderCharacter('_');
            cepField = new JFormattedTextField(cepFormatter);
            cepField.setBounds(640, 285, 220, 25);
            cepField.setBackground(Colors.SECONDARY_COLOR);
            cepField.setForeground(Colors.TEXT_COLOR);
            cepField.setFont(new Font("Dialog", Font.PLAIN, 18));
            add(cepField);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        registerButton.setFont(new Font("Dialog", Font.BOLD, 18));
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBackground(Colors.TERTIARY_COLOR);
        registerButton.setForeground(Colors.SECONDARY_COLOR);
        registerButton.setBounds(500, 590, 250, 50); // Mover 10px para cima
        add(registerButton);
        registerButton.addActionListener(this);
    }


    private void registerNewUser() {
        String cpf = cpfField.getText().replace(".", "").replace("-", "");
        String email = mailField.getText();

        // Verificar se o CPF já está registrado
        if (userController.isCpfRegistered(cpf)) {
            JOptionPane.showMessageDialog(this, "CPF já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar se o E-mail já está registrado
        if (userController.isMailRegistered(email)) {
            JOptionPane.showMessageDialog(this, "Email já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Supondo que você tenha os campos de entrada já definidos
        String name = nameField.getText();
        boolean logged = false;
        String state = (String) stateComboBox.getSelectedItem();
        String username = usernameField.getText();
        String telephone = phoneField.getText().replace("(", "").replace(")", "").replace("-", "");
        String cep = cepField.getText().replace("-", "");
        String address = addressField.getText();
        String password = new String(passwordField.getPassword());
        List<Contract> contracts = new ArrayList<>();
        List<Kitnet> kitnets = new ArrayList<>();

        Owner newUser = new Owner(name, cpf, logged, username, telephone, cep, address, email, password, state, contracts, kitnets);

        userController.addUser(newUser);
        JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
        RegisterForm.this.dispose();
        new LoginForm().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            registerNewUser();  // Chame a função de registro
        }
    }
}