package ProjetoFinal.ApiGerenciadorDoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer numeroOAB;
	private String login;
	private int nroProcesso;
	private String senha;
	@OneToMany
	private Cliente cliente;
	@ManyToOne
	private Processos processos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getNumeroOAB() {
		return numeroOAB;
	}
	public void setNumeroOAB(Integer numeroOAB) {
		this.numeroOAB = numeroOAB;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getNroProcesso() {
		return nroProcesso;
	}
	public void setNroProcesso(int nro_processo) {
		this.nroProcesso = nro_processo;
	}

}
