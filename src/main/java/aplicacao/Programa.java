package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

/**
 * Um objeto EntityManager encapsula uma conexão com a base de dados e serve para efetuar operações de
acesso a dados (inserção, remoção, deleção, atualização) em entidades (clientes, produtos, pedidos, etc.)
por ele monitoradas em um mesmo contexto de persistência.
 * 
 * @author fsouviei
 *
 */

public class Programa {

	public static void main(String[]args) {
		

		
		// conexão com o banco de dados - inicio
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");// exemplo-jpa é o nome referenciado no persistence.xml
		EntityManager em = emf.createEntityManager();
		// conexão com banco de dados - fim 
		
		//Consulta
		Pessoa p = em.find(Pessoa.class, 2); // O jpa tem uma função especifica para buscar um determinado registro por id;
		
		em.getTransaction().begin();
		em.remove(p);//Exclui
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}
}
// obs : Para excluir um registro no banco de dados, é necessário que o objeto seja monitorado.
/**
 * O que é um objeto monitorado?
 *  Ou é um objeto que você acabou de inserir, ou um objeto que foi recuperado do banco de dados e nao fechou o entityManager
 */
