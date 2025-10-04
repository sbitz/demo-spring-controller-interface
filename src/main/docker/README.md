# WireMock Demo

Intended to be run in Docker, this project shows how to get a wiremock instance running so your app doesn't have to.

## Running Docker

```shell
docker run -it --rm \
  -p 8099:8080 \
  --name wiremock \
  -v "$(pwd)/wiremock:/home/wiremock" \
  -d wiremock/wiremock \
```

## Directory Structure

The outline of this project and what goes where...

### wiremock

Home of the openapi specification.

This downloads and formats the OpenAPI specification from the running server.

```shell
wget -O - localhost:8090/v3/api-docs | jq . > openapi.json
```

## Mappings

How to respond to the requests to your server.

## \_\_files

External files referenced in the mappings.

