package com.tiancom.pas.site.sample;

import org.springframework.jms.core.MessageCreator;

import javax.annotation.Nonnull;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class Msg implements MessageCreator {

    @Nonnull
    @Override
    public Message createMessage(@Nonnull Session session) throws JMSException {
        return session.createTextMessage("测试消息");
    }
}
