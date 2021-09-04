package br.com.tdso.model;

import java.sql.Blob;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Configuracao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String assunto;
	private Blob arquivo;
	private String matricula;
	
	public Configuracao() {}
	
	public Configuracao(String assunto, Blob arquivo, String matricula) {
		this.assunto = assunto;
		this.arquivo = arquivo;
		this.matricula = matricula;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public Blob getArquivo() {
		return arquivo;
	}
	public void setArquivo(Blob arquivo) {
		this.arquivo = arquivo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public FormDto of() throws SQLException {
		String objeto = new String(this.arquivo.getBytes(1, (int) this.arquivo.length()));
		return new FormDto(this.matricula, this.assunto, objeto);
	}
	
	

}
