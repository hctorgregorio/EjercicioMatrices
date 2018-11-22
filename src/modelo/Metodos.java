package modelo;

public class Metodos {
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
			} catch (IndexOutOfBoundsException e) {
				/**
				 * CASO 1
				 *@param l1(1, 2, 3, 4, 5, 6 , 7)
				 *@param l2(0, 1, 3, 9)
				 */
				resultado[k] = l2[j];
			}
		}

		return resultado;
	}
}
