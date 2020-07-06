package com.example.weatherforecastapplication;

public class Settings {
    private static Settings instance = null;

    private Settings() {}

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    private boolean darkTheme = false;
    private String[] cities = new String[]{
            "Moscow",
            "St. Petersburg",
            "Yekaterinburg",
            "Sochi",
            "Vladivostok"
    };
    private int currentIndexOfCity = 0;

    public boolean isDarkThemeFlag() {
        return darkTheme;
    }

    public void setDarkTheme(boolean darkTheme) {
        this.darkTheme = darkTheme;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public int getCurrentIndexOfCity() {
        return currentIndexOfCity;
    }

    public void setCurrentIndexOfCity(int currentIndexOfCity) {
        this.currentIndexOfCity = currentIndexOfCity;
    }
}
