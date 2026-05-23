package fxa.projects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fxa.projects.models.GithubUserEvent;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.print("Enter a GitHub username: ");

        String username = sc.nextLine();

        String githubUserEventAPIBaseURL = "https://api.github.com/users/" + username + "/events";

        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder(URI.create(githubUserEventAPIBaseURL))
                    .header("Accept", "application/json")
                    .build();

            try {
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                ObjectMapper mapper = new ObjectMapper();
                List<GithubUserEvent> events = mapper.readValue(response.body(), new TypeReference<>() {});

                for (GithubUserEvent event : events) {
                    IO.println(event);
                }
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
