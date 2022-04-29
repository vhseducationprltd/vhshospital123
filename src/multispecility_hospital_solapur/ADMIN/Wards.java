/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multispecility_hospital_solapur.ADMIN;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author heman
 */
@Entity
@Table(name = "wards", catalog = "VHSHOSPITAL", schema = "")
@NamedQueries({
    @NamedQuery(name = "Wards.findAll", query = "SELECT w FROM Wards w")
    , @NamedQuery(name = "Wards.findBySr", query = "SELECT w FROM Wards w WHERE w.sr = :sr")
    , @NamedQuery(name = "Wards.findByWid", query = "SELECT w FROM Wards w WHERE w.wid = :wid")
    , @NamedQuery(name = "Wards.findByWardname", query = "SELECT w FROM Wards w WHERE w.wardname = :wardname")
    , @NamedQuery(name = "Wards.findByCharges", query = "SELECT w FROM Wards w WHERE w.charges = :charges")})
public class Wards implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SR")
    private Integer sr;
    @Basic(optional = false)
    @Column(name = "WID")
    private int wid;
    @Basic(optional = false)
    @Column(name = "WARDNAME")
    private String wardname;
    @Basic(optional = false)
    @Column(name = "CHARGES")
    private int charges;

    public Wards() {
    }

    public Wards(Integer sr) {
        this.sr = sr;
    }

    public Wards(Integer sr, int wid, String wardname, int charges) {
        this.sr = sr;
        this.wid = wid;
        this.wardname = wardname;
        this.charges = charges;
    }

    public Integer getSr() {
        return sr;
    }

    public void setSr(Integer sr) {
        Integer oldSr = this.sr;
        this.sr = sr;
        changeSupport.firePropertyChange("sr", oldSr, sr);
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        int oldWid = this.wid;
        this.wid = wid;
        changeSupport.firePropertyChange("wid", oldWid, wid);
    }

    public String getWardname() {
        return wardname;
    }

    public void setWardname(String wardname) {
        String oldWardname = this.wardname;
        this.wardname = wardname;
        changeSupport.firePropertyChange("wardname", oldWardname, wardname);
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        int oldCharges = this.charges;
        this.charges = charges;
        changeSupport.firePropertyChange("charges", oldCharges, charges);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sr != null ? sr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wards)) {
            return false;
        }
        Wards other = (Wards) object;
        if ((this.sr == null && other.sr != null) || (this.sr != null && !this.sr.equals(other.sr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "multispecility_hospital_solapur.ADMIN.Wards[ sr=" + sr + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
