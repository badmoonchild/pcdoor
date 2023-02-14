package ifpr.pgua.eic.pcdoor.model.repositories;

import ifpr.pgua.eic.pcdoor.model.daos.AvaliacaoDAO;
import ifpr.pgua.eic.pcdoor.model.entities.Avaliacao;
import ifpr.pgua.eic.pcdoor.model.results.Result;

public class AvaliacaoRepository {

    private AvaliacaoDAO dao;

    public AvaliacaoRepository(AvaliacaoDAO dao){
        this.dao = dao;
    }

    public Result cadastrar(int nota, int idEstabelecimento, int idUsuario){

        Avaliacao avaliacao = new Avaliacao(nota, idEstabelecimento, idUsuario);

        return dao.cadastrar(avaliacao);
    }
    
}