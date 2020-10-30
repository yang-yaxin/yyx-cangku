package com.jk.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogSenderService implements RabbitTemplate.ReturnCallback{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void returnedMessage(Message message, int i,
                                String s, String s1, String s2) {
        System.out.println(
            "AckSender returnedMessage " +
            message.toString() +
            " === " + i +
            " === " + s1 +
            " === " + s2
        );
    }

    public void send(String logJson){
        //返回回调
        rabbitTemplate.setReturnCallback(this);
        //确认回调
        rabbitTemplate.setConfirmCallback((correlationData,ack,cause)->{
            if (ack){
                System.out.println("消息发送成功");
            }else{
                System.out.println(
                    "消息发送失败, 原因：" +
                    cause +
                    correlationData.toString()
                );
            }
        });
        rabbitTemplate.convertAndSend("log-queue",logJson);
    }
}
