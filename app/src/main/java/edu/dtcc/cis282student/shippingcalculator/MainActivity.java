package edu.dtcc.cis282student.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ShipItem shipItem;

    private TextView tvBaseCost;
    private TextView tvAddedCost;
    private TextView tvTotalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shipItem = new ShipItem();

        EditText etWeight = (EditText) findViewById(R.id.et_weight);
        tvBaseCost = (TextView) findViewById(R.id.tv_baseCost);
        tvAddedCost = (TextView) findViewById(R.id.tv_addedCost);
        tvTotalCost = (TextView) findViewById(R.id.tv_totalCost);

        etWeight.addTextChangedListener(weightTextWatcher);
    }

    private TextWatcher weightTextWatcher = new TextWatcher() {
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                shipItem.setWeight((int) Double.parseDouble(s.toString()));
            } catch (NumberFormatException e) {
                shipItem.setWeight(0);
            }
            displayShipping();
        }
        public void afterTextChanged(Editable s) {}
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    };

    private void displayShipping() {
        tvBaseCost.setText(getString(R.string.costString, shipItem.getBaseCost()));
        tvAddedCost.setText(getString(R.string.costString, shipItem.getAddedCost()));
        tvTotalCost.setText(getString(R.string.costString, shipItem.getTotalCost()));
    }

}
