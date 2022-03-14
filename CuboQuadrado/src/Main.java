/**
 * Problema "Cubo e Quadrado", N�vel 2, 2021, fase 3;
 *@author Renan Rodrigues Lacerda
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Receber dados sobre o intervalo de busca desejado
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		//Cria��o dos vetores que receber�o valores quadr�ticos e c�bicos
	    long[] vetQuadrado=new long[y];
	    long[] vetCubos=new long[y];
	    
	    //Para o intervalo at� o limite superior, � feito o c�lculo de todos os valores quadr�ticos e c�bicos
	    int k=0;
	    for(long i=1;i<=y;i++){
	        vetQuadrado[k]=i*i;
	        vetCubos[k]=i*i*i;
	        k++;
	    }
	    
	    //Utilizando um algoritmo de busca bin�ria, � poss�vel pesquisar, para os n�meros indicados no intervalo inicial, se os mesmos aparecem siult�neamente nos vetores de quadr�ticos e c�bicos
	    int cuboQuadrado=0;
	    for(long i=x;i<=y;i++){
	        if(buscaBinaria(vetQuadrado, 0, y-1, i)!=-1){
	            if(buscaBinaria(vetCubos, 0, y-1, i)!=-1){
	            	//Caso algum n�mero tenha essa propriedade, incremento meu contador de cuboQuadrado.
	                cuboQuadrado++;
	            }
	        }
	    }

	    System.out.println(cuboQuadrado);
	    sc.close();
		
	}
	
	public static int buscaBinaria(long[]vet, int l, int r, long buscar) {
		int meio;
		while(l<=r){
	        meio=(l+r)/2;
	        if(vet[meio]==buscar){
	            return meio;
	        }else if(vet[meio]>buscar){
	            r=meio-1;
	        }else{
	            l=meio+1;
	        }
	    }
		return -1;
	}

}
