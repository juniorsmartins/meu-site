package microservice.microinscricoes.adapter.in.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import microservice.microinscricoes.adapter.in.dto.InscricaoIdDto;
import microservice.microinscricoes.adapter.in.dto.PagamentoDtoIn;

@Schema(name = "InscrictoRegisterDtoIn", description = "Objeto de transporte de dados.")
@Builder
public record InscritoRegisterDtoIn(

    @Schema(name = "inscricaoId", description = "Identificador Exclusivo - para identificar uma inscrição no banco de dados.", type = "Long", example = "22", required = true)
    @NotNull
    @Valid
    InscricaoIdDto inscricao,

    @Schema(name = "timeId", description = "Identificador Exclusivo - para identificar um time no banco de dados.", type = "Long", example = "22", required = true)
    @NotNull
    @Positive
    Long timeId,

    PagamentoDtoIn pagamento

) { }

