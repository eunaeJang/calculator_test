package kr.ac.skhu.hyerin.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button button0 = (Button) findViewById(R.id.button0);
        Button buttonAC = (Button) findViewById(R.id.buttonAC);
        Button buttonmul = (Button) findViewById(R.id.buttonmul);
        Button buttonsub = (Button) findViewById(R.id.buttonsub);
        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        Button buttondiv = (Button) findViewById(R.id.buttondiv);
        Button buttonR = (Button) findViewById(R.id.buttonR);

        textView = (TextView) findViewById(R.id.textview); // 결과를 보여줄 TextView
        editText = (EditText) findViewById(R.id.e); // 값을 입력할 EditText

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 입력되는 텍스트에 변화가 있을 때
                textView.setText(editText.getText().toString() + "");
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // 입력이 끝났을 때
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 입력하기 전에

            }
        });

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button0:
                        editText.append("0");
                        break;
                    case R.id.button1:
                        editText.append("1");
                        break;
                    case R.id.button2:
                        editText.append("2");
                        break;
                    case R.id.button3:
                        editText.append("3");
                        break;
                    case R.id.button4:
                        editText.append("4");
                        break;
                    case R.id.button5:
                        editText.append("5");
                        break;
                    case R.id.button6:
                        editText.append("6");
                        break;
                    case R.id.button7:
                        editText.append("7");
                        break;
                    case R.id.button8:
                        editText.append("8");
                        break;
                    case R.id.button9:
                        editText.append("9");
                        break;
                    case R.id.buttonmul:
                        editText.append("*");
                        break;
                    case R.id.buttonsub:
                        editText.append("-");
                        break;
                    case R.id.buttonPlus:
                        editText.append("+");
                        break;
                    case R.id.buttondiv:
                        editText.append("/");
                        break;
                }
            }
        };


        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);
        button3.setOnClickListener(clickListener);
        button4.setOnClickListener(clickListener);
        button5.setOnClickListener(clickListener);
        button6.setOnClickListener(clickListener);
        button7.setOnClickListener(clickListener);
        button8.setOnClickListener(clickListener);
        button9.setOnClickListener(clickListener);
        button0.setOnClickListener(clickListener);
        buttonAC.setOnClickListener(clickListener);
        buttondiv.setOnClickListener(clickListener);
        buttonmul.setOnClickListener(clickListener);
        buttonR.setOnClickListener(clickListener);
        buttonPlus.setOnClickListener(clickListener);
        buttonsub.setOnClickListener(clickListener);

    }

