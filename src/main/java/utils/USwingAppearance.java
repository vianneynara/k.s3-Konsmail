package utils;

/**
 * Utility class to store looks and feel methods.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public class USwingAppearance {
	/**
	 * Sets the look and feel of the application to Nimbus.
	 * */
    public static void setLooksAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ULogger.logSevereError(ex, USwingAppearance.class);
        }
    }
}
