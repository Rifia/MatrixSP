package com.minpd.matrix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //данные, необходимые для массива

    public final int edge = 101;
    public final int mnozhitel = 10;

    public int dimension = 3;
    public int dimensionQ = dimension*dimension;
    public int[] numbers = new int[dimensionQ];

    //функции для массива

    int maxValue(int[] numbers){
        int max = numbers[0];
        for (int i = 0; i < dimensionQ; i++) if (numbers[i] > max) max = numbers[i];
        return max;
    }

    int minValue(int[] numbers){
        int min = numbers[0];
        for (int i = 0; i < dimensionQ; i++) if (numbers[i] < min) min = numbers[i];
        return min;
    }

    void multiplication (int[] numbers){
        for (int i = 0; i < dimensionQ; i++)
            numbers[i] *= mnozhitel;
    }

    int sum (int[] numbers) {
        int k = 0;
        for (int i = 0; i < dimensionQ; i++) k += numbers[i];
        return k;
    }

    void changeToNull(int[] numbers){ for (int i = 0; i < dimensionQ; i++) numbers[i] = 0;}

    void reset(int[] numbers){ for (int i = 0; i < dimensionQ; i++) numbers[i] = (int)(Math.random()*edge);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final androidx.gridlayout.widget.GridLayout myGridLayout = findViewById(R.id.gridLayout);

        Button max = findViewById(R.id.max);
        Button min = findViewById(R.id.min);
        Button sum = findViewById(R.id.sum);
        Button toNull = findViewById(R.id.change_to_null);
        Button restart =findViewById(R.id.restart);
        Button allmult = findViewById(R.id.allmult);


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset(numbers);
                for(int i=0; i<myGridLayout.getChildCount(); i++)
                {
                    ((TextView) myGridLayout.getChildAt(i)).setText(Integer.toString(numbers[i]));
                }
            }
        });

        toNull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToNull(numbers);
                for(int i=0; i<myGridLayout.getChildCount(); i++)
                {
                    ((TextView) myGridLayout.getChildAt(i)).setText(Integer.toString(numbers[i]));
                }
            }
        });

        allmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplication(numbers);
                for(int i=0; i<myGridLayout.getChildCount(); i++)
                {
                    ((TextView) myGridLayout.getChildAt(i)).setText(Integer.toString(numbers[i]));
                }
            }
        });

        max.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maxV = maxValue(numbers);
                TextView maxResult = findViewById(R.id.max_view);
                maxResult.setText(Integer.toString(maxV));
            }
        });

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minV = minValue(numbers);
                TextView minResult = findViewById(R.id.min_view);
                minResult.setText(Integer.toString(minV));
            }
        });

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int m = sum(numbers);
                TextView summa = findViewById(R.id.sum_view);
                summa.setText(Integer.toString(m));
            }
        });

    }
}
