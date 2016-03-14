package org.team834.testproject33333;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;

import android.widget.Spinner;
import android.content.Intent;


/*


DAN README

I used QRJournal1.5 for mac

I used the Text to Columns feature in excel to format it

The APKs for the app are stored in /Scouting App FINAL USE THIS/app/build/outputs



 */


public class MainActivity extends AppCompatActivity {

    String output = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.mainPurpose);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.MainPurpose, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        /*Spinner spinner1 = (Spinner) findViewById(R.id.DriveTrain);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.DriveTrain, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);*/

        Spinner spinner2 = (Spinner) findViewById(R.id.numHighShotsAttempted);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.numHighShotsAttempted, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        Spinner spinner5 = (Spinner) findViewById(R.id.numHighShotsMade);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.numHighShotsMade, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);

        Spinner spinner3 = (Spinner) findViewById(R.id.numLowShots);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.numLowShots, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        Spinner spinner4 = (Spinner) findViewById(R.id.Climb);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.Climb, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        Spinner spinner6 = (Spinner) findViewById(R.id.ranking);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.ranking, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter6);

    }

    public void Done(View v) {
       // String output = "";

        EditText matchNum = (EditText) findViewById(R.id.matchNum);
        output += matchNum.getText() + ", ";

        EditText teamNum = (EditText) findViewById(R.id.Team_Number);
        output += teamNum.getText() + ", ";

        Spinner numHighShotsAttempted = (Spinner) findViewById(R.id.numHighShotsAttempted);
        output += numHighShotsAttempted.getSelectedItem().toString() + ", ";

        Spinner numHighShotsMade = (Spinner) findViewById(R.id.numHighShotsMade);
        output += numHighShotsMade.getSelectedItem().toString() + ", ";

        Spinner numLowShots = (Spinner) findViewById(R.id.numLowShots);
        output += numLowShots.getSelectedItem().toString() + ", ";

        Spinner mainPurpose = (Spinner) findViewById(R.id.mainPurpose);
        output += mainPurpose.getSelectedItem().toString() + ", ";

        /*Spinner Drive = (Spinner) findViewById(R.id.DriveTrain);
        output += Drive.getSelectedItem().toString() + ", ";*/

        Spinner Climb = (Spinner) findViewById(R.id.Climb);
        output += Climb.getSelectedItem().toString() + ", ";

        CheckBox lowBar = (CheckBox) findViewById(R.id.df_lowBar);
        output += lowBar.isChecked() + ", ";

        CheckBox drawBridge = (CheckBox) findViewById(R.id.df_drawBridge);
        output += drawBridge.isChecked() + ", ";

        CheckBox sallyPort = (CheckBox) findViewById(R.id.df_sallyPort);
        output += sallyPort.isChecked() + ", ";

        CheckBox rockWall = (CheckBox) findViewById(R.id.df_rockWall);
        output += rockWall.isChecked() + ", ";

        CheckBox moat = (CheckBox) findViewById(R.id.df_moat);
        output += moat.isChecked() + ", ";

        CheckBox rockyRoad = (CheckBox) findViewById(R.id.df_rockyRoad);
        output += rockyRoad.isChecked() + ", ";

        CheckBox ramparts = (CheckBox) findViewById(R.id.df_ramparts);
        output += ramparts.isChecked() + ", ";

        CheckBox portcullis = (CheckBox) findViewById(R.id.df_portcullis);
        output += portcullis.isChecked() + ", ";

        CheckBox teeterTotter = (CheckBox) findViewById(R.id.df_teeterTotter);
        output += teeterTotter.isChecked() + ", ";

        Spinner ranking = (Spinner) findViewById(R.id.ranking);
        output += ranking.getSelectedItem().toString() + ", ";

        EditText comments = (EditText) findViewById(R.id.comments);
        output += comments.getText() + ", ";

        Log.d("output", output);

        //openBarcode();
        openQRCode();
    }

    public void openBarcode() {
        Intent startNewActivity = new Intent(this, Barcode.class);
        startNewActivity.putExtra("output", output);
        startActivity(startNewActivity);
    }

    public void openQRCode() {
        Bundle string= new Bundle();
        string.putString("key", output);

        Intent startQR = new Intent(this, QRCode.class);
        startQR.putExtras(string);
        startActivity(startQR);

        output = "";
    }

}
