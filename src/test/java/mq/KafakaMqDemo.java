package mq;

import com.enshub.SpringSecurityApplication;
import com.enshub.model.User;
import com.enshub.service.AlertService;
import com.enshub.service.AlterServiceImpl;
import com.enshub.service.kfk.KafkaSender;
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
public class KafakaMqDemo
{
    @Autowired
    private KafkaSender sender;

    @Test
    public void TestListner(){
        for (int i=0;i<5;i++){
            sender.sendTest();
        }
    }
}
