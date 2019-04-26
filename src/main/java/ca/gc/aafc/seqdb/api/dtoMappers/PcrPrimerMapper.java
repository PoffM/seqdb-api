package ca.gc.aafc.seqdb.api.dtoMappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ca.gc.aafc.seqdb.api.dto.PcrPrimerDto;
import ca.gc.aafc.seqdb.entities.PcrPrimer;

@Mapper(componentModel="spring")
public interface PcrPrimerMapper {

  PcrPrimerMapper INSTANCE = Mappers.getMapper(PcrPrimerMapper.class);

  PcrPrimerDto entityToDto(PcrPrimer primer);

  @InheritInverseConfiguration
  PcrPrimer dtoToEntity(PcrPrimerDto primerDto);

}