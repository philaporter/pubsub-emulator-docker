package com.philaporter.controller;

import com.philaporter.config.PubSubConfig.PubsubOutboundGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

  private PubsubOutboundGateway messagingGateway;

  public MessageController(PubsubOutboundGateway messagingGateway) {
    this.messagingGateway = messagingGateway;
  }

  @PostMapping("/publish")
  public ResponseEntity publishMessage(@RequestBody String message) {
    messagingGateway.sendToPubsub(message);
    return ResponseEntity.ok(message);
  }
}
