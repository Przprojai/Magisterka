/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBP;

import Entity.Mieszkanie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Waldek
 */
@Stateless
public class MieszkanieFacade extends AbstractFacade<Mieszkanie> {

    @PersistenceContext(unitName = "AWZNMagisterkaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MieszkanieFacade() {
        super(Mieszkanie.class);
    }
    
}
