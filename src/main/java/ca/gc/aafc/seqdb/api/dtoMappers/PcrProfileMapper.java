package ca.gc.aafc.seqdb.api.dtoMappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import ca.gc.aafc.seqdb.api.dto.ThermocyclerProfileDto;
import ca.gc.aafc.seqdb.entities.PcrProfile;
import ca.gc.aafc.seqdb.entities.PcrProfile.PcrProfileBuilder;

@Mapper(componentModel="spring")
public abstract class PcrProfileMapper {
  
  public static PcrProfileMapper INSTANCE = Mappers.getMapper(PcrProfileMapper.class);
  
  public abstract PcrProfile dtoToEntity(ThermocyclerProfileDto thermoDto);
  
  //Our target is a builder since mapstruct will use the lombok builder to construct the object.
  @AfterMapping
  protected void setJpaSteps( ThermocyclerProfileDto thermoDto, @MappingTarget  PcrProfileBuilder pcrprofileJpa ) {
    
    pcrprofileJpa.step1(thermoDto.getSteps().get(1));
    pcrprofileJpa.step2(thermoDto.getSteps().get(2));
    pcrprofileJpa.step3(thermoDto.getSteps().get(3));
    pcrprofileJpa.step4(thermoDto.getSteps().get(4));
    pcrprofileJpa.step5(thermoDto.getSteps().get(5));
    pcrprofileJpa.step6(thermoDto.getSteps().get(6));
    pcrprofileJpa.step7(thermoDto.getSteps().get(7));
    pcrprofileJpa.step8(thermoDto.getSteps().get(8));
    pcrprofileJpa.step9(thermoDto.getSteps().get(9));
    pcrprofileJpa.step10(thermoDto.getSteps().get(10));
    pcrprofileJpa.step11(thermoDto.getSteps().get(11));
    pcrprofileJpa.step12(thermoDto.getSteps().get(12));
    pcrprofileJpa.step13(thermoDto.getSteps().get(13));
    pcrprofileJpa.step14(thermoDto.getSteps().get(14));
    pcrprofileJpa.step15(thermoDto.getSteps().get(15));
    

    
  }
  
}
