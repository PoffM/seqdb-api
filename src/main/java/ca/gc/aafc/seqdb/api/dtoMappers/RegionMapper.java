package ca.gc.aafc.seqdb.api.dtoMappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ca.gc.aafc.seqdb.api.dto.RegionDto;
import ca.gc.aafc.seqdb.entities.Region;

@Mapper(componentModel="spring")
public interface RegionMapper {
  
  
  RegionMapper INSTANCE = Mappers.getMapper( RegionMapper.class);
  
  
  RegionDto regionToRegionDto(Region region);
  
  //applies the configurations in reverse so that mappings are bilateral.
  @InheritInverseConfiguration
  Region fromRegionDto(RegionDto regionDto);
  
  
  

}
