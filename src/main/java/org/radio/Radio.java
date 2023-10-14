package org.radio;


public class Radio {


    private int numberOfRadioStations = 10; //количество радиостанций
    private int maxRadioStationNumber = numberOfRadioStations - 1;
    private int minRadioStationNumber = 0; // минимальная радиостанция
    private int currentRadioStationNumber = minRadioStationNumber; //текущий номер радиостанции
    private int minVolume = 0; // минимальная громкость
    private int maxVolume = 100; // максимальная громкость
    private int currentVolume = minVolume;// текущая громкость
    public Radio(){

    }

    public Radio(int numberOfRadioStations) { // проверка последнего номера радиостанции

        this.maxRadioStationNumber = numberOfRadioStations - 1;

    }

    public Radio(int minVolume, int maxVolume) { // проверка громкости радио
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    public int getMinRadioStationNumber() {  // возвращает мин радиостанцию
        return minRadioStationNumber;
    }

    public int getMaxRadioStationNumber() { // возвращает мах радиостанцию
        return maxRadioStationNumber;
    }

    public int getCurrentRadioStationNumber() {
        return currentRadioStationNumber;
    }

    public int getMaxVolume() { //возвращает мах громкость
        return maxVolume;
    }

    public int getMinVolume() { //возвращает мин громкость
        return minVolume;
    }


    public int getCurrentVolume() { //для изменения текущего номера радиостанции
        return currentVolume;
    }

    public void setCurrentRadioStationNumber(int newCurrentRadioStationNumber) { //проверка границ радиостанции
        if (newCurrentRadioStationNumber < minRadioStationNumber) {
            return;
        }
        if (newCurrentRadioStationNumber > maxRadioStationNumber) {
            return;
        }
        currentRadioStationNumber = newCurrentRadioStationNumber;
    }


    public void setLimitValuesVolume(int newCurrentVolume) { //проверка границ громкости радиоприемника
        if (newCurrentVolume < minVolume) {
            return;
        }
        if (newCurrentVolume > maxVolume) {
            return;
        }
        currentVolume = newCurrentVolume;
    }


    public void setNextRadioStation() { //проверка кнопки переключения следующей радиостанции
        if (currentRadioStationNumber >= maxRadioStationNumber) {
            currentRadioStationNumber = minRadioStationNumber;
        } else {
            int target = currentRadioStationNumber + 1;
            setCurrentRadioStationNumber(target);
        }
    }

    public void setPrevRadioStation() {   //проверка кнопки переключения на предыдущию радиостанцию
        if (currentRadioStationNumber <= minRadioStationNumber) {
            currentRadioStationNumber = maxRadioStationNumber;
        } else {
            int target = currentRadioStationNumber - 1;
            setCurrentRadioStationNumber(target);
        }

    }

    public void setUppVolume() {
        if (currentVolume >= maxVolume) {
            currentVolume = maxVolume;
        } else {
            int volume = currentVolume + 1;
            setLimitValuesVolume(volume);
        }
    }

    public void setDownVolume() {
        if (currentVolume <= minVolume) {
            currentVolume = minVolume;
        } else {
            int volume = currentVolume - 1;
            setLimitValuesVolume(volume);
        }
    }
}
