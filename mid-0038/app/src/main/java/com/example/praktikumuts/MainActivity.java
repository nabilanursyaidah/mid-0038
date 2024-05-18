package com.example.praktikumuts;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    private EditText editNilai, editNilai2, txtHasilPerhitungan;
    private RadioGroup radioGroup;
    private Button btnClear;
    private boolean pilihOperasi = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNilai = findViewById(R.id.MasukkanNilai1ID);
        editNilai2 = findViewById(R.id.MaukkanNIlai2ID);
        txtHasilPerhitungan = findViewById(R.id.HasilPerhitunganID);
        radioGroup = findViewById(R.id.radioGroup2);
        btnClear = findViewById(R.id.ClearID);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNilai.setText("");
                editNilai2.setText("");
                txtHasilPerhitungan.setText("");
                radioGroup.clearCheck();
                pilihOperasi = false;
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                pilihOperasi = true;
                hitung();
            }
        });
    }
    public void hitung() {
        if (!pilihOperasi || editNilai.getText().toString().isEmpty() || editNilai2.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Masukkan NIlai Pada Kolom 1 Dan 2", Toast.LENGTH_SHORT).show();
            return;
        }
        double nilai1 = Double.parseDouble(editNilai.getText().toString());
        double nilai2 = Double.parseDouble(editNilai2.getText().toString());
        if (radioGroup.getCheckedRadioButtonId() == R.id.TambahID || radioGroup.getCheckedRadioButtonId() == R.id.KurangID || radioGroup.getCheckedRadioButtonId() == R.id.KaliID) {
            int hasilInt = 0;
            if (radioGroup.getCheckedRadioButtonId() == R.id.TambahID) {
                hasilInt = (int) (nilai1 + nilai2);
            }
            else if (radioGroup.getCheckedRadioButtonId() == R.id.KurangID) {
                hasilInt = (int) (nilai1 - nilai2);
            }
            else if (radioGroup.getCheckedRadioButtonId() == R.id.KaliID) {
                hasilInt = (int) (nilai1 * nilai2);
            }
            txtHasilPerhitungan.setText(String.valueOf(hasilInt));
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.BagiID) {
            double hasilBagi = nilai1 / nilai2;
            txtHasilPerhitungan.setText(String.valueOf(hasilBagi));
        }
    }
}