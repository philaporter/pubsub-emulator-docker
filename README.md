## Google Cloud Pub/Sub Emulator

A [Google Cloud Pub/Sub Emulator](https://cloud.google.com/pubsub/docs/emulator) container image. The image is meant to be used for creating an standalone emulator for testing.

### Environment

The following environment variables must be set:

- `PUBSUB_LISTEN_ADDRESS`: The address should refer to a listen address, meaning that `0.0.0.0` can be used. The address must use the syntax `HOST:PORT`, for example `0.0.0.0:8432`. The container must expose the port used by the Pub/Sub emulator.
- `PUBSUB_PROJECT_ID`: The ID of the Google Cloud project for the emulator.

### Connect application with the emulator

The following environment variables need to be set so your application connects to the emulator instead of the production Cloud Pub/Sub environment:

- `PUBSUB_EMULATOR_HOST`: The listen address used by the emulator.
- `PUBSUB_PROJECT_ID`: The ID of the Google Cloud project used by the emulator.
- `GOOGLE_APPLICATION_CREDENTIALS`: Points to the credentials keyfile (I use a fake one for the python and Java apps)

### Build For Apple Silicon

```
docker build --platform linux/arm64 -t pubsub:latest ./
```

### Build For Intel
```
docker build -t pubsub:latest ./
```

### Starting an emulator
```
docker run -it -e PUBSUB_PROJECT_ID=local-pubsub -e PUBSUB_LISTEN_ADDRESS=0.0.0.0:8432 -p 8432:8432 pubsub:latest
```

### Creating a topic
Right now, the easiest way that I have to create topics for the emulator is to use the sample Google python code in its
`publisher.py`. Instructions for that process are in the README within that subproject.

### Sending in messages
The Java app exposes a POST route at `localhost:8080/publish`. The message request body is written to the topic. 
Instructions for that process can be found within its subproject.

### Persistence
The image has a volume mounted at `/opt/data`. To maintain states between restarts, mount a volume at this location.
