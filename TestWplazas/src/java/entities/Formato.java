/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author willi
 */
@Entity
@Table(name = "formato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formato.findAll", query = "SELECT f FROM Formato f")
    , @NamedQuery(name = "Formato.findById", query = "SELECT f FROM Formato f WHERE f.id = :id")
    , @NamedQuery(name = "Formato.findByNombreDoc", query = "SELECT f FROM Formato f WHERE f.nombreDoc = :nombreDoc")
    , @NamedQuery(name = "Formato.findByDescDocumento", query = "SELECT f FROM Formato f WHERE f.descDocumento = :descDocumento")
    , @NamedQuery(name = "Formato.findByFhoramodifica", query = "SELECT f FROM Formato f WHERE f.fhoramodifica = :fhoramodifica")})
public class Formato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 60)
    @Column(name = "nombre_doc")
    private String nombreDoc;
    @Size(max = 255)
    @Column(name = "desc_documento")
    private String descDocumento;
    @Column(name = "fhoramodifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhoramodifica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idformato")
    private Collection<Documento> documentoCollection;

    public Formato() {
    }

    public Formato(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getDescDocumento() {
        return descDocumento;
    }

    public void setDescDocumento(String descDocumento) {
        this.descDocumento = descDocumento;
    }

    public Date getFhoramodifica() {
        return fhoramodifica;
    }

    public void setFhoramodifica(Date fhoramodifica) {
        this.fhoramodifica = fhoramodifica;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formato)) {
            return false;
        }
        Formato other = (Formato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Formato[ id=" + id + " ]";
    }
    
}
