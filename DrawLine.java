package ru.vsu.cs.kg24.g122.bazykin_n_a.task2;

import java.awt.*;

import static java.lang.Math.abs;
import java.lang.Math;

public class DrawLine {
    private static int getColor(int x, int y, int x0, int y0, int x1, int y1, int c0, int c1){
        return (int) (c0 + (Math.sqrt(Math.pow((x-x0), 2) + Math.pow((y-y0), 2)) / Math.sqrt(Math.pow((x1-x0), 2) + Math.pow((y1-y0), 2))) * (c1 - c0));
    }
    public static void drawLine(Graphics2D g, int x0, int y0, int x1, int y1, int r0, int g0, int b0, int r1, int g1, int b1){
        if (x1 < x0){
            int temp = x1;
            x1 = x0;
            x0 = temp;
            temp = y1;
            y1 = y0;
            y0 = temp;
        }
        int deltax = abs(x1 - x0);
        int deltay = abs(y1 - y0);
        int y = y0 ;
        int diry = y1 - y0 ;
        int error = 0;
        int deltaerr = (deltay + 1) ;
        if ( diry > 0) diry = 1;
        if ( diry < 0) diry = -1;
        for (int x = x0; x < x1; x++){
            int r = getColor(x, y, x0, y0, x1, y1, r0, r1);
            int gr = getColor(x, y, x0, y0, x1, y1, g0, g1);
            int b = getColor(x, y, x0, y0, x1, y1, b0, b1);
            g.setColor(new Color(r, gr, b));
            g.fillRect(x, y, 2, 2);
            error = error + deltaerr ;
            if ( error >= ( deltax + 1) )
                y = y + diry ;
            error = error - ( deltax + 1) ;
        }
    }
}
