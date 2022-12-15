package com.ansen.myapplication.data;

import com.ansen.myapplication.R;
import com.ansen.myapplication.model.Affirmation;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Chris
 * @version 1.0
 * @since 2022-12-15
 */
public class Datasource {

    public List<Affirmation> loadAffirmations() {
        return Lists.newArrayList(
                new Affirmation(R.string.affirmation1),
                new Affirmation(R.string.affirmation2),
                new Affirmation(R.string.affirmation3),
                new Affirmation(R.string.affirmation4),
                new Affirmation(R.string.affirmation5),
                new Affirmation(R.string.affirmation6),
                new Affirmation(R.string.affirmation7),
                new Affirmation(R.string.affirmation8),
                new Affirmation(R.string.affirmation9),
                new Affirmation(R.string.affirmation10)
        );
    }
}
