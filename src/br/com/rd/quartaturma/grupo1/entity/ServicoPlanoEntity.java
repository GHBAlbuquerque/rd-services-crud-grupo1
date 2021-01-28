package br.com.rd.quartaturma.grupo1.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TB_SERVICO_PLANO")
@NamedQuery(name="ServicoPlano.findAll", query="SELECT t FROM ServicoPlanoEntity t")

public class ServicoPlanoEntity {
	
	@Id
	@GeneratedValue
	@Column(name="ID_SERVICO_PLANO")
	private BigInteger idServicoPlano;
	
	@Column (name="DS_SERVICO")
	private String dsServico;

	public BigInteger getIdServicoPlano() {
		return idServicoPlano;
	}

	public void setIdServicoPlano(BigInteger idServicoPlano) {
		this.idServicoPlano = idServicoPlano;
	}

	public String getDsServico() {
		return dsServico;
	}

	public void setDsServico(String dsServico) {
		this.dsServico = dsServico;
	}

	
		

}
