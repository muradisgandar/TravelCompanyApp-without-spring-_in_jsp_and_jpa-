/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import entities.Travelpackages;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author murad_isgandar
 */
public class TravelPackagesDB {

    private static EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("TravelCompanyDB");

    public static List<Travelpackages> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("select t from Travelpackages t");
        List<Travelpackages> result = query.getResultList();
        em.close();
        return result;
    }

    public static List<Travelpackages> getAllByParameters(Travelpackages t) {
        EntityManager em = entityManagerFactory.createEntityManager();

        if ((t.getCountryname() == null || t.getCountryname().isEmpty() ) && (t.getDate() == null || t.getDate().isEmpty())) {
            return getAll();
        }

        StringBuilder stb = new StringBuilder("select t from Travelpackages t where t.countryname like :name or t.date like :date");
        Query query = em.createQuery(stb.toString());
        

        query.setParameter("name", "%" + t.getCountryname() + "%");
        query.setParameter("date", "%" + t.getDate() + "%");

        List<Travelpackages> result = query.getResultList();
        em.close();
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }

    }

    public static int add(Travelpackages t) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        if ((t.getCountryname() != null && !t.getCountryname().isEmpty()) && (t.getDate() != null && !t.getDate().isEmpty())) {
            em.persist(t);
        }
        em.getTransaction().commit();
        em.close();
        return 0;
    }

    public static boolean update(Travelpackages t) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        StringBuilder stb = new StringBuilder("update Travelpackages t set t.countryname = t.countryname");

        if ((t.getCountryname() != null && !t.getCountryname().isEmpty())) {
            stb.append(",t.countryname = :name");
        }
        if ((t.getDate() != null && !t.getDate().isEmpty())) {
            stb.append(",t.date = :date");
        }

        stb.append(" where t.id = :id");

        Query query = em.createQuery(stb.toString());

        if ((t.getCountryname() != null && !t.getCountryname().isEmpty())) {
            query.setParameter("name", t.getCountryname());
        }
        if ((t.getDate() != null && !t.getDate().isEmpty())) {
            query.setParameter("date", t.getDate());
        }

        query.setParameter("id", t.getId());

        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public static int delete(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Travelpackages t = em.find(Travelpackages.class, id);
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        return 0;
    }

}
