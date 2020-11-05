/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author willi
 */
@Entity
@Table(name = "recorte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recorte.findAll", query = "SELECT r FROM Recorte r")
    , @NamedQuery(name = "Recorte.findById", query = "SELECT r FROM Recorte r WHERE r.id = :id")
    , @NamedQuery(name = "Recorte.findByRuta", query = "SELECT r FROM Recorte r WHERE r.ruta = :ruta")
    , @NamedQuery(name = "Recorte.findByFechahoracrea", query = "SELECT r FROM Recorte r WHERE r.fechahoracrea = :fechahoracrea")
    , @NamedQuery(name = "Recorte.findByFhoramodifica", query = "SELECT r FROM Recorte r WHERE r.fhoramodifica = :fhoramodifica")})
public class Recorte implements Serializable {

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
    @JoinColumn(name = "Id_documento", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Documento iddocumento;

    public Recorte() {
    }

    public Recorte(Integer id) {
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

    public Documento getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Documento iddocumento) {
        this.iddocumento = iddocumento;
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
        if (!(object instanceof Recorte)) {
            return false;
        }
        Recorte other = (Recorte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Recorte[ id=" + id + " ]";
    }
    
}
