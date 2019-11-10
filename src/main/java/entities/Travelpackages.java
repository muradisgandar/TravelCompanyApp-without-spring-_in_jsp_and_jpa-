/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author murad_isgandar
 */
@Entity
@Table(name = "travelpackages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Travelpackages.findAll", query = "SELECT t FROM Travelpackages t")
    , @NamedQuery(name = "Travelpackages.findById", query = "SELECT t FROM Travelpackages t WHERE t.id = :id")
    , @NamedQuery(name = "Travelpackages.findByCountryname", query = "SELECT t FROM Travelpackages t WHERE t.countryname = :countryname")
    , @NamedQuery(name = "Travelpackages.findByDate", query = "SELECT t FROM Travelpackages t WHERE t.date = :date")})
public class Travelpackages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "countryname")
    private String countryname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "date")
    private String date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourId")
    private List<Users> usersList;

    public Travelpackages() {
    }

    public Travelpackages(Integer id) {
        this.id = id;
    }

    public Travelpackages(Integer id, String countryname, String date) {
        this.id = id;
        this.countryname = countryname;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
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
        if (!(object instanceof Travelpackages)) {
            return false;
        }
        Travelpackages other = (Travelpackages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Travelpackages[ id=" + id + " ]";
    }
    
}
