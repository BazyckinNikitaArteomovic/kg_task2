package ru.vsu.cs.kg24.g122.bazykin_n_a.task2;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    public DrawPanel(JPanel PaintArea){
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        DrawLine.drawLine((Graphics2D) g, 100, 100, 10, 10, 0, 255, 0, 255, 0, 0);

    }
}