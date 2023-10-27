package com.echo.mall.order.message.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 发送消息
 */
public interface Sender {

    String OUTPUT = "order";

    @Output(OUTPUT)
    MessageChannel output();

}
