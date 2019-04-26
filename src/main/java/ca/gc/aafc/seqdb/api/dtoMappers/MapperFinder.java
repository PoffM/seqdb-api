package ca.gc.aafc.seqdb.api.dtoMappers;

import ca.gc.aafc.seqdb.api.dto.GroupDto;
import ca.gc.aafc.seqdb.api.dto.PcrBatchDto;
import ca.gc.aafc.seqdb.api.dto.PcrPrimerDto;
import ca.gc.aafc.seqdb.api.dto.PcrReactionDto;
import ca.gc.aafc.seqdb.api.dto.ProductDto;
import ca.gc.aafc.seqdb.api.dto.RegionDto;
import ca.gc.aafc.seqdb.api.dto.ThermocyclerProfileDto;
import ca.gc.aafc.seqdb.entities.Group;
import ca.gc.aafc.seqdb.entities.PcrBatch;
import ca.gc.aafc.seqdb.entities.PcrPrimer;
import ca.gc.aafc.seqdb.entities.PcrProfile;
import ca.gc.aafc.seqdb.entities.PcrReaction;
import ca.gc.aafc.seqdb.entities.Product;
import ca.gc.aafc.seqdb.entities.Region;

public class MapperFinder {
  
  
  private final static String groupDto = GroupDto.class.getSimpleName();
  private final static String pcrBatchDto = PcrBatchDto.class.getSimpleName();
  private final static String pcrPrimerDto = PcrPrimerDto.class.getSimpleName();
  private final static String pcrReactionDto = PcrReactionDto.class.getSimpleName();
  private final static String productDto = ProductDto.class.getSimpleName();
  private final static String regionDto = RegionDto.class.getSimpleName();
  private final static String thermoDto = ThermocyclerProfileDto.class.getSimpleName();

  public static Object mapEntityToDto(String dtoClassName, Object entityObjectToMap) throws NoSuchMethodException {

    if(dtoClassName.equals(groupDto)) {
      return GroupMapper.INSTANCE.entityToDto((Group) entityObjectToMap);
    }
    else if(dtoClassName.equals(pcrBatchDto)) {
      return PcrBatchMapper.INSTANCE.entityToDto((PcrBatch) entityObjectToMap);
    }
    else if(dtoClassName.equals(pcrPrimerDto)) {
      return PcrPrimerMapper.INSTANCE.entityToDto((PcrPrimer) entityObjectToMap);
    }
    else if(dtoClassName.equals(pcrReactionDto)) {
      return PcrReactionMapper.INSTANCE.entityToDto((PcrReaction) entityObjectToMap);
    }
    else if(dtoClassName.equals(productDto)) {
      return ProductMapper.INSTANCE.entityToDto((Product) entityObjectToMap);
    }
    else if(dtoClassName.equals(regionDto)) {
      return RegionMapper.INSTANCE.entityToDto((Region) entityObjectToMap);
    }
    else if(dtoClassName.equals(thermoDto)) {
      return PcrProfileMapper.INSTANCE.entityToDto((PcrProfile) entityObjectToMap);
    }
    else {
      throw new NoSuchMethodException("No mapper found that matches "+ dtoClassName);
    }

  }
  
  public static Object mapDtoToEntity(String entityClassName, Object dtoObjectToMap) throws NoSuchMethodException {

    if(entityClassName.equals(Group.class.getSimpleName())) {
      return GroupMapper.INSTANCE.dtoToEntity((GroupDto) dtoObjectToMap);
    }
    else if(entityClassName.equals(PcrBatch.class.getSimpleName())) {
      return PcrBatchMapper.INSTANCE.dtoToEntity((PcrBatchDto) dtoObjectToMap);
    }
    else if(entityClassName.equals(PcrPrimer.class.getSimpleName())) {
      return PcrPrimerMapper.INSTANCE.dtoToEntity((PcrPrimerDto) dtoObjectToMap);
    }
    else if(entityClassName.equals(PcrReaction.class.getSimpleName())) {
      return PcrReactionMapper.INSTANCE.dtoToEntity((PcrReactionDto) dtoObjectToMap);
    }
    else if(entityClassName.equals(Product.class.getSimpleName())) {
      return ProductMapper.INSTANCE.dtoToEntity((ProductDto) dtoObjectToMap);
    }
    else if(entityClassName.equals(Region.class.getSimpleName())) {
      return RegionMapper.INSTANCE.dtoToEntity((RegionDto) dtoObjectToMap);
    }
    else if(entityClassName.equals(PcrProfile.class.getSimpleName())) {
      return PcrProfileMapper.INSTANCE.dtoToEntity((ThermocyclerProfileDto) dtoObjectToMap);
    }
    else {
        throw new NoSuchMethodException("No mapper found that matches "+ entityClassName);
    }

  }

}
