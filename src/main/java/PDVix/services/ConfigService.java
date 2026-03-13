package PDVix.services;

import PDVix.Entities.Config;
import PDVix.repositories.ConfigRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfigService {
    @Autowired
    private final ConfigRepository repository;

    public String cfg(String chave) {
        return repository.findById(chave)
                .map(Config::getValor)
                .orElse("");
    }
}
