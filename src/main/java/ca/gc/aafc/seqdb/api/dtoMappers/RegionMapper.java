package ca.gc.aafc.seqdb.api.dtoMappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ca.gc.aafc.seqdb.api.dto.RegionDto;
import ca.gc.aafc.seqdb.entities.Region;

@Mapper
public interface RegionMapper {
  
  RegionMapper INSTANCE = Mappers.getMapper( RegionMapper.class);
  
  RegionDto regionToRegionDto(Region region);
  

}
