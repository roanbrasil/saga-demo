package com.sagademo.models;

public class HotelResponse {

        private String roomNumber;

        private RoomStatus status;

        public HotelResponse() {
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public RoomStatus getStatus() {
            return status;
        }

        public void setStatus(RoomStatus status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Hotel{" +
                    "roomNumber='" + roomNumber + '\'' +
                    ", status=" + status +
                    '}';
        }

    public enum RoomStatus {
        BOOKED,
        PENDING_OF_CONFIRMATION,
        UNAVAILABLE,
        DOESNT_EXIST
    }
}
