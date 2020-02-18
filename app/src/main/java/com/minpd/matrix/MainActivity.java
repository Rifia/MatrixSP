package com.minpd.matrix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TableLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //данные, необходимые для массива

    public final int edge = 101;
    public final int mnozhitel = 10;

    public int dimension = 4;
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
        for (int i = 0; i < dimensionQ; i++) if (numbers[i] > min) min = numbers[i];
        return min;
    }

    void multiplication (int[] numbers){
        for (int i = 0; i < dimensionQ; i++)
            numbers[i] *= mnozhitel;
    }

    void changeToNull(int[] numbers){ for (int i = 0; i < dimensionQ; i++) numbers[i] = 0;}

    void reset(int[] numbers){ for (int i = 0; i < dimensionQ; i++) numbers[i] = (int)(Math.random()*edge);}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //инициализация всех элементов

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        Button max = (Button)findViewById(R.id.max);
        Button min = (Button)findViewById(R.id.min);
        Button multipl = (Button)findViewById(R.id.multipl);
        Button toNull = (Button)findViewById(R.id.change_to_null);
        Button restart = (Button)findViewById(R.id.restart);

        TextView maxResult = (TextView)findViewById(R.id.max_view);
        TextView minResult = (TextView)findViewById(R.id.min_view);


        //как правильно снова отрисовать gridView
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset(numbers);

            }
        });

        //как правильно снова отрисовать gridView
        toNull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToNull(numbers);

            }
        });

        //как правильно снова отрисовать gridView
        multipl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplication(numbers);
            }
        });

        max.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maxV = maxValue(numbers);
                //как-то передать это значение во вьюху
            }
        });

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minV = minValue(numbers);
                //как-то передать это значение во вьюху
            }
        });

    }
}
