package org.radio;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {


    private int numberOfRadioStations = 10; //количество радиостанций
    private int maxRadioStationNumber = numberOfRadioStations - 1;
    private int minRadioStationNumber = 0; // минимальная радиостанция
    private int currentRadioStationNumber = minRadioStationNumber; //текущий номер радиостанции
    private int minVolume = 0; // минимальная громкость
    private int maxVolume = 100; // максимальная громкость
    private int currentVolume = minVolume;// текущая громкость

    public Radio(int numberOfRadioStations, int maxRadioStationNumber, int minRadioStationNumber, int minVolume, int maxVolume) {
        this.numberOfRadioStations = numberOfRadioStations;
        this.maxRadioStationNumber = maxRadioStationNumber;
        this.minRadioStationNumber = minRadioStationNumber;
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }


    public void setCurrentRadioStationNumber(int newCurrentRadioStationNumber) {
        if (newCurrentRadioStationNumber > maxRadioStationNumber) {
            return;
        }
        if (newCurrentRadioStationNumber < minRadioStationNumber) {
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
