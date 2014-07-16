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
public class EraHeaderRowView extends FrameLayout {

    private TextView mEra;

    public EraHeaderRowView(Context context) {
        super(context);
        init(context);
    }

    public EraHeaderRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EraHeaderRowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.row_era_header, this, true);
        mEra = (TextView) findViewById(R.id.era_name);
    }

    public void setEra(String era) {
        mEra.setText(era);
    }
}
