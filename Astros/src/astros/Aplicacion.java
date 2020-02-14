package astros;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		ArrayList<Astro> astros = new ArrayList();
		Astro a;
		String nombre;
		double brillo, distancia;
		int tipo;
		boolean comp;
		
		int op = 0;
		
		do {
			try {
				verMenu();
				op = Integer.parseInt(teclado.nextLine());
				
				switch(op) {
				case 1:
					a = new Astro();
					astros.add(a);
					System.out.println("Astro Sirius creado.");
					break;
				case 2:
					a = new Astro("Alfa Centauri", 4.6, 4.3, 0);
					astros.add(a);
					System.out.println("Astro Alfa Centauri creado.");
					break;
				case 3:
					System.out.print("Introduce el nombre del astro: ");
					nombre = teclado.nextLine();
					System.out.print("Introduce el brillo del astro: ");
					brillo = Double.parseDouble(teclado.nextLine());
					System.out.print("Introduce la distancia del astro: ");
					distancia = Double.parseDouble(teclado.nextLine());
					System.out.print("Introduce el tipo del astro (0, 1 o 2): ");
					tipo = Integer.parseInt(teclado.nextLine());
					
					a = new Astro(nombre, brillo, distancia, tipo);
					astros.add(a);
					System.out.println("Astro " + a.getNombre() + " creado.");
					break;
					
				case 4:
					comp = false;
					System.out.println("Introduce el nombre que quieres buscar: ");
					nombre = teclado.nextLine();
					
					for (Astro astro : astros) {
						if(astro.getNombre().contentEquals(nombre)) {
							System.out.println(astro.toString());
							comp = true;
						}
					}
					
					if(!comp) {
						System.out.println("Astro no encontrado. Comprueba el nombre.");
					}
					break;
				case 5:
					int cont = 1, i1 = 0, i2 = 0;
					
					for (Astro astro : astros) {
						System.out.println(cont + "- " + astro.getNombre());
						cont++;
					}
					
					System.out.print("Introduce el indice del primer astro: ");
					i1 = Integer.parseInt(teclado.nextLine());
					System.out.print("Introduce el indice del segundo astro: ");
					i2 = Integer.parseInt(teclado.nextLine());
					
					System.out.println(astros.get(i1 - 1).equals(astros.get(i2 - 1)) ? "Los astros son iguales" : "Los astros no son iguales");
					break;
				case 6:
					double max = 0;
					
					for (Astro astro : astros) {
						if(astro.getBrillo() > max) {
							max = astro.getBrillo();
						}
					}
					
					for (Astro astro : astros) {
						if(astro.getBrillo() == max) {
							System.out.println("El astro m�s brillante es:");
							System.out.println(astro.toString());
						}
					}
					break;
				case 7:
					comp = false;
					System.out.print("Introduce el astro que quieres buscar: ");
					nombre = teclado.nextLine();
					
					for (Astro astro : astros) {
						if(astro.getNombre().contentEquals(nombre)) {
							System.out.println(astro.getNombre() + " se puede ver " + astro.visibleCon());
							comp = true;
						}
					}
					
					if(!comp) {
						System.out.println("Astro no encontrado. Comprueba el nombre.");
					}
					break;
				case 8:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opci�n inv�lida. Introduce de 1-8");
					break;
				}
			}catch(Exception e) {
				System.out.println("Error. Datos introducidos inv�lidos.");
			}
		}while(op != 8);
	}
	
	static void verMenu() {
		System.out.println("1. Crear astro Sirius."
				+ "\n2. Crear objeto alfa"
				+ "\n3. Crear astro."
				+ "\n4. Mostrar datos de un astro."
				+ "\n5. Comprobar si dos astros son iguales."
				+ "\n6. Mostrar datos del astro m�s brillante."
				+ "\n7. Ver visibilidad de un astro."
				+ "\n8 Salir.");
	}

}
