package com.sagapattern.domain.services;

import com.sagapattern.domain.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
public class HotelService {

    private static final String TOPIC = "hotelResponse";

    private Map<String, RoomAction> roomSituation = Map.of(
            "100", RoomAction.UNBLOCK_ROOM,
            "200", RoomAction.UNBLOCK_ROOM,
            "300", RoomAction.UNBLOCK_ROOM,
            "400", RoomAction.UNBLOCK_ROOM,
            "500", RoomAction.UNBLOCK_ROOM);

    @Autowired
    @Qualifier(value = "response")
    private KafkaTemplate<String, HotelEventResponse> kafkaTemplate;


    @KafkaListener(topics = "hotelRequest")
    public void consume(HotelEventRequest request) {
        log.info(String.format("#### -> Hotel Event Request Consumed -> %s", request.toString()));

        HotelEventResponse response = new HotelEventResponse();


        if(roomSituation.containsKey(request.getRoomNumber())){
            response.setHotel(new Hotel(request.getRoomNumber(), RoomStatus.PENDING_OF_CONFIRMATION));
        }else{
            response.setHotel(new Hotel(request.getRoomNumber(), RoomStatus.UNAVAILABLE));
        }
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
