package br.com.progweb.dinheiros.model;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.progweb.dinheiros.type.Lingua;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idUsuario", nullable=false)
    private int idUsuario;

    @NotBlank
    @Size(min=0, max=40)
    // @Pattern(regexp = "[0-9a-zA-Z_-.]*")
    @Column(name="username", length=40, nullable=false, unique=true)
    private String username;

    // TODO: MD5
    @NotBlank
    @Size(min=6, max=32)
    @Column(name="senha", length=32, nullable=false)
    private String senha;
    
    @NotBlank
    @Email
    @Size(max=80)
    @Column(name="email", length=80, nullable=false, unique=true)
    private String email;

    @NotNull
    @Column(name="ultimaModSenha", nullable=false)
	private Date ultimaModificacaoSenha;
    
    @NotBlank
    // @Pattern(regexp="[A-Za-z à-úÁ-Ú]*")
    @Size(max=80)
    @Column(name="nome", nullable=false, length=80)
    private String nome;
    
    @Column(name="urlFoto", nullable=true, unique=true, length=80)
    private String urlFoto;
    
    @NotNull
    @Column(name="lingua", nullable=false)
    private Lingua lingua;

    @OneToMany(mappedBy="usuario")
    private List<Conta> contas;
    
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

    public void setUser(String user) {
        this.username = user;
    }

    public String getUser() {
        return this.username;
    }
}