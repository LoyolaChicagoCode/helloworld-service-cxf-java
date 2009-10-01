package winch.example.message;

public class HelloWorldMessageService implements MessageService {

	@Override
	public String getMessage(String message) {
		return "Hello World";
	}
}
