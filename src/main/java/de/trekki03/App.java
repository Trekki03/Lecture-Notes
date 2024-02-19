package de.trekki03;

import de.trekki03.gui.MainWindow;

import javax.swing.*;
import java.io.File;

public class App {
    private File baseFolder;
    private String[][] subjects;

    App() {
        MainWindow window = new MainWindow();
       /* JFrame frame = new JFrame("Lecture Notes");
        frame.setVisible(true);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION) {
            baseFolder = fileChooser.getSelectedFile();
        }
        assert baseFolder != null;
        listFiles(baseFolder.getAbsolutePath());
    }

    void listFiles(String path) {
        try {
            File folder = new File(path);
            File[] files = folder.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file.getAbsolutePath());
                }
                else {
                    System.out.println("File Name:" + file.getName());
                    System.out.println("File Path:" + file.getAbsolutePath());
                    System.out.println("File Size:" + file.getTotalSpace());
                    System.out.println();
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Error opening file");
        }
        */
    }
}
