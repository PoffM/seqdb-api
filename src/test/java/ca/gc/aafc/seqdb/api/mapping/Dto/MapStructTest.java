package ca.gc.aafc.seqdb.api.mapping.Dto;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;

import ca.gc.aafc.seqdb.api.dto.RegionDto;
import ca.gc.aafc.seqdb.api.dtoMappers.RegionMapper;
import ca.gc.aafc.seqdb.entities.Region;
import ca.gc.aafc.seqdb.factories.RegionFactory;

public class MapStructTest {
  
  
  @Test
  public void mapstructMapRegionToDto() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Method meth;
    Region region = RegionFactory.newRegion().description("About").build();
    
    RegionDto regionDto = RegionMapper.INSTANCE.regionToRegionDto(region);
    
    for(Method getter: RegionDto.class.getMethods()) {
      System.out.println("DTO METHODS IS " + getter.getName());
      if(getter.getName().contains("get"))
      {
        meth = region.getClass().getMethod(getter.getName());
        System.out.println("ENTITY METHOD IS " + meth.getName());
        assertEquals(getter.invoke(regionDto), meth.invoke(region));
      }
      
    }
    
  }
}
