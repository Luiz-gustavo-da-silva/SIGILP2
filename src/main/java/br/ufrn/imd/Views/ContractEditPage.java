package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;
import br.ufrn.imd.Constants.Status;
import br.ufrn.imd.Controllers.ContractController;
import br.ufrn.imd.Controllers.KitnetController;
import br.ufrn.imd.Models.Contract;
import br.ufrn.imd.Models.Kitnet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.List;

public class ContractEditPage extends MyFrame {

    JButton updateButton = new JButton("Atualizar");
    JTextField tenantNameField = new JTextField();
    JTextField tenantEmailField = new JTextField();
    JTextField tenantPhoneNumberField = new JTextField();
    JTextField startDateField = new JTextField();
    JTextField endDateField = new JTextField();
    JTextField rentAmountField = new JTextField();
    JTextField adjustmentField = new JTextField();

    JButton goBackButton = new JButton("Voltar");
    JButton contractsPageButton = new JButton("Contratos");

    ContractController cc = new ContractController();
    UUID nContractUUID;
    Contract contract;

    KitnetController kc = new KitnetController();
    List<Kitnet> kitchenettes = kc.recoverKitchenettes();
    List<String> kitchenettesNames = kc.getKitchenettesNames(kitchenettes);

    JComboBox<String> statusComboBox = new JComboBox<>(Status.status);

    JComboBox<String> kitnetNameComboBox = new JComboBox<>();

    public ContractEditPage(UUID nContractUUID, Contract contract) {
        super("Editar Contrato");
        setSize(1280, 680);
        this.nContractUUID = nContractUUID;
        this.contract = contract;
        addUIComponents();
    }

