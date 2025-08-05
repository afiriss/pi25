package controllers;

import java.util.List;

import models.TipoImovel;
import models.Imovel;
import models.Status;
import models.Imovel;
import play.mvc.Controller;

public class Imoveis extends Controller {

	public static void form() {
		List<Imovel> imoveis = Imovel.findAll();
		render(imoveis);
	}
	

	public static void listar(String termo) {
		List<Imovel> imoveis = null;
		if (termo == null) {
			imoveis = Imovel.find("status <> ?1", Status.INATIVO).fetch();
		} else {
			imoveis = Imovel.find("(lower(bairro) like ?1 "
					+ "or lower(quantidadeComodos) like ?1) and status <> ?2",
					"%" + termo.toLowerCase() + "%",
					Status.INATIVO).fetch();
		}
		render(imoveis, termo);
	}
	
	public static void detalhar(Imovel i) {
		render(i);
	}
	
	public static void editar(Long id) {
		Imovel i = Imovel.findById(id);
		
		List <Imovel> tipoImovel = Imovel.findAll();
		
		renderTemplate("imoveis/form.html", i, tipoImovel);
	}
	
	public static void salvar(Imovel i) {
		if (i.bairro != null) {
			i.bairro = i.bairro.toUpperCase();
		}
		if (i.quantidadeComodos != null) {
			i.quantidadeComodos = i.quantidadeComodos;
		}
		if(i.areaInterna != null) {
			i.areaInterna = i.areaInterna;
		}
		i.save();
		detalhar(i);
	}
	
	public static void remover(long id) {
		Imovel imovel = Imovel.findById(id);
		imovel.status = Status.INATIVO;
		imovel.save();
		listar(null);
	}
	
	

}