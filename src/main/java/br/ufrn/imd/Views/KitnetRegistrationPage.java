package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;
import br.ufrn.imd.Constants.CountryStates;
import br.ufrn.imd.Controllers.KitnetController;
import br.ufrn.imd.Models.Kitnet;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

/**
 * A classe `kitnetRegistrationPage` representa a página de cadastro de kitnets.
 * Esta classe herda de `MyFrame` e implementa a interface `ActionListener` para
 * tratar eventos de ação, como cliques de botão.
 */
public class KitnetRegistrationPage extends MyFrame implements ActionListener {
    JButton salvarButton = new JButton("Adicionar");
    JTextField nKitnetField = new JTextField();
    JTextField mobiliaField = new JTextField();
    JTextField inquilinoAlocadoField = new JTextField();
    JTextField cepField = new JTextField();
    JTextField estadoField = new JTextField();
    JComboBox<String> stateComboBox = new JComboBox<>(CountryStates.states);
    JTextField estadoUsoField = new JTextField();
    JTextField cidadeField = new JTextField();
    JTextField enderecoField = new JTextField();
    JTextField nContratoField = new JTextField();
    JTextField nameKitnetField = new JTextField();

    JButton goBackButton = new JButton("Voltar");

    /**
     * Construtor da classe `kitnetRegistrationPage`.
     * Inicializa a interface de usuário e configura a janela.
     */
    public KitnetRegistrationPage() {
        super("Cadastrar Kitnet");
        setSize(1280, 680);
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
                KitnetRegistrationPage.this.dispose();
                new KitnetsPage().setVisible(true);
            }
        });

        JLabel loginLabel = new JLabel("Cadastro de Kitnet");
        loginLabel.setBounds(370, 25, 520, 100);
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

        /*JLabel nKitnetLabel = new JLabel("N° Kitnet:");
        nKitnetLabel.setBounds(410, 135, 400, 25);
        nKitnetLabel.setForeground(Colors.TEXT_COLOR);
        nKitnetLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        nKitnetField.setBounds(410, 170, 220, 25);
        nKitnetField.setBackground(Colors.SECONDARY_COLOR);
        nKitnetField.setForeground(Colors.TEXT_COLOR);
        nKitnetField.setFont(new Font("Dialog", Font.PLAIN, 24));*/

        JLabel mobiliaLabel = new JLabel("Mobília:");
        mobiliaLabel.setBounds(640, 135, 400, 25);
        mobiliaLabel.setForeground(Colors.TEXT_COLOR);
        mobiliaLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        mobiliaField.setBounds(640, 170, 220, 25);
        mobiliaField.setBackground(Colors.SECONDARY_COLOR);
        mobiliaField.setForeground(Colors.TEXT_COLOR);
        mobiliaField.setFont(new Font("Dialog", Font.PLAIN, 24));

        /*JLabel nContratoLabel = new JLabel("Número do Contrato:");
        nContratoLabel.setBounds(30, 145, 200, 25);
        nContratoLabel.setForeground(Colors.TEXT_COLOR);
        nContratoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        nContratoField.setBounds(30, 175, 400, 55);
        nContratoField.setBackground(Colors.SECONDARY_COLOR);
        nContratoField.setForeground(Colors.TEXT_COLOR);
        nContratoField.setFont(new Font("Dialog", Font.PLAIN, 24));*/

        /*JLabel inquilinoAlocadoLabel = new JLabel("Inquilino Alocado:");
        inquilinoAlocadoLabel.setBounds(30, 145, 200, 25);
        JLabel inquilinoAlocadoLabel = new JLabel("Inquilino Alocado:");
        inquilinoAlocadoLabel.setBounds(410, 200, 400, 25);
        inquilinoAlocadoLabel.setForeground(Colors.TEXT_COLOR);
        inquilinoAlocadoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        inquilinoAlocadoField.setBounds(410, 235, 220, 25);
        inquilinoAlocadoField.setBackground(Colors.SECONDARY_COLOR);
        inquilinoAlocadoField.setForeground(Colors.TEXT_COLOR);
        inquilinoAlocadoField.setFont(new Font("Dialog", Font.PLAIN, 24));*/

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

        try {
            MaskFormatter cepFormatter = new MaskFormatter("#####-###");
            cepFormatter.setPlaceholderCharacter('_');
            JFormattedTextField cepField = new JFormattedTextField(cepFormatter);
            cepField.setBounds(410, 235, 220, 25);
            cepField.setBackground(Colors.SECONDARY_COLOR);
            cepField.setForeground(Colors.TEXT_COLOR);
            cepField.setFont(new Font("Dialog", Font.PLAIN, 18));

            add(cepLabel);
            add(cepField);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel estadoLabel = new JLabel("Estado:");
        estadoLabel.setBounds(410, 265, 400, 25);
        estadoLabel.setForeground(Colors.TEXT_COLOR);
        estadoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

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
        enderecoLabel.setBounds(410, 330, 200, 25);
        enderecoLabel.setForeground(Colors.TEXT_COLOR);
        enderecoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        enderecoField.setBounds(410, 360, 450, 25);
        enderecoField.setBackground(Colors.SECONDARY_COLOR);
        enderecoField.setForeground(Colors.TEXT_COLOR);
        enderecoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        salvarButton.setFont(new Font("Dialog", Font.BOLD, 18));
        salvarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        salvarButton.setBackground(Colors.TERTIARY_COLOR);
        salvarButton.setForeground(Colors.SECONDARY_COLOR);
        salvarButton.setBounds(500, 470, 250, 50);

        /*add(nKitnetLabel);
        add(nKitnetField);*/
        add(mobiliaLabel);
        add(mobiliaField);
        /*add(inquilinoAlocadoLabel);
        add(inquilinoAlocadoField);*/
        add(estadoUsoLabel);
        add(estadoUsoField);
        add(cepLabel);
        add(cepField);
        add(estadoLabel);
        add(stateComboBox);
        add(cidadeLabel);
        add(cidadeField);
        add(enderecoLabel);
        add(enderecoField);
        add(nameKitnetLabel);
        add(nameKitnetField);
        /*add(nContratoLabel);
        add(nContratoField);*/
        add(salvarButton);
        salvarButton.addActionListener(this);
        salvarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
    }

    /**
     * Método de tratamento de eventos de ação.
     * Este método é chamado quando o botão de salvar é clicado.
     *
     * @param e O evento de ação.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salvarButton){
            saveKitnet();
            KitnetRegistrationPage.this.dispose();
            new KitnetsPage().setVisible(true);
        }
    }

    public void saveKitnet(){

        Kitnet kitnet = new Kitnet();

        kitnet.setNKitnet(Integer.parseInt(nKitnetField.getText().trim()));
        kitnet.setFurniture(mobiliaField.getText().trim());
        /*kitnet.setTenantName(inquilinoAlocadoField.getText().trim());*/
        kitnet.setTenantName("");
        kitnet.setStateOfUse(estadoUsoField.getText().trim());
        kitnet.setCep(cepField.getText().trim());
        kitnet.setState(stateComboBox.getSelectedItem().toString().trim());
        kitnet.setCity(cidadeField.getText().trim());
        kitnet.setAddress(enderecoField.getText().trim());
        /*kitnet.setnContract(nContratoField.getText().trim().isEmpty() ? -1 : Integer.parseInt(nContratoField.getText().trim()));*/
        kitnet.setnContract(-1);
        kitnet.setNameKitnet(nameKitnetField.getText().trim());
        boolean success;
        boolean kitnetExists = false;

        KitnetController kitnetController = new KitnetController();

        kitnetExists = kitnetController.kitnetExists(kitnet.nKitnet);

        if(!kitnetExists){
            success = kitnetController.registerKitnet(kitnet);
            if(success){
                JOptionPane.showMessageDialog(null, "Cadastro da kitnet " + kitnet.nameKitnet + " realizado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro no cadastro da kitnet!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Já existe uma kitnet com esse número, por favor cadastre um número novo!");
        }
    }
}