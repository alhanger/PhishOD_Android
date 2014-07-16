package com.phishod.android.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.phishod.android.R;

/**
 * Created by benjamin on 7/15/14.
 */
public class YearRowView extends FrameLayout {

    private TextView mYear;

    public YearRowView(Context context) {
        super(context);
        init(context);
    }

    public YearRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public YearRowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_year_row, this, true);
        mYear = (TextView) findViewById(R.id.year_name);
    }

    public void setYear(String year) {
        mYear.setText(year);
    }
}
