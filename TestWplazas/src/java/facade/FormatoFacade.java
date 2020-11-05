/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Formato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Formato_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Documento;
import java.util.Collection;

/**
 *
 * @author willi
 */
@Stateless
public class FormatoFacade extends AbstractFacade<Formato> {

    @PersistenceContext(unitName = "TestWplazasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormatoFacade() {
        super(Formato.class);
    }

    public boolean isDocumentoCollectionEmpty(Formato entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Formato> formato = cq.from(Formato.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(formato, entity), cb.isNotEmpty(formato.get(Formato_.documentoCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Documento> findDocumentoCollection(Formato entity) {
        Formato mergedEntity = this.getMergedEntity(entity);
        Collection<Documento> documentoCollection = mergedEntity.getDocumentoCollection();
        documentoCollection.size();
        return documentoCollection;
    }
    
}
