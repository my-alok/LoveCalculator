package com.coracle.alok.lovecalculator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
TextView loves , result;
EditText lover1, lover2;
Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lover1=findViewById(R.id.lover1);
        lover2=findViewById(R.id.lover2);
        loves=findViewById(R.id.loves);
        result=findViewById(R.id.result);
        calculate=findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loverNam1=lover1.getText().toString();
                String loverNam2=lover2.getText().toString();
                String raw=loverNam1+"loves"+loverNam2;
                raw=raw.toLowerCase();
                char[] ch= raw.toCharArray();
                List list=new ArrayList();
                int size=ch.length;
                List<Integer> numArr=new ArrayList();
                for(int i=0; i<size; i++){
                    int count=0;
                    if(!list.contains(ch[i])){
                        for(int j=0; j<size; j++){
                            if(ch[i]==ch[j]){
                                count++;
                            }
                            list.add(ch[i]);
                        }
                        numArr.add(count);
                    }
                }
                int sze=numArr.size();
                while(sze>2){
                    //Toast.makeText(getApplicationContext(),me, Toast.LENGTH_LONG).show();
                    for(int i=0, j=sze-1; i<j; i++, j--){
                        int add=numArr.get(i)+numArr.get(j);
                        numArr.remove(j);
                        if(add>9){
                            numArr.set(i, add/10);
                            numArr.add(i+1, add%10);
                        }
                        else{
                            numArr.set(i, add);
                        }
                    }
                    sze=numArr.size();
                }
                result.setText(numArr.get(0)+""+numArr.get(1));
            }
        });
    }
}