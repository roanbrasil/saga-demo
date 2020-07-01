package com.sagapattern.domain.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HotelEventRequest {

    private String userId;

    private String quantityOfRooms;

    private RoomAction action;
}
