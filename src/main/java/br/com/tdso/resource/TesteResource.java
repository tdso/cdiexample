package br.com.tdso.resource;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tdso.dao.ConfiguracaoDao;
import br.com.tdso.model.Configuracao;
import br.com.tdso.model.FormDto;


@Path("upload")
public class TesteResource {
	
	@Inject
	ConfiguracaoDao dao;
	
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvaDados(FormDto formdto) throws SQLException {
		System.out.println("upload");
		System.out.println("formdto.getMatricula = " + formdto.getMatricula());
		System.out.println("formdto.getAssunto() = " + formdto.getAssunto());
		System.out.println("formdto.getArquivo() = " + formdto.getArquivo());
		
		Configuracao c = formdto.toConfiguracao();
		dao.salvaConfiguracao(c);
		
		String arq = formdto.getArquivo();
		
		return Response.status(200).entity(arq).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConfig(@PathParam("id") String id) throws SQLException {
		System.out.println("get id = " + id);
		
		Configuracao c = dao.getConfiguracao(Long.parseLong(id));
		FormDto formdto = c.of();
		System.out.println("get blob to text = " + formdto.getArquivo());
		return Response.status(200).entity(formdto).build();
	}
	
	
	
	
	
	
//	return Response.status(200)
//			.header("Access-Control-Allow-Origin", "*")
//			.header("Access-Control-Allow-Credentials", "true")
//			.header("Access-Control-Allow-Headers",
//					"origin, content-type, accept, authorization")
//			.header("Access-Control-Allow-Methods", 
//					"GET, POST, PUT, DELETE, OPTIONS, HEAD")

}
