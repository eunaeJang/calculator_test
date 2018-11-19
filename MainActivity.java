package kr.ac.skhu.hyerin.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    EditText e;
    TextView textView;
    Stack stack;
    Stack<Integer> stack2;
    int num1, num2;
    int result;
    String[] expression, expression2;

    String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stack = new Stack();
        stack2 = new Stack<Integer>();

        e = (EditText) findViewById(R.id.e);
        textView = (TextView) findViewById(R.id.textview);

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

        MyListener listener = new MyListener();

        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        button0.setOnClickListener(listener);
        buttonAC.setOnClickListener(listener);
        buttondiv.setOnClickListener(listener);
        buttonmul.setOnClickListener(listener);
        buttonR.setOnClickListener(listener);
        buttonPlus.setOnClickListener(listener);
        buttonsub.setOnClickListener(listener);
    }


    class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            String buttonStr = ((Button) v).getText().toString();
            switch(v.getId()) {
                case R.id.button0:
                    s = s + e.getText().toString() + 0 + " ";
                    break;
                case R.id.button1:
                    s = s + e.getText().toString() + 1 + " ";
                    break;
                case R.id.button2:
                    s = s + e.getText().toString() + 2 + " ";
                    break;
                case R.id.button3:
                    s = s + e.getText().toString() + 3 + " ";
                    break;
                case R.id.button4:
                    s = s + e.getText().toString() + 4 + " ";
                    break;
                case R.id.button5:
                    s = s + e.getText().toString() + 5 + " ";
                    e.setText(s);
                    break;
                case R.id.button6:
                    s = s + e.getText().toString() + 6 + " ";
                    break;
                case R.id.button7:
                    s = s + e.getText().toString() + 7 + " ";
                    break;
                case R.id.button8:
                    s = s + e.getText().toString() + 8 + " ";
                    break;
                case R.id.button9:
                    s = s + e.getText().toString() + 9 + " ";
                    break;
                case R.id.buttonAC:
                    e.setText("");
                    s = "";
                case R.id.buttonmul:
                    s = s + e.getText().toString() + '*' + " ";
                    break;
                case R.id.buttonsub:
                    s = s + e.getText().toString() + '-' + " ";
                    break;
                case R.id.buttonPlus:
                    s = s + e.getText().toString() + '+' + " ";
                    break;
                case R.id.buttondiv:
                    s = s + e.getText().toString() + '/' + " ";
                    break;
                case R.id.buttonR:
                    expression = s.split(" ");
                    expression2 = new String[expression.length];

                    int i = 0;
                    for (String s1 : expression) {
                        switch (s1) {
                            case "+":
                            case "-":
                                if (stack.isEmpty()) {
                                    stack.push(s1);
                                    break;
                                }
                                while (!stack.isEmpty()) {
                                    expression2[i] = (String) stack.pop();
                                    i++;
                                }
                                stack.push(s1);
                                break;

                            case "*":
                            case "/":
                                if (stack.isEmpty()) {
                                    stack.push(s1);
                                    break;
                                }
                                String operator = (String) stack.peek();
                                if (operator == "*" || operator == "/") {
                                    while (!stack.isEmpty()) {
                                        expression2[i] = (String) stack.pop();
                                        i++;
                                    }
                                } else {
                                    stack.push(s1);
                                    break;
                                }
                            default:
                                expression2[i] = s1;
                                i++;
                        }
                    }
                    while (!stack.isEmpty()) {
                        expression2[i] = (String) stack.pop();
                        i++;
                    }



                    for (i = 0; i < expression2.length; i++) {
                        if (expression2[i].equals("+")) {
                            num1 = stack2.pop();
                            num2 = stack2.pop();
                            result = num1 + num2;
                            stack2.push(result);
                        } else if (expression2[i].equals("-")) {
                            num1 = stack2.pop();
                            num2 = stack2.pop();
                            result = num2 - num1;
                            stack2.push(result);
                        } else if (expression2[i].equals("*")) {
                            num1 = stack2.pop();
                            num2 = stack2.pop();
                            result = num1 * num2;
                            stack2.push(result);
                        } else if (expression2[i].equals("/")) {
                            num1 = stack2.pop();
                            num2 = stack2.pop();
                            result = num2 / num1;
                            stack2.push(result);
                        } else
                            stack2.push(Integer.parseInt(expression2[i]));
                    }
                    int r = stack2.pop();
                    e.setText((stack2.pop()));
            }


        }
    }
}


/*
            String buttonStr = ((Button) v).getText().toString();

            if (buttonStr.equals("AC")) { //AC 누르면 (이전 결과 창 제외) 전부 삭제
                e.setText("");
                s = "";
            }

            else if (buttonStr.equals("=")) {
            */
               /*
                Stack stack = new Stack();
                String[] expression = s.split(" ");
                String[] expression2 = new String[expression.length];

                int i = 0;
                for (String s1 : expression) {
                    switch (s1) {
                        case "+":
                        case "-":
                            if (stack.isEmpty()) {
                                stack.push(s1);
                                break;
                            }
                            while (!stack.isEmpty()) {
                                expression2[i] = (String) stack.pop();
                                i++;
                            }
                            stack.push(s1);
                            break;

                        case "*":
                        case "/":
                            if (stack.isEmpty()) {
                                stack.push(s1);
                                break;
                            }
                            String operator = (String) stack.peek();
                            if (operator == "*" || operator == "/") {
                                while (!stack.isEmpty()) {
                                    expression2[i] = (String) stack.pop();
                                    i++;
                                }
                            } else {
                                stack.push(s1);
                                break;
                            }
                        default:
                            expression2[i] = s1;
                            i++;
                    }
                }
                while (!stack.isEmpty()) {
                    expression2[i] = (String) stack.pop();
                    i++;
                }

                int num1, num2;
                int result;

                Stack<Integer> stack2 = new Stack<Integer>();

                for (i = 0; i < expression2.length; i++) {
                    if (expression2[i].equals("+")) {
                        num1 = stack2.pop();
                        num2 = stack2.pop();
                        result = num1 + num2;
                        stack2.push(result);
                    } else if (expression2[i].equals("-")) {
                        num1 = stack2.pop();
                        num2 = stack2.pop();
                        result = num2 - num1;
                        stack2.push(result);
                    } else if (expression2[i].equals("*")) {
                        num1 = stack2.pop();
                        num2 = stack2.pop();
                        result = num1 * num2;
                        stack2.push(result);
                    } else if (expression2[i].equals("/")) {
                        num1 = stack2.pop();
                        num2 = stack2.pop();
                        result = num2 / num1;
                        stack2.push(result);
                    } else
                        stack2.push(Integer.parseInt(expression2[i]));
                }
		        textView.setText((stack2.pop()));

            }

            else {
                s += buttonStr+" ";
                e.setText(s);*/
