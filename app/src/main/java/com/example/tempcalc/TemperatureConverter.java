package com.example.tempcalc;

import android.widget.EditText;
import android.widget.TextView;

public class TemperatureConverter {

    public TemperatureConverter() {
    }

    public double sameToSame(double temp) {
        return temp;
    }

    public double celsToKelv(double temp) {
        return temp + 273;
    }

    public double kelvToCels(double temp) {
        return temp - 273;
    }

    public double celsToFahr(double temp) {
        return (9.0/5.0) * temp + 32;
    }

    public double fahrToCels(double temp) {
        return (5.0/9.0) * (temp - 32);
    }

    public double kelvToFahr(double temp) {
        return (9.0/5.0) * (temp - 273) + 32;
    }

    public double fahrToKelv(double temp) {
        return (5.0/9.0) * (temp - 32) + 273;
    }


}
