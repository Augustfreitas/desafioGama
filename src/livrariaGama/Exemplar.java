package livrariaGama;
public class Exemplar {

	private int codigo;
	private boolean cativa;
	private boolean emprestada;

	public Exemplar(int codigo, boolean cativa, boolean emprestada) {
		this.codigo = codigo;
		this.cativa = cativa;
		this.emprestada = emprestada;
	}

	public Exemplar() {

	}

	public int getCodigo() {

		return codigo;
	}

	public void setCodigo(int codigo) {

		this.codigo = codigo;
	}

	public boolean isCativa() {

		return cativa;
	}

	public void setCativa(boolean cativa) {

		this.cativa = cativa;
	}

	public boolean isEmprestada() {

		return emprestada;
	}

	public void setEmprestada(boolean emprestada) {

		this.emprestada = emprestada;
	}

	@Override
	public String toString() {
		return 	"Codigo = " + getCodigo() +
				"\nCativa = " + isCativa() +
				"\nEmprestada = " + isEmprestada();
	}

}