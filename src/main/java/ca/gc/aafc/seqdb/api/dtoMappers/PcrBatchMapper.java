package ca.gc.aafc.seqdb.api.dtoMappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ca.gc.aafc.seqdb.api.dto.PcrBatchDto;
import ca.gc.aafc.seqdb.entities.PcrBatch;

@Mapper(componentModel="spring")
public interface PcrBatchMapper {

   PcrBatchMapper INSTANCE = Mappers.getMapper(PcrBatchMapper.class);
   
   PcrBatchDto entityToDto(PcrBatch pcrBatch);
   
   @InheritInverseConfiguration
   PcrBatch dtoToEntity(PcrBatchDto batchDto);
}
