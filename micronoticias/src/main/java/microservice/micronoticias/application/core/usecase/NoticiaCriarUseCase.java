package microservice.micronoticias.application.core.usecase;

import microservice.micronoticias.application.core.domain.Noticia;
import microservice.micronoticias.application.core.usecase.regras.RuleStrategyToCreateNews;
import microservice.micronoticias.application.port.input.NoticiaCriarInputPort;
import microservice.micronoticias.application.port.output.NoticiaSalvarOutputPort;
import microservice.micronoticias.config.exception.http_500.NoticiaCriarUseCaseException;

import java.util.List;
import java.util.Optional;

public class NoticiaCriarUseCase implements NoticiaCriarInputPort {

    private final NoticiaSalvarOutputPort cadastrarOutputPort;

    private final List<RuleStrategyToCreateNews> ruleStrategies;

    public NoticiaCriarUseCase(NoticiaSalvarOutputPort cadastrarOutputPort, List<RuleStrategyToCreateNews> ruleStrategies) {
        this.cadastrarOutputPort = cadastrarOutputPort;
        this.ruleStrategies = ruleStrategies;
    }

    @Override
    public Noticia criar(Noticia noticia) {

        return Optional.ofNullable(noticia)
            .map(this::callBusinessRules)
            .map(this.cadastrarOutputPort::salvar)
            .orElseThrow(NoticiaCriarUseCaseException::new);
    }

    private Noticia callBusinessRules(Noticia noticia) {
        this.ruleStrategies.forEach(rule -> rule.executar(noticia));
        return noticia;
    }
}

