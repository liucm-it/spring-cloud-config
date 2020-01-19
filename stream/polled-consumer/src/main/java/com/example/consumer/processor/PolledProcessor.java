package com.example.consumer.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.messaging.MessageChannel;

public interface PolledProcessor {
    @Input
    PollableMessageSource input();

    @Output
    MessageChannel output();
}
