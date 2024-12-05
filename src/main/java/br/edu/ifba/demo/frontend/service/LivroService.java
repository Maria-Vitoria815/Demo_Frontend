package br.edu.ifba.demo.frontend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.ifba.demo.frontend.dto.LivroDTO;


@Service

public class LivroService {
    
    //Link da porta onde está rodando o backend
    private final String BASE_URL = "http://localhost:8081/livro"; 

    private final RestTemplate restTemplate = new RestTemplate();

    public List<LivroDTO> listAllLivros() {
        return List.of(restTemplate.getForObject(BASE_URL + "/listall", LivroDTO[].class));
    }

    public LivroDTO getById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/id/{id}", LivroDTO.class, id);
    }

    public LivroDTO getByIsbn(String isbn) {
        return restTemplate.getForObject(BASE_URL + "/isbn/{isbn}", LivroDTO.class, isbn);
    }

    public LivroDTO getByTitulo(String titulo) {
        return restTemplate.getForObject(BASE_URL + "/titulo/{titulo}", LivroDTO.class, titulo);
    }

    public LivroDTO save(LivroDTO livro) {
        return restTemplate.postForObject(BASE_URL, livro, LivroDTO.class);
    }

    public void delete(Long id) {
        restTemplate.delete(BASE_URL + "/delete/{id}", id);
    }
    
}
