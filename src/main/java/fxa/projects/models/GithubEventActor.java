package fxa.projects.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GithubEventActor {
    private long id;
    private String login;

    @JsonProperty("display_login")
    private String displayLogin;

    @JsonProperty("gravatar_id")
    private String gravatarId;

    private String url;

    @JsonProperty("avatar_url")
    private String avatarUrl;
}
