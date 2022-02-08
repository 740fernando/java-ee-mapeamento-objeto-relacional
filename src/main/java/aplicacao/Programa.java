package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

/**
 * Um objeto EntityManager encapsula uma conex�o com a base de dados e serve para efetuar opera��es de
acesso a dados (inser��o, remo��o, dele��o, atualiza��o) em entidades (clientes, produtos, pedidos, etc.)
por ele monitoradas em um mesmo contexto de persist�ncia.
 * 
 * @author fsouviei
 *
 */

public class Programa {

	public static void main(String[]args) {
		

		
		// conex�o com o banco de dados - inicio
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");// exemplo-jpa � o nome referenciado no persistence.xml
		EntityManager em = emf.createEntityManager();
		// conex�o com banco de dados - fim 
		
		//Consulta
		Pessoa p = em.find(Pessoa.class, 2); // O jpa tem uma fun��o especifica para buscar um determinado registro por id;
		
		em.getTransaction().begin();
		em.remove(p);//Exclui
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}
}
// obs : Para excluir um registro no banco de dados, � necess�rio que o objeto seja monitorado.
/**
 * O que � um objeto monitorado?
 *  Ou � um objeto que voc� acabou de inserir, ou um objeto que foi recuperado do banco de dados e nao fechou o entityManager
 */
