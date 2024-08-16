package br.ufrn.imd.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class kitnetsPage extends MyFrame implements ActionListener {

    private JTable table;

    public kitnetsPage() {
        super("Lista de Kitnets");
        addUIComponents();
    }

    private void addUIComponents() {
        String[] columnNames = {"Nome do inquilino", "N° Kitnet", "V. água", "V. Luz", "V. Internet", "V. aluguel", "V. Total", "Status", "Ações"};

        Object[][] data = {
                {"João Silva", "101", "R$ 30,00", "R$ 50,00", "R$ 70,00", "R$ 500,00", "R$ 650,00", "Pago", "Editar"},
                {"Maria Oliveira", "102", "R$ 25,00", "R$ 45,00", "R$ 60,00", "R$ 480,00", "R$ 610,00", "Pendente", "Editar"},
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        table = new JTable(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(8).setPreferredWidth(80);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 200));

        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
