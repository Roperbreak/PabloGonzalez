package gonzalez.pablo.imfe;

import java.util.Scanner;

public class TestPuntoConScanner {

	private static Scanner sc;

	public static void main(String[] args) {
		
		System.out.println("Introduzca x");
		System.out.println("x = ");
		sc = new Scanner(System.in);
		     int x = sc.nextInt(); 
		System.out.println("Introduzca y");
		System.out.println("y = ");
		     int y = sc.nextInt();
		
		
		Punto p = new Punto(x, y);
		System.out.println("Tenemos definido un punto (" + p.getX() + "," + p.getY() + ")");
		
		
		System.out.println("¿A que punto lo quieres trasladar?");
		System.out.println("Introduzca x");
		System.out.println("x = ");
		     int x2 = sc.nextInt(); 
		System.out.println("Introduzca y");
		System.out.println("y = ");
		     int y2 = sc.nextInt();
		System.out.println();
		p.trasladar(x2, y2);
		System.out.println("El punto final será: (" + p.getX() + "," + p.getY() + ")");
		
	}

}
