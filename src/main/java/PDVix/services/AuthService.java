package PDVix.services;

import PDVix.DTOs.LoginRequestDTO;
import PDVix.repositories.AuthRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthService {
    private final AuthRepository repository;

    public boolean login(LoginRequestDTO dto){

        if(dto == null)
            throw new IllegalArgumentException("Preencha os dados corretamente!");

        if(dto.getLogin() == null || dto.getLogin().isBlank())
            throw new IllegalArgumentException("Campo de usuário inválido");

        if(dto.getPassword() == null || dto.getPassword().isBlank())
            throw new IllegalArgumentException("Campo de usuário inválido");

        return repository.login(dto);
    }
}
