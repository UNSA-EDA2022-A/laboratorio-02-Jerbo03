package com.example.project;

import java.util.Scanner;

public class Exercise2 {

	public static void main(final String[] args) {

		Exercise2 obj = new Exercise2();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int an = sc.nextInt()+2;
			int a[] = new int[an];
			a[0] = an-2;
			for (int i = 1; i < an; i++) {
				int n = sc.nextInt();
				a[i] = n;
			}

			System.out.println(obj.esSubconjuntoSumaExt(a));
		}
	}

	public boolean esSubconjuntoSumaExt(int a[]) {
		//System.out.println("In: " + Arrays.toString(a));
		if (a[a.length-1] == 0) { 
			System.out.println("\ttrue\n");
			return true;
		}
		if (a[0] == 0 || a[a.length-1] < 0) { 
			System.out.println("\tfalse\n");
			return false;
		}
		/* verificamos si conseguimos la suma por alguna de las siguientes formas:
		(a) incluyendo el primer elemento
		(b) excluyendo el primer elemento */
		a[0]--;
		int b[] = a.clone();
		b[b.length-1] -= b[b[0]+1];
		//System.out.println("\ta: " + Arrays.toString(a));
		//System.out.println("\tb: " + Arrays.toString(b));
		return esSubconjuntoSumaExt(a) || esSubconjuntoSumaExt(b);
	}
}
