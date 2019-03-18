package com.example.szymi44.bluetoothapp;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


public class BattleshipsFragment extends Fragment {


    private static final int NUMBER_OF_SHIPS = 3;
    int tempShips = NUMBER_OF_SHIPS;

    ImageButton[][] shipButtons = new ImageButton[3][3];
    ImageButton shipButton00;
    ImageButton shipButton01;
    ImageButton shipButton02;
    ImageButton shipButton10;
    ImageButton shipButton11;
    ImageButton shipButton12;
    ImageButton shipButton20;
    ImageButton shipButton21;
    ImageButton shipButton22;

    ImageButton[][] shotButtons = new ImageButton[3][3];
    ImageButton shotButton00;
    ImageButton shotButton01;
    ImageButton shotButton02;
    ImageButton shotButton10;
    ImageButton shotButton11;
    ImageButton shotButton12;
    ImageButton shotButton20;
    ImageButton shotButton21;
    ImageButton shotButton22;

    boolean[][] shipsPositions = new boolean[3][3];

    public BattleshipsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battleships, container, false);


        initButtons(view);
        buttonsToArray();
        disableShotField();
        //Linseners for shipButtons
        for (int i = 0; i < shipButtons.length; i++) {
            for (int j = 0; j < shipButtons[1].length; j++) {

                String row = String.valueOf(i);
                String col = String.valueOf(j);
                final String rowcol = row + col;

                shipButtons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (tempShips != 0) {
                            handleShipField(rowcol);
                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), "Ustawiono wszystkie statki", Toast.LENGTH_LONG).show();
                            disableShipsField();
                            enableShotField();
                        }
                    }
                });
            }
        }


        //Liseners for shotButtons
        for (int i = 0; i < shotButtons.length; i++) {
            for (int j = 0; j < shotButtons[1].length; j++) {

                String row = String.valueOf(i);
                String col = String.valueOf(j);
                final String rowcol = row + col;

                shotButtons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        handleShotField(rowcol);
                    }
                });
            }
        }

        return view;
    }

    private void handleShipField(String rowcol) {

        int row = rowcol.codePointAt(0) - 48;
        int col = rowcol.codePointAt(1) - 48;
        shipButtons[row][col].setBackgroundColor(Color.RED);
        shipButtons[row][col].setEnabled(false);

        shipsPositions[row][col] = true;
        tempShips--;
        Toast.makeText(getActivity().getApplicationContext(), "Liczba statków do postawienia: " + String.valueOf(tempShips), Toast.LENGTH_LONG).show();

    }


    private void handleShotField(String rowcol) {
        int row = rowcol.codePointAt(0) - 48;
        int col = rowcol.codePointAt(1) - 48;

        if (shipsPositions[row][col]==true){
            Toast.makeText(getActivity().getApplicationContext(), "Trafiłeś", Toast.LENGTH_LONG).show();
            shotButtons[row][col].setBackgroundColor(Color.RED);
        }else {
            Toast.makeText(getActivity().getApplicationContext(), "Pudło", Toast.LENGTH_LONG).show();
            shotButtons[row][col].setBackgroundColor(Color.BLACK);
        }
    }

    private void initButtons(View view) {
        shipButton00 = (ImageButton) view.findViewById(R.id.shipButton00);
        shipButton01 = (ImageButton) view.findViewById(R.id.shipButton01);
        shipButton02 = (ImageButton) view.findViewById(R.id.shipButton02);
        shipButton10 = (ImageButton) view.findViewById(R.id.shipButton10);
        shipButton11 = (ImageButton) view.findViewById(R.id.shipButton11);
        shipButton12 = (ImageButton) view.findViewById(R.id.shipButton12);
        shipButton20 = (ImageButton) view.findViewById(R.id.shipButton20);
        shipButton21 = (ImageButton) view.findViewById(R.id.shipButton21);
        shipButton22 = (ImageButton) view.findViewById(R.id.shipButton22);


        shotButton00 = (ImageButton) view.findViewById(R.id.shotButton00);
        shotButton01 = (ImageButton) view.findViewById(R.id.shotButton01);
        shotButton02 = (ImageButton) view.findViewById(R.id.shotButton02);
        shotButton10 = (ImageButton) view.findViewById(R.id.shotButton10);
        shotButton11 = (ImageButton) view.findViewById(R.id.shotButton11);
        shotButton12 = (ImageButton) view.findViewById(R.id.shotButton12);
        shotButton20 = (ImageButton) view.findViewById(R.id.shotButton20);
        shotButton21 = (ImageButton) view.findViewById(R.id.shotButton21);
        shotButton22 = (ImageButton) view.findViewById(R.id.shotButton22);

    }

    private void buttonsToArray() {
        shipButtons[0][0] = shipButton00;
        shipButtons[0][1] = shipButton01;
        shipButtons[0][2] = shipButton02;
        shipButtons[1][0] = shipButton10;
        shipButtons[1][1] = shipButton11;
        shipButtons[1][2] = shipButton12;
        shipButtons[2][0] = shipButton20;
        shipButtons[2][1] = shipButton21;
        shipButtons[2][2] = shipButton22;

        shotButtons[0][0] = shotButton00;
        shotButtons[0][1] = shotButton01;
        shotButtons[0][2] = shotButton02;
        shotButtons[1][0] = shotButton10;
        shotButtons[1][1] = shotButton11;
        shotButtons[1][2] = shotButton12;
        shotButtons[2][0] = shotButton20;
        shotButtons[2][1] = shotButton21;
        shotButtons[2][2] = shotButton22;

    }

    private void disableShipsField() {
        for (int i = 0; i < shipButtons.length; i++) {
            for (int j = 0; j < shipButtons[1].length; j++) {
                shipButtons[i][j].setEnabled(false);
            }
        }
    }

    private void enableShotField() {
        for (int i = 0; i < shipButtons.length; i++) {
            for (int j = 0; j < shipButtons[1].length; j++) {
                shotButtons[i][j].setEnabled(true);
            }
        }
    }

    private void disableShotField() {
        for (int i = 0; i < shipButtons.length; i++) {
            for (int j = 0; j < shipButtons[1].length; j++) {
                shotButtons[i][j].setEnabled(false);
            }
        }
    }

}

