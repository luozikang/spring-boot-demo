package  org.lzk.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzk.rabbitmq.dao.HelloSender;
import org.lzk.rabbitmq.dao.NeoSender;
import org.lzk.rabbitmq.dao.NeoSender1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;
    @Autowired
    private NeoSender neoSender;
    @Autowired
    private NeoSender1 neoSender1;
    @Test
    public void hello() throws Exception {
        helloSender.send();
        Thread.sleep(1000l);
    }

    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            neoSender.send(i);
        }
        Thread.sleep(10000l);
    }

    @Test
    public void manyToMany() throws Exception {
        for (int i=0;i<100;i++){
            neoSender.send(i);
            neoSender1.send(i);
        }
        Thread.sleep(10000l);
    }
}