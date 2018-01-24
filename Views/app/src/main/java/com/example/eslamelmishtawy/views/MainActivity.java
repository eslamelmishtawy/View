package com.example.eslamelmishtawy.views;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView descriptionView = (TextView) findViewById(R.id.desc);
        addReadMore("faagsgasaggaagadgdgdgsvfhahdgghadkfafafdkadffadfshadfshgkhadfgkhadfgkhadfgkhadghkadghkadfgkhadfh" +
                "fdasdfsadfasfadsadfadfsdfsafadsdfsadfsadfs faagsgasaggaagadgdgdgsvfhahdgghadkfafafdkadffadfshadf" +
                "shgkhadfgkhadfgkhadfgkhadghkadghkadfgkhadfh faagsgasaggaagadgdgdgsvfhahdgghadk" +
                "fafafdkadffadfshadfshgkhadfgkhadfgkhadfgkhadghkadghkadfgkhadfh", descriptionView);


    }

    private void addReadMore(final String text, final TextView textView) {
        SpannableString ss = new SpannableString(text.substring(0, 100) + "... read more");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {

            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ds.setColor(getResources().getColor(R.color.colorPrimary, getTheme()));
                } else {
                    ds.setColor(getResources().getColor(R.color.colorPrimary));
                }
            }
        };
        ss.setSpan(clickableSpan, ss.length() - 10, ss.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
