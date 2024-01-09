# Santex Test Api

The purpose of this api is expose the football team and league from https://football-data.org/ importing data and exposing through at own database

## Installation

Clone the project with git command

```bash
git clone https://github.com/lfernan/santex.git
```
## Running gradlew commands

```bash
# clean project
./gradlew clean

# build project
./gradlew build
```
## Importing the project with Intellij

Once that the project is imported run the gradle task clean and build

## Run Using Docker Compose

```bash
# go to the project root directory 'santex'
cd ./santex

# run the docker-compose command
docker-compose build santex_app

# then run. With this you will have the service running on port 8080
docker-compose up
```

## Test the API with Postman

Within the files project you going to found the postman collection for this api

Please import this collection in postman Santex-api.postman_collection.json

## Api endpoints
```bash
# Santex Import League -> This import all the data for given League Code
curl --location 'http://localhost:8080/santex/api/importLeague/PL'

# Santex Get Players -> This return a list of Player (or Coach) for given League Code and Team Name
curl --location 'http://localhost:8080/santex/api/league/PL/players?teamName=Everton%20FC'

# Santex Get Team -> This return a Team for given Team Name and has the option to include Players or Coach
curl --location 'http://localhost:8080/santex/api/team?includeMembers=true&teamName=Arsenal%20FC'
```
## Notes
The first intention it was to used GraphQl but I run out of the time box to deliver this test and since I do no have experience with that I will push that change in the future as part of my personal learning

You will see that it is a very basic project in libraries. I generally use SpringBoot with something else like loombok. Also for the search it was in my mind to use Predicates to filter the data, but I decided not to use them. The relationship between Team and Players, Coach has been made using the DiscriminatorColumn strategy. It could be two different tables, but I decided for this approach with just one table containing the all the people who belong to the team with the differentation of PLAYER and COACH roles.

For the testing I face the same problem of being out of the time to configure and push all the unit test at least

