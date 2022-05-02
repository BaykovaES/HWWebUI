package org.example.Hw4;

import org.example.HWLesson4.MyException;
import org.example.HWLesson4.Triangle;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.HWLesson4.Triangle.triangleArea;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HwTriangleTest {
    Logger logger = LoggerFactory.getLogger(HwTriangleTest.class);

    @Test
    public void areaExistingTriangle() throws MyException {
        logger.info("Тест 1: проверка сходимости формулы на существующем треугольнике");
        assertFalse(Triangle.triangleArea(3,6,7)==0);
        logger.info("\tТест успешен");
    }

    @ParameterizedTest
    @CsvSource({"0,6,7","-3,-6,-7","3,-6,7"})
    public void exceptionsTriangle(int a, int b, int c) throws MyException {
        logger.info("Тест 2: проверка исключения вычисления площади на треугольниках");
        logger.info("\tВходящие параметры - (a,b,c) - " +a+", "+b+", "+c);
        assertThrows(MyException.class, ()->Triangle.triangleArea(a, b, c));;
        logger.info("\tТест успешен");
    }



    @Test
     public void triangleNotExist() throws MyException {
        logger.info("Тест 3: проверка корректности срабатывания исключения, когда треугольник не существует");
        assertThrows(MyException.class, ()->Triangle.triangleArea(233, 6, 7));
        logger.info("\tТест успешен");
    }
}
