package org.radio;


public class Radio {
    public int currentRadioStationNumber; //текущий номер радиостанции
    public int currentVolume; // текущая громкость

    public int getCurrentVolume() { //для изменения текущего номера радиостанции
        return currentVolume;
    }

    public void setIncreaseVolume(int newСurrentVolume) { //для изменения текущей громкости
        currentVolume = newСurrentVolume;

    }

    public int getCurrentRadioStationNumber() { //проверка текущего номера радиостанции
        return currentRadioStationNumber;
    }

    public void setToMaxRadioStation() { // максимальная  радиостанция
        currentRadioStationNumber = 9;

    }

    public void setToMinRadioStation() { //  минимальная радиостанция
        currentRadioStationNumber = 0;

    }

    public void getMinVolumeRadioStations() { // Минимальная громкость
        currentVolume = 0;
    }

    public void getMaxVolumeRadioStations() { // Максимальная громкость
        currentVolume = 100;
    }

    public void setLimitValuesStationNumber(int newCurrentRadioStationNumber) { //проверка границ радиостанции
        if (newCurrentRadioStationNumber < 0) {
            setToMinRadioStation();
        } else if (newCurrentRadioStationNumber > 9) {
            setToMaxRadioStation();
        } else {
            currentRadioStationNumber = newCurrentRadioStationNumber;
        }
    }

    public void setNextRadiostation(int newCurrentRadioStationNumber) { //проверка кнопки переключения следующей радиостанции
        if (newCurrentRadioStationNumber >= 9) {
            return;
        }
        if (newCurrentRadioStationNumber > 0) {
            currentRadioStationNumber = newCurrentRadioStationNumber + 1;
        }
    }

    public void setPrevRadioStation(int newCurrentRadioStationNumber) {   //проверка кнопки переключения на предыдущию радиостанцию
        if (newCurrentRadioStationNumber <= 0) {
            setToMaxRadioStation();
        } else if (newCurrentRadioStationNumber <= 9) {
            currentRadioStationNumber = newCurrentRadioStationNumber - 1;
        } else {
            getCurrentRadioStationNumber();
        }
    }

    public void setVolumeUpp(int newCurrentVolume) { //Увеличить  громкость
        if (newCurrentVolume <= 0) {
            getMinVolumeRadioStations();
        } else if (newCurrentVolume < 100) {
            currentVolume = newCurrentVolume + 1;
        } else {
            getMaxVolumeRadioStations();
        }

    }

    public void setVolumeDown(int newCurrentVolume) { //Уменьшить громкость
        if (newCurrentVolume <= 0) {
            getMinVolumeRadioStations();

        } else if (newCurrentVolume <= 100) {
            currentVolume = newCurrentVolume - 1;
        } else {
            getMaxVolumeRadioStations();
        }
    }
}
