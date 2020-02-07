package view;

import model.Animals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import java.util.List;

public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("W3AA");

	public void insertItem(Animals li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();

	}

	public List<Animals> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<Animals> allItems = em.createQuery("SELECT i FROM Animals i").getResultList();
		return allItems;
	}

	public void deleteItem(Animals toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animals> typedQuery = em.createQuery(
				"select	li	from Animals li where li.specias = :selectedSpecias",
				Animals.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedSpecias", toDelete.getSpecies());
		//typedQuery.setParameter("selectedPopulation", toDelete.getAmount());
		
		// we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		Animals result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
  
	}

	public void updateItem(Animals toEdit) {
//		TODO	Auto-generated	method	stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}



	public List<Animals> searchBySpecies(String animalSpecies) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animals> typedQuery = em
				.createQuery("select li	from Animals li where li.specias= :selectedSpecias", Animals.class);
		typedQuery.setParameter("selectedSpecias", animalSpecies);
		List<Animals> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;

	}



	public void cleanUp() {
		emfactory.close();
	}

	public Animals searchForAnimalById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		Animals found = em.find(Animals.class, idToEdit);
		em.close();
		return found;
	}

}