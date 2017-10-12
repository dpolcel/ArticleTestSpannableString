package br.com.polcel.testspannablestring;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mCustomTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCustomTextView = (TextView) findViewById(R.id.activity_main_show_words);

        String initialText = "Tängo Labs is the new thing!";

        SpannableString spannable = new SpannableString(initialText);

//        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.BLUE);

        String findString = "Tängo";

        int rangeStart = initialText.indexOf(findString);
        int rangeEnd = rangeStart + findString.length();

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(getApplicationContext(), "Hey you!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };

//        spannable.setSpan(colorSpan, rangeStart, rangeEnd, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spannable.setSpan(clickableSpan, rangeStart, rangeEnd, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        mCustomTextView.setText(spannable);
        mCustomTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
