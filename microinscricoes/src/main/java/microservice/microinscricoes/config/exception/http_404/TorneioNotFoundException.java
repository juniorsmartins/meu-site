package microservice.microinscricoes.config.exception.http_404;

import java.io.Serial;

public final class TorneioNotFoundException extends RecursoNaoEncontradoException {

  @Serial
  private static final long serialVersionUID = 1L;

  public TorneioNotFoundException(String message) {
    super(message);
  }

  public TorneioNotFoundException(Long id) {
    this(String.format("O Torneio %d não foi encontrado.", id));
  }
}
