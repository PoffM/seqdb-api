package ca.gc.aafc.seqdb.api.dtoMappers;

import java.util.HashMap;
import java.util.Map;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import ca.gc.aafc.seqdb.api.dto.ThermocyclerProfileDto;
import ca.gc.aafc.seqdb.entities.PcrProfile;

@Mapper(componentModel="spring")
public abstract class ThermocyclerProfileMapper {
  
  
  //"instance" of the method that we call to retrieve the mapper. static since this is a abstract class implimentation
  public static ThermocyclerProfileMapper INSTANCE = Mappers.getMapper( ThermocyclerProfileMapper.class);

  //public abstract declaration designates the responsibility of generating the method to
  //MapStruct's own code generation and auto mapping.
  public abstract ThermocyclerProfileDto  entityToDto(PcrProfile pcrProfile);
  
  //The after mapping annotation will run the following method after the initial mapping is done.
  //The method will only be injected for mappings with the Type designated with @MappingTarget
  //This way we can implement custom logic while also benefiting from the auto-generated code.
  @AfterMapping
  protected void setSteps( PcrProfile pcr, @MappingTarget ThermocyclerProfileDto targetDto ) {
    
    Map<Integer, String> intermMaps = new HashMap<Integer, String>();
    intermMaps.put(1, pcr.getStep1());
    intermMaps.put(2, pcr.getStep2());
    intermMaps.put(3, pcr.getStep3());
    intermMaps.put(4, pcr.getStep4());
    intermMaps.put(5, pcr.getStep5());
    intermMaps.put(6, pcr.getStep6());
    intermMaps.put(7, pcr.getStep7());
    intermMaps.put(8, pcr.getStep8());
    intermMaps.put(9, pcr.getStep9());
    intermMaps.put(10, pcr.getStep10());
    intermMaps.put(11, pcr.getStep11());
    intermMaps.put(12, pcr.getStep12());
    intermMaps.put(13, pcr.getStep13());
    intermMaps.put(14, pcr.getStep14());
    intermMaps.put(15, pcr.getStep15());
    
    targetDto.setSteps(intermMaps);
    
  }
  
  //This version will run out own implementation with no auto generated code injected.
  public  PcrProfile dtoToEntity(ThermocyclerProfileDto thermoDto) {
      PcrProfile pcr = new PcrProfile();
      pcr.setId(thermoDto.getPcrProfileId());
      pcr.setStep1(thermoDto.getSteps().get(1));
      pcr.setStep2(thermoDto.getSteps().get(2));
      pcr.setStep3(thermoDto.getSteps().get(3));
      pcr.setStep4(thermoDto.getSteps().get(4));
      pcr.setStep5(thermoDto.getSteps().get(5));
      pcr.setStep6(thermoDto.getSteps().get(6));
      pcr.setStep7(thermoDto.getSteps().get(7));
      pcr.setStep8(thermoDto.getSteps().get(8));
      pcr.setStep9(thermoDto.getSteps().get(9));
      pcr.setStep10(thermoDto.getSteps().get(10));
      pcr.setStep11(thermoDto.getSteps().get(11));
      pcr.setStep12(thermoDto.getSteps().get(12));
      pcr.setStep13(thermoDto.getSteps().get(13));
      pcr.setStep14(thermoDto.getSteps().get(14));
      pcr.setStep15(thermoDto.getSteps().get(15));
      
      
      return pcr;
  }
}