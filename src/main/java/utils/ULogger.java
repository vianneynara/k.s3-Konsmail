package utils;

import java.time.LocalTime;

/**
 * Utility class that helps logging messages and errors. Made as a shortcut.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public class ULogger {
	/**
	 * Logs a simple message and its time of execution.
	 * */
	public static void log(String msg) {
		log(msg, "\n");
	}

	/**
	 * Logs a message with a defined end line.
	 * */
	public static void log(String msg, String endLine) {
		log(msg, endLine, null);
	}

	/**
	 * Logs a message, with its end line and location.
	 * @param msg The message to be sent.
	 * @param endLine A string that will be concatenated at the back of the actual message.
	 * @param caller The class that is assumed as this method's invoker, used to print the location of the log.
	 * */
	public static void log(String msg, String endLine, Object caller) {
		final var time = LocalTime.now();
		if (caller == null) {
			System.out.printf("%02d:%02d:%02d | LOG: " + msg + endLine,
				time.getHour(), time.getMinute(), time.getSecond());
		} else {
			System.out.printf("@ " + caller.getClass().getName() + "| %02d:%02d:%02d | LOG: " + msg + endLine,
				time.getHour(), time.getMinute(), time.getSecond());
		}
	}

	/**
	 * Logs an error with a message.
	 * */
	public static void logError(Exception ex, String msg) {
		logError(ex, msg, "\n", null);
	}

	/**
	 * Logs an error with a message. Links to the caller object.
	 * */
	public static void logError(Exception ex, Object caller) {
		logError(ex, ex.getMessage(), "\n", caller);
	}

	/**
	 * Logs an error with a message. With an additional end line and location.
	 * */
	public static void logError(Throwable ex, String msg, String endLine, Object caller) {
		final var time = LocalTime.now();
		if (caller == null) {
			System.err.printf("%02d:%02d:%02d | ERROR: " + msg + endLine,
				time.getHour(), time.getMinute(), time.getSecond());
		} else {
			System.err.printf("@ " + caller.getClass().getName() + "| %02d:%02d:%02d | ERROR: " + msg + endLine,
				time.getHour(), time.getMinute(), time.getSecond());
		}
		ex.printStackTrace();
	}

	/**
	 * Logs a with e type severe using the java logger.
	 * */
	public static void logSevereError(Exception ex, Object caller) {
		java.util.logging.Logger.getLogger(caller.getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
}
