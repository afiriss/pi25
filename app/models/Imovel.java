package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Imovel extends Model {

    public String codigoAnuncio;
	public String bairro;
	public Integer quantidadeComodos;
	public Double areaInterna;
	public Double areaExterna;
	
	@Enumerated(EnumType.STRING)
	public Status status;

	public Imovel() {
		this.status = Status.ATIVO;
	}
	
	@ManyToOne
	public TipoImovel tipoImovel;
	
	public Double getAreaTotal() {
        return (areaInterna != null ? areaInterna : 0.0) +
               (areaExterna != null ? areaExterna : 0.0);
    }
}
