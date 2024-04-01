package dados;

public class Aquario extends Viveiro{
		private float altura;
		private float temperatura;
		
		public float getAltura() {
			return altura;
		}
		public float getTemperatura() {
			return temperatura;
		}
		public void setAltura(float altura) {
			this.altura = altura;
		}
		public void setTemperatura(float temperatura) {
			this.temperatura = temperatura;
		}
		
		public float calculaEspaco() {
			return super.calculaEspaco() * this.altura;
		}
		
		public boolean adicionaAnimal(Animal animal) {
			if(espacoDisponivel() >= (animal.calculaEspacoOcupado()*0.7)) {
				if(animal instanceof Peixe) {
					Peixe p = (Peixe) animal;
					
					if(p.getTemperaturaIdeal()< this.temperatura -3 || p.getTemperaturaIdeal()> this.temperatura+3) {
						return false;
					}
				}
				else {
					return false;
				}
				animais.add(animal);
				return true;
			}else {
				return false;
			}
		}
		
		@Override
		public String toString() {
			return super.toString() + ", temperatura=" + temperatura;
		}
		
		
		
		
		
}


