package com.naya.gameofthrones.signuterdecoderinformer.notifier;


import com.naya.gameofthrones.signuterdecoderinformer.model.Notification;

public interface Notifier {
    void sendNotification(Notification notification);
}
