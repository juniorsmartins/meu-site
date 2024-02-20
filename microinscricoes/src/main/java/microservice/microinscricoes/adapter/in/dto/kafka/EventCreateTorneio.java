package microservice.microinscricoes.adapter.in.dto.kafka;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import microservice.microinscricoes.adapter.in.dto.request.TorneioSaveDto;

public record EventCreateTorneio(

    @NotNull
    @Valid
    TorneioSaveDto torneio

) { }
