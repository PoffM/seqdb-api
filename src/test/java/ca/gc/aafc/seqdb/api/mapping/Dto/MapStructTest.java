package ca.gc.aafc.seqdb.api.mapping.Dto;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import ca.gc.aafc.seqdb.api.dto.PcrPrimerDto;
import ca.gc.aafc.seqdb.api.dto.RegionDto;
import ca.gc.aafc.seqdb.api.dto.ThermocyclerProfileDto;
import ca.gc.aafc.seqdb.api.dtoMappers.PcrPrimerMapper;
import ca.gc.aafc.seqdb.api.dtoMappers.RegionMapper;
import ca.gc.aafc.seqdb.api.dtoMappers.ThermocyclerProfileMapper;
import ca.gc.aafc.seqdb.entities.PcrPrimer;
import ca.gc.aafc.seqdb.entities.PcrProfile;
import ca.gc.aafc.seqdb.entities.Region;
import ca.gc.aafc.seqdb.factories.PcrPrimerFactory;
import ca.gc.aafc.seqdb.factories.PcrProfileFactory;
import ca.gc.aafc.seqdb.factories.RegionFactory;

public class MapStructTest {
  private final String thermoDto = ThermocyclerProfileDto.class.getSimpleName();
  private final String regionDto = RegionDto.class.getSimpleName();
  private final String pcrPrimerDto = PcrPrimerDto.class.getSimpleName();
  
  private Object getMapped(Class<?> dtoClassName, Object objectToMap) throws NoSuchMethodException {
    String className = dtoClassName.getSimpleName();
    
    
    if(className.equals(thermoDto)) {
      return ThermocyclerProfileMapper.INSTANCE.entityToDto((PcrProfile) objectToMap);
    }
    else if(className.equals(regionDto)) {
      return RegionMapper.INSTANCE.entityToDto((Region) objectToMap);
    }
    else if(className.equals(pcrPrimerDto)) {
      return PcrPrimerMapper.INSTANCE.entityToDto((PcrPrimer) objectToMap);
    }
    else {
      throw new NoSuchMethodException("No mapper found that matches "+ className);
    }
    
  }
  
  private Map<Integer, String> createExpectedMap(){
    Map<Integer, String> expectedMap = new HashMap<Integer, String>();
    expectedMap.put(1,"Losing" );
    expectedMap.put(2, "one glove");
    expectedMap.put(3, "is certainly" );
    expectedMap.put(4, "painful");
    expectedMap.put(5,"but nothing");
    expectedMap.put(6, "compared to");
    expectedMap.put(7, "the pain,");
    expectedMap.put(8, "of losing");
    expectedMap.put(9, "one");
    expectedMap.put(10, "throwing");
    expectedMap.put(11, "away");
    expectedMap.put(12,"the other" );
    expectedMap.put(13, "and finding");
    expectedMap.put(14, "the first");
    expectedMap.put(15, "one again.");
    
    return expectedMap;
  }
  
  /**
   * Uses reflection to compare equivalent fields using getter methods.
   * The method with less methods should be the base argument as it will improve efficiency. 
   * @param base
   * @param comparison
   * @return A String HastSet containing the methods asserted(matched) and the ones missed.
   * @throws IllegalAccessException
   * @throws IllegalArgumentException
   * @throws InvocationTargetException
   */

  
  public static HashSet<String> verifyObjectsAreEqual(Object base, Object comparison)
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
    HashSet<String> methodInformation = new HashSet<String>();

    Method comparisonMethod;
    String baseMethodName;

