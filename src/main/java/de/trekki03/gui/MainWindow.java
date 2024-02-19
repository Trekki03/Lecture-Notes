package de.trekki03.gui;

import de.trekki03.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.File;

public class MainWindow extends JFrame {
    private JButton pathButton;
    private JTable courseList;
    private JLabel pathLable;
    private JPanel mainPanel;
    DefaultTableModel courseTableModel;
    private File baseFolder;

    public MainWindow() {

        setTitle("Lecture Notes");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800,600);

        // Add Content
        mainPanel = new JPanel(new GridBagLayout());
        setContentPane(mainPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.75;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        pathLable = new JLabel("No Folder selected");
        mainPanel.add(pathLable, gbc);

        pathButton = new JButton("Select Base Folder");
        pathButton.addActionListener(e -> pathSelectionButtonPressed());
        gbc.gridx = 1;
        gbc.weightx = 0.25;
        mainPanel.add(pathButton, gbc);


        courseTableModel = new DefaultTableModel(new String[] {"Course"}, 0);
        courseList = new JTable(courseTableModel);
        courseList.setDefaultEditor(Object.class, null);
        courseList.setAutoCreateColumnsFromModel(true);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(new JScrollPane(courseList), gbc);

        setVisible(true);

    }

    private void pathSelectionButtonPressed() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(this);
        if(option == JFileChooser.APPROVE_OPTION) {
            baseFolder = fileChooser.getSelectedFile();
            pathLable.setText(baseFolder.getPath());
        }
        updateCourseList();
    }

    private void updateCourseList() {
        courseTableModel.setRowCount(0);
        File[] files = baseFolder.listFiles();
        if (files == null) {
            return;
        }
        for (File file: files) {
            if (!file.isDirectory()) {
                continue;
            }
            courseTableModel.addRow(new Object[] {file.getName()});
        }
    }
}
