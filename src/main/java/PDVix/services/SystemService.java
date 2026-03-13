package PDVix.services;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SystemService {
    private final ConfigService configService;
    private final NetworkService networkService;

    public boolean isOnline() {
        String servidor = configService.cfg("servidor_url");

        return networkService.isOnline(servidor);
    }
}
