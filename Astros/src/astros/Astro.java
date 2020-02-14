package astros;

public class Astro {
	String nombre;
	double brillo, distancia;
	int tipo;
	
	public Astro() {
		this.nombre = "Sirius";
		this.brillo = -1.42;
		this.distancia = 8.7;
		this.tipo = 0;
	}
	
	public Astro(String nombre, double brillo, double distancia, int tipo) {
		this.nombre = nombre;
		this.brillo = brillo;
		this.distancia = distancia;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getBrillo() {
		return brillo;
	}

	public void setBrillo(double brillo) {
		this.brillo = brillo;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public Astro buscarNombre(String nombre) {
		if(this.getNombre().contentEquals(nombre)) {
			return this;
		}else {
			return null;
		}
	}
	
	//@Override
	public boolean equals(Astro b) {
		if(this.getNombre().contentEquals(b.getNombre())
				&& this.getBrillo() == b.getBrillo()
				&& this.getDistancia() == b.getDistancia()
				&& this.getTipo() == b.getTipo()) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String tipo = "", texto = "";
		
		switch(this.getTipo()){
		case 0:
			tipo = "Estrella";
			break;
		case 1:
			tipo = "Nebulosa";
			break;
		case 2:
			tipo = "Galaxia";
			break;
		default:
			tipo = "Tipo inválido";
			break;
		}
		
		
		return this.getNombre() + ": " + tipo + "(" + String.format("%.2f", this.getBrillo()) + ", " + String.format("%.2f", this.getDistancia()) + ")";
	}
	
	public double magnitudAbsoluta() {
		return this.getBrillo() + 5 * Math.log(this.getDistancia());
	}
	
	public int masBrillante(Astro b) {
		if(this.magnitudAbsoluta() > b.magnitudAbsoluta()) {
			return 1;
		}else if(this.magnitudAbsoluta() < b.magnitudAbsoluta()) {
			return -1;
		}else {
			return 0;
		}
	}
	
	public String visibleCon() {
		if(this.getBrillo() < 5) {
			return "a simple vista.";
		}else if(this.getBrillo() >= 5 && this.getBrillo() < 7) {
			return "con prismáticos.";
		}else if(this.getBrillo() >= 7 && this.getBrillo() <= 25) {
			return "con telescopio.";
		}else {
			return "con grandes telescopios.";
		}
	}
}
