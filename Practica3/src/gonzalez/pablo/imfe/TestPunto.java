package gonzalez.pablo.imfe;

public class TestPunto {

	public static void main(String[] args) {
		
		Punto p = new Punto(2,3);
		System.out.println("Tenemos definido un punto (" + p.getX() + "," + p.getY() + ")");
		
		
		System.out.println("Queremos trasladar el punto al (4,6)");
		System.out.println();
		p.trasladar(4, 6);

		
		System.out.println("El punto final será: (" + p.getX() + "," + p.getY() + ")");
		
	}

}
