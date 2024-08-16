package br.ufrn.imd.Views;

import br.ufrn.imd.Constants.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class OwnerPage extends MyFrame implements ActionListener {

    JButton exitButton = new JButton("Sair");
    JTable contractTable;
    DefaultTableModel tableModel;

    public OwnerPage() {
        super("Página de Gestão de Contratos");
        setSize(1280, 680);
        addUIComponents();
    }

    private void addUIComponents() {
        setLayout(null);

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
                OwnerPage.this.dispose();
                new LoginForm().setVisible(true);
            }
        });

        String[] columnNames = {"Inquilino", "Kitnet", "Data Inicial",
                "Vencimento", "Aluguel",
                "Reajuste", "Status", "Visualizar", "Editar", "Deletar"};

        Object[][] data = {
                {"Alisson", 3, "20/02/2020", "20/02/2021", 500, 10, "Ativo", "Visualizar", "Editar", "Deletar"},
                {"Beatriz", 3, "20/02/2020", "20/02/2021", 500, 10, "Ativo", "Visualizar", "Editar", "Deletar"},
                {"Marcelo", 3, "20/02/2020", "20/02/2021", 500, 10, "Ativo", "Visualizar", "Editar", "Deletar"},
                {"Pedro", 3, "20/02/2020", "20/02/2021", 500, 10, "Vencido", "Visualizar", "Editar", "Deletar"},
                {"Alberto", 3, "20/02/2020", "20/02/2021", 500, 10, "Fechado", "Visualizar", "Editar", "Deletar"},
                {"Marjorie", 3, "20/02/2020", "20/02/2021", 500, 10, "Fechado", "Visualizar", "Editar", "Deletar"}
        };

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

        TableColumn viewColumn = contractTable.getColumnModel().getColumn(7);
        viewColumn.setCellRenderer(new ButtonRenderer("Visualizar"));
        viewColumn.setCellEditor(new ButtonEditor(new JCheckBox(), "Visualizar"));

        TableColumn editColumn = contractTable.getColumnModel().getColumn(8);
        editColumn.setCellRenderer(new ButtonRenderer("Editar"));
        editColumn.setCellEditor(new ButtonEditor(new JCheckBox(), "Editar"));

        TableColumn deleteColumn = contractTable.getColumnModel().getColumn(9);
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
            JOptionPane.showMessageDialog(OwnerPage.this, "Returning!");
            OwnerPage.this.dispose();
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
                case "Visualizar":
                    setBackground(Colors.QUATERNARY_COLOR);
                    break;
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


    class ButtonEditor extends DefaultCellEditor {
        private String label;
        private JButton button;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox, String label) {
            super(checkBox);
            this.label = label;
            button = new JButton(label);
            button.setOpaque(true);
            button.addActionListener(e -> {
                fireEditingStopped();
                int row = contractTable.getSelectedRow();
                if (label.equals("Visualizar")) {
                    JOptionPane.showMessageDialog(button, "Redirecting to View: " + row);
                } else if (label.equals("Editar")) {
                    JOptionPane.showMessageDialog(button, "Redirecting to Edit: " + row);
                } else if (label.equals("Deletar")) {
                    JOptionPane.showMessageDialog(button, "Redirecting to Delete: " + row);
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
