/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBP;

import Entity.Budynek;
import Entity.Stawki;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Waldek
 */
@Stateless
public class StawkiFacade extends AbstractFacade<Stawki> {

    @PersistenceContext(unitName = "AWZNMagisterkaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StawkiFacade() {
        super(Stawki.class);
    }
    public Stawki zwroc(Budynek budynek){
        Stawki wynik = null;
        try {
       // TypedQuery<Stawki> q2 = em.createNamedQuery("Stawki.findByBudynek",Stawki.class).setParameter("budynek", budynek);
       TypedQuery<Stawki> q2
                = em.createQuery("SELECT c FROM Stawki c WHERE c.idBudynku = :budynek", Stawki.class).setParameter("budynek", budynek);
        if (q2.getSingleResult() != null) {
                wynik =  q2.getSingleResult();
            }
        } catch (NoResultException e) {

            wynik =null;
    }
        return wynik;
}
}