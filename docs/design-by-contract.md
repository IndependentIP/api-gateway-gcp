# Design by Contract

* [Spectral](https://stoplight.io/open-source/spectral/) to lint swagger spec.

1. Design the API as a Swagger specification – This is a simple format that has an important benefit over using something like a Confluence page: it is a usable artifact. You can generate user documentation directly from it, use it in contract testing, and even use it to generate your implementation if desired.
1. Get review feedback on the API design as pull requests on the Swagger spec –This has the nice property that reviewers have the entire API context at hand, which leads to higher-value review feedback because it is about the API design and consistency, not the implementation details.
1. Encode examples within the Swagger file. With the help of [prism](https://github.com/stoplightio/prism) we can mock the API. The great thing about this is we can validate that the examples adhere to our spec using the [karate](https://github.com/intuit/karate) features which ensures our examples are kept up to date as we evolve our API.
1. Use the karate scenarios to validate your implementation.
