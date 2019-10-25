# Design by Contract

* Swagger/OpenAPi V2 for API definition
* [Pact](https://docs.pact.io/) to verify API 
* Imposter for generating mock
* [swagger-request-validator](https://bitbucket.org/atlassian/swagger-request-validator) or [swagger-mock-validator](https://bitbucket.org/atlassian/swagger-mock-validator)
* Cucumber of alternative with DSL for verifying scenarios
* MarkDown for documentation

https://github.com/davidkpiano/openapi-test

https://github.com/intuit/karate

1. Design the API as a Swagger specification –This is a simple format that has an important benefit over using something like a Confluence page: it is a usable artifact. You can generate user documentation directly from it, use it in contract testing, and even use it to generate your implementation if desired.
1. Get review feedback on the API design as pull requests on the Swagger spec –This has the nice property that reviewers have the entire API context at hand, and (anecdotally) I have found leads to higher-value review feedback because it is about the API design and consistency, not the implementation details.
1. Encode example interactions as [Pact](https://docs.pact.io/) files – As a way of showing our customers what example interactions with the API would look like, we added example Pact files that show what such interactions would look like. The great thing about this is we can validate that the examples adhere to our spec using the swagger-mock-validator which ensures our examples are kept up to date as we evolve our API.
1. Use the spec to validate your implementation – [swagger-request-validator](https://bitbucket.org/atlassian/swagger-request-validator) or [swagger-mock-validator](https://bitbucket.org/atlassian/swagger-mock-validator) are great tools to validate that your implementation matches the spec.
