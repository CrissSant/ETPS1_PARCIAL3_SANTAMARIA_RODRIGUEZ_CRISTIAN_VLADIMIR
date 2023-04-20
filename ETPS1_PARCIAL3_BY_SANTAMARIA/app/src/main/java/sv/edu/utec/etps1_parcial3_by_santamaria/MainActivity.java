package sv.edu.utec.etps1_parcial3_by_santamaria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.utec.etps1_parcial3_by_santamaria.Clases.ActualizarFragment;
import sv.edu.utec.etps1_parcial3_by_santamaria.Clases.EliminarFragment;
import sv.edu.utec.etps1_parcial3_by_santamaria.Clases.InsertarFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnNav;
    EditText Nombres, Apellidos, Telefono, Correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNav=findViewById(R.id.btnNav);
        Nombres=findViewById(R.id.edtNombre);
        Apellidos=findViewById(R.id.edtApellido);
        Telefono=findViewById(R.id.edtTelefono);
        Correo=findViewById(R.id.edtCorreo);

        btnNav.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navaListener= new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag= null;

            switch (item.getItemId()){

                case R.id.nav_insert:
                    seleccionFrag = new ActualizarFragment();
                    break;
                case R.id.nav_update:
                    seleccionFrag = new EliminarFragment();
                    break;
                case R.id.nav_delete:
                    seleccionFrag = new InsertarFragment();
                    break;
            }



            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentCont, seleccionFrag).commit();
            return true;

        }



    };
}