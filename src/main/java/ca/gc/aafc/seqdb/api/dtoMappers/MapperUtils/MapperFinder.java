package ca.gc.aafc.seqdb.api.dtoMappers.MapperUtils;

import ca.gc.aafc.seqdb.api.dto.GroupDto;
import ca.gc.aafc.seqdb.api.dto.PcrBatchDto;
import ca.gc.aafc.seqdb.api.dto.PcrPrimerDto;
import ca.gc.aafc.seqdb.api.dto.PcrReactionDto;
import ca.gc.aafc.seqdb.api.dto.ProductDto;
import ca.gc.aafc.seqdb.api.dto.RegionDto;
import ca.gc.aafc.seqdb.api.dto.ThermocyclerProfileDto;
import ca.gc.aafc.seqdb.api.dtoMappers.GroupMapper;
import ca.gc.aafc.seqdb.api.dtoMappers.PcrBatchMapper;
import ca.gc.aafc.seqdb.api.dtoMappers.PcrPrimerMapper;
import ca.gc.aafc.seqdb.api.dtoMappers.PcrProfileMapper;
import ca.gc.aafc.seqdb.api.dtoMappers.PcrReactionMapper;
import ca.gc.aafc.seqdb.api.dtoMappers.ProductMapper;
import ca.gc.aafc.seqdb.api.dtoMappers.RegionMapper;
import ca.gc.aafc.seqdb.api.dtoMappers.ThermocyclerProfileMapper;
import ca.gc.aafc.seqdb.entities.Group;
import ca.gc.aafc.seqdb.entities.PcrBatch;
import ca.gc.aafc.seqdb.entities.PcrPrimer;
import ca.gc.aafc.seqdb.entities.PcrProfile;
import ca.gc.aafc.seqdb.entities.PcrReaction;
import ca.gc.aafc.seqdb.entities.Product;
import ca.gc.aafc.seqdb.entities.Region;

public class MapperFinder {
  private final static String groupDtoName = GroupDto.class.getSimpleName();
  private final static String pcrBatchDtoName = PcrBatchDto.class.getSimpleName();
  private final static String pcrPrimerDtoName = PcrPrimerDto.class.getSimpleName();
  private final static String thermoDtoName = ThermocyclerProfileDto.class.getSimpleName();
  private final static String pcrReactionDtoName = PcrReactionDto.class.getSimpleName();
  private final static String productDtoName = ProductDto.class.getSimpleName();
  private final static String regionDtoName = RegionDto.class.getSimpleName();
    
  
  
  
  private final static String groupName = Group.class.getSimpleName();
  private final static String pcrBatchName = PcrBatch.class.getSimpleName();
  private final static String pcrPrimerName = PcrPrimer.class.getSimpleName();
  private final static String pcrProfileName = PcrProfile.class.getSimpleName();
  private final static String pcrReactionName = PcrReaction.class.getSimpleName();
  private final static String productName = Product.class.getSimpleName();
  private final static String regionName = Region.class.getSimpleName();
  
  
  
  
  
  
  public static Object mapJpaToDto(Object jpaToMap) {
    String className = jpaToMap.getClass().getSimpleName();
    
    if( className.equals(groupName)) {
      return GroupMapper.INSTACE.entityToDto((Group) jpaToMap);
    }
    else if( className.equals(pcrBatchName)) {
      return PcrBatchMapper.INSTANCE.entityToDto((PcrBatch) jpaToMap);
    }
    else if( className.equals(pcrPrimerName)) {
      return PcrPrimerMapper.INSTANCE.entityToDto((PcrPrimer) jpaToMap);
    }
    else if(className.equals(pcrProfileName)) {
      return ThermocyclerProfileMapper.INSTANCE.entityToDto((PcrProfile) jpaToMap);
    }
    else if( className.equals(pcrReactionName)) {
      return PcrReactionMapper.INSTANCE.entityToDto((PcrReaction) jpaToMap);
    }
    else if( className.equals(productName)) {
      return ProductMapper.INSTANCE.entityToDto((Product) jpaToMap);
    }
    else if(className.equals(regionName)) {
      return RegionMapper.INSTANCE.entityToDto((Region) jpaToMap);
    }
    else {
      return jpaToMap;
    }
    
  }
  
  public static Object mapDtoToJpa(Object dtoToMap) {
    String className = dtoToMap.getClass().getSimpleName();
    
    if(className.equals(groupDtoName)) {
      return GroupMapper.INSTACE.dtoToEntity((GroupDto) dtoToMap);
    }
    else if(className.equals(pcrBatchDtoName)) {
      return PcrBatchMapper.INSTANCE.dtoToEntity((PcrBatchDto) dtoToMap);
    }
    else if(className.equals(pcrPrimerDtoName)) {
      return PcrPrimerMapper.INSTANCE.dtoToEntity((PcrPrimerDto) dtoToMap);
    }
    else if( className.equals(pcrReactionDtoName)) {
      return PcrReactionMapper.INSTANCE.dtoToEntity((PcrReactionDto) dtoToMap);
    }
    else if( className.equals(productDtoName)) {
      return ProductMapper.INSTANCE.dtoToEntity((ProductDto) dtoToMap);
    }
    else if(className.equals(regionDtoName)) {
      return RegionMapper.INSTANCE.dtoToEntity((RegionDto) dtoToMap);
    }
    else if(className.equals(thermoDtoName)) {
      return PcrProfileMapper.INSTANCE.dtoToEntity((ThermocyclerProfileDto) dtoToMap);
    }
    
    else {
       return dtoToMap;
    }
    
  }

}
