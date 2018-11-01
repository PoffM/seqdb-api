package ca.gc.aafc.seqdb.api.hibernate;

import java.io.Serializable;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;

import ca.gc.aafc.seqdb.api.dto.RegionDto;
import ca.gc.aafc.seqdb.api.repository.BaseRepositoryTest;
import io.crnk.core.repository.ResourceRepositoryV2;

@RunWith(Enclosed.class)
public class TrimResourceStringPropertiesAspectIT {

  @TestPropertySource(properties="seqdb.trim-resource-string-properties=true")
  public static class TrimResourceStringPropertiesEnabledIT extends BaseRepositoryTest {
    
    @Inject
    private ResourceRepositoryV2<RegionDto, Serializable> regionRepository;
    
    @Test
    public void createRegion_whenFieldsHaveExtraSpaces_persistedFieldsAreTrimmed() {
      RegionDto newRegion = new RegionDto();
      newRegion.setName(" name ");
      newRegion.setSymbol(" symbol");
      newRegion.setDescription("description ");
      
      RegionDto persistedRegion = regionRepository.create(newRegion);
      assertEquals("name", persistedRegion.getName());
      assertEquals("symbol", persistedRegion.getSymbol());
      assertEquals("description", persistedRegion.getDescription());
    }
    
    @Test
    public void updateRegion_whenDescriptioneHasExtraSpaces_persistedNameIsTrimmed() {
      RegionDto newRegion = new RegionDto();
      newRegion.setName("name");
      newRegion.setSymbol("symbol");
      newRegion.setDescription("description");
      
      RegionDto persistedRegion = regionRepository.create(newRegion);
      
      persistedRegion.setDescription(" updated description ");
      RegionDto updatedRegion = regionRepository.save(persistedRegion);
      
      assertEquals("updated description", updatedRegion.getDescription());
    }
    
  }
  
  public static class TrimResourceStringPropertiesDisabledIT extends BaseRepositoryTest {
    
    @Inject
    private ResourceRepositoryV2<RegionDto, Serializable> regionRepository;
    
    @Test
    public void createRegion_whenFieldsHaveExtraSpaces_persistedFieldsAreNotTrimmed() {
      RegionDto newRegion = new RegionDto();
      newRegion.setName(" name ");
      newRegion.setSymbol(" symbol");
      newRegion.setDescription("description ");
      
      RegionDto persistedRegion = regionRepository.create(newRegion);
      assertEquals(" name ", persistedRegion.getName());
      assertEquals(" symbol", persistedRegion.getSymbol());
      assertEquals("description ", persistedRegion.getDescription());
    }
    
  }
  
}
