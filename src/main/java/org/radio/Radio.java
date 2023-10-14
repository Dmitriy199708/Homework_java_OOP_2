package org.radio;


public class Radio {
    private int currentRadioStationNumber; //текущий номер радиостанции
    private int currentVolume; // текущая громкость

    public int getCurrentRadioStationNumber() {
        return currentRadioStationNumber;
    }

    public int getCurrentVolume() { //для изменения текущего номера радиостанции
        return currentVolume;
    }

    public void setCurrentRadioStationNumber(int newCurrentRadioStationNumber) { //проверка границ радиостанции
        if (newCurrentRadioStationNumber < 0) {
            return;
        }
        if (newCurrentRadioStationNumber > 9) {
            return;
        }
        currentRadioStationNumber = newCurrentRadioStationNumber;
    }


    public void setLimitValuesVolume(int newCurrentVolume) { //проверка границ громкости радиоприемника
        if (newCurrentVolume < 0) {
            return;
        }
        if (newCurrentVolume > 100) {
            return;
        }
        currentVolume = newCurrentVolume;
    }


    public void setNextRadioStation() { //проверка кнопки переключения следующей радиостанции
        if (currentRadioStationNumber >= 9) {
            currentRadioStationNumber = 0;
        } else {
            int target = currentRadioStationNumber + 1;
            setCurrentRadioStationNumber(target);
        }
    }

    public void setPrevRadioStation() {   //проверка кнопки переключения на предыдущию радиостанцию
        if (currentRadioStationNumber <= 0) {
            currentRadioStationNumber = 9;
        } else {
            int target = currentRadioStationNumber - 1;
            setCurrentRadioStationNumber(target);
        }

    }

    public void setUppVolume() {
        if (currentVolume >= 100) {
            currentVolume = 100;
        } else {
            int volume = currentVolume + 1;
            setLimitValuesVolume(volume);
        }
    }

    public void setDownVolume() {
        if (currentVolume <= 0) {
            currentVolume = 0;
        } else {
            int volume = currentVolume - 1;
            setLimitValuesVolume(volume);
        }
    }
}
