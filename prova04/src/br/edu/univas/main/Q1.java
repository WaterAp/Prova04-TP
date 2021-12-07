package br.edu.univas.main;

import java.util.Scanner;
import br.edu.univas.vo.*;

public class Q1 {

	static int all = 50, ig = 0, ib = 0;
	static boolean deleteMode = false;
	static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		
     
		
		int option;
		boolean control = true;
		
		Veiculos[] veiculo = new Veiculos[all];
		
		
		do {
			
			menu();
			
			option = ler.nextInt();
            ler.nextLine();
			
			switch(option) {
				
				case 1:
					
					register(veiculo);
					deleteMode = false;
					
					break;
					
				case 2:
					
					printing(veiculo);
					
					break;
					
				case 3:
					deleteMode = true;
					System.out.println("Digite as caracteristicas do veiculo que deseja deletar para busca-lo: ");
					register(veiculo);
					
					
					break;
					
				case 4:
					
					System.out.println("Até mais!!!");
					control = false;
					
					break;
			
				default:
					
					System.out.println("Opção Inválida, tente novamente");
					
					break;
			
			
			
			}
			
		} while (control);
		ler.close();
		

	}

	public static void menu() {
		
		System.out.println("Cadastro de carros              ");
		System.out.println("1. Cadastro de Veículo          ");
		System.out.println("2. Listar todos os veículos     ");
		System.out.println("3. Remover um veículo cadastrado");
		System.out.println("4. Sair                         ");
		System.out.println("Escolha uma opção.              ");
		
		
	}
	
	public static void register(Veiculos[] veiculo) {
		
		Veiculos novoVeiculo = new Veiculos();
		
		System.out.println("Por favor digite a marca do veiculo: ");
		novoVeiculo.marca = ler.nextLine();
		
		System.out.println("Agora por favor digite a cor do veiculo: ");
		novoVeiculo.cor = ler.nextLine();
		
		System.out.println("Agora por favor digite o ano de fabricação do veiculo: ");
		novoVeiculo.anoFab = ler.nextInt();
		
		System.out.println("Agora por favor digite o ano do modelo: ");
		novoVeiculo.anoModel = ler.nextInt();
		
		System.out.println("Informe a potência do motor desse veiculo: ");
		novoVeiculo.motor1.potency = ler.nextFloat();
		
		System.out.println("Informe quantos cilindros esse motor possui: ");
		novoVeiculo.motor1.cilindros = ler.nextInt();
		
		if (deleteMode) {
			
			delete(veiculo, novoVeiculo);
			
		} else {
			
			storing(veiculo, novoVeiculo);
		}
		
		
		
	}
	
	public static void storing(Veiculos[] veiculo, Veiculos novoVeiculo) {
		
		if (spaces(veiculo)) {
			
			veiculo[ib] = novoVeiculo;
			ig++;
			
			System.out.println("Veiculo Cadastrado com sucesso!!! \n\n");
			
		} else {
			
			System.out.println("Não há mais espaço disponivel!\n");
			
		}
		
		
	}
	
	public static boolean spaces(Veiculos[] veiculo) {
		
		Veiculos verif = new Veiculos();
		for (int i = 0;i < all;i++) {
			verif = veiculo[i];
			
			if (verif == null) {
				
				ib = i;
				return true;
				
			}
			
			
			
		}
			

		return false;
	}
	
	public static void printing(Veiculos[] veiculo) {
		
		System.out.println("Todos veiculos cadastrados: \n");
		for (int i = 0;i < ig;i++) {
			
			Veiculos oVeiculo = new Veiculos();
			
			oVeiculo = veiculo[i];
			if (oVeiculo != null) {
				
				System.out.println("Veiculo "+(i + 1)+": ");
				System.out.println("Marca: "+oVeiculo.marca);
				System.out.println("Cor:  "+oVeiculo.cor);
				System.out.println("Ano de fabricação: "+oVeiculo.anoFab);
				System.out.println("Ano do modelo: "+oVeiculo.anoModel);
				System.out.println("potência do motor: "+oVeiculo.motor1.potency);
				System.out.println("Cilindradas do motor: "+oVeiculo.motor1.cilindros+" \n\n\n");
				
				
				
			}
		}
		
	}
	
	public static void delete(Veiculos[] veiculo, Veiculos novoVeiculo) {
		
		
		boolean cond = search(veiculo, novoVeiculo );
		if(cond) {
			
			veiculo[ib] = null;
			
			System.out.println("Veiculo deletado com sucesso!!!\n\n");
			
		} else {
			
			System.out.println("Veiculo não encontrado");
			
		}
		
	
		
		
		
		
	}
	
	public static boolean search(Veiculos[] veiculo, Veiculos novoVeiculo) {
		
		Veiculos verif = new Veiculos();
		for (int i = 0;i < all;i++) {
			verif = veiculo[i];
				if (verif == novoVeiculo) {	
					ib = i;
					return true;
	
				}

			}			
		

		return false;
	}
	
}

/*System.out.println("");
*/














