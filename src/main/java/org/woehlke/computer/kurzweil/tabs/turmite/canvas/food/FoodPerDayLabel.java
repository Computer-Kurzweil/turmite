package org.woehlke.computer.kurzweil.tabs.turmite.canvas.food;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.tabs.turmite.Turmite;
import org.woehlke.computer.kurzweil.tabs.turmite.TurmiteContext;

import javax.swing.*;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
@Log4j2
@Getter
@ToString(callSuper = true)
public class FoodPerDayLabel extends JLabel implements Turmite {

    private static final long serialVersionUID = 242L;

    @ToString.Exclude
    private final TurmiteContext tabCtx;
    private final String foodPerDayLabelString;

    public FoodPerDayLabel(TurmiteContext tabCtx) {
        super(tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getFoodPerDayLabel());
        this.tabCtx = tabCtx;
        this.foodPerDayLabelString = this.tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getFoodPerDayLabel();
    }
}
