package Aplicativo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import Controle.*;
public class Aplicativo {
	ControleJogo controle = new ControleJogo(200);
	
	public void inicializar() {
		Scanner entradaArquivo= null;
		try {
			entradaArquivo = new Scanner(new File("Base_De_Dados.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int quantLinhas =  Integer.parseInt(entradaArquivo.nextLine());
		for(int i =0; i < quantLinhas; ++i) {
			String entrada = entradaArquivo.nextLine();
			String dados [] = entrada.split(";");
			controle.adicionar(Integer.parseInt(dados[0]), dados[1], dados[2], Integer.parseInt(dados[3]) , Double.parseDouble(dados[4]));
		}
	}
	
	
	public void menu(int escolha) {
		Scanner in = new Scanner(System.in);
		String vetor []= {"Id do Jogo : ", "Nome do Jogo : ", "Plataforma : ", "Ano de Lançamento : ", "Preço do Jogo : "};
		String entrada="";
		switch(escolha) {
///********************************************************Adicionar Jogo ******************************************************///
		case 1:
			for(int i =0; i < vetor.length; ++i) {
				System.out.print(vetor[i]+ " ");
				entrada += in.nextLine() + ";";
			}
			String dados[] = entrada.split(";");
			controle.adicionar(Integer.parseInt(dados[0]), dados[1], dados[2],  Integer.parseInt(dados[3]),Double.parseDouble(dados[4]));
			System.out.println(" Jogo Adicionado !!! \n");
			break;
			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///*********************************************************Excluir Jogo******************************************************///
		case 2:

				System.out.println("Parametro do Jogo que sera Buscado pra ser excluido : \n" +
						 "1 - Id do Jogo :\n"+
						 "2 - Nome do Jogo");
				 int parametroDeExclusao = in.nextInt();
				 Scanner n = new Scanner(System.in);
				if(parametroDeExclusao == 1) {
					System.out.print("Qual o Id do Jogo a ser buscado : ");
					int idBusca = n.nextInt();
					if( controle.retornarJogo(idBusca)!= null ) {
						String txt = controle.retornarJogo(idBusca).toString();
						controle.excluirJogo(controle.retornarJogo(idBusca));
						System.out.println("O Jogo Exclúido é o : \n " + txt  + "\n");
					}
					else {
						System.out.println("O Jogo de Identificação : " + idBusca +" não foi encontrado" );

					}
				}
				else if(parametroDeExclusao == 2) {
					System.out.print("Qual o Nome do Jogo a ser buscado : ");
					in.nextLine();
					String nomeExclusao = in.nextLine();
					if( controle.retornarJogo(nomeExclusao)!= null ) {
						String txt = controle.retornarJogo(nomeExclusao).toString();
						controle.excluirJogo(controle.retornarJogo(nomeExclusao));
						System.out.println("O Jogo Exclúido é o : \n " + txt  + "\n");					}
					else {
						System.out.println("O Jogo de Identificação : " + nomeExclusao +" não foi encontrado" );

					}
				}
				else {
					System.out.println("Opção Inválida");
				}
		
			break;
			
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///****************/********************************************Buscar Jogo********************************************************///
		case 3:
			
			System.out.println("Por qual parametro deseja buscar o Jogo :\n" +
				    "1 - Id do Jogo :\n"+
					"2 - Nome do Jogo");
			 int parametroDeBusca = in.nextInt();
			 
			if(parametroDeBusca == 1) {
				System.out.print("Qual o Id do Jogo a ser buscado : ");
				int idExclusao = in.nextInt();
				if( controle.retornarJogo(idExclusao)!= null ) {
					System.out.println("O Jogo Buscado é o : \n " + controle.retornarJogo(idExclusao).toString() + "\n");
				}
				else {
					System.out.println("O Jogo de Identificação : " + idExclusao +" não foi encontrado" );

				}
			}
			else if(parametroDeBusca == 2) {
				System.out.print("Qual o Nome do Jogo a ser buscado : ");
				in.nextLine();
				String nomeExclusao = in.nextLine();
				if(controle.retornarJogo(nomeExclusao) != null) {
					System.out.println("O Jogo Buscado é o : \n " + controle.retornarJogo(nomeExclusao).toString() + "\n");
				}
				else {
					System.out.println("O Jogo de nome : " + nomeExclusao +" não foi encontrado" );
				}
			}
			else {
				System.out.println("Opção Inválida");
			}
			break;
			
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///**********************************************************Mostrar Jogos***********************************************************///
			
		case 4:
			controle.ordenarVetorPorAno();
			System.out.println(controle.mostrarJogos());
			break;
		case 5:
			controle.ordenarVetorPorNome();
			System.out.println(controle.mostrarJogos());
			break;
			

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
///*******************************************************Finalizar Programa*********************************************************///
			
		case 6:
			try {
				FileWriter file = new FileWriter("Nova_Base_De_Dados.txt");
				file.write(controle.mostrarJogos());
				file.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
			System.out.println("Código Não Identificado");
			break;
		}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	}

	
}
