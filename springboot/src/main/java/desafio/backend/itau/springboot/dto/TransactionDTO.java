package desafio.backend.itau.springboot.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.OffsetDateTime;

public class TransactionDTO {

    @NotNull
    @Positive
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public double getValor() {
        return valor;
    }

    public void setValor(@NotNull @Positive Double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

}
