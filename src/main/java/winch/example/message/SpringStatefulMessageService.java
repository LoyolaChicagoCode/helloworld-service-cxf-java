package winch.example.message;

public class SpringStatefulMessageService implements MessageService {

	private Count count;
	
	public void setCount(Count count) {
		this.count = count;
	}
	
	@Override
	public String getMessage(String message) {
		int result = getCount().incAndGet();
		System.out.println("count = " + result);
		return Integer.toString(result);
	}

	protected Count getCount() {
		return count;
	}
}
