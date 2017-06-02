package com.example.admin.programma1.controllers;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.programma1.R;
import com.example.admin.programma1.models.GameModel;

/**
 * Created by Admin on 02.06.2017.
 */

public class GameController {
    private static GameController instance;
    private GameController(){

    }
    public static synchronized GameController getInstance(){
        if (instance == null)
            instance = new GameController();
        return instance;
    }

    private static GameModel model= GameModel.getInstance();
    private Button[] buttons;
    private TextView humanScore;
    private TextView droidScore;

    private void drawButton(Button btn, int state) {
        if ( GameModel.NOUGHT == state)
            btn.setBackgroundResource(R.drawable.o);
        else if (GameModel.CROSS == state)
            btn.setBackgroundResource(R.drawable.x);
        else
            btn.setBackgroundResource(R.drawable.clear);
    }

    public void refreshGame() {
        for (int i = 0; i < buttons.length; i++)
            drawButton(buttons[i], model.getGameField()[i / 3][i % 3]);
        humanScore.setText(model.getHumanScore()+"");
        droidScore.setText(model.getDroidScore()+"");
    }

    public void setButtons(Button[] buttons) {
        this.buttons = buttons;
    }

    public void setScores(TextView humanScore, TextView droidScore) {
        this.humanScore = humanScore;
        this.droidScore = droidScore;
    }

}
