package org.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {


    @Test

    public void lastRadioStationNoLombok() {
        Radio radio = new Radio(); //проверка кол-ва радиостанций и мах номера

        Assertions.assertEquals(10, radio.getNumberOfRadioStations());


    }

    @Test

    public void lastRadioStation() {
        Radio radio = new Radio(100, 99, 10, 50, 200); //проверка кол-ва радиостанций и мах номера

        Assertions.assertEquals(100, radio.getNumberOfRadioStations());


    }

    @Test
    public void maxRadioStation() { //максимальная радиостанция
        Radio radio = new Radio(100, 99, 10, 50, 200);


        Assertions.assertEquals(99, radio.getMaxRadioStationNumber());
    }

    @Test
    public void minRadioStation() { //мимимальная радиостанция
        Radio radio = new Radio(100, 99, 10, 50, 200);


        Assertions.assertEquals(10, radio.getMinRadioStationNumber());
    }

    @Test
    public void maxVolumeRadiostation() { // максимальная громкость
        Radio radio = new Radio(100, 99, 10, 50, 200);


        Assertions.assertEquals(200, radio.getMaxVolume());
    }
    @Test
    public void minVolumeRadiostation() { // максимальная громкость
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);


        Assertions.assertEquals(50, radio.getMinVolume());
    }
    @Test
    public void nextRadio() {
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);//Если текущая радиостанция — максимальная, и клиент нажал на кнопку next на пульте, то текущей должна стать нулевая.
        radio.setCurrentRadioStationNumber(14);

        radio.setNextRadioStation();


        Assertions.assertEquals(15, radio.getCurrentRadioStationNumber());

    }

    @Test
    public void nextRadio0() {
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);//Если текущая радиостанция — максимальная, и клиент нажал на кнопку next на пульте, то текущей должна стать нулевая.
        radio.setCurrentRadioStationNumber(10);

        radio.setNextRadioStation();


        Assertions.assertEquals(11, radio.getCurrentRadioStationNumber());

    }

    @Test
    public void prevRadioStation() {
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setCurrentRadioStationNumber(10);

        radio.setPrevRadioStation();

        Assertions.assertEquals(99, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void prevRadioStation54() {
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setCurrentRadioStationNumber(54);

        radio.setPrevRadioStation();

        Assertions.assertEquals(53, radio.getCurrentRadioStationNumber());
    }

    @Test

    public void uppMaxVolume() {
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setLimitValuesVolume(201);

        radio.setUppVolume();

        Assertions.assertEquals(0, radio.getCurrentVolume());

    }

    @Test

    public void uppMaxVolume50() {
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setLimitValuesVolume(200);

        radio.setUppVolume();

        Assertions.assertEquals(200, radio.getCurrentVolume());

    }

    @Test

    public void uppMaxVolume98() {
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setLimitValuesVolume(98);

        radio.setUppVolume();

        Assertions.assertEquals(99, radio.getCurrentVolume());

    }

    @Test

    public void downMaxVolume() { // Убавление громкости в минимальном значение, находясь на границе выставленных значений
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setLimitValuesVolume(50);

        radio.setDownVolume();

        Assertions.assertEquals(50, radio.getCurrentVolume());

    }

    @Test

    public void downMaxVolume100() { // Убавление громкости в минимальном значение, находясь на границе выставленных значений
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setLimitValuesVolume(100);

        radio.setDownVolume();

        Assertions.assertEquals(99, radio.getCurrentVolume());

    }

    @Test

    public void aboveValidStationNumberMax() { //проверка границ радиостанции (выше валидного диапазона)
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);

        radio.setCurrentRadioStationNumber(99);

        Assertions.assertEquals(99, radio.getCurrentRadioStationNumber());
    }

    @Test

    public void aboveValidStationNumberMix() { //проверка границ радиостанции (ниже валидного диапазона)
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);

        radio.setCurrentRadioStationNumber(-1);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void validRangeStationNumber() { //проверка границ радиостанции ( валидный  диапазон)
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);

        radio.setCurrentRadioStationNumber(99);

        Assertions.assertEquals(99, radio.getCurrentRadioStationNumber());
        ;
    }

    @Test
    public void belowValidRangeStationNumber() { //переключение на сл радиостанцию
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setCurrentRadioStationNumber(0);

        radio.setNextRadioStation();

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test

    public void nextStation() { // Переключение на следующую  радиостанцию , установка несуществующей волны
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setCurrentRadioStationNumber(100);

        radio.setNextRadioStation();

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());

    }

    @Test

    public void nextStationOnTheBorder() { // Переключение на следующую  радиостанцию
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setCurrentRadioStationNumber(99);

        radio.setNextRadioStation();

        Assertions.assertEquals(10, radio.getCurrentRadioStationNumber());

    }

    @Test

    public void prevRadioStationOnTheBorder() {  // Переключение на предыдущую   радиостанцию, установка несуществующей волны
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setCurrentRadioStationNumber(-1);

        radio.setPrevRadioStation();

        Assertions.assertEquals(99, radio.getCurrentRadioStationNumber());

    }

    @Test

    public void prevRadioStation8() {  // Переключение на предыдущую   радиостанцию
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setCurrentRadioStationNumber(12);

        radio.setPrevRadioStation();

        Assertions.assertEquals(11, radio.getCurrentRadioStationNumber());

    }


    @Test

    public void prevRadioStation1() {  // Переключение на предыдущую   радиостанцию
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setCurrentRadioStationNumber(10);

        radio.setPrevRadioStation();

        Assertions.assertEquals(99, radio.getCurrentRadioStationNumber());

    }

    @Test

    public void uppVolume() { // прибавление громкости в максимальном значение
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setLimitValuesVolume(200);

        radio.setUppVolume();

        Assertions.assertEquals(200, radio.getCurrentVolume());

    }

    @Test

    public void uppVolumeOnTheBorder() { // прибавление громкости в максимальном значение, выше установленных границ
        Radio radio = new Radio(100, 99, 10, 50, 200);
        radio.setLimitValuesVolume(201);

        radio.setUppVolume();

        Assertions.assertEquals(0, radio.getCurrentVolume());

    }

    @Test

    public void uppVolume55() { // прибавление громкости
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setLimitValuesVolume(55);

        radio.setUppVolume();

        Assertions.assertEquals(56, radio.getCurrentVolume());

    }

    @Test

    public void belowMinVolume() { // ниже Минимальной  громкости
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setLimitValuesVolume(-1);

        Assertions.assertEquals(0, radio.getCurrentVolume());


    }

    @Test

    public void higherMaxVolume() { // Выше максимальной громкости
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setLimitValuesVolume(201);

        Assertions.assertEquals(0, radio.getCurrentVolume());

    }

    @Test

    public void downVolume() { // Убавление громкости в минимальном значение, находясь на границе выставленных значений
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setLimitValuesVolume(0);

        radio.setDownVolume();


        Assertions.assertEquals(50, radio.getCurrentVolume());

    }

    @Test

    public void downVolume56() { // Убавление громкости
        Radio radio = new Radio(100, 99, 10, 0, 50, 200, 0);
        radio.setLimitValuesVolume(55);

        radio.setDownVolume();

        Assertions.assertEquals(54, radio.getCurrentVolume());

    }
}






