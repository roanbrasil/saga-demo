package com.sagapattern.domain.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HotelEventResponse {

    private String userId;

    public Hotel hotel;
}
