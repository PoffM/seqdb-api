package ca.gc.aafc.seqdb.api.dto;

import java.util.HashMap;
import java.util.Map;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;

@Data
@JsonApiResource(type = "thermocyclerprofile")
public class ThermocyclerProfileDto {
  
  @JsonApiId
  private Integer pcrProfileId;
  
  
  private Map<Integer, String> steps = new HashMap<Integer, String>();
  

  
}
