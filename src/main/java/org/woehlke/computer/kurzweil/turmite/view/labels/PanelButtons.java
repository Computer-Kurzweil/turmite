package org.woehlke.computer.kurzweil.turmite.view.labels;

import org.woehlke.computer.kurzweil.turmite.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.turmite.model.ApplicationModel;
import org.woehlke.computer.kurzweil.turmite.view.ApplicationFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelButtons extends JPanel implements ActionListener {

    final static long serialVersionUID = 242L;

    private volatile JLabel copyright;
    private volatile JButton buttonsRunA;
    private volatile JButton buttonsRunB;
    private volatile JButton buttonsRunC;
    private final ApplicationFrame tab;
    private final ApplicationModel model;

    public PanelButtons(ApplicationModel model, ApplicationFrame tab, ComputerKurzweilProperties config ) {
        this.tab = tab;
        this.model = model;
        this.copyright = new JLabel(config.getTurmite().getView().getCopyright());
        this.buttonsRunA = new JButton(config.getTurmite().getView().getButtonsRunA());
        this.buttonsRunB = new JButton(config.getTurmite().getView().getButtonsRunB());
        this.buttonsRunC = new JButton(config.getTurmite().getView().getButtonsRunC());
        int hgap = 16;
        int vgap = 2;
        this.copyright.setLayout(new FlowLayout( FlowLayout.RIGHT, hgap, vgap));
        this.buttonsRunA.setLayout(new FlowLayout( FlowLayout.LEFT, hgap, vgap));
        this.buttonsRunB.setLayout(new FlowLayout( FlowLayout.LEFT, hgap, vgap));
        this.buttonsRunC.setLayout(new FlowLayout( FlowLayout.LEFT, hgap, vgap));
        this.setLayout(new FlowLayout( FlowLayout.CENTER, hgap, vgap));
        this.add(this.copyright);
        this.add(this.buttonsRunA);
        this.add(this.buttonsRunB);
        this.add(this.buttonsRunC);
        this.buttonsRunA.addActionListener(this);
        this.buttonsRunB.addActionListener(this);
        this.buttonsRunC.addActionListener(this);
    }

    /**
     * TODO write doc.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.buttonsRunA){
            this.model.runA();
        }
        if(ae.getSource() == this.buttonsRunB){
            this.model.runB();
        }
        if(ae.getSource() == this.buttonsRunC){
            this.model.runC();
        }
        this.tab.getCanvas().repaint();
        this.tab.repaint();
    }
}
