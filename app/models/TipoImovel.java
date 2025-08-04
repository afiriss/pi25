package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class TipoImovel extends Model {

	  public String descricao;

	    public TipoImovel(String descricao) {
	        this.descricao = descricao;
	    }

	    public String toString() {
	        return descricao;
	    }
	
}

