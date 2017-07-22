package com.tiancom.pas;

import com.tiancom.pas.site.sample.Msg;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PasApplication implements CommandLineRunner {

    @Autowired
	private JmsTemplate jmsTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(PasApplication.class, args);
	}

	@Bean
	public Queue queue() {
	    return new Queue("my-queue");
    }

	@Override
	public void run(String... args) throws Exception {
		jmsTemplate.send("my-destination", new Msg());
		rabbitTemplate.convertAndSend("my-queue", "来自RabbitMQ的问候");
	}
}
