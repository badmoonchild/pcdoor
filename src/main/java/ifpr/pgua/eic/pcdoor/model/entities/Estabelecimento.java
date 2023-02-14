package ifpr.pgua.eic.pcdoor.model.entities;

public class Estabelecimento {

    private int idEstabelecimento; 
    private String nomeEstabelecimento;
    private String emailEstabelecimento;
    private String senhaEstabelecimento;
    private String tipoEstabelecimento;
    private String cnpj;
    private String descricaoAcessibilidade;
    private int pontuacao;
    private String endereco;
    
    public Estabelecimento(int idEstabelecimento, String nomeEstabelecimento, String emailEstabelecimento,
            String senhaEstabelecimento, String tipoEstabelecimento, String cnpj, String descricaoAcessibilidade,
            int pontuacao, String endereco) {
        this.idEstabelecimento = idEstabelecimento;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.emailEstabelecimento = emailEstabelecimento;
        this.senhaEstabelecimento = senhaEstabelecimento;
        this.tipoEstabelecimento = tipoEstabelecimento;
        this.cnpj = cnpj;
        this.descricaoAcessibilidade = descricaoAcessibilidade;
        this.pontuacao = pontuacao;
        this.endereco = endereco;
    }

    public Estabelecimento(String nomeEstabelecimento, String emailEstabelecimento,
            String senhaEstabelecimento, String tipoEstabelecimento, String cnpj, String descricaoAcessibilidade,
            int pontuacao, String endereco) {
        this(-1, nomeEstabelecimento, emailEstabelecimento, senhaEstabelecimento, tipoEstabelecimento, cnpj, descricaoAcessibilidade, pontuacao, endereco);
    }

    public int getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }


    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }


    public String getEmailEstabelecimento() {
        return emailEstabelecimento;
    }

    public void setEmailEstabelecimento(String emailEstabelecimento) {
        this.emailEstabelecimento = emailEstabelecimento;
    }


    public String getSenhaEstabelecimento() {
        return senhaEstabelecimento;
    }

    public void setSenhaEstabelecimento(String senhaEstabelecimento) {
        this.senhaEstabelecimento = senhaEstabelecimento;
    }


    public String getTipoEstabelecimento() {
        return tipoEstabelecimento;
    }

    public void setTipoEstabelecimento(String tipoEstabelecimento) {
        this.tipoEstabelecimento = tipoEstabelecimento;
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
    public String getDescricaoAcessibilidade() {
        return descricaoAcessibilidade;
    }

    public void setDescricaoAcessibilidade(String descricaoAcessibilidade) {
        this.descricaoAcessibilidade = descricaoAcessibilidade;
    }


    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacaoMedia) {
        this.pontuacao = pontuacaoMedia;
    }


    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String toString(){
        String str = nomeEstabelecimento;

        return str;
    }
    
}