    for (Method getterMethod : base.getClass().getMethods()) {

      baseMethodName = getterMethod.getName();


      if (baseMethodName.contains("get")) {
        try {
          if (comparison.getClass().getMethod(baseMethodName) != null) {

            comparisonMethod = comparison.getClass().getMethod(baseMethodName);
            if (comparisonMethod.getName() != "getClass") {
              methodInformation.add("\n Asserted Method : " + comparisonMethod.getName());
              assertEquals(getterMethod.invoke(base), comparisonMethod.invoke(comparison));
            }
          }
        } catch (NoSuchMethodException e) {
          methodInformation.add("\n Missed Method : " + baseMethodName);
        }

      }
    }
    return methodInformation;
  }
  
  /**
   * Compares the given PcrProfile with it's expected values.
   * @param profileFromDto
   */
  private void validateCreatedPcrProfileSteps(PcrProfile profileFromDto) {
    assertEquals(profileFromDto.getStep1(), "Losing");

    assertEquals(profileFromDto.getStep2(), "one glove");

    assertEquals(profileFromDto.getStep3(), "is certainly");

    assertEquals(profileFromDto.getStep4(), "painful");

    assertEquals(profileFromDto.getStep5(), "but nothing");

    assertEquals(profileFromDto.getStep6(), "compared to");

    assertEquals(profileFromDto.getStep7(), "the pain,");

    assertEquals(profileFromDto.getStep8(), "of losing");

    assertEquals(profileFromDto.getStep9(), "one");

    assertEquals(profileFromDto.getStep10(), "throwing");

    assertEquals(profileFromDto.getStep11(), "away");

    assertEquals(profileFromDto.getStep12(), "the other");

    assertEquals(profileFromDto.getStep13(), "and finding");

    assertEquals(profileFromDto.getStep14(), "the first");

    assertEquals(profileFromDto.getStep15(), "one again.");
  }


  @Test
  public void mapstructMapRegionToDto_AutogeneratedMapping_MatchingObjects() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Region region = RegionFactory.newRegion().description("About").build();
    

    RegionDto regionDto = RegionMapper.INSTANCE.entityToDto(region);
    System.out.println("MADE A MAPPER");
    
    assertEquals(regionDto.getDescription(), region.getDescription());
    assertEquals(regionDto.getSymbol(), region.getSymbol());
    assertEquals(regionDto.getName(), region.getName());
    assertEquals(regionDto.getTagId(), region.getTagId());
    
    System.out.println(verifyObjectsAreEqual(region,regionDto));

    

  }
  
  @Test
  public void ThermocyclerProfileMapper_pcrProfileToThermocyclerProfileDto() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    //set up base entity
    PcrProfile basePcr = PcrProfileFactory.newPcrProfile()
        .step1("Losing")
        .step2("one glove")
        .step3("is certainly")
        .step4("painful")
        .step5("but nothing")
        .step6("compared to")
        .step7("the pain,")
        .step8("of losing")
        .step9("one")
        .step10("throwing")
        .step11("away")
        .step12("the other")
        .step13("and finding")
        .step14("the first")
        .step15("one again.").build();
    
    
    //create DTO based off mapping implementation
    ThermocyclerProfileDto thermoDto = ThermocyclerProfileMapper.INSTANCE.entityToDto(basePcr);
    
    //verify results
   verifyObjectsAreEqual(thermoDto, basePcr);
    assertEquals(thermoDto.getSteps(), createExpectedMap());
    
  }
  
  @Test
  public void  ThermocyclerProfileMapper_ThermocyclerProfileDtoToPcrProfile_MatchingObjects() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    //set up base Dto
    ThermocyclerProfileDto baseDto = new ThermocyclerProfileDto();
    
    Map<Integer,String> expectedMap = createExpectedMap();
    
    baseDto.setSteps(expectedMap);
    
    //create Entity based off mapping implementation
    PcrProfile pcrFromMapper = ThermocyclerProfileMapper.INSTANCE.dtoToEntity(baseDto);
    
    //verify the results
    verifyObjectsAreEqual(baseDto, pcrFromMapper);
    
    validateCreatedPcrProfileSteps(pcrFromMapper);
    
  }
  
  @Test
  public void TestMapperFinder() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    PcrProfile basePcr = PcrProfileFactory.newPcrProfile()
        .step1("Losing")
        .step2("one glove")
        .step3("is certainly")
        .step4("painful")
        .step5("but nothing")
        .step6("compared to")
        .step7("the pain,")
        .step8("of losing")
        .step9("one")
        .step10("throwing")
        .step11("away")
        .step12("the other")
        .step13("and finding")
        .step14("the first")
        .step15("one again.").build();
    
    ThermocyclerProfileDto thermoDto = (ThermocyclerProfileDto) getMapped(ThermocyclerProfileDto.class, basePcr);
    
    
    Region baseRegion = RegionFactory.newRegion().description("About").build();
    
    RegionDto regionDto = (RegionDto) getMapped(RegionDto.class, baseRegion);
    
    PcrPrimer basePrimer = PcrPrimerFactory.newPcrPrimer().build();
    
    PcrPrimerDto primerDto = (PcrPrimerDto) getMapped(PcrPrimerDto.class, basePrimer);
    
    verifyObjectsAreEqual(primerDto, basePrimer);
    verifyObjectsAreEqual(regionDto, baseRegion);
    verifyObjectsAreEqual(thermoDto, basePcr);

  }
  
}
