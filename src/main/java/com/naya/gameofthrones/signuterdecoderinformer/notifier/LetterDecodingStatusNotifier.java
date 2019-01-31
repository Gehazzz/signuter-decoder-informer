package com.naya.gameofthrones.signuterdecoderinformer.notifier;

import com.naya.gameofthrones.signuterdecoderinformer.model.Notification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service("Status")
@AllArgsConstructor
public class LetterDecodingStatusNotifier implements Notifier {

    RestTemplate restTemplate;

    @Override
    public void sendNotification(Notification notification) {
        try {
            restTemplate.postForObject("http://localhost:8080/letter-status", notification, Notification.class);
            log.info("Letter status notification sent");
        }catch (Exception e) {
            log.error("no sender url found");
        }
    }
}
