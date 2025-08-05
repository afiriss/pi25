package jobs;

import models.Imovel;
import models.TipoImovel;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

		@Override
		public void doJob() throws Exception {
			if (TipoImovel.count() == 0) {
				TipoImovel casa = new TipoImovel("Casa");
				casa.save();

				TipoImovel apartamento = new TipoImovel("Apartamento");
				apartamento.save();

				TipoImovel chale = new TipoImovel("Chalé");
				chale.save();

			}
		}
	}