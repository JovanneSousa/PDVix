package PDVix.DTOs;

public class UsuarioDTO {
    private int id;
    private String login;
    private String nome;
    private String perfil;
    private String status;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", nome='" + nome + '\'' +
                ", perfil='" + perfil + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
