package PDVix.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SystemService {
    @Autowired
    private final ConfigService configService;
    @Autowired
    private final NetworkService networkService;

    public boolean isOnline() {
        String servidor = configService.cfg("servidor_url");

        return networkService.isOnline(servidor);
    }
}
