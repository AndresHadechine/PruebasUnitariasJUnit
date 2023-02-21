package org.example;

public class Aritmetica {
    private float ultimoResultado;
    private CalculadoraAppService service;

    public float suma(float primerSumando, float segundoSumando) {
        return ultimoResultado = primerSumando + segundoSumando;
    }

    public float resta(float minuendo, float sustraendo) {
        return ultimoResultado = minuendo - sustraendo;
    }

    public float multipliacion(float primerFactor, float segundoFactor) {
        return ultimoResultado = primerFactor * segundoFactor;
    }

    public float division(float dividendo, float divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor no puede ser cero");
        }
        return ultimoResultado = dividendo / divisor;
    }

    public int potencia(String usuario, String contraseña, int base, int exponente) throws Exception {
        boolean login = service.login(usuario, contraseña);

        if (!login) {
            throw new Exception("Usuario o la contraseña son inválidos");
        }
        return service.potencia(base, exponente);
    }
}
