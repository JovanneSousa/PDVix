package PDVix.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemStatusDTO {
    private boolean online;
    private String versao;
    private String numeroPDV;
}
