package org.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void setWave() { // включение определенной радиостанции
        Radio radio = new Radio();
        radio.setLimitValuesStationNumber(9);

        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void aboveValidStationNumber() { //проверка границ радиостанции (выше валидного диапазона)
        Radio radio = new Radio();

        radio.setLimitValuesStationNumber(10);

        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void validRangeStationNumber() { //проверка границ радиостанции ( валидный  диапазон)
        Radio radio = new Radio();

        radio.setLimitValuesStationNumber(9);

        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void belowValidRangeStationNumber() { //проверка границ радиостанции (ниже валидного диапазона)
        Radio radio = new Radio();
        radio.setLimitValuesStationNumber(-1);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void NextStation() { // Переключение на следующую  радиостанцию
        Radio radio = new Radio();
        radio.setNextRadiostation(1);

        int expected = 2;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);

    }
    @Test

    public void NextStationOnTheBorder() { // Переключение на следующую  радиостанцию
        Radio radio = new Radio();
        radio.setNextRadiostation(9);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);

    }
    @Test

    public void NextStationNegativeMeaning() { // Переключение на следующую  радиостанцию
        Radio radio = new Radio();
        radio.setNextRadiostation(-1);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void prevRadioStationNegativeMeanin() { // Переключение радиостанции назад
        Radio radio = new Radio();
        radio.setPrevRadioStation(-1);


        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void prevRadioStation10() { // Переключение радиостанции назад
        Radio radio = new Radio();
        radio.setPrevRadioStation(10);


        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void prevRadioStation9() { // Переключение радиостанции назад
        Radio radio = new Radio();
        radio.setPrevRadioStation(9);


        int expected = 8;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void prevRadioStation() { // Переключение радиостанции назад
        Radio radio = new Radio();
        radio.setPrevRadioStation(-1);


        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);

    }
    @Test

    public void selectAnyVolume() { //выбор любой громкости
        Radio radio = new Radio();
        radio.setIncreaseVolume(55);


        int expected = 55;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
    @Test

    public void switchingVolumeRadioUpp() { // Увеличение громкости
        Radio radio = new Radio();

        radio.setVolumeUpp(15);


        int expected = 16;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }
    @Test

    public void switchingVolumeRadioDown() { // Уменьшение громкости
        Radio radio = new Radio();

        radio.setVolumeDown(99);


        int expected = 98;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }
    @Test

    public void maxVolumeIncreaseLimits() { // максимальный  граничные значения увеличения громкости
        Radio radio = new Radio();

        radio.setVolumeUpp(101);


        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }
    @Test

    public void higherMaxVolumeIncreaseLimits() { // выше максимальньного  граничного значения увеличения громкости
        Radio radio = new Radio();

        radio.setVolumeUpp(0);


        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }
    @Test

    public void higherMaxVolumeIncreaseLimits100() { // выше максимальньного  граничного значения увеличения громкости
        Radio radio = new Radio();

        radio.setVolumeUpp(100);


        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }
    @Test

    public void minVolumeIncreaseLimits2() { // минимальные граничные значения уменьшения  громкости
        Radio radio = new Radio();

        radio.setVolumeDown(2);


        int expected = 1;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }
    @Test

    public void belowMinVolumeIncreaseLimits() { // ниже минимального граничного значения уменьшения громкости
        Radio radio = new Radio();

        radio.setVolumeDown(0);


        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }
    @Test

    public void belowMinVolumeIncreaseLimit() { // предел минимального граничного значения уменьшения громкости
        Radio radio = new Radio();

        radio.setVolumeDown(100);


        int expected = 99;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }
    @Test

    public void belowMinVolumeIncreaseLimitsIs() { // выше предела  минимального граничного значения уменьшения громкости
        Radio radio = new Radio();

        radio.setVolumeDown(1011);


        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }


}



