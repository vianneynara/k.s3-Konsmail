package utils;

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
