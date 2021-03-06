package com.jobJunior.cursomc.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobJunior.cursomc.dto.CidadeDTO;
import com.jobJunior.cursomc.dto.EstadoDTO;
import com.jobJunior.cursomc.model.Cidade;
import com.jobJunior.cursomc.model.Estado;
import com.jobJunior.cursomc.service.CidadeService;
import com.jobJunior.cursomc.service.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> findAll(){
		List<Estado> lEstados = estadoService.findAll();
		List<EstadoDTO> lDtos = lEstados.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(lDtos);
	}
	
	@GetMapping(value="/{estadoId}/cidades")
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> list = cidadeService.findByEstado(estadoId);
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
}
