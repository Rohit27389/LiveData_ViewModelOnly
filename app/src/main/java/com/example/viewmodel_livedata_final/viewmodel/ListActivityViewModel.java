package com.example.viewmodel_livedata_final.viewmodel;

import android.app.Application;

import com.example.viewmodel_livedata_final.database.AppRepository;
import com.example.viewmodel_livedata_final.database.NoteEntity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class ListActivityViewModel extends AndroidViewModel {

    public List<NoteEntity> mNotesList;
    private AppRepository mRepository;

    public ListActivityViewModel(@NonNull Application application) {
        super(application);
        mRepository=AppRepository.getInstance(application.getApplicationContext());
        mNotesList=mRepository.repNotesList;
    }

    public void addSampleData() {
        mRepository.addSampleData();
    }
}
