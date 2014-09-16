package algoritmos;

import java.util.Scanner;

public class NextFit {

    public static void main(String[] args) {

        System.out.println("---------------NEXT FIT---------------");
        System.out.println("");
        
        Scanner in = new Scanner(System.in);
        System.out.println("NÃºmeros de processos:");
        
        int p = in.nextInt();

        System.out.println("NÃºmero de blocos de memÃ³ria:");
        int m = in.nextInt();

        int parr[] = new int[p],
            marr[] = new int[m],
            marrAux[] = new int[m];

        for (int i = 0; i < p; i++) {
            System.out.println("Tamanho do processo (" + (i + 1) + ") :");
            parr[i] = in.nextInt();
        }

        for (int i = 0; i < m; i++) {
            System.out.println("Tamanho da memória [" + (i + 1) + "] :");
            marr[i] = in.nextInt();
            marrAux[i] = 0;
        }
        
        System.out.println("");
        
        int j = 0, i;
        
        int passou = 0;
        for (i = 0; i < m; i++) {                              
            if (marr[i] > parr[j] && marrAux[i] == 0) {
                marr[i] -= parr[j];
                System.out.println("Alocado processo " + (j + 1) + " para memória " + (i + 1) + " tamanho que permaneceu depois de alocar " + marr[i]);                                
                j = j + 1;
                passou = 1;
                marrAux[i] = 1;                               
                if (j == p) {                    
                    i = m;
                }
            }                                                        
            if (i == (m - 1)){                          
                if (passou == 1){
                    i = 0;
                }else{                                                  
                    System.out.println("Não há mais memória suficiente!");                              
                }
            }
        } 
        if (j < p) {                                
            System.out.println("Não há mais memória suficiente!");
        } 

    }
}

