package projetofinal.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Processos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Cliente cliente;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String descricao;
	private String nome;
	private Date dataCriacao;
	private int nroProcesso;
	@ManyToOne
	private Documento documento;
	@ManyToOne
	private Usuario usuario;

	public Processos() {

	}

	public Processos(
			@NotNull @NotEmpty @Length(min = 2) int nroProcesso, 
			Status status2,
			@NotNull @NotEmpty Cliente cliente,
			@NotNull @NotEmpty Documento documento,
			@NotNull @NotEmpty Usuario usuario, 
			@NotNull @NotEmpty Date dataCriacao) {

		this.nroProcesso = nroProcesso;
		this.cliente = cliente;
		this.documento = documento;
		this.usuario = usuario;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getNroProcesso() {
		return nroProcesso;
	}

	public void setNroProcesso(int numeroprocesso) {
		this.nroProcesso = numeroprocesso;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
