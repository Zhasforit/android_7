package kz.talipovsn.weather;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONObject;

import static kz.talipovsn.weather.HttpClient.getHTMLData;
import static kz.talipovsn.weather.HttpClient.getHTMLImage;

// СОЗДАТЕЛЬ ПОГОДЫ
public class WeatherBuilder {

    // Получение JSON html-данных погоды по городу и языку
    private static String getWeatherData(String location, String lang) {
        String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?units=metric";
        String API = "52c336c8ceb8a6d8e4ee482985660291";
        String url = BASE_URL + "&q=" + location + "&lang=" + lang + "&appid=" + API;
        //System.out.println(url);
        return getHTMLData(url);
    }

    // Получение с web bitmap картинки погоды по ее коду
    private static Bitmap getWheaterImage(String code) {
        String IMG_URL = "http://openweathermap.org/img/w/";
        String url = IMG_URL + code + ".png";
        //System.out.println(url);
        return getHTMLImage(url);
    }

    // Парсинг даты в формате JSON с созданием объекта погоды
    private static Weather dataParsing(String json) {
        Weather weather = new Weather();
        try {
            JSONObject _obj = new JSONObject(json);
            JSONObject _sys = _obj.getJSONObject("sys");
            JSONArray _weather = _obj.getJSONArray("weather");
            JSONObject _weather0 = _weather.getJSONObject(0);
            JSONObject _main = _obj.getJSONObject("main");
            weather.setCountry(_sys.getString("country"));
            weather.setCity(_obj.getString("name"));
            weather.setDt(_obj.getLong("dt"));
            weather.setDescription(_weather0.getString("description"));
            weather.setCondition(_weather0.getString("main"));
            weather.setIconName(_weather0.getString("icon"));
            weather.setTemperature(_main.getDouble("temp"));
        } catch (Exception ignore) {
        }
        return weather;
    }

    // Получение готового объекта погоды по городу и языку
    public static Weather buildWeather (String location, String lang) {
        Weather weather = dataParsing(getWeatherData(location, lang));
        weather.setIconData(getWheaterImage(weather.getIconName()));
        return weather;
    }
}