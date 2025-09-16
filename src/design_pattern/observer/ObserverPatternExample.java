package design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temp);
}

interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObserver();
}

class WeatherStation implements Subject {
    private float temperature;
    private List<Observer> observerList;

    public WeatherStation() {
        this.observerList = new ArrayList<>();
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObserver();
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer ob : observerList) {
            ob.update(temperature);
        }
    }
}

class DisplayDevice implements Observer {
    @Override
    public void update(float temp) {
        System.out.println("Display device temperature is " + temp);
    }
}

class MobileDevice implements Observer {
    @Override
    public void update(float temp) {
        System.out.println("Mobile device temperature is " + temp);
    }
}


public class ObserverPatternExample {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.setTemperature(25);

        DisplayDevice displayDevice =new DisplayDevice();
        weatherStation.attach(displayDevice);

        MobileDevice mobileDevice = new MobileDevice();
        weatherStation.attach(mobileDevice);

        weatherStation.setTemperature(28);
    }

}
