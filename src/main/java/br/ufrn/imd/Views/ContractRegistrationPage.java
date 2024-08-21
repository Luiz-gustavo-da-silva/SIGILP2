package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;
import br.ufrn.imd.Controllers.ContractController;
import br.ufrn.imd.Controllers.KitnetController;
import br.ufrn.imd.Models.Kitnet;
//import br.ufrn.imd.Controllers.KitnetController;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ContractRegistrationPage extends MyFrame implements ActionListener {
    JTextField nameField = new JTextField();
    JTextField mailField = new JTextField();
    JTextField phoneField = new JTextField();
    JComboBox<String> kitnetComboBox = new JComboBox<>();
    JTextField rentField = new JTextField();
    JTextField startDateField = new JTextField();
    JTextField endDateField = new JTextField();
    JButton registerButton = new JButton("Cadastrar");
    JButton goBackButton = new JButton("Voltar");

    public List<Kitnet> listKitnet = new ArrayList<>();
    public ContractRegistrationPage() {
        super("Página de Registro");
        setSize(1280, 680);
        searchKitchenettes();
        addUIcomponents();
    }

    private void addUIcomponents() {

        goBackButton.setFont(new Font("Dialog", Font.BOLD, 14));
        goBackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        goBackButton.setBounds(1030, 10, 100, 30);
        goBackButton.setBackground(Colors.QUATERNARY_COLOR);
        goBackButton.setForeground(Colors.SECONDARY_COLOR);
        add(goBackButton);
        goBackButton.addActionListener(this);
        goBackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ContractRegistrationPage.this.dispose();
                new ContractsPage().setVisible(true);
            }
        });

        JLabel loginLabel = new JLabel("Cadastro de Contrato");
        loginLabel.setBounds(370, 25, 520, 100);
        loginLabel.setForeground(Colors.TEXT_COLOR);
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);

        JLabel nameLabel = new JLabel("Nome do Inquilino");
        nameLabel.setBounds(410, 130, 400, 25);
        nameLabel.setForeground(Colors.TEXT_COLOR);
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        nameField.setBounds(410, 165, 450, 25);
        nameField.setBackground(Colors.SECONDARY_COLOR);
        nameField.setForeground(Colors.TEXT_COLOR);
        nameField.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(nameLabel);
        add(nameField);

        JLabel mailLabel = new JLabel("Seu e-mail");
        mailLabel.setBounds(410, 200, 400, 25);
        mailLabel.setForeground(Colors.TEXT_COLOR);
        mailLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        mailField.setBounds(410, 235, 450, 25);
        mailField.setBackground(Colors.SECONDARY_COLOR);
        mailField.setForeground(Colors.TEXT_COLOR);
        mailField.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(mailLabel);
        add(mailField);

        JLabel phoneLabel = new JLabel("Nº de telefone");
        phoneLabel.setBounds(410, 265, 400, 25);
        phoneLabel.setForeground(Colors.TEXT_COLOR);
        phoneLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        try{
            MaskFormatter phoneFieldFormatter = new MaskFormatter("(##)#####-####"); //Formata o campo de data.
            phoneFieldFormatter.setPlaceholderCharacter('_'); //Enquanto não há nada digitado esse caractere é colocado.
            JFormattedTextField phoneField = new JFormattedTextField(phoneFieldFormatter);
            phoneField.setBounds(410, 295, 220, 25);
            phoneField.setBackground(Colors.SECONDARY_COLOR);
            phoneField.setForeground(Colors.TEXT_COLOR);
            phoneField.setFont(new Font("Dialog", Font.PLAIN, 18));

            add(phoneLabel);
            add(phoneField);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel kitnetLabel = new JLabel("Kitnet");
        kitnetLabel.setBounds(640, 265, 400, 25);
        kitnetLabel.setForeground(Colors.TEXT_COLOR);
        kitnetLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        kitnetComboBox.setBounds(640, 295, 220, 25);
        kitnetComboBox.setBackground(Colors.SECONDARY_COLOR);
        kitnetComboBox.setForeground(Colors.TEXT_COLOR);
        kitnetComboBox.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Popula o JComboBox com os nomes das Kitnets
        for (Kitnet kitnet : listKitnet) {
            kitnetComboBox.addItem(kitnet.getNameKitnet());
        }

        add(kitnetLabel);
        add(kitnetComboBox);

        JLabel rentLabel = new JLabel("V. Aluguel:");
        rentLabel.setBounds(410, 325, 400, 25);
        rentLabel.setForeground(Colors.TEXT_COLOR);
        rentLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        rentField.setBounds(410, 355, 220, 25);
        rentField.setBackground(Colors.SECONDARY_COLOR);
        rentField.setForeground(Colors.TEXT_COLOR);
        rentField.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(rentLabel);
        add(rentField);

        JLabel startDateLabel = new JLabel("Data de início do contrato");
        startDateLabel.setBounds(640, 325, 400, 25);
        startDateLabel.setForeground(Colors.TEXT_COLOR);
        startDateLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        try{
            MaskFormatter startDateFormatter = new MaskFormatter("##/##/####"); //Formata o campo de data.
            startDateFormatter.setPlaceholderCharacter('_'); //Enquanto não há nada digitado esse caractere é colocado.
            JFormattedTextField startDateField = new JFormattedTextField(startDateFormatter);
            startDateField.setBounds(640, 355, 220, 25);
            startDateField.setBackground(Colors.SECONDARY_COLOR);
            startDateField.setForeground(Colors.TEXT_COLOR);
            startDateField.setFont(new Font("Dialog", Font.PLAIN, 18));

            add(startDateLabel);
            add(startDateField);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        JLabel endDateLabel = new JLabel("Data de fim do contrato");
        endDateLabel.setBounds(410, 385, 400, 25);
        endDateLabel.setForeground(Colors.TEXT_COLOR);
        endDateLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        try{
            MaskFormatter endDateFormatter = new MaskFormatter("##/##/####"); //Formata o campo de data.
            endDateFormatter.setPlaceholderCharacter('_'); //Enquanto não há nada digitado esse caractere é colocado.
            JFormattedTextField endDateField = new JFormattedTextField(endDateFormatter);
            endDateField.setBounds(410, 415, 220, 25);
            endDateField.setBackground(Colors.SECONDARY_COLOR);
            endDateField.setForeground(Colors.TEXT_COLOR);
            endDateField.setFont(new Font("Dialog", Font.PLAIN, 18));

            add(endDateLabel);
            add(endDateField);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        registerButton.setFont(new Font("Dialog", Font.BOLD, 18));
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBackground(Colors.TERTIARY_COLOR);
        registerButton.setForeground(Colors.SECONDARY_COLOR);
        registerButton.setBounds(500, 455, 250, 50);
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
            JOptionPane.showMessageDialog(ContractRegistrationPage.this, "Cadastro realizado com sucesso!");
            ContractRegistrationPage.this.dispose();
            new ContractsPage().setVisible(true);
        }
    }

    public void searchKitchenettes(){
        KitnetController kitnetController = new KitnetController();
        listKitnet = kitnetController.recoverKitchenettes();
    }
}