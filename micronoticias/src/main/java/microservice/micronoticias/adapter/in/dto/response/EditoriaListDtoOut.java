package microservice.micronoticias.adapter.in.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EditoriaListDtoOut(

    Long id,

    String nomenclatura,

    String descricao

) { }

