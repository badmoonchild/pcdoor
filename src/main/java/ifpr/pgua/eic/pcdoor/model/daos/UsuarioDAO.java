package ifpr.pgua.eic.pcdoor.model.daos;

import ifpr.pgua.eic.pcdoor.model.entities.Usuario;
import ifpr.pgua.eic.pcdoor.model.results.Result;

public interface UsuarioDAO {
    Result cadastrar(Usuario usuario);
    Usuario buscarEmail(String email);
    Usuario login(String email, String senha);
}