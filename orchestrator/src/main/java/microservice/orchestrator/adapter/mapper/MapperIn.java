package microservice.orchestrator.adapter.mapper;

import microservice.orchestrator.adapter.in.consumer.dto.HistoryDtoRequest;
import microservice.orchestrator.adapter.in.consumer.dto.InscritoDtoRequest;
import microservice.orchestrator.adapter.in.consumer.dto.TimeIdDto;
import microservice.orchestrator.adapter.in.consumer.event.SagaEventRequest;
import microservice.orchestrator.application.core.domain.History;
import microservice.orchestrator.application.core.domain.Inscrito;
import microservice.orchestrator.application.core.domain.SagaEvent;
import microservice.orchestrator.application.core.domain.Time;
import microservice.orchestrator.application.core.domain.enums.EEventSource;
import microservice.orchestrator.application.core.domain.enums.ESagaStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface MapperIn {

    @Mapping(source = "id", target = "sagaEventId")
    @Mapping(source = "source", target = "source", qualifiedByName = "converterStringParaEnumEventSource")
    @Mapping(source = "status", target = "status", qualifiedByName = "converterStringParaEnumSagaStatus")
    SagaEvent toSagaEvent(SagaEventRequest sagaEventRequest);

    @Named("converterStringParaEnumEventSource")
    default EEventSource converterStringParaEnumEventSource(String source) {
        if (source == null) {
            return null;
        }
        return EEventSource.fromValue(source);
    }

    @Named("converterStringParaEnumSagaStatus")
    default ESagaStatus converterStringParaEnumSagaStatus(String status) {
        if (status == null) {
            return null;
        }
        return ESagaStatus.fromValue(status);
    }

    @Mapping(source = "inscricao.id", target = "inscricaoId")
    Inscrito toInscrito(InscritoDtoRequest inscritoDtoRequest);

    Time toTime(TimeIdDto timeIdDto);

    @Mapping(source = "status", target = "status", qualifiedByName = "converterStringParaEnumSagaStatus")
    History toHistory(HistoryDtoRequest historyDtoRequest);

}

