package com.example.caldesign;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView operation, result, AC, operation_proc, operation_Delit, operation_div,num_7,num_8,num_9,operation_mult,
            num_4,num_5,num_6, operation_diff, num_1,num_2,num_3,operation_sum, num_00,num_0, comma,operation_Equally;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        operation = findViewById(R.id.operation);
        result = findViewById(R.id.result);
        AC = findViewById(R.id.AC);
        operation_proc = findViewById(R.id.operation_proc);
        operation_Delit = findViewById(R.id.operation_Delit);
        operation_div = findViewById(R.id.operation_div);
        num_7 = findViewById(R.id.num_7);
        num_8 = findViewById(R.id.num_8);
        num_9 = findViewById(R.id.num_9);
        operation_mult = findViewById(R.id.operation_mult);
        num_4 = findViewById(R.id.num_4);
        num_5 = findViewById(R.id.num_5);
        num_6 = findViewById(R.id.num_6);
        operation_diff = findViewById(R.id.operation_diff);
        num_1 = findViewById(R.id.num_1);
        num_2 = findViewById(R.id.num_2);
        num_3 = findViewById(R.id.num_3);
        operation_sum = findViewById(R.id.operation_sum);
        num_00 = findViewById(R.id.num_00);
        num_0 = findViewById(R.id.num_0);
        comma = findViewById(R.id.comma);
        operation_Equally = findViewById(R.id.operation_Equally);

        num_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("7");
            }
        });
        num_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("8");
            }
        });
        num_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("9");
            }
        });
        num_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("4");
            }
        });
        num_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("5");
            }
        });
        num_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("6");
            }
        });
        num_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("1");
            }
        });
        num_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("2");
            }
        });
        num_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("3");
            }
        });
        num_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("0");
            }
        });
        num_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("00");
            }
        });
        comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append(".");
            }
        });
        operation_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("/");
            }
        });
        operation_diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("-");
            }
        });
        operation_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("+");
            }
        });
        operation_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("*");
            }
        });
        operation_proc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("%");
            }
        });
        operation_Delit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = operation.getText().toString();
                if(!s.isEmpty()){
                    String NewText = s.substring(0, s.length()-1);
                    operation.setText(NewText);
                }
            }
        });
        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = operation.getText().toString();
                String text = result.getText().toString();
                if(!s.isEmpty()){
                    operation.setText("");
                }
                if (!text.isEmpty()) {
                    result.setText("");
                }
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = result.getText().toString();
                if (!text.isEmpty() && text != "Error") {
                    operation.setText(text);
                    result.setText("");
                }

            }
        });
        operation_Equally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expressionText = operation.getText().toString();
                if (!expressionText.trim().isEmpty()) {
                    try {
                        Expression expr = new ExpressionBuilder(expressionText).build();
                        double resultValue = expr.evaluate();

                        // Проверяем, является ли число целым
                        if (resultValue == (long) resultValue) {
                            result.setText(String.valueOf((long) resultValue));
                        } else {
                            // Форматируем вывод для избежания научной нотации
                            result.setText(String.format("%.6f", resultValue).replaceAll("0*$", "").replaceAll("\\.$", ""));
                        }
                    } catch (Exception e) {
                        result.setText("Error");
                    }
                }
            }
        });

    }
}