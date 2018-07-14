package br.com.progweb.dinheiros.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import br.com.progweb.dinheiros.type.Lingua;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idUsuario")
    private int idUsuario;

    private String user;

    // TODO: MD5
    private String senha;

    public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getUltimaModificacaoSenha() {
		return ultimaModificacaoSenha;
	}

	public void setUltimaModificacaoSenha(Date ultimaModificacaoSenha) {
		this.ultimaModificacaoSenha = ultimaModificacaoSenha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public Lingua getLingua() {
		return lingua;
	}

	public void setLingua(Lingua lingua) {
		this.lingua = lingua;
	}

	private Date ultimaModificacaoSenha;

    private String nome;
    
    private String urlFoto;
    
    private Lingua lingua;

    // private List<Contas> contas;

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return this.user;
    }
}