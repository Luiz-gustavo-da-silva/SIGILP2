package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;
import br.ufrn.imd.Controllers.KitnetController;
import br.ufrn.imd.Controllers.LoginController;
import br.ufrn.imd.Enums.SystemMessage;
import br.ufrn.imd.Models.Kitnet;
import br.ufrn.imd.Views.KitnetEditPage;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A classe `KitnetsPage` representa a página que exibe a lista de kitnets registradas.
 * Esta classe herda de `MyFrame` e implementa a interface `ActionListener` para
 * lidar com eventos de ação, como cliques de botões.
 */
public class KitnetsPage extends MyFrame implements ActionListener {

    private JTable table;

    JButton exitButton = new JButton("Sair");
    JButton addKitnet = new JButton("+ Kitnet");
    JButton contractButton = new JButton("Contratos");
    JTable contractTable;
    DefaultTableModel tableModel;

    List<Kitnet> kitchenettes = new ArrayList<>();

    private KitnetController kitnetController = new KitnetController();
    private LoginController lc = new LoginController();

    /**
     * Construtor da classe `KitnetsPage`.
     * Inicializa a interface de usuário e configura a janela.
     */
    public KitnetsPage() {
        super("Lista de Kitnets");
        setSize(1280, 680);
        kitchenettes = recoverKitchenettes();
        addUIComponents();
    }

    /**
     * Adiciona e configura os componentes da interface de usuário.
     * Cria os botões, a tabela de kitnets e configura as colunas de ação para editar e deletar.
     */
    private void addUIComponents() {
        setLayout(null);

        exitButton.setFont(new Font("Dialog", Font.BOLD, 14));
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exitButton.setBounds(1150, 10, 70, 30);
        exitButton.setBackground(Colors.QUATERNARY_COLOR);
        exitButton.setForeground(Colors.SECONDARY_COLOR);
        add(exitButton);
        exitButton.addActionListener(this);

        contractButton.setFont(new Font("Dialog", Font.BOLD, 14));
        contractButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contractButton.setBackground(Colors.QUATERNARY_COLOR);
        contractButton.setForeground(Colors.SECONDARY_COLOR);
        contractButton.setBounds(850, 10, 150, 30);
        add(contractButton);
        contractButton.addActionListener(this);
        contractButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KitnetsPage.this.dispose();
                new ContractsPage().setVisible(true);
            }
        });

        addKitnet.setFont(new Font("Dialog", Font.BOLD, 14));
        addKitnet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addKitnet.setBounds(1030, 10, 100, 30);
        addKitnet.setBackground(Colors.QUATERNARY_COLOR);
        addKitnet.setForeground(Colors.SECONDARY_COLOR);
        add(addKitnet);
        addKitnet.addActionListener(this);
        addKitnet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KitnetsPage.this.dispose();
                new KitnetRegistrationPage().setVisible(true);
            }
        });

        String[] columnNames = {"Nome da Kitnet", "Mobília", "Estado de uso", "Cep", "Estado", "Cidade", "Endereço", "Editar", "Deletar"};
        Object[][] data = kitnetController.convertListToArray(kitchenettes);

        tableModel = new DefaultTableModel(data, columnNames);
        contractTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 7;
            }
        };

        contractTable.setRowHeight(30);
        contractTable.setBackground(Colors.SECONDARY_COLOR);
        contractTable.setShowVerticalLines(false);
        contractTable.getTableHeader().setBackground(Colors.SECONDARY_COLOR);
        contractTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 14));

        TableColumn editColumn = contractTable.getColumnModel().getColumn(7);
        editColumn.setCellRenderer(new ButtonRenderer("Editar"));
        editColumn.setCellEditor(new ButtonAction(new JCheckBox(), "Editar"));

        TableColumn deleteColumn = contractTable.getColumnModel().getColumn(8);
        deleteColumn.setCellRenderer(new ButtonRenderer("Deletar"));
        deleteColumn.setCellEditor(new ButtonAction(new JCheckBox(), "Deletar"));

        JScrollPane scrollPane = new JScrollPane(contractTable);
        scrollPane.setBounds(140, 100, 1000, 400);
        scrollPane.getViewport().setBackground(Colors.SECONDARY_COLOR);
        add(scrollPane);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            if(lc.Logout()){
                JOptionPane.showMessageDialog(null, "Logout realizado com sucesso!");
                KitnetsPage.this.dispose();
                new LoginForm().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Falha Logout!");
            }
        }
    }

    /**
     * Recupera a lista de kitnets do controlador.
     *
     * @return Uma lista de objetos `Kitnet`.
     */
    public List<Kitnet> recoverKitchenettes(){
        return kitnetController.recoverKitchenettes();
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer(String text) {
            setText(text);
            setOpaque(true);
            setFont(new Font("Dialog", Font.BOLD, 12));
            setForeground(Colors.SECONDARY_COLOR);

            switch (text) {
                case "Editar":
                    setBackground(Colors.QUATERNARY_COLOR);
                    break;
                case "Deletar":
                    setBackground(Colors.TERTIARY_COLOR);
                    break;
                default:
                    setBackground(Colors.PRIMARY_COLOR);
                    break;
            }
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }


    class ButtonAction extends DefaultCellEditor {
        private String label;
        private JButton button;
        private boolean isPushed;

        public ButtonAction(JCheckBox checkBox, String label) {
            super(checkBox);
            this.label = label;
            button = new JButton(label);
            button.setOpaque(true);
            button.addActionListener(e -> {
                fireEditingStopped();
                int row = contractTable.getSelectedRow();
                if (label.equals("Editar")) {
                    KitnetsPage.this.dispose();
                    new KitnetEditPage(kitchenettes.get(row).getnKitnetUUID()).setVisible(true);

                } else if (label.equals("Deletar")) {
                    boolean res = removeKitnet(kitchenettes.get(row).getnKitnetUUID());
                    if (res) {
                        JOptionPane.showMessageDialog(button, SystemMessage.KITNET_REMOVED_SUCCESS.getMessage());
                        kitchenettes.remove(row);
                        tableModel.removeRow(row);
                        contractTable.revalidate();
                        contractTable.repaint();
                    } else {
                        JOptionPane.showMessageDialog(button, SystemMessage.KITNET_REMOVE_ERROR.getMessage());
                    }
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            isPushed = true;
            button.setText((value == null) ? "" : value.toString());
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            isPushed = false;
            return label;
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }


    /**
     * Remove uma kitnet da lista e do controlador.
     *
     * @param nKitnetUUID O UUID da kitnet a ser removida.
     * @return `true` se a kitnet foi removida com sucesso, `false` caso contrário.
     */
    public boolean removeKitnet(UUID nKitnetUUID){
        return kitnetController.removeKitnet(nKitnetUUID);
    }
}
