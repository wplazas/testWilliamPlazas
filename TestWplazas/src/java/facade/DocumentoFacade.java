/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Documento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Documento_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Recorte;
import entities.Formato;
import java.util.Collection;

/**
 *
 * @author willi
 */
@Stateless
public class DocumentoFacade extends AbstractFacade<Documento> {

    @PersistenceContext(unitName = "TestWplazasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentoFacade() {
        super(Documento.class);
    }

    public boolean isRecorteCollectionEmpty(Documento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Documento> documento = cq.from(Documento.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(documento, entity), cb.isNotEmpty(documento.get(Documento_.recorteCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Recorte> findRecorteCollection(Documento entity) {
        Documento mergedEntity = this.getMergedEntity(entity);
        Collection<Recorte> recorteCollection = mergedEntity.getRecorteCollection();
        recorteCollection.size();
        return recorteCollection;
    }

    public boolean isIdformatoEmpty(Documento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Documento> documento = cq.from(Documento.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(documento, entity), cb.isNotNull(documento.get(Documento_.idformato)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Formato findIdformato(Documento entity) {
        return this.getMergedEntity(entity).getIdformato();
    }
    
}
