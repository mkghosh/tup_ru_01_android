package ghose.mithun.com.sometaskofviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etFirstNum, etSecondNum, etThirdNum, etFourthNum;
    private Button btnAdd, btnMul, btnAvg;
    private TextView result;
    private int firstNum, secondNum, thirdNum, fourthNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnAdd.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnAvg.setOnClickListener(this);

    }

    private void initViews() {
        etFirstNum = (EditText) findViewById(R.id.et_firstNum);
        etSecondNum = (EditText) findViewById(R.id.et_secondNum);
        etThirdNum = (EditText) findViewById(R.id.et_thirdNum);
        etFourthNum = (EditText) findViewById(R.id.et_fourthNum);

        btnAdd = (Button) findViewById(R.id.btn_add);
        btnMul = (Button) findViewById(R.id.btn_mul);
        btnAvg = (Button) findViewById(R.id.btn_avg);

        result = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                getNumbers();
                int additionRes = firstNum + secondNum +thirdNum + fourthNum;
                result.setText("The result of the addition is : " + additionRes);
                break;
            case R.id.btn_mul:
                getNumbers();
                int multiplicationRes = firstNum * secondNum * thirdNum * fourthNum;
                result.setText("The result of the multiplication is : " + multiplicationRes);
                break;
            case R.id.btn_avg:
                getNumbers();
                double avgRes = (firstNum + secondNum + thirdNum + fourthNum) / 4;
                result.setText("The average is : " + avgRes);
                break;
            default:
                break;
        }
    }

    private void getNumbers() {
        firstNum = Integer.parseInt(!etFirstNum.getText().toString().isEmpty() ? etFirstNum.getText().toString(): "0") ;
        secondNum = Integer.parseInt(!etSecondNum.getText().toString().isEmpty() ? etSecondNum.getText().toString(): "0") ;
        thirdNum = Integer.parseInt(!etThirdNum.getText().toString().isEmpty() ? etThirdNum.getText().toString(): "0") ;
        fourthNum = Integer.parseInt(!etFourthNum.getText().toString().isEmpty() ? etFourthNum.getText().toString(): "0") ;
    }
}
