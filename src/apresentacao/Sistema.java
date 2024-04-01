package apresentacao;

import java.util.ArrayList;
import java.util.Scanner;
import negocio.Zoologico;
import dados.*;

public class Sistema {
	
	private static Scanner scan = new Scanner(System.in);
	private static Zoologico zoo = new Zoologico();
	
	public static void main(String[] args) {

        int opcao = -1;

        while (opcao != 0) {

            menu();
            opcao = Integer.parseInt(scan.nextLine());
            
            switch (opcao) {
            case 0:
                break;
            case 1:
               cadastrarViveiro();
                break;
            case 2:
                cadastrarAnimal();
                break;
            case 3:
                mostrarTodosViveiros();
                break;
            case 4:
            	mostrarTodosAnimais();
                break;
            }
        }
	}
	
	public static void menu() {
		  System.out.println("Escolha uma opção:");
	      System.out.println("0 - Sair");
	      System.out.println("1 - Cadastrar Viveiro");
	      System.out.println("2 - Cadastrar Animal");
	      System.out.println("3 - Mostrar Viveiros");
	      System.out.println("4 - Mostrar Animais");
	}
	
	private static void mostrarTodosViveiros() {
		ArrayList<Viveiro> v = zoo.getViveiros();
		
		for(int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
	}
	
	
	private static void mostrarTodosAnimais() {
		ArrayList<Animal> a = zoo.getAnimal();
		
		for(int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}
	
	private static Viveiro novoViveiro() {
		Viveiro v = new Viveiro();
		System.out.println("Digite o nome");
		v.setNome(scan.nextLine());
		System.out.println("Digite a largura");
		v.setLargura(Float.parseFloat(scan.nextLine()));
		System.out.println("Digite o comprimento");
		v.setComprimento(Float.parseFloat(scan.nextLine()));
		
		return v;
	}

	private static Aquario novoAquario() {
		Aquario a = new Aquario();
		System.out.println("Digite o nome");
		a.setNome(scan.nextLine());
		System.out.println("Digite a largura");
		a.setLargura(Float.parseFloat(scan.nextLine()));
		System.out.println("Digite o comprimento");
		a.setComprimento(Float.parseFloat(scan.nextLine()));
		System.out.println("Digite a Altura");
		a.setAltura(Float.parseFloat(scan.nextLine()));
		System.out.println("Digite a temperatura");
		a.setTemperatura(Float.parseFloat(scan.nextLine()));
		
		return a;
	}

	private static void cadastrarViveiro() {
		System.out.println("Digite o tipo de viveiro");
		System.out.println("1 - Viveiro");
		System.out.println("2 - Aquario");
		int escolha = Integer.parseInt(scan.nextLine());
		
		switch(escolha) {
			case 1:
				zoo.CadastraViveiro(novoViveiro());
			break;
			case 2:
				zoo.CadastraViveiro(novoAquario());
			break;
			default:
				System.out.println("Opção invalida");
		}
		
	}

	private static Animal novoAnimal() {
		Animal a = new Animal();
		System.out.println("Digite o nome");
		a.setNome(scan.nextLine());
		System.out.println("Digite a idade");
		a.setIdade(Integer.parseInt(scan.nextLine()));
		System.out.println("Digite a especie");
		a.setEspecie(scan.nextLine());
		System.out.println("Digite a cor");
		a.setCor(scan.nextLine());
		System.out.println("Digite sua largura");
		a.setLargura(Float.parseFloat(scan.nextLine()));
		System.out.println("Digite seu comprimento");
		a.setComprimento(Float.parseFloat(scan.nextLine()));
		
		mostrarViveiros();
		System.out.println("Digite o numero do viveiro:");
		int vi = Integer.parseInt(scan.nextLine());
		
		while(vi >= zoo.getSoViveiro().size()) {
			System.out.println("Numero invalido");
			System.out.println("Digite o numero do viveiro");
			vi = Integer.parseInt(scan.nextLine());
		}
		
		while(!zoo.alocaAnimal(a, zoo.getSoViveiro().get(vi))) {
			System.out.println("Não foi possivel alocar nesse viveiro");
			mostrarViveiros();
			System.out.println("Digite o numero do viveiro");
			vi = Integer.parseInt(scan.nextLine());
			while(vi >= zoo.getSoViveiro().size()) {
				System.out.println("Numero invalido");
				System.out.println("Digite o numero do viveiro");
				vi = Integer.parseInt(scan.nextLine());
			}
		}
		return a;
	
	}

	private static Peixe novoPeixe() {
		Peixe p = new Peixe();
		System.out.println("Digite o nome");
		p.setNome(scan.nextLine());
		System.out.println("Digite a idade");
		p.setIdade(Integer.parseInt(scan.nextLine()));
		System.out.println("Digite a especie");
		p.setEspecie(scan.nextLine());
		System.out.println("Digite a cor");
		p.setCor(scan.nextLine());
		System.out.println("Digite sua largura");
		p.setLargura(Float.parseFloat(scan.nextLine()));
		System.out.println("Digite seu comprimento");
		p.setComprimento(Float.parseFloat(scan.nextLine()));
		System.out.println("Digite a altura do peixe");
		p.setAltura(Float.parseFloat(scan.nextLine()));
		System.out.println("Digite a temperatura ideal");
		p.setTemperaturaIdeal(Float.parseFloat(scan.nextLine()));
	
		mostrarAquario();
		System.out.println("Digite o numero do aquario");
		int aq = Integer.parseInt(scan.nextLine());
		while(aq >= zoo.getSoAquario().size()) {
			System.out.println("Numero invalido");
			System.out.println("Digite o numero do aquario");
			aq = Integer.parseInt(scan.nextLine());
		}
		while(!zoo.alocaAnimal(p, zoo.getSoAquario().get(aq))) {
			System.out.println("Não foi possivel alocar nesse aquario");
			mostrarAquario();
			System.out.println("Digite o numero do aquario");
			aq = Integer.parseInt(scan.nextLine());
			while(aq >= zoo.getSoAquario().size()) {
				System.out.println("Numero invalido");
				System.out.println("Digite o numero do aquario");
				aq = Integer.parseInt(scan.nextLine());
			}
		}
		
		return p;
	}


	
	private static void cadastrarAnimal() {
		System.out.println("Digite o tipo de animal que deseja cadastrar:");
		System.out.println("1 - Animal");
		System.out.println("2 - Peixe");
		int escolha = Integer.parseInt(scan.nextLine());
		
		switch(escolha) {
			case 1:
				zoo.CadastraAnimais(novoAnimal());
			break;
			case 2:
				zoo.CadastraAnimais(novoPeixe());
			break;
			default:
				System.out.println("Opção incorreta");
			break;
		}
	}
	
	private static void mostrarViveiros() {
		ArrayList<Viveiro> temp = zoo.getSoViveiro();
		for(int i = 0; i< temp.size(); i++) {
			System.out.println(i + " - " + temp.get(i).getNome());
		}
	}
	
	private static void mostrarAquario() {
		ArrayList<Aquario> temp = zoo.getSoAquario();
		
		for(int i = 0; i < temp.size(); i++) {
			System.out.println(i + " - " + temp.get(i).getNome());
		}
	}
	
	






}

