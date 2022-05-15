package com.example.project;

import java.util.Scanner;

public class Exercise2 {

	public static void main(final String[] args) {

		Exercise2 obj = new Exercise2();
		Scanner sc = new Scanner(System.in);
		while (true) {

			int n = sc.nextInt(), suma;
			int a[] = new int[n];

			for (int i = 0; i < a.length; i++) { // n no debería actualizarse si se va a comparar
				n = sc.nextInt();
				a[i] = n;
			}

			suma = sc.nextInt();

			System.out.println(obj.esSubconjuntoSumaExt(a, suma));
		}
	}

	public boolean esSubconjuntoSumaExt(int a[], int suma) {
		// System.out.println("\ta: " + Arrays.toString(a) + "\tsum: " + suma);
		// Si "suma" es 0, significa que dentro del array hay numeros cuya suma es igual a "suma"
		if (suma == 0)
			return true;
		// Si ya se utlizaron todos los numeros y "suma" no es 0, significa que no hay subconjuntos que sumen "suma"
		if (a.length == 0)
			return false;
		// Guardamos el ultimo valor del array antes de eliminarlo y para analizarlo
		int last = a[a.length-1];
		// si este valor es 1
		if (last == 1 && a.length>1)
			// Revisa, si se puede, si el valor siguiente es multiplo de 7
			if (a[a.length-2] % 7 == 0)
				// Si lo es, lo reemplaza por 0, asi no contaria en la suma
				a[a.length-2] = 0;
		// Si el ultimo valor es diferente de 0, pero multiplo de 7
		if (last != 0 && last % 7 == 0)
			// Se considera obligatoriamente en la suma
			return esSubconjuntoSumaExt(a, suma - last);
		// Eliminamos el ultimo valor, ya que no tenemos un indice n en la funcion
		a = Arrays.copyOf(a, a.length-1);
		// Y retornamos el subconjunto contando el ultimo valor, y sin contarlo
		return esSubconjuntoSumaExt(a, suma - last) || esSubconjuntoSumaExt(a, suma);
	}
}
