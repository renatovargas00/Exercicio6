package br.usjt.hellospringboot.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="previsoes")
@NamedQuery (name = "Cidade.buscarPelaLatitudeEPelaLongitude",
query = "SELECT c FROM Cidade c WHERE latitude = :latitude AND longitude = :longitude")
public class Tempo implements Serializable{
private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Double Min;
	private Double Max;
	private Double hum;
	private String des;
	private String data;
	private Double hora;
	




	@OneToOne(optional=true, cascade = {CascadeType.ALL})
	@JoinColumn (name = "dia")
	private Dia dia;

	@ManyToOne (cascade = {CascadeType.ALL})
	@JoinColumn (name="cidade_id")
	private Cidade cidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMin() {
		return Min;
	}

	public void setMin(Double min) {
		Min = min;
	}

	public Double getMax() {
		return Max;
	}

	public void setMax(Double max) {
		Max = max;
	}

	public Double getHum() {
		return hum;
	}

	public void setHum(Double hum) {
		this.hum = hum;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getHora() {
		return hora;
	}

	public void setHora(Double hora) {
		this.hora = hora;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
	
}
