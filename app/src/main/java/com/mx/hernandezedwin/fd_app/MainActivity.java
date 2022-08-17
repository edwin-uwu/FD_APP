package com.mx.hernandezedwin.fd_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] nombres = {"MASANORI KOHASHI","HOKUTO MATSUYAMA","KANTA","NAOTO SUENAGA","2"};
    String[] nombresJapones = {"小橋 正典","小橋 正典","小橋 正典","末永 直登","2"};
    //float[] precios = {12,34,556};XD
    int[] carnumero = {34,45,57,311,2};
    int[] fotos = {R.drawable.masanori_kohashi,R.drawable.hokuto_matsuyama,R.drawable.kanta,R.drawable.naoto_suenaga,R.drawable.naoto_suenaga};
    RecyclerView rcv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv1 = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv1.setLayoutManager(linearLayoutManager);
        rcv1.setAdapter(new AdaptadorFruta());
    }

    private class AdaptadorFruta extends RecyclerView.Adapter<AdaptadorFruta.AdaptadorFrutaHolder> {
        @NonNull
        @Override
        public AdaptadorFrutaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorFrutaHolder(getLayoutInflater().inflate(R.layout.itemfruta,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorFrutaHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return nombres.length;
        }

        private class AdaptadorFrutaHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            TextView tv1,tv2,tv3;
            ImageView iv1;
            public AdaptadorFrutaHolder(@NonNull View itemView) {
                super(itemView);
                iv1 = itemView.findViewById(R.id.imageView);
                tv1 = itemView.findViewById(R.id.tvNombre);
                tv2 = itemView.findViewById(R.id.tvNombrejapo);
                tv3 = itemView.findViewById(R.id.tvCarroNumero);
                itemView.setOnClickListener(this);
            }//Imprime cada uno de los elementos

            public void imprimir(int position) {
                iv1.setImageResource(fotos[position]);
                tv1.setText(nombres[position]);
                tv2.setText(nombresJapones[position]);
                tv3.setText(String.valueOf(carnumero[position]));
                //tv2.setText(String.valueOf(precios[position]));
            }

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),nombres[getLayoutPosition()],Toast.LENGTH_LONG).show();
            }
        }
    }
}