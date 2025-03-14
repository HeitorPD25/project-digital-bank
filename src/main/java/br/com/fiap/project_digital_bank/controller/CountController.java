package br.com.fiap.project_digital_bank.controller;

import java.util.List;
//import java.util.logging.Logger;

//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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


    
        
    







}
