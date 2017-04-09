/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBP;

import Entity.Budynek;
import Entity.Mieszkanie;
import Entity.Oplaty;
import Entity.Stawki;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Waldek
 */
@Stateless
public class OplatyFacade extends AbstractFacade<Oplaty> {

    @PersistenceContext(unitName = "AWZNMagisterkaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OplatyFacade() {
        super(Oplaty.class);
    }
        public Integer id(){
        Query q = em.createQuery ("SELECT MAX(X.id) FROM Oplaty X");
Integer result = (Integer) q.getSingleResult ();
if(result==null)result=1;
else
      result+=1;
      
        return result;
    } 

public Oplaty sprawdz(Integer miesiac, Integer rok,Mieszkanie mieszkanieid){
        Oplaty oplaty = new Oplaty();
            try{
            TypedQuery<Oplaty> q = em.createQuery ("SELECT x FROM Oplaty x WHERE X.miesiac=:miesiac AND X.rok=:rok AND X.idMieszkania=:mieszkanie ",Oplaty.class).setParameter("miesiac", miesiac).setParameter("rok", rok).setParameter("mieszkanie", mieszkanieid);
            if(q.getSingleResult()!=null)
            oplaty = q.getSingleResult();
            }
            catch (NoResultException e){
                oplaty=null;
            }
            return oplaty;
        }
public List<Oplaty> oplatymiesieczne(){
    List<Oplaty> lista = new ArrayList<Oplaty>();
    Date data = new Date();
    Integer miesiac = data.getMonth()+1;
    Integer rok = data.getYear()+1900;
    try{
            TypedQuery<Oplaty> q = em.createQuery ("SELECT X FROM Oplaty X WHERE X.miesiac=:miesiac AND X.rok=:rok",Oplaty.class).setParameter("miesiac", miesiac).setParameter("rok", rok);
            if(q.getResultList()!=null)
            lista = q.getResultList();
            }
            catch (NoResultException e){
                lista=null;
            }
    
    return lista;
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
