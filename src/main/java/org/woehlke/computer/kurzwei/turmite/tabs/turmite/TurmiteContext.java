package org.woehlke.computer.kurzwei.turmite.tabs.turmite;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzwei.turmite.application.ComputerKurzweilContext;
import org.woehlke.computer.kurzwei.turmite.commons.tabs.TabContext;
import org.woehlke.computer.kurzwei.turmite.tabs.turmite.model.WorldPoint;

import java.util.concurrent.ForkJoinTask;

import static java.lang.Thread.State.NEW;
/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
@Log4j2
@Getter
@ToString(callSuper = false, exclude={"ctx","controller","tab"})
@EqualsAndHashCode(callSuper = false, exclude={"ctx","controller","tab"})
public class TurmiteContext extends ForkJoinTask<Void> implements TabContext, Turmite {

    private static final long serialVersionUID = 242L;

    private final ComputerKurzweilContext ctx;
    private final TurmiteTab tab;
    private final TurmiteCanvas canvas;
    private final TurmiteModel tabModel;

    @Setter
    private TurmiteController controller;

    public TurmiteContext(
        TurmiteTab tab,
        ComputerKurzweilContext ctx
    ) {
       this.tab = tab;
       this.ctx = ctx;
        int scale = 2;
        int width = 320 * scale;
        int height = 234 * scale;
        WorldPoint worldDimensions = new WorldPoint(width,height);
       this.canvas = new TurmiteCanvas(  worldDimensions );
       this.tabModel = this.canvas.getTabModel();
       this.controller = new TurmiteController();
    }

    @Override
    public void stopController() {
        this.controller.exit();
        this.controller = null;
        this.controller = new TurmiteController();
    }

    @Override
    public void startController() {
        if(this.controller == null){
            this.controller = new TurmiteController();
        } else {
            if(this.controller.getState() != NEW){
                this.stopController();
            }
        }
    }

    @Override
    public Void getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Void value) {

    }

    @Override
    protected boolean exec() {
        this.tab.update();
        this.tab.repaint();
        return true;
    }
}
