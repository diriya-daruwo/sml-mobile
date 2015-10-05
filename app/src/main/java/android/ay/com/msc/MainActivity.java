package android.ay.com.msc;

import android.app.ProgressDialog;
import android.ay.com.msc.activity.MainMenuActivity;
import android.ay.com.msc.activity.MenuActivity;
import android.ay.com.msc.utils.Constant;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button signinButton;
    private ProgressDialog pDialog;
    private Thread splashThreadHandler;
    protected int splashTime = 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {


            setContentView(R.layout.activity_main);

            UIInitialize();

        }catch (Exception e){
            Toast.makeText(this,getResources().getString(R.string.exception),
                    Toast.LENGTH_LONG).show();
            callBack();
        }

    }

    /**
     * UI Initialize Method
     * @throws Exception
     */
    private void UIInitialize() throws Exception{
        try {

            userNameEditText = (EditText) findViewById(R.id.userNameEditText);
            passwordEditText = (EditText) findViewById(R.id.passwordEditText);

            signinButton = (Button) findViewById(R.id.signinButton);
            signinButton.setOnClickListener(this);

        }catch (Exception e){
            throw e;
        }
    }

    private void callBack() {
        finish();
    }

    @Override
    public void onBackPressed() {
        callBack();
    }

    @Override
    public void onClick(View view) {
        try {

            switch (view.getId()){
                case R.id.signinButton :

                    //=============================================
                    Intent callMenu = new Intent(this, MenuActivity.class);
                    startActivity(callMenu);
                    finish();
                    //=============================================


//                    final String userName  =  userNameEditText.getText().toString();
//                    final String password  =  passwordEditText.getText().toString();
//
//                    if (userName.isEmpty()){
//
//                        Toast.makeText(this,getResources().getString(R.string.username_empty),
//                                Toast.LENGTH_LONG).show();
//
//                    }else  if (password.isEmpty()){
//
//                        Toast.makeText(this,getResources().getString(R.string.password_empty),
//                                Toast.LENGTH_LONG).show();
//
//                    }else{
//
//                        //---------------------------------------------------------
//
//                        showProgressDialog();
//
//
//                        splashThreadHandler = new Thread() {
//                            @Override
//                            public void run() {
//                                try {
//                                    synchronized(this){
//                                        wait(splashTime);
//
//
//                                    }
//
//                                } catch(InterruptedException e) {
//                                    hideProgressDialog();
//                                }
//                                finally {
//                                    hideProgressDialog();
//
//
//                                }
//                            }
//                        };
//
//                        splashThreadHandler.start();
//
//                        if (userName.equals(Constant.USER_NAME) &&
//                                password.equals(Constant.PASSWORD)){
//
//                            hideProgressDialog();
//
////                            Intent callMenu = new Intent(this, MainMenuActivity.class);
//                            Intent callMenu = new Intent(this, MenuActivity.class);
//                            startActivity(callMenu);
//                            finish();
//
//                        }else{
//
//                            hideProgressDialog();
//
//                            showAlert();
//
//                        }
//
//
//
//                        //---------------------------------------------------------
//
//                    }

                    break;

                default:break;
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private void showAlert() {
        try {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            alertDialogBuilder.setTitle("Error Login");
            alertDialogBuilder
                    .setMessage("Invalid user name or password")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();




        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void showProgressDialog() {

        if (pDialog != null)
            pDialog = null;

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please Wait...");
        pDialog.setCancelable(false);
        pDialog.show();


    }

    private void hideProgressDialog() {
        if (pDialog != null){

            pDialog.dismiss();
            pDialog = null;

        }
    }
}
