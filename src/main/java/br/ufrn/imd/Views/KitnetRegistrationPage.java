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

/**
 * A classe `kitnetRegistrationPage` representa a página de cadastro de kitnets.
 * Esta classe herda de `MyFrame` e implementa a interface `ActionListener` para
 * tratar eventos de ação, como cliques de botão.
 */
public class KitnetRegistrationPage extends MyFrame implements ActionListener {
    JButton salvarButton = new JButton("Adicionar");
    JTextField mobiliaField = new JTextField();
    JTextField cepField = new JTextField();
    JTextField estadoField = new JTextField();
    JTextField estadoUsoField = new JTextField();
    JTextField cidadeField = new JTextField();
    JTextField enderecoField = new JTextField();
    JTextField nameKitnetField = new JTextField();

    JButton exitButton = new JButton("Sair");
    JButton kitnetsPageButton = new JButton("Kitnets");

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
                KitnetRegistrationPage.this.dispose();
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
                KitnetRegistrationPage.this.dispose();
                new KitnetsPage().setVisible(true);
            }
        });

        JLabel loginLabel = new JLabel("Cadastro de Kitnet");
        loginLabel.setBounds(360, 25, 520, 100);
        loginLabel.setForeground(Colors.TEXT_COLOR);
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);

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
        estadoLabel.setBounds(640, 265, 400, 25);
        estadoLabel.setForeground(Colors.TEXT_COLOR);
        estadoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        estadoField.setBounds(640, 295, 220, 25);
        estadoField.setBackground(Colors.SECONDARY_COLOR);
        estadoField.setForeground(Colors.TEXT_COLOR);
        estadoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel cidadeLabel = new JLabel("Cidade:");
        cidadeLabel.setBounds(410, 265, 400, 25);
        cidadeLabel.setForeground(Colors.TEXT_COLOR);
        cidadeLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        cidadeField.setBounds(410, 295, 220, 25);
        cidadeField.setBackground(Colors.SECONDARY_COLOR);
        cidadeField.setForeground(Colors.TEXT_COLOR);
        cidadeField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoLabel.setBounds(410, 330, 200, 25);
        enderecoLabel.setForeground(Colors.TEXT_COLOR);
        enderecoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        enderecoField.setBounds(410, 360, 220, 25);
        enderecoField.setBackground(Colors.SECONDARY_COLOR);
        enderecoField.setForeground(Colors.TEXT_COLOR);
        enderecoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel nameKitnetLabel = new JLabel("Nome da Kitnet:");
        nameKitnetLabel.setBounds(640, 330, 200, 25);
        nameKitnetLabel.setForeground(Colors.TEXT_COLOR);
        nameKitnetLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        nameKitnetField.setBounds(640, 360, 220, 25);
        nameKitnetField.setBackground(Colors.SECONDARY_COLOR);
        nameKitnetField.setForeground(Colors.TEXT_COLOR);
        nameKitnetField.setFont(new Font("Dialog", Font.PLAIN, 24));

        salvarButton.setFont(new Font("Dialog", Font.BOLD, 18));
        salvarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        salvarButton.setBackground(Colors.TERTIARY_COLOR);
        salvarButton.setForeground(Colors.SECONDARY_COLOR);
        salvarButton.setBounds(500, 470, 250, 50);

        add(mobiliaLabel);
        add(mobiliaField);
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
        add(nameKitnetLabel);
        add(nameKitnetField);
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

        kitnet.setFurniture(mobiliaField.getText().trim());
        kitnet.setStateOfUse(estadoUsoField.getText().trim());
        kitnet.setCep(cepField.getText().trim());
        kitnet.setState(estadoField.getText().trim());
        kitnet.setCity(cidadeField.getText().trim());
        kitnet.setAddress(enderecoField.getText().trim());
        kitnet.setNameKitnet(nameKitnetField.getText().trim());
        boolean success;
        boolean kitnetExists = false;

        KitnetController kitnetController = new KitnetController();

        kitnetExists = kitnetController.kitnetExists(kitnet.getnKitnetUUID());

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
