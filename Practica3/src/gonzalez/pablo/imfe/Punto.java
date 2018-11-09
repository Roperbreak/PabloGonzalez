package gonzalez.pablo.imfe;

public class Punto {
	
	private int x=0 ;
	private int y=0;
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void setX(int x) { //Setter de X
		
		this.x=x;
	}
	
	public void setY(int y) { //Setter de Y
		
		this.y=y;	
	}
	
	public int getX() { //Getter de X
		
		return x;
	}
	
	public int getY() { //Getter de Y
		
		return y;
	}	
	public Punto (int x, int y) {//Definimos el constructor
		
		this.x=x;
		this.y=y;	
	}
	
	public void trasladar(int x, int y) { //Metodo trasladar para cambiarlo a otro punto
		
		setX((this.x+x));
		setY((this.y+y));
	}
}
