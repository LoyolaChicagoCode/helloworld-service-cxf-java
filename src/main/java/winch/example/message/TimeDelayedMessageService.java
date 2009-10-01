package winch.example.message;

import java.text.MessageFormat;
import java.util.Date;

/**
 * Takes in a <code>MessageFormat</code> pattern and returns the pattern with
 * the message as an argument.
 */
public class TimeDelayedMessageService implements MessageService {

	private String pattern;

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	/**
	 * Gets a message formatted based upon the pattern and the message as an
	 * argument for the pattern.
	 * 
	 * @see winch.example.message.MessageService#getMessage(java.lang.String)
	 */
	@Override
	public String getMessage(String message) {
		String pattern = getPattern();
		if (pattern == null) {
			return null;
		}
		System.out.println(Thread.currentThread() + " starting at " + new Date());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread() + " interrupted at " + new Date());
		}
		System.out.println(Thread.currentThread() + " returning at " + new Date());
		return MessageFormat.format(pattern, message);
	}
}
