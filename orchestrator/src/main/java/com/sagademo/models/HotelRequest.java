package com.sagademo.models;

public class HotelRequest {

    private String roomNumber;

    private RoomAction action;

    public HotelRequest() {
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomAction getAction() {
        return action;
    }

    public void setAction(RoomAction action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "HotelRequest{" +
                "roomNumber='" + roomNumber + '\'' +
                ", action=" + action +
                '}';
    }

    public enum RoomAction {
        BLOCK_ROOM,
        CONFIRM_ROOM,
        UNBLOCK_ROOM;
    }
}