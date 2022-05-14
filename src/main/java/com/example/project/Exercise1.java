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

	public boolean esCuadradoPerfecto(int numero) {
		//Significa que luego de una llamada recursiva, el numero es divisible por un cuadrado perfecto
		if (numero == 1) return true;
		/* Se sabe que numero es cuadrado perfecto si es multiplicacion de 2 numeros naturales
		 * o el de otros 2 cuadrados perfectos (n^2 = a^2 * b^2)
		*/
		for (int a = 2; Math.pow(a, 2) <= numero; a++)
			// Probamos si "numero" es divisble por algun cuadrado perfecto menor o igual a el mismo
			if(numero % Math.pow(a, 2) == 0)
				// Si es divisble, hay que probar si el cociente (b) tambien cuadrado perfecto
				return esCuadradoPerfecto((int) (numero/Math.pow(a, 2)));
		return false;
	}
}
