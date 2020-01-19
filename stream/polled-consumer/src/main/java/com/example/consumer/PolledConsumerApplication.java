package com.example.consumer;

import com.example.consumer.processor.PolledProcessor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableBinding(PolledProcessor.class)
public class PolledConsumerApplication {

	public static final ExecutorService exec = Executors.newSingleThreadExecutor();

	public static void main(String[] args) {
		SpringApplication.run(PolledConsumerApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(PollableMessageSource input, MessageChannel output) {
		return args -> {
			System.out.println("===== 发送消息到 polledConsumerIn ======= 接收消息 polledConsumerOut ===");
			System.out.println("一秒处理一个消息");
			exec.execute(() -> {
				boolean result = false;
				while (true) {
					// this is where we poll for a message, process it, and send a new one
					result = input.poll(m -> {
						String payload = (String) m.getPayload();
						System.out.println("Received: " + payload);
						output.send(MessageBuilder.withPayload(payload.toUpperCase())
								.copyHeaders(m.getHeaders())
								.build());
					}, new ParameterizedTypeReference<String>() { });

					try {
						Thread.sleep(1_000);
					}
					catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						break;
					}
					if (result) {
						System.out.println("Success");
					}
				}
			});
		};
	}
}
