package br.pucpr.nightlifeserver.rest.establishments;

import br.pucpr.nightlifeserver.lib.exception.BadRequestException;
import br.pucpr.nightlifeserver.lib.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EstablishmentsService {
    private EstablishmentsRepository repository;

    public EstablishmentsService(EstablishmentsRepository repository) {
        this.repository = repository;
    }
    public List<Establishments> getAllEstablishments() {
        return repository.findAll();
    }

    public Establishments addEstablishment(Establishments establishment) {
        if (establishment == null) {
            throw new BadRequestException("Artist cannot be null!");
        }
        if (establishment.getId() != null) {
            throw new BadRequestException("Cannot save with an id!");
        }
        return repository.save(establishment);
    }

    public void deleteEstablishment(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(id);
        }
        repository.deleteById(id);
    }
}
