#!/bin/bash

set -euo pipefail

source util.sh

main() {
  # Get our working project, or exit if it's not set.
  local project_id="$(get_project_id)"
  if [[ -z "$project_id" ]]; then
    exit 1
  fi
  # Try to create an App Engine project in our selected region.
  # If it already exists, return a success ("|| true").
  echo "gcloud app create --region=$REGION"
  gcloud app create --region="$REGION" || true
  # Prepare the necessary variables for substitution in our app configuration
  # template, and create a temporary file to hold the templatized version.
  local service_name="${project_id}.appspot.com"
  export TEMP_FILE="../examples/petstore/app.yaml"
  < "$APP" \
    sed -E "s/SERVICE_NAME/${service_name}/g" \
    > "$TEMP_FILE"
  echo "Deploying ${APP}..."
  echo "gcloud -q app deploy $TEMP_FILE"
  gcloud -q app deploy "$TEMP_FILE"
}

cleanup() {
  rm "$TEMP_FILE"
}

# Defaults.
APP="../examples/petstore/app_template.yaml"
REGION="us-central"

if [[ "$#" == 0 ]]; then
  : # Use defaults.
elif [[ "$#" == 1 ]]; then
  APP="$1"
elif [[ "$#" == 2 ]]; then
  APP="$1"
  REGION="$2"
else
  echo "Wrong number of arguments specified."
  echo "Usage: deploy_app.sh [app-template] [region]"
  exit 1
fi

# Cleanup our temporary files even if our deployment fails.
#trap cleanup EXIT

main "$@"
