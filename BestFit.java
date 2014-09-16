package algoritmos;

import java.util.Scanner;

public class BestFit {

    public static void main(String args[]) {

        int p, m;
        Scanner in = new Scanner(System.in);

        System.out.println("---------------BEST FIT---------------");
        System.out.println("");
        
        System.out.println("Números de processos:");
        p = in.nextInt();
        System.out.println("Número de blocos de memória:");
        m = in.nextInt();

        int tamProcessos[] = new int[p];
        int segMemoria[] = new int[m];
        int segMemoriaAux[] = new int[m];

        int i;

        for (i = 0; i < p; i++) {
            System.out.println("Tamanho do processo (" + (i + 1) + ") :");
            tamProcessos[i] = in.nextInt();
        }

        for (i = 0; i < m; i++) {
            System.out.println("Tamanho da memória [" + (i + 1) + "] :" );
            segMemoria[i] = in.nextInt();
            segMemoriaAux[i] = 0;
        }

        int j = 0;

        for (i = 0; i < m; i++) {
            for (j = i + 1; j < m; j++) {
                if (segMemoria[i] > segMemoria[j]) {
                    int t = segMemoria[i];
                    segMemoria[i] = segMemoria[j];
                    segMemoria[j] = t;
                }
            }
        }
        
        j = 0;
                  
        for (i = 0; i < m; i++) {                   
            if (segMemoria[i] > tamProcessos[j] && segMemoriaAux[i] == 0) {
                segMemoria[i] -= tamProcessos[j];
                System.out.println("Alocado processo " + (j + 1) + " para memória " + (i + 1) + " tamanho que permaneceu depois de alocar " + segMemoria[i])
                j = j + 1; 
                segMemoriaAux[i] = 1;
                i = 0;
                if (j == p) {
                    i = m;
                }
            }
        }
        if (j < p) {
            System.out.println("Não há mais memória suficiente!");
        }
    }
}
