package com.sagapattern.presentation;

import com.sagapattern.domain.model.HotelEventRequest;
import com.sagapattern.domain.services.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

    private final Producer producer;

    @Autowired
    HotelController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody HotelEventRequest message) {
        this.producer.sendMessage(message);
    }
}

/***
 curl --header "Content-Type: application/json" \
 --request POST \
 --data '{"userId":"teste", "quantityOfRooms":"5", "action":"BLOCK_ROOM"}' \
 http://localhost:9000/hotel/publish
 **/