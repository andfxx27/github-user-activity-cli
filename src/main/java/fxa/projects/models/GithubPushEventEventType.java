package fxa.projects.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GithubPushEventEventType extends GithubBaseEventEventType {
    @JsonProperty("repository_id")
    private long repositoryId;

    @JsonProperty("push_id")
    private long pushId;

    private String ref;
    private String head;
    private String before;
}
