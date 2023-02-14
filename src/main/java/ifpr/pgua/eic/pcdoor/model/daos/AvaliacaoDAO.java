package ifpr.pgua.eic.pcdoor.model.daos;

import ifpr.pgua.eic.pcdoor.model.entities.Avaliacao;
import ifpr.pgua.eic.pcdoor.model.results.Result;

public interface AvaliacaoDAO {
    Result cadastrar(Avaliacao avaliacao);
}