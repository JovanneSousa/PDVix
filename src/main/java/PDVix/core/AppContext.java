package PDVix.core;

import PDVix.controllers.LoginController;
import PDVix.controllers.PdvController;
import PDVix.repositories.AuthRepository;
import PDVix.repositories.ConfigRepository;
import PDVix.services.AuthService;
import PDVix.services.ConfigService;
import PDVix.services.NetworkService;
import PDVix.services.SystemService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppContext {
    private static AppContext instance;

    // Infra
    private final ObjectMapper objectMapper;

    // Repositories
    private final ConfigRepository configRepository;
    private final AuthRepository authRepository;

    // Services
    private final ConfigService configService;
    private final NetworkService networkService;
    private final SystemService systemService;
    private final AuthService authService;

    // Controllers
    private final LoginController loginController;
    private final PdvController pdvController;

    private AppContext() {
        // Infra
        this.objectMapper = new ObjectMapper();

        // Repositories
        this.configRepository = new ConfigRepository();
        this.authRepository   = new AuthRepository(objectMapper);

        // Services
        this.configService  = new ConfigService(configRepository);
        this.networkService = new NetworkService();
        this.systemService  = new SystemService(configService, networkService);
        this.authService    = new AuthService(authRepository);

        // Controllers
        this.loginController = new LoginController(authService);
        this.pdvController   = new PdvController();
    }

    public static AppContext getInstance() {
        if (instance == null) {
            instance = new AppContext();
        }
        return instance;
    }

    public Object getController(Class<?> clazz) {
        if (clazz == LoginController.class) return loginController;
        if (clazz == PdvController.class)   return pdvController;
        throw new IllegalArgumentException("Controller não registrado: " + clazz.getName());
    }

    public ConfigService getConfigService()   { return configService; }
    public AuthService getAuthService()       { return authService; }
    public SystemService getSystemService()   { return systemService; }
    public NetworkService getNetworkService() { return networkService; }
}
