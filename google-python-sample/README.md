## Sampled Code with slight revisions / explanations
See this for emulator details: https://cloud.google.com/pubsub/docs/emulator

Sample code source repo: https://github.com/googleapis/python-pubsub/tree/main/samples/snippets

### Requirements
```
python 3 
pip 3

# (I had issues with 3.10.14 with my m1 laptop, I also had to do this:
#  pip install --no-binary :all: grpcio --ignore-installed
```

### Getting started
```
pip install -r requirements.txt
export PUBSUB_EMULATOR_HOST=localhost:8432
export GOOGLE_APPLICATION_CREDENTIALS=fake-keyfile.json
```

### Using the Google sample to interact with the emulator
```
# create the topic "test-topic" under the project "local-pubsub"
python publisher.py local-pubsub create test-topic

# list the topics under the project "local-pubsub"
python publisher.py local-pubsub list

# create a pull subscriber "test-topic-sub"
python subscriber.py local-pubsub create test-topic test-topic-sub
```