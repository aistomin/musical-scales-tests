package com.github.aistomin.mst;

import com.github.aistomin.mst.domain.MajorScale;
import com.github.aistomin.mst.domain.Note;
import com.github.aistomin.mst.simple.SimpleAnswer;
import com.github.aistomin.mst.simple.SimpleQuestion;
import com.github.aistomin.mst.simple.SimpleTest;
import com.github.aistomin.mst.simple.SimpleTestConsole;
import com.github.aistomin.mst.simple.SimpleText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by aistomin on 2019-06-04.
 * <p>
 * Main class of the application.
 */
public final class Main {

    /**
     * Main method of the application.
     *
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        final Test test = new SimpleTest(() -> {
            final List<String> degrees = Arrays.asList(
                "Tonic",
                "Supertonic",
                "Mediant",
                "Subdominant",
                "Dominant",
                "Submediant",
                "Leading Tone"
            );
            final ArrayList<Question> questions = new ArrayList<>();
            final List<Note> notes = Note.simpleNotes();
            final Random random = new Random();
            for (int i = 0; i < 10; i++) {
                final MajorScale scale = new MajorScale(
                    notes.get(random.nextInt(notes.size()))
                );
                final String degree = degrees.get(
                    random.nextInt(degrees.size())
                );
                final String question = String.format("%s of the %s", degree, scale.name());
                final String answer;
                switch (degree) {
                    case "Tonic":
                        answer = scale.tonic().helmholtzName();
                        break;
                    case "Supertonic":
                        answer = scale.supertonic().helmholtzName();
                        break;
                    case "Mediant":
                        answer = scale.mediant().helmholtzName();
                        break;
                    case "Subdominant":
                        answer = scale.subdominant().helmholtzName();
                        break;
                    case "Dominant":
                        answer = scale.dominant().helmholtzName();
                        break;
                    case "Submediant":
                        answer = scale.submediant().helmholtzName();
                        break;
                    case "Leading Tone":
                        answer = scale.leadingTone().helmholtzName();
                        break;
                    default:
                        throw new IllegalStateException(
                            String.format(
                                "Unknown major scale degree: %s", degree
                            )
                        );
                }
                questions.add(
                    new SimpleQuestion(
                        new SimpleText(question), new SimpleAnswer(answer)
                    )
                );
            }
            return questions;
        });
        new SimpleTestConsole(test).runTest();
    }
}
