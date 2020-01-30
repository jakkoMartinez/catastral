package com.cesarmartinez.catastral.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.cesarmartinez.catastral.R;
import com.cesarmartinez.catastral.room.dao.LevDatosMedidorDao;
import com.cesarmartinez.catastral.room.model.Ruta;
import java.util.ArrayList;
import java.util.List;

public class RutaAdapter extends RecyclerView.Adapter<RutaAdapter.RutaHolder> {
    private List<LevDatosMedidorDao.allRutas> rutas = new ArrayList<>();
    private OnItemClickListener listener;
    @NonNull
    @Override
    public RutaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ruta_item, parent, false);
        return new RutaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RutaHolder holder, int position) {
        LevDatosMedidorDao.allRutas currentRuta= rutas.get(position);
        //String rutastring=currentRuta.mruta;
        //String sectorstring=currentRuta.sector;
        holder.textViewRuta.setText(currentRuta.mruta);
        holder.textViewSector.setText(currentRuta.sector);
        holder.textViewDescripcion.setText(currentRuta.descripcion);
        holder.textViewCantidad.setText(String.valueOf(currentRuta.cantidad));
        holder.textViewFaltantes.setText(String.valueOf(currentRuta.faltantes));
        holder.textViewTomados.setText(String.valueOf(currentRuta.levantados));
    }

    @Override
    public int getItemCount() {
        return rutas.size();
    }
    public void setRutas(List<LevDatosMedidorDao.allRutas> rutas) {
        this.rutas = rutas;
        notifyDataSetChanged();
    }
    class RutaHolder extends RecyclerView.ViewHolder{
        private TextView textViewRuta,textViewSector,textViewDescripcion,textViewCantidad,textViewFaltantes,textViewTomados;

        public RutaHolder(@NonNull View itemView) {
            super(itemView);
            textViewRuta=itemView.findViewById(R.id.text_view_ruta);
            textViewSector=itemView.findViewById(R.id.text_view_sector);
            textViewDescripcion=itemView.findViewById(R.id.text_view_descripcion);
            textViewCantidad=itemView.findViewById(R.id.text_view_cantidad);
            textViewFaltantes=itemView.findViewById(R.id.text_view_faltantes);
            textViewTomados=itemView.findViewById(R.id.text_view_tomados);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(rutas.get(position));
                    }
                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(LevDatosMedidorDao.allRutas ruta);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
