package PDVix.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "config")
@Getter
@Setter
@AllArgsConstructor
public class Config {
    @Id
    private String chave;
    private String valor;
}
