package control;

import java.awt.image.IndexColorModel;

public class Principal {

	public static void main(String[] args) {

		Principal ejercicio = new Principal();
		
		//CASO 1 IZQ
		/*
		int[] lista1 = {0, 1, 3, 9};
		int[] lista2 = {1, 2, 3, 4, 5, 6, 7};
		*/
		/*
		int[] lista1 = {1, 2, 3, 4, 5, 6, 7};
		int[] lista2 = {0, 1, 3, 9};
		*/
		
		//CASO 2 IZQ
		
		/*
		int[] lista1 = {1, 2, 3, 5, 5, 6, 7};
		int[] lista2 = {0, 1, 3, 4};
		*/
		/*
		int[] lista1 = {0, 1, 3, 4};
		int[] lista2 = {1, 2, 3, 5, 5, 6, 7};
		*/
		
		//CASO 3
		/*
		int[] lista1 = {1, 2, 3, 4, 5, 6, 7};
		int[] lista2 = {0, 1, 3, 4};
		*/
		/*
		int[] lista1 = {0, 1, 3, 4};
		int[] lista2 = {1, 2, 3, 4, 5, 6, 7};
		*/
				
		//int[] mezclaListas = ejercicio.mezclarListasOrdenadas(lista1, lista2);
		//int[] listaMezclada = ejercicio.copiarArray(lista1, lista2);
		//ejercicio.ordenarLista(listaMezclada);
		
		//ordenar matriz
		
		int[][] matrizDesordenada = {
				{0, 11, 10, 1},
				{2, 8, 4, 6, 12},
				{15, 20},
				{9, 3, 1, 7, 5, 11}
		};
		
		//int numeroColumnas = ejercicio.columnasArray(matrizDesordenada);
		ejercicio.ordenarMatriz(matrizDesordenada);
		
		System.out.println("FIN DEL PROGRAMA");
		
		
	}
	
	public int[] mezclarListasOrdenadas (int[] l1, int[] l2) {
		int[] resultado = new int[l1.length + l2.length];
		int i = 0;
		int j = 0;
		
		for (int k = 0; k < resultado.length; k++) {
			try {
				if (l1[i] <= l2[j]) {
					resultado[k] = l1[i];
					i++;
				} else {
					resultado[k] = l2[j];
					j++;
				}
			} catch (IndexOutOfBoundsException e1) {
				/**
				 * CASO 1
				 *@param l1(1, 2, 3, 4, 5, 6 , 7)
				 *@param l2(0, 1, 3, 9)
				 */
				
				if (l1.length > l2.length ) {
					try {
						/**
						 * CASO 2
						 *@param l1(1, 2, 3, 5, 5, 6 , 7)
						 *@param l2(0, 1, 3, 4)
						 */
						resultado[k] = l1[i];
						i++;
					} catch (IndexOutOfBoundsException e2) {
						/**
						 * CASO 1
						 *@param l1(0, 1, 3, 9)
						 *@param l2(1, 2, 3, 4, 5, 6 , 7)
						 */
						resultado[k] = l2[j];
					}
				} else {
					try {
						/** CASO 3
						 *@param l1(1, 2, 3, 4, 5, 6 , 7)
						 *@param l2(0, 1, 3, 4)
						 */
						resultado[k] = l2[j];
						j++;
					} catch (IndexOutOfBoundsException e3) {
						/**
						 * CASO 1
						 *@param l1(1, 2, 3, 4, 5, 6 , 7)
						 *@param l2(0, 1, 3, 9)
						 */
						resultado[k] = l1[i];
					}
				}
				
			}
		}

		return resultado;
	}
	
	public void ordenarMatriz (int[][] matriz) {
		int aux = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				for (int k = 0; k < matriz.length; k++) {
					for (int l = 0; l < matriz[k].length; l++) {
						if (matriz[i][j] < matriz[k][l]) {
							aux = matriz[i][j];
							matriz[i][j] = matriz[k][l];
							matriz[k][l] = aux;
						}
					}
				}
			}
		}
	}
	
	public void ordenarLista (int[] lista) {
		int aux;
		for (int i = 0; i < lista.length; i++) {
			for (int j = 0; j < lista.length; j++) {
				if (lista[i] < lista[j]) {
					aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}
		}
	}
	/*
	public int columnasArray (int [][] matriz) {
		int columnas = 0;
		int cont = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				cont++;
			}
			if (cont > columnas) {
				columnas = cont;
			}
			cont = 0;
		}
		return columnas;
	}
	*/
	
	public int[] copiarArray (int[] l1, int[] l2) {
		int[] resultado = new int[l1.length + l2.length];
		int i = 0;
		int j = 0;
		for (int k = 0; k < resultado.length; k++) {
			if (i < l1.length) {
				resultado[k] = l1[i];
				i++;
			} else {
				resultado[k] = l2[j];
				j++;
			}
		}
		return resultado;
	}

}
