package dados;

public class Animal {
	private String nome;
	private String cor;
	private String especie;
	private int idade;
	protected float altura;
	protected float comprimento;
	protected float largura;
	
	public String getNome() {
		return nome;
	}
	public String getCor() {
		return cor;
	}
	public int getIdade() {
		return idade;
	}
	public float getAltura() {
		return altura;
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
	public void setCor(String cor) {
		this.cor = cor;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}
	public void setLargura(float largura) {
		this.largura = largura;
	}
	
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public float calculaEspacoOcupado() {
		return this.comprimento * this.largura;
	}
	
	
	@Override
	public String toString() {
		return "nome=" + nome + ", cor=" + cor + ", especie=" + especie + ", idade=" + idade;
	}

}
