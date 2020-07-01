package com.sagapattern.domain.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private String roomNumber;

    private RoomStatus status;
}
