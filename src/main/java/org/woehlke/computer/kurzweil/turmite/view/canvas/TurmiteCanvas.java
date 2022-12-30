package org.woehlke.computer.kurzweil.turmite.view.canvas;


import org.woehlke.computer.kurzweil.turmite.model.TurmiteModel;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;


/**
 * Mandelbrot Set drawn by a Turing Machine.
 * (C) 2006 - 2022 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/mandelbrot-julia">Github Repository</a>
 * @see <a href="https://java.woehlke.org/mandelbrot-julia/">Maven Project Repository</a>
 *
 * @see TurmiteModel
 * @see Dimension
 *
 * @see JComponent
 * @see Graphics
 *
 * Date: 05.02.2006
 * Time: 00:51:51
 */
public class TurmiteCanvas extends JComponent {

    @Serial
    private final static long serialVersionUID = 242L;

    private volatile TurmiteModel app;
    private volatile Dimension preferredSize;

    public TurmiteCanvas(TurmiteModel app) {
        this.app = app;
        int width = this.app.getWorldDimensions().getWidth();
        int height = this.app.getWorldDimensions().getHeight();
        this.preferredSize = new Dimension(width, height);
        this.setSize(this.preferredSize);
        this.setPreferredSize(preferredSize);
    }

    public void paint(Graphics g) {
        this.setSize(this.preferredSize);
        this.setPreferredSize(preferredSize);
        super.paintComponent(g);
        for(int y = 0; y < app.getWorldDimensions().getY(); y++){
            for(int x = 0; x < app.getWorldDimensions().getX(); x++){
                Color stateColor = getColorForCellStatus(app.getCellStatusFor(x,y));
                g.setColor(stateColor);
                g.drawLine(x,y,x,y);
            }
        }
    }

    private Color getColorForCellStatus(int cellStatus){
        int red = 0;
        int green = 0;
        int blue = cellStatus * 3 + 32;
        blue = Math.min(blue,255);
        Color stateColor = new Color(red, green, blue);
        return stateColor;
    }

    public void update(Graphics g) {
        paint(g);
    }

}
