package com.github.aistomin.mst.simple;

import com.github.aistomin.mst.Question;
import com.github.aistomin.mst.QuestionsProvider;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aistomin on 02.10.18.
 */
final class TestQuestionsProvider implements QuestionsProvider {

    /**
     * Test questions list.
     */
    private final List<Question> items = new ArrayList<>();

    /**
     * Ctor.
     */
    TestQuestionsProvider() {
        items.add(
            new SimpleQuestion(
                new SimpleText("1 + 1 = ?"), new SimpleAnswer("2")
            )
        );
        items.add(
            new SimpleQuestion(
                new SimpleText("3 + 6 = ?"), new SimpleAnswer("9")
            )
        );
        items.add(
            new SimpleQuestion(
                new SimpleText("6 - 2 = ?"), new SimpleAnswer("4")
            )
        );
        items.add(
            new SimpleQuestion(
                new SimpleText("2 * 2 = ?"), new SimpleAnswer("4")
            )
        );
        items.add(
            new SimpleQuestion(
                new SimpleText("6 / 2 = ?"), new SimpleAnswer("3")
            )
        );
    }

    @Override
    public List<Question> questions() {
        return items;
    }
}
