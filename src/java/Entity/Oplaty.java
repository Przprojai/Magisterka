/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Waldek
 */
@Entity
@Table(name = "oplaty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oplaty.findAll", query = "SELECT o FROM Oplaty o")
    , @NamedQuery(name = "Oplaty.findById", query = "SELECT o FROM Oplaty o WHERE o.id = :id")
    , @NamedQuery(name = "Oplaty.findByMiesiac", query = "SELECT o FROM Oplaty o WHERE o.miesiac = :miesiac")
    , @NamedQuery(name = "Oplaty.findByRok", query = "SELECT o FROM Oplaty o WHERE o.rok = :rok")
    , @NamedQuery(name = "Oplaty.findBySumaOplat", query = "SELECT o FROM Oplaty o WHERE o.sumaOplat = :sumaOplat")})
public class Oplaty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "miesiac")
    private int miesiac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rok")
    private int rok;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suma_oplat")
    private float sumaOplat;
    @NotNull
    @Column(name = "zaplacono")
    private float zaplacono;
    @NotNull
    @Column(name = "podsumowanie")
    private float podsumowanie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOplaty")
    private Collection<DodatkoweOplaty> dodatkoweOplatyCollection;
    @JoinColumn(name = "id_mieszkania", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mieszkanie idMieszkania;
    @JoinColumn(name = "id_stawki", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Stawki idStawki;

    public Oplaty() {
    }

    public Oplaty(Integer id) {
        this.id = id;
    }

    public Oplaty(Integer id, int miesiac, int rok, float sumaOplat, float zaplacono, float podsumowanie) {
        this.id = id;
        this.miesiac = miesiac;
        this.rok = rok;
        this.sumaOplat = sumaOplat;
        this.zaplacono = zaplacono;
        this.podsumowanie = podsumowanie;
    }

    public Integer getId() {
        return id;
    }

    public float getZaplacono() {
        return zaplacono;
    }

    public void setZaplacono(float zaplacono) {
        this.zaplacono = zaplacono;
    }

    public float getPodsumowanie() {
        return podsumowanie;
    }

    public void setPodsumowanie(float podsumowanie) {
        this.podsumowanie = podsumowanie;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMiesiac() {
        return miesiac;
    }

    public void setMiesiac(int miesiac) {
        this.miesiac = miesiac;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public float getSumaOplat() {
        return sumaOplat;
    }

    public void setSumaOplat(float sumaOplat) {
        this.sumaOplat = sumaOplat;
    }

    @XmlTransient
    public Collection<DodatkoweOplaty> getDodatkoweOplatyCollection() {
        return dodatkoweOplatyCollection;
    }

    public void setDodatkoweOplatyCollection(Collection<DodatkoweOplaty> dodatkoweOplatyCollection) {
        this.dodatkoweOplatyCollection = dodatkoweOplatyCollection;
    }

    public Mieszkanie getIdMieszkania() {
        return idMieszkania;
    }

    public void setIdMieszkania(Mieszkanie idMieszkania) {
        this.idMieszkania = idMieszkania;
    }

    public Stawki getIdStawki() {
        return idStawki;
    }

    public void setIdStawki(Stawki idStawki) {
        this.idStawki = idStawki;
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
        if (!(object instanceof Oplaty)) {
            return false;
        }
        Oplaty other = (Oplaty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " " + miesiac + " " +rok + " " +sumaOplat + " " +idMieszkania + " " + idStawki;
    }
    
}
