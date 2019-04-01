
package ca.gc.aafc.seqdb.api.dtoMappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ca.gc.aafc.seqdb.api.dto.ProductDto;
import ca.gc.aafc.seqdb.entities.Product;

@Mapper(componentModel="spring")
public interface ProductMapper {
  
  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
  
  ProductDto entityToDto(Product product);
  
  @InheritInverseConfiguration
  Product dtoToEntity(ProductDto productDto);

}
