package livrariaGama;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Livro {

	private String titulo;
	// private String autor;
	private Date ano;
	private int edicao;
	private String editora;
	private String ISBN;
	List<Livro> livros = new ArrayList<Livro>();

	Autor autor = new Autor();

	public Livro(String titulo, Autor autor, String ano, int edicao, String editora, String ISBN)
			throws ParseException {
		this.titulo = titulo;
		this.autor = autor;
		Date Ano = new SimpleDateFormat("dd/MM/yyyy").parse(ano);
		this.ano = Ano;
		this.edicao = edicao;
		this.editora = editora;
		this.ISBN = ISBN;
	}

	public void setLivro(String titulo, Autor autor, String ano, int edicao, String editora, String ISBN)
			throws ParseException {
		livros.add(new Livro(titulo, autor, ano, edicao, editora, ISBN));
	}

	public Livro() {

	}

	public Autor getAutor() {
		return this.autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public void mostraLivroDoAutor(String nome) {
		if (livros.toString().contains(nome) == true) {
			System.out.println("Os Livros cadastrados do escritor " + nome + " são: ");
			for (int j = 0; j < livros.size(); j++) {
				if (livros.get(j).toString().contains(nome) == true) {
					System.out.println(livros.get(j).getTitulo().intern());
				}
			}
		} else {
			System.out.println("Livro não cadastrado!");
		}
	}

	public void mostraAutorLivro(String nome) {
		if (livros.toString().contains(nome) == true) {
			System.out.println("O escritor do livro " + nome + " é: ");
			for (int i = 0; i < livros.size(); i++) {
				if (livros.get(i).toString().contains(nome) == true) {
					String autor = livros.get(i).getAutor().getNome();
					System.out.println(autor);
				}
			}
		} else {
			System.out.println("Escritor não cadastrado!");
		}
	}

	@Override
	public String toString() {
		// System.out.println("===Livro===");
		return "Titulo = " + getTitulo() +
				"\nAno = " + getAno() +
				"\nEdicao = " + getEdicao() +
				"\nEditora = " + getEditora() +
				"\nISBN = " + getISBN() +
				"\nAutor = " + autor.getNome();
	}
}
