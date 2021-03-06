package senac.sp.com.br.applistaplanetasenacti93;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView ListaPlanetas;

    String[] nomePlanetas = {"Jupiter", "Lua", "Marte", "Plutão", "Mercurio",
            "Netuno", "Saturno", "Sol", "Terra", "Urano", "Venus"};
    int[] imagemPlanetas = {R.drawable.jupiter, R.drawable.lua, R.drawable.marte, R.drawable.plutao, R.drawable.mercurio,
            R.drawable.netuno, R.drawable.saturno, R.drawable.sol, R.drawable.terra, R.drawable.urano, R.drawable.venus};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaPlanetas = findViewById(R.id.listarPlanetas);

        CustomAdapter adapter = new CustomAdapter();

        //Montando a Listas com o modelo
        ListaPlanetas.setAdapter(adapter);

        ListaPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MostrarPlanetaActivity.class);

                //Enviar o valor de uma activity para outra receber
                intent.putExtra("nomePlaneta", nomePlanetas[position]);

                intent.putExtra("imagemPlaneta", imagemPlanetas[position]);

                startActivity(intent);
            }
        });

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imagemPlanetas.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //Montando o layout para ser inserido no ListViem

            TextView txtNomePlanetas;
            ImageView imgNomePlanetas;

            View carregaView = getLayoutInflater().inflate(R.layout.modelo_lista_planetas, null);

            txtNomePlanetas = carregaView.findViewById(R.id.txtListaPlaneta);
            imgNomePlanetas = carregaView.findViewById(R.id.imgListaPlaneta);

            txtNomePlanetas.setText(nomePlanetas[position]);
            imgNomePlanetas.setImageResource(imagemPlanetas[position]);

            return null;
        }
    }
}
