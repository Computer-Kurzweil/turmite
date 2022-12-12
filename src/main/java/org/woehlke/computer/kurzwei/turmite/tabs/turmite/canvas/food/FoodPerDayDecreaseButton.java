package org.woehlke.computer.kurzwei.turmite.tabs.turmite.canvas.food;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzwei.turmite.tabs.turmite.Turmite;
import org.woehlke.computer.kurzwei.turmite.tabs.turmite.TurmiteContext;

import javax.swing.*;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
@Log4j2
@Getter
@ToString(callSuper = true)
public class FoodPerDayDecreaseButton extends JButton implements Turmite {

    private static final long serialVersionUID = 242L;

    @ToString.Exclude
    private final TurmiteContext tabCtx;
    private final String labelFoodPerDayDecrease;

    public FoodPerDayDecreaseButton(TurmiteContext tabCtx) {
        super(tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getButtonFoodPerDayDecrease());
        this.tabCtx = tabCtx;
        this.labelFoodPerDayDecrease = this.tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getButtonFoodPerDayDecrease();
    }
}
