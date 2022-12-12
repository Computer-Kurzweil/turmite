package org.woehlke.computer.kurzwei.turmite.tabs.turmite.model;

import lombok.*;
import org.woehlke.computer.kurzwei.turmite.tabs.turmite.Turmite;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TurmiteParameter implements Turmite {

    private static final long serialVersionUID = 242L;

    private int foodPerDay;
    private int foodPerDayGardenOfEden;
    private boolean gardenOfEdenEnabled;

    public void increaseFoodPerDay() {
        this.foodPerDay++;
    }

    public void decreaseFoodPerDay() {
        this.foodPerDay--;
    }

    public void toggleGardenOfEden() {
      this.gardenOfEdenEnabled = ! this.gardenOfEdenEnabled;
    }

}
