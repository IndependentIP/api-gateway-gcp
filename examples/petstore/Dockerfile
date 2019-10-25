FROM stoplight/prism:3

COPY petstore.yaml api.yaml
COPY config.json config.json

EXPOSE 8080

ENTRYPOINT [ "node", "dist/index.js", "mock", "-p", "8080", "-h", "0.0.0.0", "api.yaml" ]

