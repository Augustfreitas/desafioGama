package livrariaGama;
public class Usuario {

    private String nome;
    private long CPF;
    private String telefone;
    private static String matricula = "0";

    public Usuario(String nome, int CPF, String telefone, String matricula) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        Usuario.matricula = matricula;
    }

    public Usuario() {

    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public long getCPF() {

        return CPF;
    }

    public void setCPF(int CPF) {

        this.CPF = CPF;
    }

    public String getTelefone() {

		return telefone;
    }

    public void setTelefone(String telefone) {

		this.telefone = telefone;
    }

    public String getMatricula() {

		return matricula;
    }

    public void setMatricula(String matricula) {
        Usuario.matricula = matricula;

    }

    public static String numeroMatricula() {
        int numeroMatricula = Integer.parseInt(matricula);
        numeroMatricula++;
        return matricula = String.valueOf(numeroMatricula);
    }

    public void mostrarUsuario() {
        System.out.printf("Nome: %s\nCPF: %d\nTelefone: %s\n" + "Matricula: %s\n", nome, CPF, telefone, matricula);
    }

    @Override
    public String toString() {
        return  "Nome = " + getNome() +
                "\nCPF = " + getCPF() +
                "\nTelefone = " + getTelefone();
    }

}