/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Recorte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Recorte_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Documento;

/**
 *
 * @author willi
 */
@Stateless
public class RecorteFacade extends AbstractFacade<Recorte> {

    @PersistenceContext(unitName = "TestWplazasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecorteFacade() {
        super(Recorte.class);
    }

    public boolean isIddocumentoEmpty(Recorte entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Recorte> recorte = cq.from(Recorte.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(recorte, entity), cb.isNotNull(recorte.get(Recorte_.iddocumento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Documento findIddocumento(Recorte entity) {
        return this.getMergedEntity(entity).getIddocumento();
    }
    
}
