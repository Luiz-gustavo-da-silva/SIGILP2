package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;
import br.ufrn.imd.Controllers.ContractController;
import br.ufrn.imd.Exceptions.OwnerNotLoggedException;
import br.ufrn.imd.Models.Contract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.io.IOException;
import java.util.List;

public class ContractsPage extends MyFrame implements ActionListener {

    JButton exitButton = new JButton("Sair");
    JButton addContract = new JButton("Adicionar Contrato");
    JButton kitnetsButton = new JButton("Kitnets");
    JTable contractTable;
    DefaultTableModel tableModel;

    public ContractsPage() {
        super("Página de Gestão de Contratos");
        setSize(1280, 680);
        addUIComponents();
    }

    private void addUIComponents() {
        JLabel loginLabel = new JLabel("Olá! Aqui estão os seus contratos:");
        loginLabel.setBounds(140, 10, 1000, 100);
        loginLabel.setForeground(Colors.TEXT_COLOR);
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 28));
        loginLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(loginLabel);

        kitnetsButton.setFont(new Font("Dialog", Font.BOLD, 14));
        kitnetsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        kitnetsButton.setBackground(Colors.QUATERNARY_COLOR);
        kitnetsButton.setForeground(Colors.SECONDARY_COLOR);
        kitnetsButton.setBounds(800, 10, 100, 30);
        add(kitnetsButton);
        kitnetsButton.addActionListener(this);
        kitnetsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ContractsPage.this.dispose();
                //new KitnetsPage().setVisible(true);
            }
        });

        addContract.setFont(new Font("Dialog", Font.BOLD, 14));
        addContract.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addContract.setBackground(Colors.QUATERNARY_COLOR);
        addContract.setForeground(Colors.SECONDARY_COLOR);
        addContract.setBounds(925, 10, 200, 30);
        add(addContract);
        addContract.addActionListener(this);
        addContract.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ContractsPage.this.dispose();
                //new ContractRegistrationPage().setVisible(true);
            }
        });

        exitButton.setFont(new Font("Dialog", Font.BOLD, 14));
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exitButton.setBackground(Colors.QUATERNARY_COLOR);
        exitButton.setForeground(Colors.SECONDARY_COLOR);
        exitButton.setBounds(1150, 10, 70, 30);
        add(exitButton);
        exitButton.addActionListener(this);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ContractsPage.this.dispose();
                new LoginForm().setVisible(true);
            }
        });

        String[] columnNames = {"Inquilino", "Kitnet", "Data Inicial",
                "Vencimento", "Aluguel",
                "Reajuste", "Status", "Editar", "Deletar"};

        ContractController cc = new ContractController();
        List<Contract> contracts;
        try {
            contracts = cc.getAllContracts();
        } catch (OwnerNotLoggedException | IOException e) {
            throw new RuntimeException(e);
        }
        Object[][] data = cc.convertListToArray(contracts);

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
        editColumn.setCellEditor(new ButtonEditor(new JCheckBox(), "Editar"));

        TableColumn deleteColumn = contractTable.getColumnModel().getColumn(8);
        deleteColumn.setCellRenderer(new ButtonRenderer("Deletar"));
        deleteColumn.setCellEditor(new ButtonEditor(new JCheckBox(), "Deletar"));

        JScrollPane scrollPane = new JScrollPane(contractTable);
        scrollPane.setBounds(140, 100, 1000, 400);
        scrollPane.getViewport().setBackground(Colors.SECONDARY_COLOR);
        add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            ContractsPage.this.dispose();
            new LoginForm().setVisible(true);
        }
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
            }
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }


    class ButtonEditor extends DefaultCellEditor {
        private String label;
        private JButton button;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox, String label) {
            super(checkBox);
            ContractController cc = new ContractController();
            List<Contract> contracts;
            try {
                contracts = cc.getAllContracts();
            } catch (OwnerNotLoggedException | IOException e) {
                throw new RuntimeException(e);
            }
            this.label = label;
            button = new JButton(label);
            button.setOpaque(true);
            button.addActionListener(e -> {
                fireEditingStopped();
                int row = contractTable.getSelectedRow();
                if (label.equals("Editar")) {
                    JOptionPane.showMessageDialog(button, "Redirecting to Edit: " + row);
                } else if (label.equals("Deletar")) {
                    cc.deleteContract(contracts.get(row));
                    JOptionPane.showMessageDialog(button, "Contrato de ID nº " + contracts.get(row).getnContract() + " deletado com sucesso.");

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
}
