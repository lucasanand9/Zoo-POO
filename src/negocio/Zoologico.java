package negocio;

import java.util.ArrayList;

import dados.Animal;
import dados.Aquario;
import dados.Viveiro;

public class Zoologico {
	private ArrayList<Animal> animais = new ArrayList<Animal>();
	private ArrayList<Viveiro> viveiros = new ArrayList<Viveiro>();
	
	public void CadastraViveiro(Viveiro v) {
		viveiros.add(v);
	}
	
	public void CadastraAnimais(Animal a) {
		animais.add(a);
	}
	
	public ArrayList<Viveiro> getViveiros(){
		return this.viveiros;
	}
	
	public boolean alocaAnimal(Animal a, Viveiro v) {
		return v.adicionaAnimal(a);
	}
	
	public ArrayList<Aquario> getSoAquario(){
		ArrayList<Aquario> temp = new ArrayList<Aquario>();
		
		for(int i = 0; i < viveiros.size(); i++) {
			if(viveiros.get(i) instanceof Aquario) {
				temp.add((Aquario)viveiros.get(i));
			}
		}
		return temp;
	}
	
	public ArrayList<Viveiro> getSoViveiro(){
		ArrayList<Viveiro> temp = new ArrayList<Viveiro>();
		for(int i = 0; i < viveiros.size(); i++) {
			if(!(viveiros.get(i) instanceof Aquario)) {
				temp.add(viveiros.get(i));
			}
		}
		return temp;
	}	
	
	public ArrayList<Animal> getAnimal(){
		return animais;
	}
	
	
}