import gui.LoginPage;
import utils.USwingAppearance;

/**
 * This class runs the main application. Also sets the look and feel.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * @author <a href="https://github.com/trustacean">Edward</a>
 * */

public class Konsmail {

    public static void main(String[] args) {
        USwingAppearance.setLooksAndFeel();
        new LoginPage().setVisible(true);
    }
}
