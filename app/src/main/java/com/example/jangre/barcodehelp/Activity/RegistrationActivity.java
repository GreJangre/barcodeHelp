package com.example.jangre.barcodehelp.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.example.jangre.barcodehelp.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.io.Serializable;

public class RegistrationActivity extends AppCompatActivity {

    private TextView tvCardText;
    Document doc = null;
    Elements contents;
    String Top10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        tvCardText = findViewById(R.id.tv_code_text);
        Button btnDirect = findViewById(R.id.btnDirect);
        Button btStartScan = findViewById(R.id.button2);
        //Button btnFinish = findViewById(R.id.btnFinish);
        final EditText nameText = findViewById(R.id.nameText);
        final EditText dateText = findViewById(R.id.dateText);
        final RadioButton foodText = findViewById(R.id.r2);

        btStartScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQRScanner();

            }
        });

        btnDirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();

//                FoodItem datas = new FoodItem();
//                datas.name = nameText.getText().toString();
//                datas.kinds = foodText.getText().toString();
//                datas.date = dateText.getText().toString();
//
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("datas", (Serializable) datas);
//
//                intent.putExtras(bundle);

              intent.putExtra("name",nameText.getText().toString());
                intent.putExtra("food",foodText.getText().toString());

                intent.putExtra("date",dateText.getText().toString());

                setResult(RESULT_OK);

                finish();
            }
        });

//        btnFinish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
    }

    private void startQRScanner() {
        new IntentIntegrator(this).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                //test = result.getContents();
                updateText(result.getContents());
//                new AsyncTask () {
//                    @Override
//                    protected Object doInBackground(Object[] params) {
//                        try {
//                            doc = Jsoup.connect("http://www.koreannet.or.kr/home/hpisSrchGtin.gs1?gtin=8801033795916").get();
//                            contents = doc.select("div.productTit");
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        Top10 = "";
//                        int cnt = 0;
//                        for(Element element: contents) {
//                            cnt++;
//                            Top10 += element.text() + "\n";
//                            if (cnt == 1) {
//                                break;
//                            }
//                        }
//                        return null;
//                    }
//                    @Override
//                    protected void onPostExecute(Object o) {
//                        super.onPostExecute(o);
//                        Log.i("TAG", ""+Top10);
//                        tvCardText.setText(Top10);
//                    }
//                }.execute();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void updateText(String scanCode) {
        tvCardText.setText(scanCode);
    }
}

