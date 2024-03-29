package ifpr.pgua.eic.pcdoor.model.repositories;

import java.util.List;

import ifpr.pgua.eic.pcdoor.model.daos.EstabelecimentoDAO;
import ifpr.pgua.eic.pcdoor.model.entities.Estabelecimento;
import ifpr.pgua.eic.pcdoor.model.results.Result;

public class EstabelecimentoRepository {
    
    private EstabelecimentoDAO dao;

    public EstabelecimentoRepository(EstabelecimentoDAO dao){
        this.dao = dao;
    }

    public Result cadastrarEstabelecimento(String nome, String email, String senha, String tipo, String cnpj, String descricao, int pontuacao, String endereco){

        Estabelecimento estabelecimento = new Estabelecimento(nome, email, senha, tipo, cnpj, descricao, pontuacao, endereco);

        return dao.cadastrar(estabelecimento);
    }

    public Estabelecimento buscarEmail(String email){

        return dao.buscarEmail(email);
    }

    public Estabelecimento buscarCnpj(String cnpj){

        return dao.buscarCnpj(cnpj);
    }

    public Estabelecimento login(String email, String senha){

        return dao.login(email, senha);
    }

    public List<Estabelecimento> listarEstabelecimentos(){
        return dao.listar();
    }
}
