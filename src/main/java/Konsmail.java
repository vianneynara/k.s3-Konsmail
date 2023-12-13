import gui.LoginPage;
import utils.USwingAppearance;

/**
 * Main class to run the application.
 *
 * @author narwa
 */

public class Konsmail {

    public static void main(String[] args) {
        USwingAppearance.setLooksAndFeel();
        new LoginPage().setVisible(true);
    }
}
