package pl.igor.testtask2.model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class GeoDataDto {

    @Id
    @GeneratedValue
    private Long id;
    private String deviceId;
    private int latitude;
    private int longitude;
    LocalDateTime dateTimeNow = LocalDateTime.now();

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setDateTimeNow(LocalDateTime dateTimeNow) {
        this.dateTimeNow = dateTimeNow;
    }

    public Long getId() {
        return id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public LocalDateTime getDateTimeNow() {
        return dateTimeNow;
    }

    @Override
    public String toString() {
        return "GeoDataDto{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", dateTimeNow=" + dateTimeNow +
                '}';
    }
}
