package net.ys.component;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RabbitMessageListener {

    @RabbitListener(queues = "test.queue1")
    public void receive(Map map) {
        System.out.println(map);
    }

    @RabbitListener(queues = "test.queue2")
    public void receiveMessage(Message message) {
        System.out.println("receiveMessage:" + message.getBody());
        System.out.println("receiveMessage:" + message.getMessageProperties());
    }
}