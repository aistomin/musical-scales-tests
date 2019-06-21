package com.github.aistomin.mst.tests;

import com.github.aistomin.mst.Question;
import com.github.aistomin.mst.Result;
import com.github.aistomin.mst.Test;
import com.github.aistomin.mst.domain.MajorScale;
import com.github.aistomin.mst.domain.Note;
import com.github.aistomin.mst.simple.SimpleAnswer;
import com.github.aistomin.mst.simple.SimpleQuestion;
import com.github.aistomin.mst.simple.SimpleTest;
import com.github.aistomin.mst.simple.SimpleText;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by aistomin on 2019-06-13.
 * <p>
 * Test that checks pupil's knowledge of the notes which are the part of the certain
 * major scale.
 */
public final class SimpleMajorScaleTest implements Test {

    /**
     * Test instance.
     */
    private final Test test;

    /**
     * Ctor.
     *
     * @param scale The major scale which we want to test.
     */
    public SimpleMajorScaleTest(final MajorScale scale) {
        this.test = new SimpleTest("Simple Major Scale Test", () -> {
            final ArrayList<Question> questions = new ArrayList<>();
            final List<Note> notes = Note.simpleNotes();
            final Random random = new Random();
            for (int i = 0; i < 10; i++) {
                final Note note = notes.get(random.nextInt(notes.size()));
                final String question = String.format(
                    "Is %s the part of %s? Y/N",
                    note.helmholtzName(), scale.name()
                );
                questions.add(
                    new SimpleQuestion(
                        new SimpleText(question),
                        new SimpleAnswer(
                            scale.notes().contains(note) ? "Y" : "N"
                        )
                    )
                );
            }
            return questions;
        });
    }

    @Override
    public String name() {
        return this.test.name();
    }

    @Override
    public Boolean hasMoreQuestions() {
        return this.test.hasMoreQuestions();
    }

    @Override
    public Question nextQuestion() {
        return this.test.nextQuestion();
    }

    @Override
    public Result currentTestResult() {
        return this.test.currentTestResult();
    }
}
