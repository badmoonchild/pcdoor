package ifpr.pgua.eic.pcdoor.model.daos;

import java.util.List;

import ifpr.pgua.eic.pcdoor.model.entities.Estabelecimento;
import ifpr.pgua.eic.pcdoor.model.results.Result;

public interface EstabelecimentoDAO {
    Result cadastrar(Estabelecimento estabelecimento);
    Estabelecimento buscarEmail(String email);
    Estabelecimento buscarCnpj(String cnpj);
    Estabelecimento login(String email, String senha);
    List<Estabelecimento> listar();
}