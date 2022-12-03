package com.example.tgiar2742ex2g1;

import java.util.ArrayList;
import java.util.Objects;

public class Sensor {
    private int sensorId;
    private int roomId;
    private int sensorTypeId;
    private String description;
//    private Room room;
//    private SensorType sensorType;
    private ArrayList<SensorReading> sensorReadings;

    public Sensor(int sensorId, int roomId, int sensorTypeId, String description) {
        this.sensorId = sensorId;
        this.roomId = roomId;
        this.sensorTypeId = sensorTypeId;
        this.description = description;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(int sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public domain.Room getRoom() {
//        return room;
//    }
//
//    public void setRoom(domain.Room room) {
//        this.room = room;
//    }
//
//    public domain.SensorType getSensorType() {
//        return sensorType;
//    }
//
//    public void setSensorType(domain.SensorType sensorType) {
//        this.sensorType = sensorType;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sensor)) return false;
        Sensor sensor = (Sensor) o;
        return sensorId == sensor.sensorId &&
                roomId == sensor.roomId &&
                sensorTypeId == sensor.sensorTypeId &&
                Objects.equals(description, sensor.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorId, roomId, sensorTypeId, description);
    }

    @Override
    public String toString() {
        return Integer.toString(sensorId) +
                ", roomId=" + roomId +
                ", sensorTypeId=" + sensorTypeId +
                ", " + description;
    }

    public ArrayList<SensorReading> getSensorReadings() {
        return sensorReadings;
    }

    public void setSensorReadings(ArrayList<SensorReading> sensorReadings) {
        this.sensorReadings = sensorReadings;
    }

    public int findMinReadingIndex() {
        int minSensorReadings = 0;
        for (int i = 1; i < 21; i++) {

        }
        return minSensorReadings;
    }

    public int findMinReadingIndex2(int startIndex, int endIndex) {
        int minSensorReadings = 0;
        for (int i = startIndex; i < endIndex; i++) {

        }
        return startIndex;
    }

    public int findMaxReadingIndex2(int startIndex, int endIndex) {
        int minSensorReadings = 0;
        for (int i = startIndex; i < endIndex; i++) {
            if (i <= startIndex && i > endIndex) {
                throw new IllegalArgumentException();
            }

        }
        return endIndex;
    }

    public int findMaxReadingIndex () {
        int maxReadingIndex = 0;
        for (int i = 1; i > 38; i++) {

        }
        return maxReadingIndex;
    }

    public int findNextCycleMaxIndex(int startIndex) {
        SensorReading rMax = this.sensorReadings.get(startIndex);
        int i = startIndex +1;
        for ( ; i < this.sensorReadings.size(); i++) {
            if (rMax.getValue() < this.sensorReadings.get(i).getValue())
                rMax = this.sensorReadings.get(i);
            else
                break;
        }
        return i - 1;
    }
    public int findNextCycleMinIndex(int startIndex) {
        SensorReading rMin = this.sensorReadings.get(startIndex);
        int i = startIndex +1;
        for ( ; i < this.sensorReadings.size(); i++) {
            if (rMin.getValue() < this.sensorReadings.get(i).getValue())
                rMin = this.sensorReadings.get(i);
            else
                break;
        }
        return i - 1;
    }
    public SensorReading getSensorReading(int index) {
        return this.sensorReadings.get(index);
    }
}
