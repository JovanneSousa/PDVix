package PDVix.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataDTO {
    private UsuarioDTO user;
    @Override
    public String toString() {
        return user != null ? user.toString() : null;
    }
}
