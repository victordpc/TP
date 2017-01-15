package tp.pr3.mv;

/**
 * Clase de inicio de nuestra aplicación
 */
public class Main {

	/**
	 * Inicio del programa
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		try {
			Engine engine = new Engine();
			engine.start();
		} catch (Exception e) {
			System.err.println("Ejecución incorrecta" + System.getProperty("line.separator") + e.getMessage());
		}
	}
}
