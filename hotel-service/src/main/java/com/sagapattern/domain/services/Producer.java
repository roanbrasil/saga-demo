package com.sagapattern.domain.services;

import com.sagapattern.domain.model.HotelEventRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {

    private static final String TOPIC = "hotelRequest";

    @Autowired
    @Qualifier(value = "request")
    private KafkaTemplate<String, HotelEventRequest> kafkaTemplate;

    public void sendMessage(HotelEventRequest message) {
        log.info(String.format("#### -> Producing message -> %s", message.toString()));
        this.kafkaTemplate.send(TOPIC, message);
    }
}