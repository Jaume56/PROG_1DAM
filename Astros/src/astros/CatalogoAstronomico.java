package astros;

import java.util.ArrayList;

public class CatalogoAstronomico {
	String nombre;
	ArrayList<Astro> listaAstros;
	
	public CatalogoAstronomico() {
		this.nombre = "Catálogo";
		this.listaAstros = new ArrayList();
	}
	
	public CatalogoAstronomico(String nombre) {
		this.nombre = nombre;
		this.listaAstros = new ArrayList();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		String texto = this.getNombre() + ":\n";
		
		if(!listaAstros.isEmpty()) {
			for (Astro astro : listaAstros) {
				texto += astro.toString() + "\n";
			}
			
			return texto;
		}else {
			return "El catálogo está vacío.";
		}
	}

	public ArrayList<Astro> getListaAstros() {
		return listaAstros;
	}

	public void setListaAstros(ArrayList<Astro> listaAstros) {
		this.listaAstros = listaAstros;
	}
	
	private int posicionDe(Astro a) {
		if(listaAstros.contains(a)){
			return listaAstros.indexOf(a);
		}else {
			System.out.println("El astro no está en la lista.");
			return -1;
		}
	}
	
	private boolean esEstrellaSimpleVista(int i) {
		return listaAstros.get(i).visibleCon().contentEquals("a simple vista.") ? true : false;
	}
	
	public boolean anyade(Astro a) {
		return listaAstros.add(a) ? true : false;
	}
	
	public ArrayList<Astro> filtraEstrellasSimpleVista(){
		ArrayList<Astro> simpleVista = new ArrayList();
		
		if(!listaAstros.isEmpty()) {
			for (Astro astro : listaAstros) {
				if(astro.visibleCon().contentEquals("a simple vista.")) {
					simpleVista.add(astro);
				}
			}
			return simpleVista;
		}else {
			System.out.println("El catálogo está vacío.");
			return null;
		}
	}
	
	public Astro brillaMas() {
		double max = 0;
		Astro a = new Astro();
		
		if(!listaAstros.isEmpty()) {
			for (Astro astro : listaAstros) {
				if(astro.getBrillo() > max) {
					max = astro.getBrillo();
				}
			}
			
			for (Astro astro : listaAstros) {
				if(astro.getBrillo() == max) {
					a = astro;
				}
			}
			return a;
		}else {
			System.out.println("El catálogo está vacío.");
			return null;
		}
	}
}
