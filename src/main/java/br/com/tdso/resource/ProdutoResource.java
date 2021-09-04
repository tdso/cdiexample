package br.com.tdso.resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartInput;

import br.com.tdso.model.Produto;

@Path("produto")
public class ProdutoResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Produto getProduto () {
		Produto p = new Produto ("Samsung A", new BigDecimal(550.0));
		return p;
	}
	
	@POST
	//@Consumes(MediaType.MULTIPART_FORM_DATA_TYPE)
	public Response upload(byte[] arquivo) throws IOException, SerialException, SQLException{
		
		String texto = arquivo.toString();
		SerialBlob sb = new SerialBlob (arquivo); 
		
		System.out.println("texto = " + sb.getBinaryStream().toString());
		//System.out.println(arquivo.readAllBytes().toString());
		return Response.ok().build();
	}

}
