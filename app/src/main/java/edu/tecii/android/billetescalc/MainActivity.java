package edu.tecii.android.billetescalc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.inputNum)
    EditText inputNum;
    @Bind(R.id.btnCal)
    Button btnCal;
    @Bind(R.id.txtResu)
    TextView txtResu;
    @Bind(R.id.txtResu1)
    TextView txtResu1;
    @Bind(R.id.txtResu2)
    TextView txtResu2;
    @Bind(R.id.txtResu3)
    TextView txtResu3;
    @Bind(R.id.txtResu4)
    TextView txtResu4;
    @Bind(R.id.txtResu5)
    TextView txtResu5;
    @Bind(R.id.txtResu6)
    TextView txtResu6;
    @Bind(R.id.txtResu7)
    TextView txtResu7;
    @Bind(R.id.txtResu8)
    TextView txtResu8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnCal)
    public void handleClickSubmit() {
        hideKeyboard();
        int parteent, partedec;
        int b100, b50, b20 , m5, m2, m1, m05, m02,m01;

        String num = inputNum.getText().toString().trim();
        double num1 = Double.parseDouble(num);
        parteent = (int)(num1);
        if (!num.isEmpty()) {
            b100 = parteent / 100;
            parteent = parteent % 100;
            b50 = parteent /50;
            parteent = parteent % 50;
            b20 = parteent / 20;
            parteent = parteent %20;
            m5 = parteent / 5;
            parteent = parteent % 5;
            m2 = parteent / 2;
            parteent = parteent % 2;
            m1 = parteent;

            partedec = (int)(num1*1000+0.5);
            m05 = partedec / 500;
            partedec = partedec % 500;
            m02 = partedec / 200;
            partedec = partedec % 200;
            m01 = partedec / 100;


            String resu = "Billetes de 100: "+b100;
            String resu1 = "Billetes de 50: "+b50;
            String resu2 = "Billetes de 20: "+b20;
            String resu3 = "Monedas de 5 pesos: "+m5;
            String resu4 = "Monedas de 2 pesos: "+m2;
            String resu5 = "Monedas de 1 peso: "+m1;
            String resu6 = "Monedas de 50 centavos: "+m05;
            String resu7 = "Monedas de 20 centavos: "+m02;
            String resu8 = "Monedas de 10 centavos: "+m01;

            //String strTip = String.format(getString(R.string.global_message_tip), tip);
            txtResu.setVisibility(View.VISIBLE);
            txtResu.setText(resu);
            txtResu1.setVisibility(View.VISIBLE);
            txtResu1.setText(resu1);
            txtResu2.setVisibility(View.VISIBLE);
            txtResu2.setText(resu2);
            txtResu3.setVisibility(View.VISIBLE);
            txtResu3.setText(resu3);
            txtResu4.setVisibility(View.VISIBLE);
            txtResu4.setText(resu4);
            txtResu5.setVisibility(View.VISIBLE);
            txtResu5.setText(resu5);
            txtResu6.setVisibility(View.VISIBLE);
            txtResu6.setText(resu6);
            txtResu7.setVisibility(View.VISIBLE);
            txtResu7.setText(resu7);
            txtResu8.setVisibility(View.VISIBLE);
            txtResu8.setText(resu8);
        }
    }


    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        try {
            inputManager.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        } catch (NullPointerException npe) {
            Log.e(getLocalClassName(), Log.getStackTraceString(npe));
        }
    }
}
