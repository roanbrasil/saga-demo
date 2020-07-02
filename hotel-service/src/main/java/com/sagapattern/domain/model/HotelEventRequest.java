package com.sagapattern.domain.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HotelEventRequest {

    private String roomNumber;

    private RoomAction action;
}
