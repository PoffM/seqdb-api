package ca.gc.aafc.seqdb.api.dtoMappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ca.gc.aafc.seqdb.api.dto.GroupDto;
import ca.gc.aafc.seqdb.entities.Group;

@Mapper (componentModel="spring")
public interface GroupMapper {
  
  GroupMapper INSTACE = Mappers.getMapper(GroupMapper.class);
  
  GroupDto entityToDto (Group group);
  
  @InheritInverseConfiguration
  Group dtoToEntity(GroupDto groupDto);

}
