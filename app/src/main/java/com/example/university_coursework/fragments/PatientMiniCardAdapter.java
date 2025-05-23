package com.example.university_coursework.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.university_coursework.PatientCard;
import com.example.university_coursework.R;
import com.example.university_coursework.database.PatientInfo;

import java.util.List;

//Адаптер для списка карточек RecyclerView
public class PatientMiniCardAdapter extends RecyclerView.Adapter<PatientMiniCardAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private List<PatientInfo> patients;

    //Интерфейс для обработки нажатия на элемент списка
    interface OnStateClickListener{
        void onStateClick(PatientInfo patient, int position, View view);
    }
    private final OnStateClickListener onClickListener;


    public PatientMiniCardAdapter(Context context, List<PatientInfo> patients, OnStateClickListener onClickListener){
        this.patients = patients;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    //Возвращает объект ViewHolder, который будет хранить данные по одному объекту PatientMiniCard
    @Override
    public PatientMiniCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.patient_card_list_item, parent, false);
        return new ViewHolder(view);
    }

    //выполняет привязку объекта ViewHolder к объекту PatientMiniCard по определенной позиции
    @Override
    public void onBindViewHolder(PatientMiniCardAdapter.ViewHolder holder, int position) {
        String age = holder.itemView.getContext().getString(R.string.age);
        String gender = holder.itemView.getContext().getString(R.string.gender);
        String diagnosis = holder.itemView.getContext().getString(R.string.diagnosis);

        PatientInfo patient = patients.get(position);
        holder.photoResource.setImageBitmap(patient.getPhotoResource());
        holder.fioView.setText(patient.getSurname() + " " + patient.getName() + " " + patient.getFathersName());
        holder.ageAndGenderView.setText(age + " " + patient.getAge() + "    " + gender + " " + patient.getGender());
        holder.diagnosisView.setText(diagnosis + " " + patient.getDiagnosis());
        holder.policyNumberView.setText(String.valueOf(patient.getPolicyNumber()));
        holder.idView.setText("ID: " + patient.getId());

        // обработка нажатия на кнопку "Посмотреть карточку"
        holder.openCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bitmap не сериализируется, его не получится передать в объекта пациента!!!!!!!?????
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    onClickListener.onStateClick(patients.get(currentPosition), currentPosition, view);
                }
            }
        });

    }

    //Кол-во объектов в списке
    @Override
    public int getItemCount() {
        return patients.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView photoResource;
        final TextView fioView;
        final TextView ageAndGenderView, diagnosisView;
        final TextView policyNumberView, idView;
        Button openCardButton;

        ViewHolder(View view){
            super(view);
            photoResource = view.findViewById(R.id.picture_card_list_item);
            fioView = view.findViewById(R.id.fio_card_list_item);
            ageAndGenderView = view.findViewById(R.id.age_gender_name_card_list_item);
            diagnosisView = view.findViewById(R.id.diagnosis_name_card_list_item);
            policyNumberView = view.findViewById(R.id.policy_name_card_list_item);
            idView = view.findViewById(R.id.id_name_card_list_item);
            openCardButton = view.findViewById(R.id.detailsButton);
        }
    }

    //Фильтр выводимого списка при поиске нужного ID
    public void updateList(List<PatientInfo> filteredList) {
        this.patients = filteredList;
        notifyDataSetChanged();
    }

}
