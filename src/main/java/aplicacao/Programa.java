package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[]args) {
		
		// Foi atribuido o valor nulo para o id, porque o próprio banco de dados vai gerenciar inserção do valor
		Pessoa p1 = new Pessoa(null,"Fernando Luiz","fernando@gmail.com");
		Pessoa p2 = new Pessoa(null,"Lauren Ribeiro","lauren@gmail.com");
		Pessoa p3 = new Pessoa(null,"Christtofer Luiz","chris@gmail.com");
		
		// conexão com o banco de dados - inicio
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");// exemplo-jpa é o nome referenciado no persistence.xml
		EntityManager em = emf.createEntityManager();
		// conexão com banco de dados - fim 
		
		// Inserção das informações do objeto no banco de dados - inicio
		em.getTransaction().begin(); // Quando JPA faz uma operação que não é uma simples leitura de dados, ele precisa de uma transação, é necessário chamar getTransaction().begin()
		em.persist(p1);// método persist - É responsável por realizar o salvamento do objeto  no bd
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();//confirmar as alterações
		// Inserção das informações do objeto no banco de dados - fim

		
		System.out.println("Pronto!");
	
	}
}
