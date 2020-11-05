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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")
    , @NamedQuery(name = "Documento.findById", query = "SELECT d FROM Documento d WHERE d.id = :id")
    , @NamedQuery(name = "Documento.findByRuta", query = "SELECT d FROM Documento d WHERE d.ruta = :ruta")
    , @NamedQuery(name = "Documento.findByFechahoracrea", query = "SELECT d FROM Documento d WHERE d.fechahoracrea = :fechahoracrea")
    , @NamedQuery(name = "Documento.findByFhoramodifica", query = "SELECT d FROM Documento d WHERE d.fhoramodifica = :fhoramodifica")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 60)
    @Column(name = "ruta")
    private String ruta;
    @Column(name = "fechahoracrea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahoracrea;
    @Column(name = "fhoramodifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhoramodifica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocumento")
    private Collection<Recorte> recorteCollection;
    @JoinColumn(name = "Id_formato", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Formato idformato;

    public Documento() {
    }

    public Documento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Date getFechahoracrea() {
        return fechahoracrea;
    }

    public void setFechahoracrea(Date fechahoracrea) {
        this.fechahoracrea = fechahoracrea;
    }

    public Date getFhoramodifica() {
        return fhoramodifica;
    }

    public void setFhoramodifica(Date fhoramodifica) {
        this.fhoramodifica = fhoramodifica;
    }

    @XmlTransient
    public Collection<Recorte> getRecorteCollection() {
        return recorteCollection;
    }

    public void setRecorteCollection(Collection<Recorte> recorteCollection) {
        this.recorteCollection = recorteCollection;
    }

    public Formato getIdformato() {
        return idformato;
    }

    public void setIdformato(Formato idformato) {
        this.idformato = idformato;
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
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Documento[ id=" + id + " ]";
    }
    
}
