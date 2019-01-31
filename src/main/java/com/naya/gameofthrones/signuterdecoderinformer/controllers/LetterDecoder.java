package com.naya.gameofthrones.signuterdecoderinformer.controllers;

import com.naya.gameofthrones.signuterdecoderinformer.model.DecodedLetter;
import com.naya.gameofthrones.signuterdecoderinformer.model.Letter;

/**
 * @author Evgeny Borisov
 */
public interface LetterDecoder {
    DecodedLetter decode(Letter letter);
}
