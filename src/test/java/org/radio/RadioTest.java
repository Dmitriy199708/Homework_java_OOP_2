package org.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {


    @Test

    public void lastRadioStation() {
        Radio radio = new Radio(56); //проверка кол-ва радиостанций и мах номера

        Assertions.assertEquals(55, radio.getMaxRadioStationNumber());


    }

    @Test
    public void minRadioStation() { //мимимальная радиостанция
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(0);
        radio.getMinRadioStationNumber();

        Assertions.assertEquals(0,radio.getCurrentRadioStationNumber());
    }

    @Test
    public void maxVolumeRadiostation() { // максимальная громкость
        Radio radio = new Radio(0,100);


        Assertions.assertEquals(100,radio.getMaxVolume());
    }
    @Test
    public void minVolumeRadiostation() { // максимальная громкость
        Radio radio = new Radio(0,55);


        Assertions.assertEquals(0,radio.getMinVolume());
    }
    @Test
    public void nextRadio() {
        Radio radio = new Radio(15);//Если текущая радиостанция — максимальная, и клиент нажал на кнопку next на пульте, то текущей должна стать нулевая.
        radio.setCurrentRadioStationNumber(14);

        radio.setNextRadioStation();


        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());

    }

    @Test
    public void nextRadio0() {
        Radio radio = new Radio(15);//Если текущая радиостанция — максимальная, и клиент нажал на кнопку next на пульте, то текущей должна стать нулевая.
        radio.setCurrentRadioStationNumber(0);

        radio.setNextRadioStation();


        Assertions.assertEquals(1, radio.getCurrentRadioStationNumber());

    }

    @Test
    public void prevRadioStation() {
        Radio radio = new Radio(55);
        radio.setCurrentRadioStationNumber(0);

        radio.setPrevRadioStation();

        Assertions.assertEquals(54, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void prevRadioStation54() {
        Radio radio = new Radio(55);
        radio.setCurrentRadioStationNumber(54);

        radio.setPrevRadioStation();

        Assertions.assertEquals(53, radio.getCurrentRadioStationNumber());
    }

    @Test

    public void uppMaxVolume() {
        Radio radio = new Radio(0, 100);
        radio.setLimitValuesVolume(100);

        radio.setUppVolume();

        Assertions.assertEquals(100, radio.getCurrentVolume());

    }

    @Test

    public void uppMaxVolume50() {
        Radio radio = new Radio(0, 50);
        radio.setLimitValuesVolume(50);

        radio.setUppVolume();

        Assertions.assertEquals(50, radio.getCurrentVolume());

    }

    @Test

    public void uppMaxVolume98() {
        Radio radio = new Radio(0, 100);
        radio.setLimitValuesVolume(98);

        radio.setUppVolume();

        Assertions.assertEquals(99, radio.getCurrentVolume());

    }

    @Test

    public void downMaxVolume() { // Убавление громкости в минимальном значение, находясь на границе выставленных значений
        Radio radio = new Radio(0, 100);
        radio.setLimitValuesVolume(0);

        radio.setDownVolume();

        Assertions.assertEquals(0, radio.getCurrentVolume());

    }

    @Test

    public void downMaxVolume100() { // Убавление громкости в минимальном значение, находясь на границе выставленных значений
        Radio radio = new Radio(0, 100);
        radio.setLimitValuesVolume(100);

        radio.setDownVolume();

        Assertions.assertEquals(99, radio.getCurrentVolume());

    }

    @Test

    public void aboveValidStationNumberMax() { //проверка границ радиостанции (выше валидного диапазона)
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(10);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void aboveValidStationNumberMix() { //проверка границ радиостанции (ниже валидного диапазона)
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(-1);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void validRangeStationNumber() { //проверка границ радиостанции ( валидный  диапазон)
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(9);

        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void belowValidRangeStationNumber() { //переключение на сл радиостанцию
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(0);

        radio.setNextRadioStation();

        int expected = 1;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void nextStation() { // Переключение на следующую  радиостанцию , установка несуществующей волны
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(100);

        radio.setNextRadioStation();

        int expected = 1;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void nextStationOnTheBorder() { // Переключение на следующую  радиостанцию
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(9);

        radio.setNextRadioStation();

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void prevRadioStationOnTheBorder() {  // Переключение на предыдущую   радиостанцию, установка несуществующей волны
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(-1);

        radio.setPrevRadioStation();

        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected,actual);

    }

    @Test

    public void prevRadioStation8() {  // Переключение на предыдущую   радиостанцию
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(8);

        radio.setPrevRadioStation();

        int expected = 7;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected,actual);

    }


    @Test

    public void prevRadioStation1() {  // Переключение на предыдущую   радиостанцию
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(0);

        radio.setPrevRadioStation();

        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void uppVolume() { // прибавление громкости в максимальном значение
        Radio radio = new Radio();
        radio.setLimitValuesVolume(100);

        radio.setUppVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void uppVolumeOnTheBorder() { // прибавление громкости в максимальном значение, выше установленных границ
        Radio radio = new Radio();
        radio.setLimitValuesVolume(101);

        radio.setUppVolume();

        int expected = 1;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void uppVolume55() { // прибавление громкости
        Radio radio = new Radio();
        radio.setLimitValuesVolume(55);

        radio.setUppVolume();

        int expected = 56;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void maxVolume() { // максимальная громкость
        Radio radio = new Radio();
        radio.setLimitValuesVolume(100);


        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void MinVolume() { // Минимальная громкость
        Radio radio = new Radio();
        radio.setLimitValuesVolume(0);


        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void belowMinVolume() { // ниже Минимальной  громкости
        Radio radio = new Radio();
        radio.setLimitValuesVolume(-1);


        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void higherMaxVolume() { // Выше максимальной громкости
        Radio radio = new Radio();
        radio.setLimitValuesVolume(101);


        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void downVolume() { // Убавление громкости в минимальном значение, находясь на границе выставленных значений
        Radio radio = new Radio();
        radio.setLimitValuesVolume(0);

        radio.setDownVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void downVolume56() { // Убавление громкости
        Radio radio = new Radio();
        radio.setLimitValuesVolume(55);

        radio.setDownVolume();

        int expected = 54;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }
}






