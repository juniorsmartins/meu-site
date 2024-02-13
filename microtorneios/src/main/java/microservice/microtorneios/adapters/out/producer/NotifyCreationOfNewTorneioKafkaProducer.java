package microservice.microtorneios.adapters.out.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservice.microtorneios.application.port.output.NotifyCreationOfNewTorneioOutputPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotifyCreationOfNewTorneioKafkaProducer implements NotifyCreationOfNewTorneioOutputPort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.torneio-save}")
    private String torneioSaveTopic;

    @Override
    public void sendEvent(String payload) {
        try {
            log.info("Enviando evento para o tópico {}, com os dados {}", torneioSaveTopic, payload);
            kafkaTemplate.send(torneioSaveTopic, payload);

        } catch (Exception ex) {
            log.error("Erro ao tentar enviar dados para o tópico {}, com o payload {}", torneioSaveTopic, payload, ex);
        }
    }
}
