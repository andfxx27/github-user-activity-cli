package fxa.projects.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GithubUserEvent {
    private String id;
    private GithubEventType type;
    private GithubEventActor actor;
    private GithubEventRepo repo;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
    @JsonSubTypes({
        @JsonSubTypes.Type(value = GithubCreateEventEventType.class, name = "CreateEvent"),
        @JsonSubTypes.Type(value = GithubPushEventEventType.class, name = "PushEvent")
    })
    private GithubBaseEventEventType payload;

    @JsonProperty("public")
    private boolean isPublic;

    @JsonProperty("created_at")
    private String createdAt;
}
