package PDVix.DTOs;

public class LoginResponseDTO {
    private boolean status;
    private UsuarioDTO data;
    private String message;

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", user=" + (data != null ? data.toString() : null) +
                '}';
    }
}
