package br.com.fiap.project_digital_bank.model;

import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Entity
@Data
public class Count {

    @Id
    private String agency;

    @NotNull(message = "O Nome não pode ser nulo.")
    private String name;

    @NotNull(message = "O CPF não pode ser nulo.")
    private Long cpf;
    
    @PastOrPresent(message = "A Data não pode ser no futuro.")
    private LocalDate startDate;
    
    @PositiveOrZero(message = "O Saldo inicial não pode ser negativo.")
    private Long initialBalance;
    
    private boolean status;
    
    private Type type;
    
}
