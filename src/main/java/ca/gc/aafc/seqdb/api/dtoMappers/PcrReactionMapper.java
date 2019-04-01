package ca.gc.aafc.seqdb.api.dtoMappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ca.gc.aafc.seqdb.api.dto.PcrReactionDto;
import ca.gc.aafc.seqdb.entities.PcrReaction;

@Mapper(componentModel="spring")
public interface PcrReactionMapper {
  
  PcrReactionMapper INSTANCE = Mappers.getMapper(PcrReactionMapper.class);
  
  PcrReactionDto entityToDto(PcrReaction reaction);
  
  @InheritInverseConfiguration
  PcrReaction dtoToEntity(PcrReactionDto reactionDto);

}
