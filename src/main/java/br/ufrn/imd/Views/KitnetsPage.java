package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;
import br.ufrn.imd.Controllers.KitnetController;
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



public class KitnetsPage extends MyFrame implements ActionListener {

    private JTable table;

    JButton exitButton = new JButton("Sair");
    JButton addKitnet = new JButton("+ Kitnet");

    JButton contractButton = new JButton("Contratos");

    JTable contractTable;
    DefaultTableModel tableModel;

    List<Kitnet> kitchenettes = new ArrayList<>();

    public KitnetsPage() {
        super("Lista de Kitnets");
        setSize(1280, 680);
        kitchenettes = recoverKitchenettes();
        addUIComponents();
    }

    private void addUIComponents() {
        setLayout(null);

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
                KitnetsPage.this.dispose();
                new LoginForm().setVisible(true);
            }
        });

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

        Object[][] data = new Object[kitchenettes.size()][10];

        for (int i = 0; i < kitchenettes.size(); i++) {
            Kitnet kitnet = kitchenettes.get(i);

            data[i][0] = kitnet.getNameKitnet();
            data[i][1] = kitnet.getFurniture();
            data[i][2] = kitnet.getStateOfUse();
            data[i][3] = kitnet.getCep();
            data[i][4] = kitnet.getState();
            data[i][5] = kitnet.getCity();
            data[i][6] = kitnet.getAddress();
            data[i][7] = "Editar";
            data[i][8] = "Deletar";
        }

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
            JOptionPane.showMessageDialog(KitnetsPage.this, "Returning!");
            KitnetsPage.this.dispose();
            new ContractsPage().setVisible(true);
        }
    }

    public List<Kitnet> recoverKitchenettes(){
        KitnetController kitnetController = new KitnetController();
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
                    new KitnetEditPage(kitchenettes.get(row).getNKitnet()).setVisible(true);

                } else if (label.equals("Deletar")) {
                    boolean res = removeKitnet(kitchenettes.get(row).getNKitnet());
                    if (res) {
                        JOptionPane.showMessageDialog(button, "Kitnet removida com sucesso!");
                        kitchenettes.remove(row);
                        tableModel.removeRow(row);
                        contractTable.revalidate();
                        contractTable.repaint();
                    } else {
                        JOptionPane.showMessageDialog(button, "Erro ao deletar kitnet, essa kitnet pode estar associada a um contrato!");
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


    public boolean removeKitnet(int nKitnet){
        KitnetController kitnetController = new KitnetController();
        return kitnetController.removeKitnet(nKitnet);
    }
}
