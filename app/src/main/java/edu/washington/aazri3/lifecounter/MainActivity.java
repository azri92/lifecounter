package edu.washington.aazri3.lifecounter;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private final String TAG = "MainActivity";
    private int[] playerHP = new int[4];
    final int PLAYERS = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            for (int i = 0; i < PLAYERS; i++) {
                playerHP[i] = 20;
                setHP(i + 1);
            }
        } else {
            int[] savedHP = savedInstanceState.getIntArray("playerHP");
            for (int i = 0; i < PLAYERS; i++) {
                playerHP[i] = savedHP[i];
                setHP(i+1);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putIntArray("playerHP", playerHP);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        playerHP = savedInstanceState.getIntArray("playerHP");
        for (int i = 0; i < PLAYERS; i++) {
            setHP(i+1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // TODO: Can be simplified
    public void btnClicked(View view) {
        int newHP = 1;
        int playerNum = 1;
        switch (view.getId()) {
            case R.id.p1min1:
                newHP = changeHP(1, -1);
                playerNum = 1;
                break;
            case R.id.p1min5:
                newHP = changeHP(1, -5);
                playerNum = 1;
                break;
            case R.id.p1plus1:
                newHP = changeHP(1, 1);
                playerNum = 1;
                break;
            case R.id.p1plus5:
                newHP = changeHP(1, 5);
                playerNum = 1;
                break;
            case R.id.p2min1:
                newHP = changeHP(2, -1);
                playerNum = 2;
                break;
            case R.id.p2min5:
                newHP = changeHP(2, -5);
                playerNum = 2;
                break;
            case R.id.p2plus1:
                newHP = changeHP(2, 1);
                playerNum = 2;
                break;
            case R.id.p2plus5:
                newHP = changeHP(2, 5);
                break;
            case R.id.p3min1:
                newHP = changeHP(3, -1);
                playerNum = 3;
                break;
            case R.id.p3min5:
                newHP = changeHP(3, -5);
                playerNum = 3;
                break;
            case R.id.p3plus1:
                newHP = changeHP(3, 1);
                playerNum = 3;
                break;
            case R.id.p3plus5:
                newHP = changeHP(3, 5);
                playerNum = 3;
                break;
            case R.id.p4min1:
                newHP = changeHP(4, -1);
                playerNum = 4;
                break;
            case R.id.p4min5:
                newHP = changeHP(4, -5);
                playerNum = 4;
                break;
            case R.id.p4plus1:
                newHP = changeHP(4, 1);
                playerNum = 4;
                break;
            case R.id.p4plus5:
                newHP = changeHP(4, 5);
                playerNum = 4;
                break;
        }

        if (newHP <= 0) {
            playerDied(playerNum);
        }

    }

    private int changeHP(int playerNum, int hpChange) {
        int currHP = playerHP[playerNum - 1];
        int newHP = currHP + hpChange;
        playerHP[playerNum - 1] = newHP;
        setHP(playerNum);

        return newHP;
    }

    private void playerDied(int playerNum) {
        Context context = getApplicationContext();
        CharSequence text = "Player " + playerNum + " LOSES!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void setHP(int playerNum) {
        String id = "p" + playerNum + "hp";
        int hpID = getResources().getIdentifier(id, "id", getPackageName());
        TextView hpText = (TextView) findViewById(hpID);
        hpText.setText("" + playerHP[playerNum - 1]);
    }

}
