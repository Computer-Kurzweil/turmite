package org.woehlke.computer.kurzwei.turmite;

import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzwei.turmite.application.ComputerKurzweilProperties;
import org.woehlke.computer.kurzwei.turmite.tabs.turmite.TurmiteTab;

/**
 * Class with main Method for Starting the Desktop Application.
 *
 * @see TurmiteTab
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
@Log4j2
public class TurmiteApplication {

    private TurmiteApplication(String configFileName, String jarFilePath) {
        ComputerKurzweilProperties properties = ComputerKurzweilProperties.propertiesFactory(configFileName, jarFilePath);
        TurmiteTab simulatedEvolutionTab = new TurmiteTab(properties);
    }

    /**
     * Starting the Desktop Application
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        String configFileName = "application.yml";
        String jarFilePath = "target/turmite.jar";
        TurmiteApplication application = new TurmiteApplication(configFileName,jarFilePath);
    }
}
