package com.example.project;

import java.util.Scanner;

public class Exercise1 {

	public static void main(final String[] args) {
		Exercise1 obj = new Exercise1();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			System.out.println(obj.esCuadradoPerfecto(n));			
		}
	}

	/*
	 * Tenemos que un numero cuadrado siempre sera producto de otros 2 cuadrados
	 * n^2 = a^2 * b^2
	 * Por ejemplo: 64 = 4^2 * 2^2
	 * Mi codigo buscara dividir el numero que queremos probar entre cuadrados perfectos
	 * Si llega a 1, es porque el numero si es un cuadrado perfecto
	 * Si no es divisible, llegara a 0, false
	 */
	
	public boolean esCuadradoPerfecto(int numero) {
		// 0 no es un cuadardo perfecto
		// Ademas, es el codigo de error que arroja la otra funcion
		if (numero == 0) return false;
		// 1 significa que en la anterior ejecucion, el numero fue divisible por otro cuadrado
		if (numero == 1) return true;
		// Si es otro entero, probamos si este es divisible por otro cuadrado
		// Empezamos el divisor en 2, porque el 1 divide a todos los numeros
		return esCuadradoPerfecto(esDivisblePorCuadradoPerfecto(numero, 2));
	}
	
	public int esDivisblePorCuadradoPerfecto(int numero, int divisor) {
		// Si el cuadrado del divisor es mayor al numero, el numero no es cuadrado
		if ((int) Math.pow(divisor, 2) > numero)
			return 0;
		// Si la division no exacta, probamos con el siguiente cuadrado como divisor
		if (numero % (int) Math.pow(divisor, 2) > 0)
			return esDivisblePorCuadradoPerfecto(numero, divisor + 1);
		// Si la division fue exacta, probamos el nuevo cuadrado perfecto, que puede ser 1
		return (int) (numero / Math.pow(divisor, 2));
	}
}
