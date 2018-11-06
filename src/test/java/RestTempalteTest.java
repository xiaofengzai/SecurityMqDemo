import com.enshub.SpringSecurityApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.listener.AsyncConsumerRestartedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.AsyncClientHttpRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.HttpMessageConverterExtractor;

import java.util.concurrent.ExecutionException;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(classes = SpringSecurityApplication.class)
public class RestTempalteTest
{
    @Autowired
    private AsyncRestTemplate asyncRestTemplate;
    @Test
    public void test() throws ExecutionException, InterruptedException {
        ListenableFuture<ResponseEntity<String>> future= asyncRestTemplate.getForEntity("www.baidu.com",String.class);
        future.addCallback(new ListenableFutureCallback<ResponseEntity<String>>(){
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(ResponseEntity<String> stringResponseEntity) {
                System.out.println("sss");
            }
        });
        System.out.println(future.get().getBody());
    }

}
