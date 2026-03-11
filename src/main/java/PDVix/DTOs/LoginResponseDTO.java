package PDVix.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {
    private String status;
    private DataDTO data;
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
