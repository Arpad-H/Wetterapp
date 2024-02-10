package org.oaad.Entities;

class CurrentUnits {
    private String time;
    private String interval;
    private String temperature_2m;
    private String apparent_temperature;
    private String cloud_cover;
    private String rain;

    public String getCloud_cover() {
        return cloud_cover;
    }

    public void setCloud_cover(String cloud_cover) {
        this.cloud_cover = cloud_cover;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(String temperature_2m) {
        this.temperature_2m = temperature_2m;
    }

    public String getApparent_temperature() {
        return apparent_temperature;
    }

    public void setApparent_temperature(String apparent_temperature) {
        this.apparent_temperature = apparent_temperature;
    }
}

class Current {
    private String time;
    private int interval;
    private double temperature_2m;
    private double apparent_temperature;
    private double cloud_cover;
    private double rain;

    public double getCloud_cover() {
        return cloud_cover;
    }

    public void setCloud_cover(double cloud_cover) {
        this.cloud_cover = cloud_cover;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public double getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(double temperature_2m) {
        this.temperature_2m = temperature_2m;
    }

    public double getApparent_temperature() {
        return apparent_temperature;
    }

    public void setApparent_temperature(double apparent_temperature) {
        this.apparent_temperature = apparent_temperature;
    }



}
public class WeatherData {
    private double latitude;
    private double longitude;
    private String place_name ="";

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    private double generationtime_ms;
    private int utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private int elevation;
    private CurrentUnits current_units;
    private Current current;


    public WeatherData() {

    }
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getGenerationtime_ms() {
        return generationtime_ms;
    }

    public void setGenerationtime_ms(double generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }

    public int getUtc_offset_seconds() {
        return utc_offset_seconds;
    }

    public void setUtc_offset_seconds(int utc_offset_seconds) {
        this.utc_offset_seconds = utc_offset_seconds;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezone_abbreviation() {
        return timezone_abbreviation;
    }

    public void setTimezone_abbreviation(String timezone_abbreviation) {
        this.timezone_abbreviation = timezone_abbreviation;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public CurrentUnits getCurrent_units() {
        return current_units;
    }

    public void setCurrent_units(CurrentUnits current_units) {
        this.current_units = current_units;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}
