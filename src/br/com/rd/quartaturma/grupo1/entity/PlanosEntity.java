package br.com.rd.quartaturma.grupo1.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="TB_PLANOS")
@NamedQuery(name="Planos.findAll", query="SELECT t FROM PlanosEntity t")

public class PlanosEntity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ID_PLANO")
	private BigInteger idPlano;
	
	@Column (name="NM_PLANO")
	private String nmPlano;
	
	@Column (name="DS_PLANO")
	private String dsPlano;
	
	@Column (name="VL_PLANO")
	private Double vlPlano;
	
	@ManyToOne
	@JoinColumn (name="ID_SERVICO_PLANO") //FK???
	private ServicoPlanoEntity servicoPlano;
	
	public BigInteger getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(BigInteger idPlano) {
		this.idPlano = idPlano;
	}

	public String getNmPlano() {
		return nmPlano;
	}

	public void setNmPlano(String nmPlano) {
		this.nmPlano = nmPlano;
	}

	public String getDsPlano() {
		return dsPlano;
	}

	public void setDsPlano(String dsPlano) {
		this.dsPlano = dsPlano;
	}

	public ServicoPlanoEntity getServicoPlano() {
		return servicoPlano;
	}

	public void setServicoPlano(ServicoPlanoEntity servicoPlano) {
		this.servicoPlano = servicoPlano;
	}

	public Double getVlPlano() {
		return vlPlano;
	}

	public void setVlPlano(Double vlPlano) {
		this.vlPlano = vlPlano;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
