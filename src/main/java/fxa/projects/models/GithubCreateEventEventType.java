package fxa.projects.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GithubCreateEventEventType extends GithubBaseEventEventType {
    private String ref;

    @JsonProperty("ref_type")
    private String refType;

    @JsonProperty("full_ref")
    private String fullRef;

    @JsonProperty("master_branch")
    private String masterBranch;

    private String description;

    @JsonProperty("pusher_type")
    private String pusherType;
}
