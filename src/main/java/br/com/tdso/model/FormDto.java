package br.com.tdso.model;

import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

public class FormDto {
	
	private String assunto;
	private String arquivo;
	private String matricula;
	
	public FormDto() {}
	
	public FormDto(	String matricula , String assunto, String arquivo) {
		this.matricula = matricula;
		this.assunto = assunto;
		this.arquivo = arquivo;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "FormDto [assunto=" + assunto + ", arquivo=" + arquivo + ", matricula=" + matricula + "]";
	}
	
	public Configuracao toConfiguracao() throws SQLException {
		Blob blob = new SerialBlob(this.arquivo.getBytes());
		return new Configuracao(this.assunto, blob, this.matricula);
	}
	
	

}
