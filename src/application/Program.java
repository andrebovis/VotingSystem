package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Candidato;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Candidato> candidatos = new ArrayList<>();
		
		candidatos.add(new Candidato("João", "10"));
		candidatos.add(new Candidato("Maria", "20"));
		
		System.out.println("Lista de candidatos: " + candidatos);
		
		while (true) {
			System.out.print("Digite o número do candidato para votar (ou 'fim' para terminar): ");
			String entrada = sc.nextLine();
			
			if (entrada.equalsIgnoreCase("fim")) {
				break;
			}
			
			boolean votoValido = false;
			for (Candidato candidato : candidatos) {
				if (candidato.getNumero().equals(entrada)) {
					candidato.addVote(); 
					System.out.println("Voto registrado para " + candidato.getNome() + "!");
					votoValido = true;
					break; 
				}
			}
			
		
			if (!votoValido) {
				System.out.println("Voto nulo. Número não encontrado.");
			}
		}
		
		System.out.println("\n--- Resultado da votação ---");
		for (Candidato candidato : candidatos) {
			System.out.println(candidato.getNome() + " - Votos: " + candidato.getVotesReceived());
		}
		
		sc.close();
	}
}