    private void addUIComponents() {

        goBackButton.setFont(new Font("Dialog", Font.BOLD, 14));
        goBackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        goBackButton.setBounds(1030, 10, 100, 30);
        goBackButton.setBackground(Colors.QUATERNARY_COLOR);
        goBackButton.setForeground(Colors.SECONDARY_COLOR);
        add(goBackButton);
        goBackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ContractEditPage.this.dispose();
                new ContractsPage().setVisible(true);
            }
        });

        contractsPageButton.setFont(new Font("Dialog", Font.BOLD, 14));
        contractsPageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contractsPageButton.setBounds(1030, 10, 100, 30);
        contractsPageButton.setBackground(Colors.QUATERNARY_COLOR);
        contractsPageButton.setForeground(Colors.SECONDARY_COLOR);
        add(contractsPageButton);
        contractsPageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ContractEditPage.this.dispose();
                new ContractsPage().setVisible(true);
            }
        });

        JLabel titleLabel = new JLabel("Editar Contrato");
        titleLabel.setBounds(360, 25, 520, 100);
        titleLabel.setForeground(Colors.TEXT_COLOR);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        JLabel tenantNameLabel = new JLabel("Nome do Inquilino:");
        tenantNameLabel.setBounds(410, 175, 220, 25);
        tenantNameLabel.setForeground(Colors.TEXT_COLOR);
        tenantNameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        tenantNameField.setBounds(410, 210, 220, 25);
        tenantNameField.setBackground(Colors.SECONDARY_COLOR);
        tenantNameField.setForeground(Colors.TEXT_COLOR);
        tenantNameField.setFont(new Font("Dialog", Font.PLAIN, 18));

        JLabel tenantEmailLabel = new JLabel("Email do Inquilino:");
        tenantEmailLabel.setBounds(640, 175, 220, 25);
        tenantEmailLabel.setForeground(Colors.TEXT_COLOR);
        tenantEmailLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        tenantEmailField.setBounds(640, 210, 220, 25);
        tenantEmailField.setBackground(Colors.SECONDARY_COLOR);
        tenantEmailField.setForeground(Colors.TEXT_COLOR);
        tenantEmailField.setFont(new Font("Dialog", Font.PLAIN, 18));

        JLabel tenantPhoneNumberLabel = new JLabel("Telefone do Inquilino:");
        tenantPhoneNumberLabel.setBounds(410, 245, 220, 25);
        tenantPhoneNumberLabel.setForeground(Colors.TEXT_COLOR);
        tenantPhoneNumberLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        tenantPhoneNumberField.setBounds(410, 280, 220, 25);
        tenantPhoneNumberField.setBackground(Colors.SECONDARY_COLOR);
        tenantPhoneNumberField.setForeground(Colors.TEXT_COLOR);
        tenantPhoneNumberField.setFont(new Font("Dialog", Font.PLAIN, 18));

        JLabel startDateLabel = new JLabel("Data de Início:");
        startDateLabel.setBounds(640, 245, 220, 25);
        startDateLabel.setForeground(Colors.TEXT_COLOR);
        startDateLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        startDateField.setBounds(640, 280, 220, 25);
        startDateField.setBackground(Colors.SECONDARY_COLOR);
        startDateField.setForeground(Colors.TEXT_COLOR);
        startDateField.setFont(new Font("Dialog", Font.PLAIN, 18));

        JLabel endDateLabel = new JLabel("Data de Término:");
        endDateLabel.setBounds(410, 315, 220, 25);
        endDateLabel.setForeground(Colors.TEXT_COLOR);
        endDateLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        endDateField.setBounds(410, 350, 220, 25);
        endDateField.setBackground(Colors.SECONDARY_COLOR);
        endDateField.setForeground(Colors.TEXT_COLOR);
        endDateField.setFont(new Font("Dialog", Font.PLAIN, 18));

        JLabel rentAmountLabel = new JLabel("Valor do Aluguel:");
        rentAmountLabel.setBounds(640, 315, 220, 25);
        rentAmountLabel.setForeground(Colors.TEXT_COLOR);
        rentAmountLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        rentAmountField.setBounds(640, 350, 220, 25);
        rentAmountField.setBackground(Colors.SECONDARY_COLOR);
        rentAmountField.setForeground(Colors.TEXT_COLOR);
        rentAmountField.setFont(new Font("Dialog", Font.PLAIN, 18));

        JLabel adjustmentLabel = new JLabel("Ajuste:");
        adjustmentLabel.setBounds(410, 385, 220, 25);
        adjustmentLabel.setForeground(Colors.TEXT_COLOR);
        adjustmentLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        adjustmentField.setBounds(410, 420, 220, 25);
        adjustmentField.setBackground(Colors.SECONDARY_COLOR);
        adjustmentField.setForeground(Colors.TEXT_COLOR);
        adjustmentField.setFont(new Font("Dialog", Font.PLAIN, 18));

        setTextFields();

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(640, 385, 220, 25);
        statusLabel.setForeground(Colors.TEXT_COLOR);
        statusLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        statusComboBox.setBounds(640, 420, 220, 25);
        statusComboBox.setBackground(Colors.SECONDARY_COLOR);
        statusComboBox.setForeground(Colors.TEXT_COLOR);
        statusComboBox.setFont(new Font("Dialog", Font.PLAIN, 18));
        statusComboBox.setSelectedItem(contract.getStatus());

        JLabel kitnetNameLabel = new JLabel("Kitnet:");
        kitnetNameLabel.setBounds(410, 455, 450, 25);
        kitnetNameLabel.setForeground(Colors.TEXT_COLOR);
        kitnetNameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));


        kitnetNameComboBox.setBounds(410, 490, 450, 25);
        kitnetNameComboBox.setBackground(Colors.SECONDARY_COLOR);
        kitnetNameComboBox.setForeground(Colors.TEXT_COLOR);
        kitnetNameComboBox.setFont(new Font("Dialog", Font.PLAIN, 18));
        for (String name : kitchenettesNames) {
            kitnetNameComboBox.addItem(name);
        }
        kitnetNameComboBox.setSelectedItem(kc.getKitnetName(kitchenettes, contract.getnKitnetUUID()));

        updateButton.setFont(new Font("Dialog", Font.BOLD, 18));
        updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateButton.setBackground(Colors.TERTIARY_COLOR);
        updateButton.setForeground(Colors.SECONDARY_COLOR);
        updateButton.setBounds(500, 550, 250, 50);

        add(tenantNameLabel);
        add(tenantNameField);
        add(tenantEmailLabel);
        add(tenantEmailField);
        add(tenantPhoneNumberLabel);
        add(tenantPhoneNumberField);
        add(startDateLabel);
        add(startDateField);
        add(endDateLabel);
        add(endDateField);
        add(rentAmountLabel);
        add(rentAmountField);
        add(adjustmentLabel);
        add(adjustmentField);
        add(statusLabel);
        add(statusComboBox);
        add(updateButton);
        add(kitnetNameLabel);
        add(kitnetNameComboBox);

        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    editContract();
                    ContractEditPage.this.dispose();
                    new ContractsPage().setVisible(true);
                } catch (IOException | ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao editar o contrato: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void editContract () throws IOException, ParseException{

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String tenantName = tenantNameField.getText().trim();
        String tenantEmail = tenantEmailField.getText().trim();
        String tenantPhoneNumber = tenantPhoneNumberField.getText().trim();
        Date startDate = formatter.parse(startDateField.getText().trim()) ;
        Date endDate = formatter.parse(endDateField.getText().trim()) ;
        double rentAmount = Double.parseDouble(rentAmountField.getText().trim());
        double adjustment = Double.parseDouble(adjustmentField.getText().trim());
        String status = (String) statusComboBox.getSelectedItem();
        String selectedKitnetName = (String) kitnetNameComboBox.getSelectedItem();
        UUID selectedKitnetUUID = kc.getKitnetUUID(kitchenettes, selectedKitnetName);

        Contract updatedContract = new Contract(nContractUUID, tenantName, tenantEmail,
                tenantPhoneNumber, selectedKitnetUUID, startDate, endDate, rentAmount, adjustment, status);
        boolean res = cc.editContract(contract.getnContractUUID(), updatedContract);
        if (res) {
            System.out.println("Contrato existente e editado com sucesso.");
        }
    }

    public void setTextFields(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        tenantNameField.setText(contract.getTenantName());
        tenantEmailField.setText(contract.getTenantEmail());
        tenantPhoneNumberField.setText(contract.getTenantPhoneNumber());
        startDateField.setText(dateFormat.format(contract.getStartDate()));
        endDateField.setText(dateFormat.format(contract.getEndDate()));
        rentAmountField.setText(Double.toString(contract.getRentAmount()));
        adjustmentField.setText(Double.toString(contract.getAdjustment()));
    }
}
