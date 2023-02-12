package ifpr.pgua.eic.pcdoor.model.repositories;

import ifpr.pgua.eic.pcdoor.model.daos.UsuarioDAO;
import ifpr.pgua.eic.pcdoor.model.entities.Usuario;
import ifpr.pgua.eic.pcdoor.model.results.Result;

public class UsuarioRepository {

    private UsuarioDAO dao;

    public UsuarioRepository(UsuarioDAO dao){
        this.dao = dao;
    }

    public Result cadastrarUsuario(String nome, String email, String senha){

        Usuario usuario = new Usuario(nome, email, senha);

        return dao.cadastrar(usuario);
    }

    public Usuario buscarEmail(String email){

        return dao.buscarEmail(email);
    }
    
}