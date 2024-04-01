package dados;

import java.util.ArrayList;

public class Viveiro {
	protected String nome;
	protected float comprimento;
	protected float largura;
	protected ArrayList<Animal> animais = new ArrayList<Animal>(); 
	
	public String getNome() {
		return nome;
	}
	public float getComprimento() {
		return comprimento;
	}
	public float getLargura() {
		return largura;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}
	public void setLargura(float largura) {
		this.largura = largura;
	}
	
	public ArrayList<Animal> mostraAnimais(){
		return animais;
	}
	
	public float calculaEspaco() {
		return this.comprimento * this.largura;
	}
	
	public float espacoOcupado() {
		float espaco = 0;
		for(int i = 0; i < animais.size(); i++) {
			espaco += this.animais.get(i).calculaEspacoOcupado();
		}
		return espaco;
	}
	
	public float espacoDisponivel() {
		return this.calculaEspaco() - this.espacoOcupado();
	}
	
	public boolean adicionaAnimal(Animal a) {
		if(a.calculaEspacoOcupado() > 0.7*this.espacoDisponivel()) {
				return false;				
		}else {
			if(a instanceof Peixe){
				animais.add(a);
				return true;
			}else {
				return false;
			}
		}
	}
	@Override
	public String toString() {
		return "nome=" + nome + ", animais=" + animais;
	}
	
}
