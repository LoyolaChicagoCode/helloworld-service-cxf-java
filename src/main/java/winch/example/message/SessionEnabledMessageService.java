package winch.example.message;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

public class SessionEnabledMessageService implements MessageService, HttpSessionListener {

	@Resource
	private WebServiceContext wsContext;

	@Override
	public String getMessage(String message) {
		int result = getCount().incAndGet();
		System.out.println("count = " + result);
		return Integer.toString(result);
	}

	public final static String ATTRIBUTE_NAME = "messageservice.count";

	protected Count getCount() {
		return (Count) getSession().getAttribute(ATTRIBUTE_NAME);
	}

	protected HttpSession getSession() {
		return ((javax.servlet.http.HttpServletRequest) wsContext
				.getMessageContext().get(MessageContext.SERVLET_REQUEST))
				.getSession();
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		System.out.println("Session created: " + session);
		session.setAttribute(ATTRIBUTE_NAME, new Count());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("Session destroyed: " + event.getSession());
	}
}
