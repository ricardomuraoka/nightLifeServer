package br.pucpr.nightlifeserver.rest.establishments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EstablishmentsRepository extends JpaRepository<Establishments, UUID> {
    List<Establishments> getAllEstablishments();
}
