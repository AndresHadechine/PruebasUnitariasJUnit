package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AritmeticaTest {

    @InjectMocks
    public static Aritmetica aritmetica;

    @Mock
    private CalculadoraAppService service;

    @BeforeAll
    public static void initClass() {
        aritmetica = new Aritmetica();
    }

    @AfterAll
    public static void finishClass() {
        aritmetica = null;
    }

    @BeforeEach
    public void init() {
        //aritmetica = new Aritmetica();
    }

    @AfterEach
    public void finish() {
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

    @Test
    public void testPotencia() throws Exception {
        //Arrange
        String usuario = "andres";
        String contrasena = "hadechine";
        int base = 2;
        int exponente = 2;
        Mockito.when(service.login(usuario, contrasena)).thenReturn(true);
        Mockito.when(service.potencia(base, exponente)).thenReturn(4);

        //Act
        int resultado = aritmetica.potencia(usuario, contrasena, base, exponente);

        //Assert
        Assertions.assertEquals(4, resultado);
    }

    @Test
    public void testPotenciaLoginInvalido() throws Exception {
        //Arrange
        String usuario = "usuario";
        String contrasena = "invalido";
        int base = 2;
        int exponente = 2;
        Mockito.when(service.login(usuario, contrasena)).thenReturn(false);

        //Act
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            aritmetica.potencia(usuario, contrasena, base, exponente);
        });

        //Assert
        Assertions.assertEquals("Usuario o la contraseña son inválidos", exception.getMessage());
    }

}