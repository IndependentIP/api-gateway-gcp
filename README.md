## Cloud Endpoints Quickstart Scripts

These scripts help you get started with [Google Cloud Endpoints](https://cloud.google.com/endpoints/)
quickly and easily. They are designed for use with the
[Endpoints
Quickstart Guide](https://cloud.google.com/endpoints/docs/quickstart-endpoints).

The included API is a sample for a Pet Store.

*This is an example application, not an official FUGA product.*

## Before you begin

1. Create a new
[Cloud Platform project](https://console.cloud.google.com/projectcreate).

1. [Enable billing](https://support.google.com/cloud/answer/6293499#enable-billing)
   for your project.

1.  Download and install the [Google Cloud
    SDK](https://cloud.google.com/sdk/docs/), which includes the
    [gcloud](https://cloud.google.com/sdk/gcloud/) command-line tool.

1.  Initialize the Cloud SDK.

        gcloud init

1.  Set your default project (replace YOUR-PROJECT-ID with the name of your
    project).

        gcloud config set project YOUR-PROJECT-ID
        
1. configure Docker command-line tool to authenticate to Container Registry (you need to run this only once):
   
        gcloud auth configure-docker        

At a minimum, Endpoints and ESP require the following services:

| Name | Title |
|----|-----|
|servicemanagement.googleapis.com|Service Management API|
|servicecontrol.googleapis.com|Service Control API|
|endpoints.googleapis.com|Google Cloud Endpoints|

In most cases, the gcloud endpoints services deploy command enables these required services.

To confirm that the required services are enabled:

    gcloud services list

If you don't see the required services listed, enable them:

    gcloud services enable SERVICE_NAME

Replace `SERVICE_NAME` with the name of the service to enable. 

## Usage

Now we can push the mocked petstore to the google cloud environment by executing:    
    
    mvn -DGOOGLE_PROJECT_ID=<YOUR-PROJECT-ID> clean install

*Note: these scripts will create an App Engine project, deploy an app, and create endpoints!*

## Documenting your API

As a best practice, always include the description field in property definitions and in all other sections of your OpenAPI document. The description field can contain multiple lines and supports [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/). For example, the following creates a bulleted list on the API homepage in a portal:

    swagger: "2.0"
    info:
      description: "A simple API to help you learn about Cloud Endpoints.

      * item 1

      * item 2"
    title: "Endpoints Example"
      version: "1.0.0"
    host: "${ENDPOINTS_SERVICE_NAME}"
    
To display custom documentation in your portal, you must store the files in a Git repository and configure the URL to the Git repository on the Settings page in your portal.

Subfolders within your service folder let you group related pages under a section, and may contain further subfolders. The title of the folders and filenames are used in navigation. For example, a file named Getting Started.md appears in the left navigation bar as Getting Started. Within the folder named after your Endpoints service name, you must have a file called navigation.yaml. This file indicates how you want your content to appear in the left navigation bar in your portal.
    
## Resources

* [Custom configuration Prism](https://help.stoplight.io/prism/getting-started/custom-configuration)
* [Deploying to Google App Engine using Docker](https://graysonkoonce.com/deploying-to-google-app-engine-using-docker/)
* [Adding custom documentation Cloud Endpoints](https://cloud.google.com/endpoints/docs/openapi/dev-portal-add-custom-docs)