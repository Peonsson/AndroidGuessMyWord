package se.kth.anderslm.guessmyword;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private GuessMyWordModel guessModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textInput = (EditText) findViewById(R.id.editText);
         textOutput = (TextView) findViewById(R.id.textView);
         stopWatch = (Chronometer) findViewById(R.id.chronometer);
         newGameButton = (Button) findViewById(R.id.button);
         newGameButton.setOnClickListener(new NewGameClickListener());
         submitButton = (Button) findViewById(R.id.button2);
         submitButton.setOnClickListener(new SubmitClickListener());

        guessModel = new GuessMyWordModel();
    }

    private class SubmitClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String input = textInput.getText().toString();
            if(input.length() > 0) {
                char guess = input.charAt(0);
                textOutput.setText("The character: " + guess);
            } else {
                showToast("Please enter a letter!");
            }
        }
    }

    private class NewGameClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // To do...
        }
    }

    private TextView textOutput;
    private Chronometer stopWatch;
    private EditText textInput;
    private Button submitButton;
    private Button newGameButton;

    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
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
}
