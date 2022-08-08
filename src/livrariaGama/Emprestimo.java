package livrariaGama;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.lang.String;

public class Emprestimo {

	private LocalDate dataDeEmprestimo;
	private LocalDate dataPrevistaDeDevolucao;
	private LocalDate dataDeEntregaReal;
	private int situacao;
	private Livro titulo;

	private Usuario usuario;

	LocalDate data = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private double multa = 0.5;

	Livro livro = new Livro();
	Usuario usuarioFinal = new Usuario();
	private Boolean devolvido = false;

	public Emprestimo(Livro titulo, Usuario usuario, int situacao) {
		this.dataDeEmprestimo = data;
		this.dataPrevistaDeDevolucao = LocalDate.parse(dataPrevistaDevolucao(), formatter);
		this.situacao = situacao;
		this.titulo = titulo;
		this.usuario = usuario;
	}

	public Emprestimo() {

	}

	public LocalDate getDataDeEmprestimo() {

		return dataDeEmprestimo;
	}

	public void setDataDeEmprestimo(LocalDate dataDeEmprestimo) {

		this.dataDeEmprestimo = dataDeEmprestimo;
	}

	public LocalDate getDataPrevistaDeDevulcao() {

		return dataPrevistaDeDevolucao;
	}

	public void setDataPrevistaDeDevulcao(LocalDate dataPrevistaDeDevulcao) {
		this.dataPrevistaDeDevolucao = dataPrevistaDeDevulcao;
	}

	public LocalDate getDataDeEntregaReal() {

		return dataDeEntregaReal;
	}

	public void setDataDeEntregaReal(LocalDate dataDeEntregaReal) {

		this.dataDeEntregaReal = dataDeEntregaReal;
	}

	public void setSituacao(int situacao) {

		this.situacao = situacao;
	}

	public String dataEmprestimo() {
		return data.format(formatter);
	}

	public String dataPrevistaDevolucao() {
		LocalDate dataDevolucao = data.plusDays(3);
		this.dataPrevistaDeDevolucao = dataDevolucao;
		return dataDevolucao.format(formatter);
	}

	public String dataFinalDevolucao(int dias) {
		LocalDate datafinalDevolucao = data.plusDays(dias);
		this.dataDeEntregaReal = datafinalDevolucao;
		return datafinalDevolucao.format(formatter);
	}

	public String situacao(Boolean devolvido) {
		if (devolvido == true) {
			if (dataDeEntregaReal.isAfter(dataPrevistaDeDevolucao)) {
				Period periodo = Period.between(dataPrevistaDeDevolucao, dataDeEntregaReal);
				int diasDiferenca = periodo.getDays();
				if (diasDiferenca > 0) {
					multa *= diasDiferenca;
					this.devolvido = devolvido;
					System.out.println(devolvido);
					return "Livro devolvido em atraso!\n" + String.format("Multa de entrega atrasada: R$%.2f", multa);
				}
			}if (dataDeEntregaReal.isBefore(dataPrevistaDeDevolucao) && devolvido == true) {
				return "Fechado";
			}
		} 
		if (devolvido == false) {
			if (dataDeEntregaReal.isAfter(dataPrevistaDeDevolucao)) {
				Period periodo = Period.between(dataPrevistaDeDevolucao, dataDeEntregaReal);
				int diasDiferenca = periodo.getDays();
				if (diasDiferenca > 0) {
					multa *= diasDiferenca;
					this.devolvido = devolvido;
					System.out.println(devolvido);
				return "Em atraso!\n"+ String.format("Valor a ser pago: R$%.2f", multa);
				}
			}
		}
		this.devolvido = false;
		return (situacao == 1) ? "Em aberto" : "Fechado";
	}

	public void mostrarEmprestimo(int dias, boolean devolvido) {
			System.out.println(
				"Livro = " + titulo.getTitulo() +
				"\nUsuario = " + usuario.getNome() +
				"\nData do emprestimo = " + dataEmprestimo() +
				"\nData prevista de devolução = " + dataPrevistaDevolucao() +
				"\nData de devolução = " + dataFinalDevolucao(dias) +
				"\nSituação = " + situacao(devolvido)
			);
	}

	@Override
	public String toString() {
		return "Livro = " + titulo.getTitulo() +
				"\nUsuario = " + usuario.getNome() +
				"\nData do emprestimo = " + dataEmprestimo() +
				"\nData prevista de devolução = " + dataPrevistaDevolucao() +
				"\nData de devolução = " + dataFinalDevolucao(10) +
				"\nSituação = " + situacao(true);
	}
}
