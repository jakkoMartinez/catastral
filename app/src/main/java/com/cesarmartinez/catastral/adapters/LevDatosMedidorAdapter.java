package com.cesarmartinez.catastral.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cesarmartinez.catastral.R;
import com.cesarmartinez.catastral.room.model.LevDatosMedidor;

import java.util.ArrayList;
import java.util.List;

public class LevDatosMedidorAdapter extends RecyclerView.Adapter<LevDatosMedidorAdapter.LevDatosMedidorHolder> {
    private List<LevDatosMedidor> levDatosMedidores = new ArrayList<>();
    private List<LevDatosMedidor> levDatoMedidores1 = new ArrayList<>();
    private OnItemClickListener listener;
    @NonNull
    @Override
    public LevDatosMedidorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lev_item, parent, false);
        return new LevDatosMedidorHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LevDatosMedidorHolder holder, int position) {
        LevDatosMedidor currentLevDatosMedidor= levDatosMedidores.get(position);
        String nombretring="";
        holder.textViewMedidor.setText(currentLevDatosMedidor.getLevdatmedmedidor());
        holder.textViewCuenta.setText(currentLevDatosMedidor.getLevdatmedcuenta());
        holder.textViewCodcatastral.setText(currentLevDatosMedidor.getLevdatmedcodcatastral());
        holder.textViewUsuario.setText(nombretring);
    }

    @Override
    public int getItemCount() {
        return levDatosMedidores.size();
    }
    public void setLevantamientos(List<LevDatosMedidor> levDatosMedidores) {
        this.levDatosMedidores = levDatosMedidores;
        notifyDataSetChanged();
    }


    class LevDatosMedidorHolder extends RecyclerView.ViewHolder{
        private TextView textViewMedidor;
        private TextView textViewCuenta;
        private TextView textViewCodcatastral;
        private TextView textViewUsuario;
        private ProgressBar pgb_datmed,pgb_datacom,pgb_datacli,pgb_dataobs;
        public LevDatosMedidorHolder(@NonNull View itemView) {
            super(itemView);
            textViewMedidor=itemView.findViewById(R.id.text_view_medidor);
            textViewCuenta=itemView.findViewById(R.id.text_view_cuenta);
            textViewCodcatastral=itemView.findViewById(R.id.text_view_codcatastral);
            textViewUsuario=itemView.findViewById(R.id.text_view_usuario);
            pgb_datmed=itemView.findViewById(R.id.Pgb_datmed);
            pgb_datacom=itemView.findViewById(R.id.Pgb_datacom);
            pgb_datacli=itemView.findViewById(R.id.Pgb_datacli);
            pgb_dataobs=itemView.findViewById(R.id.Pgb_dataobs);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(levDatosMedidores.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(LevDatosMedidor levDatosMedidor);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}