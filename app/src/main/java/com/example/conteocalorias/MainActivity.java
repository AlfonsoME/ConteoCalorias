package com.example.conteocalorias;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] datos = {
                "1000", "2000", "3000", "",
                "4000", "",
                "5000", "6000", "",
                "7000", "8000", "9000", "",
                "10000"
        };

        int maxCalorias = 0;
        int caloriasActuales = 0;
        int elfoMax = -1;
        int elfoActual = 1;

        for (String linea : datos) {
            if (linea.equals("")) {
                if (caloriasActuales > maxCalorias) {
                    maxCalorias = caloriasActuales;
                    elfoMax = elfoActual;
                }
                caloriasActuales = 0;
                elfoActual++;
            } else {
                caloriasActuales += Integer.parseInt(linea);
            }
        }

        // Revisar último elfo
        if (caloriasActuales > maxCalorias) {
            maxCalorias = caloriasActuales;
            elfoMax = elfoActual;
        }

        // Imprimir resultado en Logcat
        Log.d("ConteoCalorias", "El elfo con más calorías es el #" + elfoMax +
                " con un total de " + maxCalorias + " calorías.");
    }
}

