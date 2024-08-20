package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;
import br.ufrn.imd.Controllers.KitnetController;
import br.ufrn.imd.Models.Kitnet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KitnetEditPage extends MyFrame implements ActionListener {

    JButton updateButton = new JButton("Atualizar");
    JTextField nKitnetField = new JTextField();
    JTextField mobiliaField = new JTextField();
    JTextField inquilinoAlocadoField = new JTextField();
    JTextField cepField = new JTextField();
    JTextField estadoField = new JTextField();
    JTextField estadoUsoField = new JTextField();
    JTextField cidadeField = new JTextField();
    JTextField enderecoField = new JTextField();
    JTextField nContratoField = new JTextField();
    int nKitnet;
    Kitnet kitnetEdit = new Kitnet();

    JButton exitButton = new JButton("Sair");

    JButton kitnetsPageButton = new JButton("Kitnets");

    public KitnetEditPage(int nKitnet) {
        super("Editar Kitnet");
        setSize(1280, 680);
        this.nKitnet = nKitnet;
        searchKitnet();
        addUIComponents();
    }

    /**
     * Método responsável por adicionar e configurar os componentes da interface de usuário.
     * Este método cria labels e campos de texto para cada atributo de uma kitnet, e também
     * configura o botão de registro.
     */
    private void addUIComponents() {

        exitButton.setFont(new Font("Dialog", Font.BOLD, 14));
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exitButton.setBounds(1150, 10, 70, 30);
        exitButton.setBackground(Colors.QUATERNARY_COLOR);
        exitButton.setForeground(Colors.SECONDARY_COLOR);
        add(exitButton);
        exitButton.addActionListener(this);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KitnetEditPage.this.dispose();
                new LoginForm().setVisible(true);
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


        JLabel nKitnetLabel = new JLabel("N° Kitnet:");
        nKitnetLabel.setBounds(30, 45, 200, 25);
        nKitnetLabel.setForeground(Colors.TEXT_COLOR);
        nKitnetLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        nKitnetField.setBounds(30, 75, 400, 55);
        nKitnetField.setBackground(Colors.SECONDARY_COLOR);
        nKitnetField.setForeground(Colors.TEXT_COLOR);
        nKitnetField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel mobiliaLabel = new JLabel("Mobília:");
        mobiliaLabel.setBounds(460, 45, 200, 25);
        mobiliaLabel.setForeground(Colors.TEXT_COLOR);
        mobiliaLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        mobiliaField.setBounds(460, 75, 400, 55);
        mobiliaField.setBackground(Colors.SECONDARY_COLOR);
        mobiliaField.setForeground(Colors.TEXT_COLOR);
        mobiliaField.setFont(new Font("Dialog", Font.PLAIN, 24));

        /*JLabel nContratoLabel = new JLabel("Número do Contrato:");
        nContratoLabel.setBounds(30, 245, 200, 25);
        nContratoLabel.setForeground(Colors.TEXT_COLOR);
        nContratoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        nContratoField.setBounds(30, 275, 400, 55);
        nContratoField.setBackground(Colors.SECONDARY_COLOR);
        nContratoField.setForeground(Colors.TEXT_COLOR);
        nContratoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel inquilinoAlocadoLabel = new JLabel("Inquilino Alocado:");
        inquilinoAlocadoLabel.setBounds(30, 145, 200, 25);
        inquilinoAlocadoLabel.setForeground(Colors.TEXT_COLOR);
        inquilinoAlocadoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        inquilinoAlocadoField.setBounds(30, 175, 400, 55);
        inquilinoAlocadoField.setBackground(Colors.SECONDARY_COLOR);
        inquilinoAlocadoField.setForeground(Colors.TEXT_COLOR);
        inquilinoAlocadoField.setFont(new Font("Dialog", Font.PLAIN, 24));*/

        JLabel estadoUsoLabel = new JLabel("Estado de Uso:");
        estadoUsoLabel.setBounds(460, 145, 200, 25);
        estadoUsoLabel.setForeground(Colors.TEXT_COLOR);
        estadoUsoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        estadoUsoField.setBounds(460, 175, 400, 55);
        estadoUsoField.setBackground(Colors.SECONDARY_COLOR);
        estadoUsoField.setForeground(Colors.TEXT_COLOR);
        estadoUsoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel cepLabel = new JLabel("CEP:");
        cepLabel.setBounds(30, 345, 200, 25);
        cepLabel.setForeground(Colors.TEXT_COLOR);
        cepLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        cepField.setBounds(30, 375, 400, 55);
        cepField.setBackground(Colors.SECONDARY_COLOR);
        cepField.setForeground(Colors.TEXT_COLOR);
        cepField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel estadoLabel = new JLabel("Estado:");
        estadoLabel.setBounds(460, 345, 200, 25);
        estadoLabel.setForeground(Colors.TEXT_COLOR);
        estadoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        estadoField.setBounds(460, 375, 400, 55);
        estadoField.setBackground(Colors.SECONDARY_COLOR);
        estadoField.setForeground(Colors.TEXT_COLOR);
        estadoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel cidadeLabel = new JLabel("Cidade:");
        cidadeLabel.setBounds(30, 445, 200, 25);
        cidadeLabel.setForeground(Colors.TEXT_COLOR);
        cidadeLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        cidadeField.setBounds(30, 475, 400, 55);
        cidadeField.setBackground(Colors.SECONDARY_COLOR);
        cidadeField.setForeground(Colors.TEXT_COLOR);
        cidadeField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoLabel.setBounds(460, 445, 200, 25);
        enderecoLabel.setForeground(Colors.TEXT_COLOR);
        enderecoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        enderecoField.setBounds(460, 475, 400, 55);
        enderecoField.setBackground(Colors.SECONDARY_COLOR);
        enderecoField.setForeground(Colors.TEXT_COLOR);
        enderecoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        updateButton.setFont(new Font("Dialog", Font.BOLD, 18));
        updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateButton.setBackground(Colors.TERTIARY_COLOR);
        updateButton.setForeground(Colors.SECONDARY_COLOR);
        updateButton.setBounds(350, 550, 250, 50);

        add(nKitnetLabel);
        add(nKitnetField);
        add(mobiliaLabel);
        add(mobiliaField);
        /*add(inquilinoAlocadoLabel);
        add(inquilinoAlocadoField);*/
        add(estadoUsoLabel);
        add(estadoUsoField);
        add(cepLabel);
        add(cepField);
        add(estadoLabel);
        add(estadoField);
        add(cidadeLabel);
        add(cidadeField);
        add(enderecoLabel);
        add(enderecoField);
        /*add(nContratoLabel);
        add(nContratoField);*/
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
        int nKitnet = Integer.parseInt(nKitnetField.getText().trim());
        String furniture = mobiliaField.getText().trim();
        String tenantName = kitnetEdit.getTenantName();
        String stateOfUse = estadoUsoField.getText().trim();
        String cep = cepField.getText().trim();
        String state = estadoField.getText().trim();
        String city = cidadeField.getText().trim();
        String address = enderecoField.getText().trim();
        int nContract = kitnetEdit.getnContract();
        boolean success = false;

        Kitnet kitnet = new Kitnet(nKitnet, furniture, tenantName, stateOfUse, cep, state, city, address, nContract);

        KitnetController kitnetController = new KitnetController();

        success = kitnetController.editKitnet(kitnet);

        if(success){
            JOptionPane.showMessageDialog(null, "A kitnet foi atualizada os valores de inquilino e número do contrato permanecem os mesmo do registrado no contrato!");
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao atualizar kitnet, por favor tente outra vez!");
        }
    }

    public void searchKitnet(){
        KitnetController kitnetController = new KitnetController();
        kitnetEdit = kitnetController.searchKitnet(nKitnet);

        if (kitnetEdit != null) {
            nKitnetField.setText(String.valueOf(kitnetEdit.getNKitnet()));
            nKitnetField.setEnabled(false);
            mobiliaField.setText(kitnetEdit.getFurniture());
            inquilinoAlocadoField.setText(kitnetEdit.getTenantName());
            cepField.setText(kitnetEdit.getCep());
            estadoField.setText(kitnetEdit.getState());
            estadoUsoField.setText(kitnetEdit.getStateOfUse());
            cidadeField.setText(kitnetEdit.getCity());
            enderecoField.setText(kitnetEdit.getAddress());
            nContratoField.setText(String.valueOf(kitnetEdit.getnContract() == -1 ? "" : kitnetEdit.getnContract()));
        } else {
            JOptionPane.showMessageDialog(this, "Kitnet não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

