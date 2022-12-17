package org.woehlke.computer.kurzweil.turmite.model;

import lombok.extern.slf4j.Slf4j;
import org.woehlke.computer.kurzweil.turmite.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.turmite.model.fractal.GaussianNumberPlane;
import org.woehlke.computer.kurzweil.turmite.model.common.Point;
import org.woehlke.computer.kurzweil.turmite.view.state.ApplicationStateMachine;
import org.woehlke.computer.kurzweil.turmite.model.turing.SierpinksiTriangleTuringMachine;
import org.woehlke.computer.kurzweil.turmite.view.ApplicationFrame;

/**
 * Mandelbrot Set drawn by a Turing Machine.
 * (C) 2006 - 2022 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/mandelbrot-julia">Github Repository</a>
 * @see <a href="https://java.woehlke.org/mandelbrot-julia/">Maven Project Repository</a>
 *
 * @see GaussianNumberPlane
 * @see SierpinksiTriangleTuringMachine
 * @see ApplicationStateMachine
 *
 * @see ComputerKurzweilProperties
 * @see ApplicationFrame
 *
 * Created by tw on 16.12.2019.
 */
@Slf4j
public class ApplicationModel {

    private volatile GaussianNumberPlane gaussianNumberPlane;
    private volatile SierpinksiTriangleTuringMachine sierpinksiTriangleTuringMachine;
    private volatile ApplicationStateMachine applicationStateMachine;

    private volatile ComputerKurzweilProperties config;
    private volatile ApplicationFrame frame;

    public ApplicationModel(ComputerKurzweilProperties config, ApplicationFrame frame) {
        this.config = config;
        this.frame = frame;
        this.gaussianNumberPlane = new GaussianNumberPlane(this);
        this.sierpinksiTriangleTuringMachine = new SierpinksiTriangleTuringMachine(this);
        this.applicationStateMachine = new ApplicationStateMachine();
    }

    public synchronized boolean click(Point c) {
        applicationStateMachine.click();
        boolean repaint = true;
        switch (applicationStateMachine.getApplicationState()) {
            case MANDELBROT:
                sierpinksiTriangleTuringMachine.start();
                repaint = false;
                break;
            case JULIA_SET:
                gaussianNumberPlane.computeTheJuliaSetFor(c);
                break;
        }
        return repaint;
    }

    public synchronized boolean step() {
        boolean repaint = false;
        switch (applicationStateMachine.getApplicationState()) {
            case MANDELBROT:
                repaint = sierpinksiTriangleTuringMachine.step();
                break;
            case JULIA_SET:
                break;
        }
        return repaint;
    }

    public synchronized int getCellStatusFor(int x, int y) {
        return gaussianNumberPlane.getCellStatusFor(x, y);
    }

    public Point getWorldDimensions() {
        int scale = config.getSierpinskitriangle().getView().getScale();
        int width = scale * config.getSierpinskitriangle().getView().getWidth();
        int height = scale * config.getSierpinskitriangle().getView().getHeight();
        return new Point(width, height);
    }

    public GaussianNumberPlane getGaussianNumberPlane() {
        return gaussianNumberPlane;
    }

}
