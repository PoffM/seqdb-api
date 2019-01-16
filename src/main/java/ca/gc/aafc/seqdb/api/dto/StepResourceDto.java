package ca.gc.aafc.seqdb.api.dto;

import ca.gc.aafc.seqdb.entities.StepResource.StepResourceType;
import ca.gc.aafc.seqdb.entities.StepTemplate.StepResourceValue;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;

@Data
@JsonApiResource(type = "stepResource")
public class StepResourceDto {
  
  @JsonApiId
  private Integer stepResourceId;
  
  private StepResourceType type;
  
  private StepResourceValue value;
  
  /**
   * In the future, this should be set automatically from the chain.
   */
  private Integer chainTemplateId;
  
  /**
   * In the future, this should be replaced with a relation to ChainStepTemplateDto.
   */
  private Integer stepTemplateId;
  
  @JsonApiRelation
  private ChainDto chain;
  
//  @JsonApiRelation
//  private SpecimenDto specimen;
//  
//  @JsonApiRelation
//  private SpecimenReplicateDto specimenReplicate;
//  
//  @JsonApiRelation
//  private MixedSpecimenDto mixedSpecimen;
//  
//  @JsonApiRelation
//  private SampleDto sample;
  
//  @JsonApiRelation
//  private PcrBatchDto pcrBatch;
//  
//  @JsonApiRelation
//  private SeqBatchDto seqBatch;
//  
//  @JsonApiRelation
//  private SeqSubmissionDto seqSubmission;
//  
//  @JsonApiRelation
//  private ProductDto product;
  
  @JsonApiRelation
  private RegionDto region;
  
  @JsonApiRelation
  private PcrPrimerDto primer;
  
//  @JsonApiRelation
//  private PcrProfileDto pcrProfile;
//  
//  @JsonApiRelation
//  private ProtocolDto protocol;
  
}
