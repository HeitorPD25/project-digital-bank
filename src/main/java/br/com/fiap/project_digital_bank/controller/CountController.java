package br.com.fiap.project_digital_bank.controller;

import java.util.List;
//import java.util.logging.Logger;

//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.project_digital_bank.model.Count;
import br.com.fiap.project_digital_bank.repository.CountRepository;

@RestController
@RequestMapping("counts")
public class CountController {
  
    //private final Logger log = (Logger) LoggerFactory.getLogger(getClass());

    @Autowired
    private CountRepository repository;


    @GetMapping
    public List<Count> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Count create(@RequestBody Count count) {
        //log.info("Cadastrando uma nova conta: " + count.getAgency());
        System.out.println("Cadastrando uma nova conta: " + count.getAgency());
        repository.save(count);
        return count;
    }

    @GetMapping("/{agency}")
    public ResponseEntity<Count> get(@PathVariable String agency) {
        //log.info("Buscando conta: " + agency);
        System.out.println("Buscando conta: " + agency);
        return ResponseEntity.ok(getCountByAgency(agency));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Count> get(@PathVariable Long cpf) {
        //log.info("Buscando conta: " + agency);
        System.out.println("Buscando conta: " + cpf);
        return ResponseEntity.ok(getCountByCpf(cpf));
    }

    private Count getCountByAgency (String agency) {
        return repository.findById(agency)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada.")
                );
    }

    private Count getCountByCpf (Long cpf) {
        return repository.findByCpf(cpf).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada.")
                );
    }


    
        
    







}
