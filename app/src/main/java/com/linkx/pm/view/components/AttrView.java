package com.linkx.pm.view.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.linkx.pm.R;

public class AttrView extends FrameLayout {
    @Bind(R.id.attr_name)
    TextView attrNameText;
    @Bind(R.id.attr_value)
    TextView attrValueText;


    public AttrView(Context context) {
        super(context);
        setup();
    }

    public AttrView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public AttrView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    public AttrView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_attr, this);
        ButterKnife.bind(this);
    }

    public AttrView setup(String attrName, String attrValue) {
        attrNameText.setText(attrName);
        attrValueText.setText(attrValue);
        return this;
    }
}
