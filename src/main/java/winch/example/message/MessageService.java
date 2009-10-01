package winch.example.message;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface MessageService {

	public String getMessage(@WebParam(name="message") String message);
	
}
