package com.sagapattern.domain.services;

import com.sagapattern.domain.model.Hotel;
import com.sagapattern.domain.model.HotelEventRequest;
import com.sagapattern.domain.model.HotelEventResponse;
import com.sagapattern.domain.model.RoomStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class HotelService {

    private static final String TOPIC = "hotelResponse";

    @Autowired
    @Qualifier(value = "response")
    private KafkaTemplate<String, HotelEventResponse> kafkaTemplate;

    @KafkaListener(topics = "hotelRequest")
    public void consume(HotelEventRequest request) {
        log.info(String.format("#### -> Hotel Event Request Consumed -> %s", request.toString()));

        //TODO: Implementar um HASH com 5 quartos em memoria por enquanto e tirar valor fixo na response
        HotelEventResponse response = new HotelEventResponse();
        response.setUserId("1234");
        response.setHotel(new Hotel("580", RoomStatus.PENDING_OF_CONFIRMATION));
        sendMessage(response);
    }

    public void sendMessage(HotelEventResponse message) {
        log.info(String.format("#### -> Hotel Event Response Producer Message -> %s", message.toString()));
        this.kafkaTemplate.send(TOPIC, message);
    }

//    @KafkaListener(topics = "hotelResponse")
//    public void consume(HotelEventResponse response) {
//        log.info(String.format("#### -> Hotel Event Response Consumed -> %s", response.toString()));
//    }
}
