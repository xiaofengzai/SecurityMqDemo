package mq;

import com.enshub.SpringSecurityApplication;
import com.enshub.model.User;
import com.enshub.service.AlertService;
import com.enshub.service.AlterServiceImpl;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:rabbitmq.xml")
@SpringBootTest(classes = SpringSecurityApplication.class)
public class RabbitMqDemo
{
    @Autowired
    private AlertService alterService;
//    @Test
//    public void TestListner(){
//        alterService.send("testQueue",new User("ee","d"));
//    }

    @Test
    public  void testActiveMq(){
        send();
        recieve();
        System.out.println("okguest");

    }

    private void send(){
        for (int i=0;i<10;i++){
            alterService.rabbitSend("","queue1",new User("demo"+i,"ahh"));
        }
    }

    private void recieve(){
        for (int i=0;i<10;i++){
            User item=alterService.recieve("queue1");
            System.out.println(item.getUsername());
        }

    }
}
