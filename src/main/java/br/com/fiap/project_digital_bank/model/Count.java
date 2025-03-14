package br.com.fiap.project_digital_bank.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Count {

    @Id
    private String agency;
    private String name;
    private int cpf;
    private LocalDate startDate;
    private int initialBalance;
    private boolean status;
    private Type tipo;
    
}
