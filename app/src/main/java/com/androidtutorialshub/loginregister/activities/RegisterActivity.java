package com.androidtutorialshub.loginregister.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.helpers.InputValidation;
import com.androidtutorialshub.loginregister.model.User;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;

/**
 * Created by lalit on 8/27/2016.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;

    private NestedScrollView nestedScrollView;

    String spineritem[] = {"user","admin"};
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;
    private TextInputLayout textInputLayoutFirstName;
    private TextInputLayout textInputLayoutlastname;
    private CheckBox hobie1;
    private CheckBox hobie2;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Spinner spinner;
    String str_spinner;
    String hobes;


    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;
    private TextInputEditText textInputEditTextFirstName;
    private TextInputEditText textInputEditTextlastname;




    private AppCompatButton appCompatButtonRegister;
    private AppCompatTextView appCompatTextViewLoginLink;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;
    String radio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();


    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirmPassword = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);
        textInputLayoutFirstName = (TextInputLayout) findViewById(R.id.textInputLayoutfirstName);
        textInputLayoutlastname = (TextInputLayout) findViewById(R.id.textInputLayoutlasttName);
        spinner = (Spinner) findViewById(R.id.spiner);
        hobie1=(CheckBox) findViewById(R.id.hob1);
        hobie2=(CheckBox) findViewById(R.id.hob2);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);




        ArrayAdapter<String> spinerarray=new ArrayAdapter<String>(RegisterActivity.this,android.R.layout.simple_spinner_item,spineritem);
        spinerarray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinerarray);




       /* spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                str_spinner = spinner.getSelectedItem().toString();
            }
        });
*/

        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);
        textInputEditTextFirstName = (TextInputEditText) findViewById(R.id.textInputEditTextfirstName);
        textInputEditTextlastname = (TextInputEditText) findViewById(R.id.textInputEditTextlastName);

        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);

        appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);

    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        appCompatButtonRegister.setOnClickListener(this);
        appCompatTextViewLoginLink.setOnClickListener(this);

    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();

    }

 @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.appCompatButtonRegister:
                postDataToSQLite();
                break;

            case R.id.appCompatTextViewLoginLink:
                finish();
                break;
            case R.id.spiner:
             //   str_spinner = spinner.getSelectedItem().toString();
                break;
        }
    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
            return;
        }

        if (!databaseHelper.checkUser(textInputEditTextName.getText().toString().trim())) {

            user.setFirstName(textInputEditTextFirstName.getText().toString().trim());
            user.setLastName(textInputEditTextlastname.getText().toString().trim());
            user.setUserName(textInputEditTextName.getText().toString().trim());
            user.setPassword(textInputEditTextPassword.getText().toString().trim());
            user.setconfirmPassword(textInputEditTextConfirmPassword.getText().toString().trim());


            str_spinner = spinner.getSelectedItem().toString();
            user.setUsertpe(str_spinner);

            if(hobie1.isChecked()){
                hobes = hobie1.getText().toString();
            }else{
                hobes=hobie2.getText().toString();
            }
            user.sethobbies(hobes);

            int selectedId = radioGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            radioButton = (RadioButton) findViewById(selectedId);
            radio= radioButton.getText().toString();



          //  user.setUsertpe(textInputLayoutusertype.getText().toString().trim());
            user.setgender(radio);
            Toast.makeText(RegisterActivity.this, hobes, Toast.LENGTH_SHORT).show();


            databaseHelper.addUser(user);
            Toast.makeText(RegisterActivity.this, "Registerd succesfully", Toast.LENGTH_SHORT).show();

        /*    // Snack Bar to show success message that record saved successfully
            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();

*/
        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(RegisterActivity.this, "Username already exixts", Toast.LENGTH_SHORT).show();
        }


    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        textInputEditTextName.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextConfirmPassword.setText(null);
        textInputEditTextFirstName.setText(null);
    }
}
