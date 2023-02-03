package ifpr.pgua.eic.pcdoor.model.daos;

import java.util.List;

import ifpr.pgua.eic.pcdoor.model.entities.Usuario;
import ifpr.pgua.eic.pcdoor.model.results.Result;

public interface UsuarioDAO {
    Result cadastrar(Usuario usuario);
    List<Usuario> listaUsuario();
}
