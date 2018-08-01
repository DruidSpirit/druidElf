package other;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class hellowSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.start();
		context.getBean(hellowSpring.class);
	}

}
