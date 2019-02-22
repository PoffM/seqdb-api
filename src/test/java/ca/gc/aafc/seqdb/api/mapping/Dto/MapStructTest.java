package ca.gc.aafc.seqdb.api.mapping.Dto;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;

import ca.gc.aafc.seqdb.api.dto.RegionDto;
import ca.gc.aafc.seqdb.api.dtoMappers.RegionMapper;
import ca.gc.aafc.seqdb.entities.Region;
import ca.gc.aafc.seqdb.factories.RegionFactory;

public class MapStructTest {
  
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
              methodInformation.add("Asserted Method : " + comparisonMethod.getName());
              assertEquals(getterMethod.invoke(base), comparisonMethod.invoke(comparison));
            }
          }
        } catch (NoSuchMethodException e) {
          methodInformation.add("Missed Method : " + baseMethodName);
        }

      }
    }
    return methodInformation;
  }

  public static void verifyMatchingMethod(Method baseMethod, Object base, Object comparison)
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
      NoSuchMethodException, SecurityException {
    Method comparisonMethod;

    if (comparison.getClass().getMethod(baseMethod.getName()) != null) {

      comparisonMethod = comparison.getClass().getMethod(baseMethod.getName());
      System.out.println("Found Matching Method : " + comparisonMethod.getName());
      if (comparisonMethod.getName() != "getClass") {

        assertEquals(baseMethod.invoke(base), comparisonMethod.invoke(comparison));
      }
    } else {
      throw new IllegalArgumentException("no matching method found");
    }

  }

  @Test
  public void mapstructMapRegionToDto() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Region region = RegionFactory.newRegion().description("About").build();

    RegionDto regionDto = RegionMapper.INSTANCE.regionToRegionDto(region);
    System.out.println("MADE A MAPPER");
    
    assertEquals(regionDto.getDescription(), region.getDescription());
    assertEquals(regionDto.getSymbol(), region.getSymbol());
    assertEquals(regionDto.getName(), region.getName());
    assertEquals(regionDto.getTagId(), region.getTagId());
    
    verifyMatchingMethod(RegionDto.class.getMethod("getSymbol"), regionDto, region);
    System.out.println(verifyObjectsAreEqual(region,regionDto));

    

  }
}
