# Version. Can change in build progress
ARG GCLOUD_SDK_VERSION=alpine

# Use google cloud sdk
FROM google/cloud-sdk:$GCLOUD_SDK_VERSION

# Install Java 8 for Pub/Sub emulator
RUN apk --update add openjdk8-jre
RUN gcloud components install pubsub-emulator --quiet

# Volume to persist Pub/Sub data
VOLUME /opt/data

COPY start-pubsub .

EXPOSE 8432

ENTRYPOINT ["./start-pubsub"]