package winch.example.message;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class MemberVariableMessageServiceTest extends
		AbstractDependencyInjectionSpringContextTests {

	private MemberVariableMessageService memberVariableMessageService;

	public void testMessage()
	{
		assertEquals("The argument passed in is hello world.",memberVariableMessageService.getMessage("hello world"));
	}
	
	public void testNullMessage()
	{
		assertEquals("The argument passed in is null.",memberVariableMessageService.getMessage(null));
	}
	
	public MemberVariableMessageService getMemberVariableMessageService() {
		return memberVariableMessageService;
	}

	public void setMemberVariableMessageService(
			MemberVariableMessageService memberVariableMessageService) {
		this.memberVariableMessageService = memberVariableMessageService;
	}

	@Override
	protected String[] getConfigLocations() {
		setAutowireMode(AUTOWIRE_BY_NAME);
		return new String[] { "file:src/main/webapp/WEB-INF/applicationContext-cxf.xml" };
	}
}
