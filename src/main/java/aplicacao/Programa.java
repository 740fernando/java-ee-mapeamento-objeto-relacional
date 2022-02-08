package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[]args) {
		
		// Foi atribuido o valor nulo para o id, porque o pr�prio banco de dados vai gerenciar inser��o do valor
		Pessoa p1 = new Pessoa(null,"Fernando Luiz","fernando@gmail.com");
		Pessoa p2 = new Pessoa(null,"Lauren Ribeiro","lauren@gmail.com");
		Pessoa p3 = new Pessoa(null,"Christtofer Luiz","chris@gmail.com");
		
		// conex�o com o banco de dados - inicio
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");// exemplo-jpa � o nome referenciado no persistence.xml
		EntityManager em = emf.createEntityManager();
		// conex�o com banco de dados - fim 
		
		// Inser��o das informa��es do objeto no banco de dados - inicio
		em.getTransaction().begin(); // Quando JPA faz uma opera��o que n�o � uma simples leitura de dados, ele precisa de uma transa��o, � necess�rio chamar getTransaction().begin()
		em.persist(p1);// m�todo persist - � respons�vel por realizar o salvamento do objeto  no bd
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();//confirmar as altera��es
		// Inser��o das informa��es do objeto no banco de dados - fim

		
		System.out.println("Pronto!");
	
	}
}
