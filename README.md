# github-user-activity-cli

Simple CLI based github user activity fetcher app

## How to use

1. Clone the repo to your local machine
2. Run using an IDE (e.g. IntelliJ IDEA), or build into an executable .jar using tools such as Maven -
   `mvn clean install`
3. List of commands:
    1. `<github username>` - GitHub username whose event(s) to be fetched
4. For now, the supported GitHub event type is:
    1. `CreateEvent`
    2. `PushEvent`
5. Public API used are inspired from
   GitHub's [event api](https://docs.github.com/en/rest/activity/events?apiVersion=2022-11-28#list-public-events)

## Tech Stacks

- Standard Java Library (JDK 25)

## Project Idea

Ideas taken from roadmap.sh [github-user-activity-cli](https://roadmap.sh/projects/github-user-activity) project