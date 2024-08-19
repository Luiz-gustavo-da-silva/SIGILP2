package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;
import br.ufrn.imd.Controllers.KitnetController;

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
    JTextField nKitnetField = new JTextField();
    JTextField mobiliaField = new JTextField();
    JTextField inquilinoAlocadoField = new JTextField();
    JTextField valorBaseAluguelField = new JTextField();
    JTextField valorAtualAluguelField = new JTextField();
    JTextField cepField = new JTextField();
    JTextField estadoField = new JTextField();
    JTextField estadoUsoField = new JTextField();
    JTextField cidadeField = new JTextField();
    JTextField enderecoField = new JTextField();
    JTextField nContratoField = new JTextField();


    /**
     * Construtor da classe `kitnetRegistrationPage`.
     * Inicializa a interface de usuário e configura a janela.
     */
    public KitnetRegistrationPage() {
        super("Cadatrar kitnet");
        setSize(1280, 680);
        addUIComponents();
    }

    /**
     * Método responsável por adicionar e configurar os componentes da interface de usuário.
     * Este método cria labels e campos de texto para cada atributo de uma kitnet, e também
     * configura o botão de registro.
     */
    private void addUIComponents() {
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

        JLabel inquilinoAlocadoLabel = new JLabel("Inquilino Alocado:");
        inquilinoAlocadoLabel.setBounds(30, 145, 200, 25);
        inquilinoAlocadoLabel.setForeground(Colors.TEXT_COLOR);
        inquilinoAlocadoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        inquilinoAlocadoField.setBounds(30, 175, 400, 55);
        inquilinoAlocadoField.setBackground(Colors.SECONDARY_COLOR);
        inquilinoAlocadoField.setForeground(Colors.TEXT_COLOR);
        inquilinoAlocadoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel estadoUsoLabel = new JLabel("Estado de Uso:");
        estadoUsoLabel.setBounds(460, 145, 200, 25);
        estadoUsoLabel.setForeground(Colors.TEXT_COLOR);
        estadoUsoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        estadoUsoField.setBounds(460, 175, 400, 55);
        estadoUsoField.setBackground(Colors.SECONDARY_COLOR);
        estadoUsoField.setForeground(Colors.TEXT_COLOR);
        estadoUsoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel valorBaseAluguelLabel = new JLabel("Valor Base do Aluguel:");
        valorBaseAluguelLabel.setBounds(30, 245, 200, 25);
        valorBaseAluguelLabel.setForeground(Colors.TEXT_COLOR);
        valorBaseAluguelLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        valorBaseAluguelField.setBounds(30, 275, 400, 55);
        valorBaseAluguelField.setBackground(Colors.SECONDARY_COLOR);
        valorBaseAluguelField.setForeground(Colors.TEXT_COLOR);
        valorBaseAluguelField.setFont(new Font("Dialog", Font.PLAIN, 24));

        JLabel valorAtualAluguelLabel = new JLabel("Valor Atual do Aluguel:");
        valorAtualAluguelLabel.setBounds(460, 245, 200, 25);
        valorAtualAluguelLabel.setForeground(Colors.TEXT_COLOR);
        valorAtualAluguelLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        valorAtualAluguelField.setBounds(460, 275, 400, 55);
        valorAtualAluguelField.setBackground(Colors.SECONDARY_COLOR);
        valorAtualAluguelField.setForeground(Colors.TEXT_COLOR);
        valorAtualAluguelField.setFont(new Font("Dialog", Font.PLAIN, 24));

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

        JLabel nContratoLabel = new JLabel("Número do Contrato:");
        nContratoLabel.setBounds(460, 545, 200, 25);
        nContratoLabel.setForeground(Colors.TEXT_COLOR);
        nContratoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        nContratoField.setBounds(460, 575, 400, 55);
        nContratoField.setBackground(Colors.SECONDARY_COLOR);
        nContratoField.setForeground(Colors.TEXT_COLOR);
        nContratoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        salvarButton.setFont(new Font("Dialog", Font.BOLD, 18));
        salvarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        salvarButton.setBackground(Colors.TERTIARY_COLOR);
        salvarButton.setForeground(Colors.SECONDARY_COLOR);
        salvarButton.setBounds(350, 550, 250, 50);

        add(nKitnetLabel);
        add(nKitnetField);
        add(mobiliaLabel);
        add(mobiliaField);
        add(inquilinoAlocadoLabel);
        add(inquilinoAlocadoField);
        add(estadoUsoLabel);
        add(estadoUsoField);
        add(valorBaseAluguelLabel);
        add(valorBaseAluguelField);
        add(valorAtualAluguelLabel);
        add(valorAtualAluguelField);
        add(cepLabel);
        add(cepField);
        add(estadoLabel);
        add(estadoField);
        add(cidadeLabel);
        add(cidadeField);
        add(enderecoLabel);
        add(enderecoField);
        add(nContratoLabel);
        add(nContratoField);
        add(salvarButton);

        salvarButton.addActionListener(this);
        salvarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int a = 0;
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
        int nKitnet = Integer.parseInt(nKitnetField.getText().trim());
        String furniture = mobiliaField.getText().trim();
        String tenantName = inquilinoAlocadoField.getText().trim();
        String stateOfUse = estadoUsoField.getText().trim();
        String cep = cepField.getText().trim();
        String state = estadoField.getText().trim();
        String city = cidadeField.getText().trim();
        String address = enderecoField.getText().trim();
        int nContract = Integer.parseInt(nContratoField.getText().trim());
        boolean success;
        int result = -1;
        boolean kitnetExists = false;
        try {
            KitnetController kitnetController = new KitnetController();

            kitnetExists = kitnetController.kitnetExists(nKitnet);

            if(!kitnetExists){
                result = kitnetController.checkContractNumber(nContract, nKitnet);
                JOptionPane.showMessageDialog(null, "Result: "+ result);

                if(result == 1){
                    JOptionPane.showMessageDialog(null, "A kitnet "+ nKitnet+ "já existe e já está atribuída ao contrato. Por favor adicione outro número" + nContract);
                    success = false;
                }else if(result == 2){
                    JOptionPane.showMessageDialog(null, "Já existe outra kitnet associada a esse contrato, o valor foi substituído pela nova kitnet!");
                    success = kitnetController.registerKitnet(nKitnet, furniture, tenantName, stateOfUse, cep, state, city, address, nContract);
                }else if(result == 3){
                    JOptionPane.showMessageDialog(null, "A kitnet foi atribuída ao contrato" + nContract + " Com sucesso!");
                    success = kitnetController.registerKitnet(nKitnet, furniture, tenantName, stateOfUse, cep, state, city, address, nContract);
                }else if(result == 4){
                    JOptionPane.showMessageDialog(null, "Não existe um contrato com esse número!");
                    success = kitnetController.registerKitnet(nKitnet, furniture, tenantName, stateOfUse, cep, state, city, address, nContract);
                }else{
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro na adição da kitnet no contrato!");
                    success = false;
                }

                if(success == true){
                    JOptionPane.showMessageDialog(null, "Cadastro da kitnet " + nKitnet + " realizado com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "Ocorreu algum erro no cadastro da kitnet!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Já existe uma kitnet com esse número, por favor cadastre um número novo!");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}
