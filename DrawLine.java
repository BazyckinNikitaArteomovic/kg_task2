package ru.vsu.cs.kg24.g122.bazykin_n_a.task2;

import java.awt.*;

import static java.lang.Math.abs;
import java.lang.Math;

public class DrawLine {
    private static int getColor(int x, int y, int x0, int y0, int x1, int y1, int c0, int c1){
        return (int) (c0 + (Math.sqrt(Math.pow((x-x0), 2) + Math.pow((y-y0), 2)) / Math.sqrt(Math.pow((x1-x0), 2) + Math.pow((y1-y0), 2))) * (c1 - c0));
    }
    public static void drawLine(Graphics2D g, int x1, int y1, int x2, int y2, int r0, int g0, int b0, int r1, int g1, int b1){
        int dy = y2 - y1;
        int dx = x2 - x1;
        int incYi, incXi, incXf, incYf;
        if (dy >= 0) {
            incYi = 1;
        } else {
            dy = -dy;
            incYi = -1;
        }
        if (dx >= 0) {
            incXi = 1;
        } else {
            dx = -dx;
            incXi = -1;
        }
        if (dx >= dy) {
            incYf = 0;
            incXf = incXi;
        } else {
            incXf = 0;
            incYf = incYi;
            dx ^= dy;
            dy ^= dx;
            dx ^= dy;
        }
        int x = x1;
        int y = y1;
        int incE = 2 * dy;
        int d = incE - dx;
        int incNE = d - dx;
        while(x != x2){
            int xp = x;
            int yp = y;
            int r = getColor(x, y, x1, y1, x2, y2, r0, r1);
            int gr = getColor(x, y, x1, y1, x2, y2, g0, g1);
            int b = getColor(x, y, x1, y1, x2, y2, b0, b1);
            g.setColor(new Color(r, gr, b));
            g.fillRect(xp, yp, 2, 2);
            if (d <= 0) {
                x += incXf;
                y += incYf;
                d += incE;
            } else {
                x += incXi;
                y += incYi;
                d += incNE;
            }
        }
    }
}
