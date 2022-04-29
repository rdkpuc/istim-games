package Controle;
import Jogo.*;
import Ordenacao.*;
public class ControleJogo {
	
	private int quantJogos;
	private JogoDigital jogos[];
	private int posicao =-1;
	private JogoDigital ultimoJogo;
	
	public ControleJogo(int quantJogos) {
		this.quantJogos = quantJogos;
		this.jogos = new JogoDigital[quantJogos];
	}
	
//******************************Inicio Métodos de Adição********************************//

	public void adicionar(int id, String nome, String plataforma , int anoLancamento , double preco) {
		if(posicao<quantJogos) {
			posicao++;
			jogos[posicao] = new JogoDigital( id,  nome,  plataforma ,  anoLancamento ,  preco);
		}
		else {
			System.out.println("Armazenamento cheio");
		}
	}
	public void adicionar(JogoDigital jogo) {
		if(posicao<quantJogos) {
			posicao++;
			jogos[posicao] = jogo;
		}
		else {
			System.out.println("Armazenamento cheio");
		}
	}
	
//********************************Fim Métodos de Adição********************************//
	
//******************************Inicio Métodos de Exclusão****************************//
	public JogoDigital excluirJogo(JogoDigital jogo) {
		if(posicao>=0) {
			posicao--;
			for(int i =0; i <= posicao;) {
				if(jogos[i] == jogo) {
					ultimoJogo = jogos[i];
					jogos[i] = null;
					realocarVetor(i);
					return ultimoJogo;
				}
				else {
					++i;
				}
			}
		}
		return  null;
	}
	
//******************************Fim Métodos de Exclusão*****************************//

//******************************Inicio Métodos de Busca*****************************//

	public JogoDigital retornarJogo(String nome) {
		for(int i =0; i <= posicao;) {
			if(jogos[i].getNomeJogo().equals(nome)) {
				return jogos[i]; 		
			}
			else {
				++i;
			}
		}
		return null;
	}
	public JogoDigital retornarJogo(int id) {
		for(int i =0; i <= posicao;) {
			if(jogos[i].getIdJogo() == id) {
				return jogos[i]; 		
			}
			else {
				++i;
			}
		}
		return null;
	}
	
//*******************************Fim Métodos de Busca*******************************//

//*********************Inicio Métodos de Ordenação*****************************//
	public void ordenarVetorPorAno() {
		Ordenacao ordenar = new Ordenacao();
		jogos = ordenar.quicksortAnoLancamento(jogos, 0, posicao);
		
	}
	public void ordenarVetorPorNome() {
		Ordenacao ordenar = new Ordenacao();
		jogos = ordenar.quicksortNome(jogos, 0, posicao);

	}
	
//*********************Fim Métodos de Ordenação******************************//
	private void realocarVetor(int indice) {
		for(int i = indice; i< posicao; ++i) {
			jogos[i] = jogos[i+1];
		}
	}
	
//*********************Inicio Métodos de Impressão****************************//
	public String mostrarJogos() {
		String txt = "";
			
		for(int i =0; i<= posicao; ++i) {
			txt+= jogos[i].toString() + "\n";
		}
		return txt;
	}
//*********************Fim Métodos de Impressão***********************//

}
