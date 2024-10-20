package ru.vsu.cs.kg24.g122.bazykin_n_a.task2;

import javax.swing.*;

public class MainFrame extends JDialog {
    private JPanel contentPane;
    private JPanel paintAreaPanel;

    public MainFrame() {
        setContentPane(contentPane);
        setModal(true);
        DrawPanel dp = new DrawPanel(paintAreaPanel);
        paintAreaPanel.add(dp);
    }

    public static void main(String[] args) {
        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setSize(900, 900);
        System.exit(0);
    }
}
