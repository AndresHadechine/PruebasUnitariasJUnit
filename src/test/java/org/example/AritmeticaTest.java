package org.example;

import org.junit.jupiter.api.*;

class AritmeticaTest {

    static Aritmetica aritmetica;

    @BeforeAll
    public static void initClass(){
        aritmetica = new Aritmetica();
    }
    @AfterAll
    public static void finishClass(){
        aritmetica = null;
    }

    @BeforeEach
    public void init(){
        //aritmetica = new Aritmetica();
    }

    @AfterEach
    public void finish(){
        //aritmetica = null;
    }

    @Test
    void suma() {
        //Arrange
        float primerSumando = 4;
        float segundoSumando = 5;
        float resultado;
        float resultadoEsperado = 9;

        //Act
        resultado = aritmetica.suma(primerSumando, segundoSumando);

        //Assert
        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void resta() {
        Assertions.assertEquals(3, aritmetica.resta(7, 4));
    }

    @Test
    void multipliacion() {
        Assertions.assertEquals(50, aritmetica.multipliacion(5, 10));
    }

    @Test
    void division() {
        Assertions.assertEquals(2, aritmetica.division(10, 5));
    }

    @Test
    void divisionPorCero() {
         ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> {
             aritmetica.division(4, 0);
         });
        Assertions.assertEquals("Divisor no puede ser cero", exception.getMessage());
    }

}