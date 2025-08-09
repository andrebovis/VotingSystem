package application;

import java.util.ArrayList;
import java.util.List;

import entities.Candidato;

public class Program {

	public static void main(String[] args) {
		
		List<Candidato> candidatos = new ArrayList<>();
		
		Candidato candidato1 = new Candidato("João", "10");
		Candidato candidato2 = new Candidato("Maria", "20");
		
		candidatos.add(candidato1);
		candidatos.add(candidato2);
		
		System.out.println("Lista de candidatos: " + candidatos);
	}
}