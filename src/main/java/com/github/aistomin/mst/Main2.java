package com.github.aistomin.mst;

import com.github.aistomin.mst.domain.MajorScale;
import com.github.aistomin.mst.domain.Note;
import com.github.aistomin.mst.simple.SimpleAnswer;
import com.github.aistomin.mst.simple.SimpleQuestion;
import com.github.aistomin.mst.simple.SimpleTest;
import com.github.aistomin.mst.simple.SimpleTestConsole;
import com.github.aistomin.mst.simple.SimpleText;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by aistomin on 2019-06-04.
 * <p>
 * Main class of the application.
 */
public final class Main2 {

    /**
     * Main method of the application.
     *
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        final Test test = new SimpleTest(() -> {
            final ArrayList<Question> questions = new ArrayList<>();
            final List<Note> notes = Note.simpleNotes();
            final Random random = new Random();
            for (int i = 0; i < 10; i++) {
                final MajorScale scale = new MajorScale(Note.C);
                final Note note = notes.get(random.nextInt(notes.size()));
                final String question = String.format("Is %s the part of %s? Y/N", note.helmholtzName(), scale.name());
                questions.add(
                    new SimpleQuestion(
                        new SimpleText(question),
                        new SimpleAnswer(scale.notes().contains(note) ? "Y" : "N")
                    )
                );
            }
            return questions;
        });
        new SimpleTestConsole(test).runTest();
    }
}
