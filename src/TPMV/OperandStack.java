package TPMV;

public class OperandStack {

	private int stack[];
	private int contador;
	private int STACK_SIZE=1000;

    public OperandStack() {
        this.stack = new int[STACK_SIZE];
		this.contador = 0;
    }

    public int length() {
        return contador;
    }

	public boolean push(int operando){
		boolean resultado = false;

		if (contador >= this.stack.length) {
			this.redim();
		}
		this.stack[contador++]=operando;
		resultado = true;

		return resultado;
	}

	public int pop(){
	int resultado = 0;
		if (contador>0)
			resultado = this.stack[--contador];
		else
			resultado = this.stack[0];
		return resultado;
	}
	
	public int getLastPosition(){
		int resultado = 0;
		if (contador > 0)
			resultado = stack[contador -1];
		else
			resultado = stack[0];
		return resultado;
	}

	public String toString(){
		String resultado="";
        if (this.stack.length == 0) {
            resultado="<vacía>";
        } else {
            for (int i = 0; i < contador; i++) {
                resultado += this.stack[i] + " ";
            }
        }
        return resultado;
	}
	
	private void redim(){
		int newSize = this.stack.length + this.STACK_SIZE;
        this.stack = java.util.Arrays.copyOf(this.stack, newSize);
	}
	
	public void reset() {
		contador = 0;
	}
}
