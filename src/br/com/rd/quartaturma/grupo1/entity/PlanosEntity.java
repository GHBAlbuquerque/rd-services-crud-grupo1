package br.com.rd.quartaturma.grupo1.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@Column (name="ID_SERVICO_PLANO") //FK???
	private BigInteger idServicoPlano;
	
	public BigInteger getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(BigInteger idPlano) {
		this.idPlano = idPlano;
	}

	public String getNmPLano() {
		return nmPlano;
	}

	public void setNmPLano(String nmPLano) {
		this.nmPlano = nmPLano;
	}

	public String getDsPlano() {
		return dsPlano;
	}

	public void setDsPlano(String dsPlano) {
		this.dsPlano = dsPlano;
	}

	public BigInteger getIdServicoPlano() {
		return idServicoPlano;
	}

	public void setIdServicoPlano(BigInteger idServicoPlano) {
		this.idServicoPlano = idServicoPlano;
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
