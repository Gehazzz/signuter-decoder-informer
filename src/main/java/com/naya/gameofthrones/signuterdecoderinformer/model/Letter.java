package com.naya.gameofthrones.signuterdecoderinformer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Letter {
    private String id;
    private String content;
    private String signature;
    private String location;

    public String getSignature() {
        return getEncrypted();
    }

    private String getEncrypted() {
        return Integer.toBinaryString(signature.hashCode());
    }
}
