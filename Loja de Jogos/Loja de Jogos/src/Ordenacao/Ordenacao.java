package Ordenacao;
import Controle.*;
import Jogo.*;
public class Ordenacao {
	
	public JogoDigital [] quicksortAnoLancamento(JogoDigital jogos[] , int inicio , int fim) {
		int part;
		if(fim - inicio >1) {
			
			part = particao(jogos , inicio , fim);
			quicksortAnoLancamento(jogos , inicio , part -1);
			quicksortAnoLancamento(jogos , part+1, fim);
			
		}
		return jogos;
		
	}
	private void trocar(JogoDigital[] jogos, int part, int i) {
		JogoDigital aux;
		aux = jogos[i];
		jogos[i] = jogos[part];
		jogos[part] = aux;
	}
	private int particao(JogoDigital jogos[] , int inicio , int fim) {
		int meio = (inicio + fim)/2;
		JogoDigital pivot = jogos[fim];
		int part = inicio-1;
		for(int i =inicio; i < fim; ++i) {
			if(jogos[i].getAnoLancamento() < pivot.getAnoLancamento()) {
				part = part+1;
				trocar(jogos, part , i);
			}
			else if(jogos[i].getAnoLancamento() == pivot.getAnoLancamento()) {
				if(jogos[i].getNomeJogo().compareTo(pivot.getNomeJogo()) < 0) {
					part = part+1;
					trocar(jogos, part , i);
				}
	
				else if(jogos[i].getNomeJogo().compareTo(pivot.getNomeJogo()) == 0) {
					if(jogos[i].getPreco() > pivot.getPreco()) {
						part = part+1;
						trocar(jogos, part , i);

					}
				}
			}
		
		}	
		part ++;
		trocar(jogos , part , fim);
		return (part);
	}
	
	public JogoDigital[] quicksortNome(JogoDigital []jogos , int inicio, int fim) {
		int part;
		if(inicio<fim) {
			part = particaoNome(jogos , inicio , fim);
			quicksortNome(jogos , inicio , part-1);
			quicksortNome(jogos , part+1, fim);
		}
		return jogos;
	}
	private int particaoNome(JogoDigital[] jogos, int inicio, int fim) {
		// TODO Auto-generated method stub
		JogoDigital pivot = jogos[fim];
		int part = inicio -1;
		for(int i = inicio;i<fim; ++i) {
			if(jogos[i].getNomeJogo().compareTo(pivot.getNomeJogo())<0) {
				part++;
				trocar(jogos, part , i);
			}
		}
		part++;
		trocar(jogos,part , fim);
		return (part);
	}
	
	
}
