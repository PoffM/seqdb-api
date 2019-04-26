package ca.gc.aafc.seqdb.api.dtoMappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ca.gc.aafc.seqdb.api.dto.ThermocyclerProfileDto;
import ca.gc.aafc.seqdb.entities.PcrProfile;

@Mapper(componentModel="spring")
public interface PcrProfileMapper {

  PcrProfileMapper INSTANCE = Mappers.getMapper(PcrProfileMapper.class);
  
  ThermocyclerProfileDto entityToDto(PcrProfile pcrProfile);
  
  @InheritInverseConfiguration
  PcrProfile dtoToEntity(ThermocyclerProfileDto thermoDto);
  
  
}
