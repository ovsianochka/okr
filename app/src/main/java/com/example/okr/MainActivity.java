package com.example.okr;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB, editTextAlpha;
    private Button buttonCalculate;
    private TextView textViewFormula, textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextAlpha = findViewById(R.id.editTextAlpha);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewFormula = findViewById(R.id.textViewFormula);
        textViewResult = findViewById(R.id.editTextResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        try {
            double a = Double.parseDouble(editTextA.getText().toString());
            double b = Double.parseDouble(editTextB.getText().toString());
            double alpha = Double.parseDouble(editTextAlpha.getText().toString());

            // Проверка на отрицательные числа и угол более 90º
            if (a < 0 b < 0 alpha < 0 || alpha > 90) {
                showNegativeValueToast();
                return;
            }

            // Применение формулы S = ab * sin(α)
            double radians = Math.toRadians(alpha); // Переводим угол в радианы
            double result = a * b * Math.sin(radians);

            // Вывод результата
            textViewResult.setText(String.valueOf(result));

        } catch (NumberFormatException e) {
            showInvalidInputToast();
        }
    }

    private void showNegativeValueToast() {
        Toast.makeText(this, "Введите положительные числа и угол (0-90°)", Toast.LENGTH_SHORT).show();
    }

    private void showInvalidInputToast() {
        Toast.makeText(this, "Пожалуйста, введите корректные значения", Toast.LENGTH_SHORT).show();
    }
}