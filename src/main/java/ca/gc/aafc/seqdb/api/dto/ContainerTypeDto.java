package ca.gc.aafc.seqdb.api.dto;

import java.sql.Timestamp;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;

@Data
@JsonApiResource(type = "containerType")
public class ContainerTypeDto {

  @JsonApiId
  private Integer containerTypeId;

  private String name;

  private Integer numberOfColumns;

  private Integer numberOfRows;

  private Timestamp lastModified;

  @JsonApiRelation
  private GroupDto group;

}
