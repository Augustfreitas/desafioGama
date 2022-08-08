package livrariaGama;

import static livrariaGama.Usuario.numeroMatricula;
import java.text.ParseException;


public class App {
    public static void main(String[] args) throws ParseException {
		Livro livro = new Livro();
		Autor autor = new Autor();
		autor.setAutor("J.K.Rolling", "Brasileira", 32, "f");
		autor.setAutor("D. Pedro I", "Portugûes", 122, "M");
		autor.setAutor("Patati", "Tangamandapiano", 35, "M");

	
        Usuario user = new Usuario("Rodrigo", 111_111_111-11, "61 99999-9999", numeroMatricula());
		Usuario user2 = new Usuario("Eric", 222_222_222-22, "61 99999-9999", numeroMatricula());
		Usuario user3 = new Usuario("Joao", 333_333_333-33, "61 99999-9999", numeroMatricula());

		
		livro.setLivro("Harry Potter", autor.autores.get(0),"22/07/2018",5,"Calice","");
		livro.setLivro("O Aluno Iluminado", autor.autores.get(2),"01/04/2022",4, "Patatá","ABC12344");
		livro.setLivro("Independencia ou Brasil", autor.autores.get(1),"01/07/1980",1,"Atlas","EWRT32432");
		livro.setLivro("Independencia ou Brasil - O retorno", autor.autores.get(2),"01/07/1980",1,"Atlas","EWRT32432");

		livro.mostraLivroDoAutor("Patati");
		livro.mostraLivroDoAutor("João");
		System.out.println("---------------------");
		livro.mostraAutorLivro("O Aluno Iluminado");
		livro.mostraAutorLivro("Pequeno principe");

		/*Emprestimo emprestimo = new Emprestimo(livro.livros.get(0),user,1);
		System.out.println("++++++++++++++++++");
		emprestimo.mostrarEmprestimo(7,false);*/
		

    }
}

//Augustfreitas
//marianarusig
//EricMarques