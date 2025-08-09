package entities;

public class Candidato {
	
	private String nome;
	private String numero;
	private int votesReceived;
	
	public Candidato(String nome, String numero) {
		this.nome = nome;
		this.numero = numero;
		this.votesReceived = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getNumero() {
		return numero;
	}

	public int getVotesReceived() {
		return votesReceived;
	}
	
	public void addVote() {
		this.votesReceived++;
	}

	@Override
	public String toString() {
		return "Candidato: " + nome + ", Número: " + numero + ", Votos: " + votesReceived;
	}
}
