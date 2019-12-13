package com.demo.fashion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC13
 */
@Entity
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdcli", query = "SELECT c FROM Cliente c WHERE c.idcli = :idcli")
    , @NamedQuery(name = "Cliente.findByNomcli", query = "SELECT c FROM Cliente c WHERE c.nomcli = :nomcli")
    , @NamedQuery(name = "Cliente.findByApecli", query = "SELECT c FROM Cliente c WHERE c.apecli = :apecli")
    , @NamedQuery(name = "Cliente.findByDnicli", query = "SELECT c FROM Cliente c WHERE c.dnicli = :dnicli")})

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator (name="IDCLI", sequenceName = "SeqIDCLI", initialValue = 5, allocationSize = 100 )
    @Column(name = "IDCLI")
    private Long idcli;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "NOMCLI")
    private String nomcli;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "APECLI")
    private String apecli;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DNICLI")
    private int dnicli;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteIdcli")
    private List<Venta> ventaList;

    public Cliente() {
    }

    public Cliente(Long idcli) {
        this.idcli = idcli;
    }

    public Cliente(Long idcli, String nomcli, String apecli, int dnicli) {
        this.idcli = idcli;
        this.nomcli = nomcli;
        this.apecli = apecli;
        this.dnicli = dnicli;
    }

    public Long getIdcli() {
        return idcli;
    }

    public void setIdcli(Long idcli) {
        this.idcli = idcli;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public String getApecli() {
        return apecli;
    }

    public void setApecli(String apecli) {
        this.apecli = apecli;
    }

    public int getDnicli() {
        return dnicli;
    }

    public void setDnicli(int dnicli) {
        this.dnicli = dnicli;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcli != null ? idcli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcli == null && other.idcli != null) || (this.idcli != null && !this.idcli.equals(other.idcli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.fashion.entity.Cliente[ idcli=" + idcli + " ]";
    }

}
