package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;
import br.ufrn.imd.Constants.CountryStates;
import br.ufrn.imd.Controllers.KitnetController;
import br.ufrn.imd.Enums.SystemMessage;
import br.ufrn.imd.Models.Kitnet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.UUID;

public class KitnetEditPage extends MyFrame implements ActionListener {

    JButton updateButton = new JButton("Atualizar");
    JTextField mobiliaField = new JTextField();
    JTextField cepField = new JTextField();
    JTextField estadoField = new JTextField();
    JTextField estadoUsoField = new JTextField();
    JTextField cidadeField = new JTextField();
    JTextField enderecoField = new JTextField();
    JTextField nameKitnetField = new JTextField();

    JComboBox<String> stateComboBox = new JComboBox<>(CountryStates.states);
    
    UUID nKitnetUUID;
    Kitnet kitnetEdit = new Kitnet();

    JButton goBackButton = new JButton("Voltar");

    JButton kitnetsPageButton = new JButton("Kitnets");

    public KitnetEditPage(UUID nKitnetUUID) {
        super("Editar Kitnet");
        setSize(1280, 680);
        this.nKitnetUUID = nKitnetUUID;
        searchKitnet();
        addUIComponents();
    }

    /**
     * Método responsável por adicionar e configurar os componentes da interface de usuário.
     * Este método cria labels e campos de texto para cada atributo de uma kitnet, e também
     * configura o botão de registro.
     */
    private void addUIComponents() {

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
                KitnetEditPage.this.dispose();
                new KitnetsPage().setVisible(true);
            }
        });

        kitnetsPageButton.setFont(new Font("Dialog", Font.BOLD, 14));
        kitnetsPageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        kitnetsPageButton.setBounds(1030, 10, 100, 30);
        kitnetsPageButton.setBackground(Colors.QUATERNARY_COLOR);
        kitnetsPageButton.setForeground(Colors.SECONDARY_COLOR);
        add(kitnetsPageButton);
        kitnetsPageButton.addActionListener(this);
        kitnetsPageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KitnetEditPage.this.dispose();
                new KitnetsPage().setVisible(true);
            }
        });

        JLabel loginLabel = new JLabel("Editar Kitnet");
        loginLabel.setBounds(360, 25, 520, 100);
        loginLabel.setForeground(Colors.TEXT_COLOR);
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);

        JLabel nameKitnetLabel = new JLabel("Nome da Kitnet:");
        nameKitnetLabel.setBounds(410, 135, 400, 25);
        nameKitnetLabel.setForeground(Colors.TEXT_COLOR);
        nameKitnetLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        nameKitnetField.setBounds(410, 170, 220, 25);
        nameKitnetField.setBackground(Colors.SECONDARY_COLOR);
        nameKitnetField.setForeground(Colors.TEXT_COLOR);
        nameKitnetField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel mobiliaLabel = new JLabel("Mobília:");
        mobiliaLabel.setBounds(640, 135, 400, 25);
        mobiliaLabel.setForeground(Colors.TEXT_COLOR);
        mobiliaLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        mobiliaField.setBounds(640, 170, 220, 25);
        mobiliaField.setBackground(Colors.SECONDARY_COLOR);
        mobiliaField.setForeground(Colors.TEXT_COLOR);
        mobiliaField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel estadoUsoLabel = new JLabel("Estado de Uso:");
        estadoUsoLabel.setBounds(640, 200, 400, 25);
        estadoUsoLabel.setForeground(Colors.TEXT_COLOR);
        estadoUsoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        estadoUsoField.setBounds(640, 235, 220, 25);
        estadoUsoField.setBackground(Colors.SECONDARY_COLOR);
        estadoUsoField.setForeground(Colors.TEXT_COLOR);
        estadoUsoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel cepLabel = new JLabel("CEP:");
        cepLabel.setBounds(410, 200, 220, 25);
        cepLabel.setForeground(Colors.TEXT_COLOR);
        cepLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        cepField.setBounds(410, 235, 220, 25);
        cepField.setBackground(Colors.SECONDARY_COLOR);
        cepField.setForeground(Colors.TEXT_COLOR);
        cepField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel estadoLabel = new JLabel("Estado:");
        estadoLabel.setBounds(410, 265, 400, 25);
        estadoLabel.setForeground(Colors.TEXT_COLOR);
        estadoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        /*estadoField.setBounds(640, 295, 220, 25);
        estadoField.setBackground(Colors.SECONDARY_COLOR);
        estadoField.setForeground(Colors.TEXT_COLOR);
        estadoField.setFont(new Font("Dialog", Font.PLAIN, 24));*/

        stateComboBox.setBounds(410, 295, 220, 25);
        stateComboBox.setBackground(Colors.SECONDARY_COLOR);
        stateComboBox.setForeground(Colors.TEXT_COLOR);
        stateComboBox.setFont(new Font("Dialog", Font.PLAIN, 18));

        JLabel cidadeLabel = new JLabel("Cidade:");
        cidadeLabel.setBounds(640, 265, 400, 25);
        cidadeLabel.setForeground(Colors.TEXT_COLOR);
        cidadeLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        cidadeField.setBounds(640, 295, 220, 25);
        cidadeField.setBackground(Colors.SECONDARY_COLOR);
        cidadeField.setForeground(Colors.TEXT_COLOR);
        cidadeField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoLabel.setBounds(410, 330, 220, 25);
        enderecoLabel.setForeground(Colors.TEXT_COLOR);
        enderecoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        enderecoField.setBounds(410, 360, 450, 25);
        enderecoField.setBackground(Colors.SECONDARY_COLOR);
        enderecoField.setForeground(Colors.TEXT_COLOR);
        enderecoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        updateButton.setFont(new Font("Dialog", Font.BOLD, 18));
        updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateButton.setBackground(Colors.TERTIARY_COLOR);
        updateButton.setForeground(Colors.SECONDARY_COLOR);
        updateButton.setBounds(500, 470, 250, 50);

        add(mobiliaLabel);
        add(mobiliaField);
        add(estadoUsoLabel);
        add(estadoUsoField);
        add(cepLabel);
        add(cepField);
        add(estadoLabel);
        add(stateComboBox);
        add(estadoField);
        add(cidadeLabel);
        add(cidadeField);
        add(enderecoLabel);
        add(enderecoField);
        add(nameKitnetLabel);
        add(nameKitnetField);
        add(updateButton);

        updateButton.addActionListener(this);
        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int a = 0;
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateButton){
            updateKitnet();
            KitnetEditPage.this.dispose();
            new KitnetsPage().setVisible(true);
        }
    }

    public void updateKitnet(){
        String furniture = mobiliaField.getText().trim();
        String stateOfUse = estadoUsoField.getText().trim();
        String cep = cepField.getText().trim();
        String state = (String) stateComboBox.getSelectedItem();
        String city = cidadeField.getText().trim();
        String address = enderecoField.getText().trim();
        String nameKitnet = nameKitnetField.getText().trim();
        UUID nKitnetUUID = kitnetEdit.getnKitnetUUID();
        boolean success = false;

        Kitnet kitnet = new Kitnet(nKitnetUUID, furniture, stateOfUse, cep, state, city, address, nameKitnet);

        KitnetController kitnetController = new KitnetController();

        success = kitnetController.editKitnet(kitnet);

        if(success){
            JOptionPane.showMessageDialog(null, SystemMessage.KITNET_UPDATE_SUCCESS.getMessage());
        }else{
            JOptionPane.showMessageDialog(null, SystemMessage.KITNET_UPDATE_ERROR.getMessage());
        }
    }

    public void searchKitnet(){
        KitnetController kitnetController = new KitnetController();
        kitnetEdit = kitnetController.searchKitnet(nKitnetUUID);

        if (kitnetEdit != null) {
            mobiliaField.setText(kitnetEdit.getFurniture());
            cepField.setText(kitnetEdit.getCep());
            /*estadoField.setText(kitnetEdit.getState());*/
            estadoUsoField.setText(kitnetEdit.getStateOfUse());
            cidadeField.setText(kitnetEdit.getCity());
            enderecoField.setText(kitnetEdit.getAddress());
            nameKitnetField.setText(kitnetEdit.getNameKitnet());
            String state = kitnetEdit.getState();
            stateComboBox.setSelectedItem(state);
        } else {
            JOptionPane.showMessageDialog(this, SystemMessage.KITNET_NOT_FOUND.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
}
