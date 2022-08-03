package com.example.tempcalc;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFirst;
    private Spinner spinnerSec;
    private EditText editTemp;
    private TextView editResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFirst = (Spinner) findViewById(R.id.spinner3);
        String[] elements = {"Celsius", "Kelvin", "Fahrenheit"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, elements);
        spinnerFirst.setAdapter(adapter);

        spinnerSec = (Spinner) findViewById(R.id.spinner2);
        String[] elements2 = {"Celsius", "Kelvin", "Fahrenheit"};
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, elements2);
        spinnerSec.setAdapter(adapter2);

        editTemp = (EditText) findViewById(R.id.editTemp);
        editResult = (TextView) findViewById(R.id.editResult);
    }

    public void onButCalcTempClick(View view) {

        TemperatureConverter converter = new TemperatureConverter();
        String temperature = editTemp.getText().toString();
        double convTemp = 0.0;
        //double temp = Double.parseDouble(editTemp.getText().toString());

        double temp = 0.0;
        try {
            temp = Double.parseDouble(editTemp.getText().toString());
        } catch (NumberFormatException e) {
            Log.e("error","Incorrect format");
            editResult.setText("Incorrect format");
            return;
        }

        if (spinnerFirst.getSelectedItemPosition() == 0 && spinnerSec.getSelectedItemPosition() == 0)
            convTemp = converter.sameToSame(temp);
        if (spinnerFirst.getSelectedItemPosition() == 1 && spinnerSec.getSelectedItemPosition() == 1)
            convTemp = converter.sameToSame(temp);
        if (spinnerFirst.getSelectedItemPosition() == 2 && spinnerSec.getSelectedItemPosition() == 2)
            convTemp = converter.sameToSame(temp);

        if (spinnerFirst.getSelectedItemPosition() == 0 && spinnerSec.getSelectedItemPosition() == 1)
            convTemp = converter.celsToKelv(temp);
        if (spinnerFirst.getSelectedItemPosition() == 1 && spinnerSec.getSelectedItemPosition() == 0)
            convTemp = converter.kelvToCels(temp);

        if (spinnerFirst.getSelectedItemPosition() == 0 && spinnerSec.getSelectedItemPosition() == 2)
            convTemp = converter.celsToFahr(temp);
        if (spinnerFirst.getSelectedItemPosition() == 2 && spinnerSec.getSelectedItemPosition() == 0)
            convTemp = converter.fahrToCels(temp);

        if (spinnerFirst.getSelectedItemPosition() == 1 && spinnerSec.getSelectedItemPosition() == 2)
            convTemp = converter.kelvToFahr(temp);
        if (spinnerFirst.getSelectedItemPosition() == 2 && spinnerSec.getSelectedItemPosition() == 1)
            convTemp = converter.fahrToKelv(temp);

        editResult.setText(Double.toString(convTemp));

    }
}