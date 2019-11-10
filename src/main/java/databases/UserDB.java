/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import entities.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author murad_isgandar
 */
public class UserDB {

    private static EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("TravelCompanyDB");

    public static int add(Users u) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();

        return u.getId();
    }

}
