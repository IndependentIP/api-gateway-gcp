FROM stoplight/prism:3

COPY petstore.yaml api.yaml

EXPOSE 8080

# The App Engine front end will route incoming requests to the appropriate module on port 8080.
# You must be sure that your application code is listening on 8080.
ENTRYPOINT [ "node", "dist/index.js", "mock", "-p", "8080", "-h", "0.0.0.0", "api.yaml" ]

