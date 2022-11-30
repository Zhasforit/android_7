package kz.talipovsn.weather;

import android.graphics.Bitmap;

import java.text.SimpleDateFormat;
import java.util.Date;

// Класс погоды
public class Weather {
    private String city; // Город
    private String country; // Страна
    private long dt; // Дата и время
    private double temperature; // Температура
    private String condition; // Состояние
    private String description;  // Описание погоды
    private String iconName; // Код иконки
    private Bitmap iconData; // Иконка

    public void setCity(String city) {
        this.city = city;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setDt(long dt) {
        this.dt = dt;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
    public void setIconData(Bitmap iconData) {
        this.iconData = iconData;
    }

    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }
    public String getDt() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(dt*1000));

    }
    public double getTemperature() {
        return temperature;
    }
    public String getCondition() {
        return condition;
    }
    public String getDescription() {
        return description;
    }
    public String getIconName() {
        return iconName;
    }
    public Bitmap getIconData() {
        return iconData;
    }
}
