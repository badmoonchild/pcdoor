package ifpr.pgua.eic.pcdoor.model.entities;

import java.time.LocalDate;

public class Usuario {
    
    private String nomeUsuario;
    private LocalDate dataNascimento;
    private String email;
    private String enderecoUsuario;

    
    public Usuario(String nomeUsuario, LocalDate dataNascimento, String email, String enderecoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.enderecoUsuario = enderecoUsuario;
    }


    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getEnderecoUsuario() {
        return enderecoUsuario;
    }
    
    public void setEnderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

}
