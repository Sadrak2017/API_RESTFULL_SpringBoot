package br.com.sadrak.api_restfull.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.camunda.bpm.engine.exception.NotAllowedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ServiceImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Object getResource(String json) throws IOException {
		Assert.notNull(json, "Json de request não pode ser null");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(json);
		JsonNode versao = actualObj.get("versao");
		JsonNode instituicao = actualObj.get("instituicao");
		JsonNode usuario = actualObj.get("usuario");
		JsonNode aplicacao = actualObj.get("aplicacao");
		JsonNode quantidade = actualObj.get("quantidade");
		JsonNode nome = actualObj.get("nome");
		JsonNode q = actualObj.get("q");
		
		Assert.notNull(versao, "Json de request não pode ser null");
		Assert.notNull(nome, "Atributo 'Nome' no json de request não pode ser null");
		Assert.notNull(usuario, "Atributo 'usuario' no json de request não pode ser null");
		Assert.notNull(aplicacao, "Atributo 'aplicacao' no json de request não pode ser null");
		
		jdbcTemplate.execute("set search_path to XT");
		List<Map<String, Object>> response = jdbcTemplate.queryForList("SELECT * FROM " + nome.textValue() + "(?, ?, ?, ?, ?, ?)", new Object[] {versao.asText(), instituicao.asInt(), aplicacao.asInt(), usuario.asText(), (q!= null ? q.toString(): null), (quantidade != null ? quantidade.asText(): null)});
	
		return response;
	}
	
	public void patchResource(String json) throws IOException {
		Assert.notNull(json, "Json de request não pode ser null");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(json);
		JsonNode versao = actualObj.get("versao");
		JsonNode instituicao = actualObj.get("instituicao");
		JsonNode usuario = actualObj.get("usuario");
		JsonNode aplicacao = actualObj.get("aplicacao");
		JsonNode nome = actualObj.get("nome");
		JsonNode body = actualObj.get("body");
		
		Assert.notNull(versao, "Json de request não pode ser null");
		Assert.notNull(instituicao, "Atributo 'instituicao' no json de request não pode ser null");
		Assert.notNull(nome, "Atributo 'Nome' no json de request não pode ser null");
		Assert.notNull(usuario, "Atributo 'usuario' no json de request não pode ser null");
		Assert.notNull(aplicacao, "Atributo 'aplicacao' no json de request não pode ser null");
		Assert.notNull(body, "Atributo 'body' no json de request não pode ser null");
		
	}
	
	public void postResource(String json) throws IOException {
		Assert.notNull(json, "Json de request não pode ser null");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(json);
		JsonNode versao = actualObj.get("versao");
		JsonNode instituicao = actualObj.get("instituicao");
		JsonNode usuario = actualObj.get("usuario");
		JsonNode aplicacao = actualObj.get("aplicacao");
		JsonNode nome = actualObj.get("nome");
		JsonNode body = actualObj.get("body");
		
		Assert.notNull(versao, "Json de request não pode ser null");
		Assert.notNull(instituicao, "Atributo 'instituicao' no json de request não pode ser null");
		Assert.notNull(nome, "Atributo 'Nome' no json de request não pode ser null");
		Assert.notNull(usuario, "Atributo 'usuario' no json de request não pode ser null");
		Assert.notNull(aplicacao, "Atributo 'aplicacao' no json de request não pode ser null");
		Assert.notNull(body, "Atributo 'body' no json de request não pode ser null");
		
	}
	
	public void deleteResource(String json) throws IOException {
		Assert.notNull(json, "Json de request não pode ser null");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(json);
		JsonNode versao = actualObj.get("versao");
		JsonNode instituicao = actualObj.get("instituicao");
		JsonNode usuario = actualObj.get("usuario");
		JsonNode aplicacao = actualObj.get("aplicacao");
		JsonNode nome = actualObj.get("nome");
		JsonNode body = actualObj.get("body");
		
		Assert.notNull(versao, "Json de request não pode ser null");
		Assert.notNull(instituicao, "Atributo 'instituicao' no json de request não pode ser null");
		Assert.notNull(nome, "Atributo 'Nome' no json de request não pode ser null");
		Assert.notNull(usuario, "Atributo 'usuario' no json de request não pode ser null");
		Assert.notNull(aplicacao, "Atributo 'aplicacao' no json de request não pode ser null");
		Assert.notNull(body, "Atributo 'body' no json de request não pode ser null");
		
	}

}
