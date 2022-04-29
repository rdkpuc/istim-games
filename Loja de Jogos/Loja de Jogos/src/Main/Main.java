package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import Controle.*;
import Aplicativo.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Aplicativo aplicativo = new Aplicativo();
		aplicativo.inicializar();
		
		int entrada =0;
		while(entrada != 6) {
			String menu ="1 - Adicionar Jogo \n" +
	                 "2 - Excluir Jogo \n" +
				     "3 - Mostrar Jogo Especifico \n" + 
	                 "4 - Mostrar Todos os Jogos por Ordem de Lançamento \n"+
				     "5 - Mostrar Todos os Jogos por Nome \n"  +
	                 "6 - Finalizar Programa";
			System.out.println(menu);
			entrada = in.nextInt(); 
			aplicativo.menu(entrada);
					
		}
}	
}