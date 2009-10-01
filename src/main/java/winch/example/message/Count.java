package winch.example.message;

public class Count {

	private int count = 0;

	public synchronized int incAndGet() {
		return ++count;
	}

	public synchronized int get() {
		return count;
	}
}
