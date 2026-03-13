package PDVix.services;

import PDVix.Entities.Config;
import PDVix.repositories.ConfigRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConfigService {
    private final ConfigRepository repository;

    public String cfg(String chave) {
        return repository.findById(chave)
                .map(Config::getValor)
                .orElse("");
    }
}
