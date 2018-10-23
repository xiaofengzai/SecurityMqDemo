package mq;

import com.enshub.SpringSecurityApplication;
import com.enshub.model.User;
import com.enshub.service.AlertService;
import com.enshub.service.AlterServiceImpl;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(classes = SpringSecurityApplication.class)
public class ActiveMqDemo
{
    @Autowired
    @Qualifier("amqCoonectionFactory")
    private ActiveMQConnectionFactory factory;
    @Autowired
    private ActiveMQQueue queue;
    @Autowired
    private AlertService alterService;
    @Test
    public void TestListner(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("activemq.xml");
        JmsTemplate jmsTemplate= (JmsTemplate) applicationContext.getBean("jmsTemplate");
        AlterServiceImpl service=new AlterServiceImpl();
        service.setJmsOperations(jmsTemplate);
        service.send("testQueue",new User("ee","d"));
    }

    //@Test
    public  void testActiveMq(){
//        send();
//        recieve();
        alterService.send("testQueue",new User("wenfeng","ddd"));
       // User usr=alterService.recieve("testQueue");
        System.out.println("kk");

    }

    private void send(){
        try {
        Session session=factory.createConnection().createSession(false,Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer=session.createProducer(queue);
        TextMessage message=session.createTextMessage();
        message.setText("Hello worls");
        producer.send(message);
        }catch (Exception e){

        }
    }

    private void recieve(){
        try {
        Connection connection=factory.createConnection();
        connection.start();
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer=session.createConsumer(queue);
        TextMessage message=(TextMessage) consumer.receive();
        System.out.println("recieve"+message.getText());
        }catch (Exception e){

        }
    }
}
