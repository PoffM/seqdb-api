package ca.gc.aafc.seqdb.api.dto;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;

@Data
@JsonApiResource(type = "thermocyclerprofile")
public class ThermocyclerProfileDto {
  
  @JsonApiId
  private Integer pcrProfileId;
  
  private String name;

  private String cycles;
  
  private Map<Integer, String> steps = new HashMap<Integer, String>();
  
  private Timestamp lastModified;

  @JsonApiRelation
  private RegionDto region;

  @JsonApiRelation
  private GroupDto group;
  
}
