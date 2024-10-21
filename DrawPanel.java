package ru.vsu.cs.kg24.g122.bazykin_n_a.task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class DrawPanel extends JPanel {

    private ArrayList<Point> points = new ArrayList<>();

    public DrawPanel(JPanel PaintArea){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                points.add(new Point(x, y, (int) (Math.random() * 255), (int) (Math.random() * 255),
                        (int) (Math.random() * 255)));
                repaint();
            }
        });
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int size = points.size();
        if (size % 2 != 0){size -= 1;}
        for (int i = 0; i < size; i += 2){
            DrawLine.drawLine((Graphics2D) g, points.get(i).getX(), points.get(i).getY(), points.get(i + 1).getX(),
                    points.get(i + 1).getY(), points.get(i).getR(), points.get(i).getG(),
                    points.get(i).getB(), points.get(i + 1).getR(), points.get(i + 1).getG(),
                    points.get(i + 1).getB());
        }
    }
}