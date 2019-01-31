package com.naya.gameofthrones.signuterdecoderinformer.controllers;

import com.naya.gameofthrones.signuterdecoderinformer.model.DecodedLetter;
import com.naya.gameofthrones.signuterdecoderinformer.model.Letter;
import com.naya.gameofthrones.signuterdecoderinformer.model.Notification;
import com.naya.gameofthrones.signuterdecoderinformer.notifier.Notifier;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@Service
public class LetterDecoderImpl implements LetterDecoder {
    @Autowired
    private Map<String, Notifier> notifiers;
    @Setter
    private long delay=1;

    @Override
    @SneakyThrows
    public DecodedLetter decode(Letter letter) {
        notifyLetterWillBeDecoded(letter);
        Thread.sleep(delay);
        Field field = Letter.class.getDeclaredField("signature");
        field.setAccessible(true);
        String author = (String) field.get(letter);
        DecodedLetter decodedLetter = DecodedLetter.builder().id(letter.getId()).author(author).location(letter.getLocation()).content(letter.getContent()).build();
        notifyLetterDecoded(letter);
        notifyGuard(decodedLetter);
        return decodedLetter;
    }

    private void notifyLetterWillBeDecoded(Letter letter) {
        String message = "STARTED: We started letter - " + letter.getId() + "decoding at: " + LocalDateTime.now() + " it will take some time";
        notifiers.get("Status").sendNotification(Notification.builder().letterId(letter.getId()).message(message).build());
    }

    private void notifyLetterDecoded(Letter letter) {
        String message = ("FINISHED: Letter - " + letter.getId() + " decoded at "  + LocalDateTime.now() + "and sent to guard");
        notifiers.get("Status").sendNotification(Notification.builder().letterId(letter.getId()).message(message).build());
    }

    private void notifyGuard(DecodedLetter decodedLetter){
        String message = decodedLetter.getAuthor() + " does this sender pose a threat?";
        notifiers.get("Guard").sendNotification(Notification.builder().letterId(decodedLetter.getId()).message(message).build());
    }
}
