package org.team834.testproject33333;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.mainPurpose);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.MainPurpose, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner1 = (Spinner) findViewById(R.id.DriveTrain);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.DriveTrain, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        Spinner spinner2 = (Spinner) findViewById(R.id.numHighShots);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.numHighShots, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        Spinner spinner3 = (Spinner) findViewById(R.id.numLowShots);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.numLowShots, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        Spinner spinner4 = (Spinner) findViewById(R.id.Climb);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.Climb, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

    }

    public void Done(View v) {
        String output = "";
        EditText matchNum = (EditText) findViewById(R.id.matchNum);
        output += matchNum.getText() + ", ";

        EditText teamNum = (EditText) findViewById(R.id.Team_Number);
        output += teamNum.getText() + ", ";

        Spinner numHighShots = (Spinner) findViewById(R.id.numHighShots);
        output += numHighShots.getSelectedItem().toString() + ", ";

        Spinner numLowShots = (Spinner) findViewById(R.id.numLowShots);
        output += numHighShots.getSelectedItem().toString() + ", ";

        Spinner mainPurpose = (Spinner) findViewById(R.id.mainPurpose);
        output += mainPurpose.getSelectedItem().toString() + ", ";

        Spinner Drive = (Spinner) findViewById(R.id.DriveTrain);
        output += Drive.getSelectedItem().toString() + ", ";

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

        EditText comments = (EditText) findViewById(R.id.comments);
        output += teamNum.getText() + ", ";


    }

}
