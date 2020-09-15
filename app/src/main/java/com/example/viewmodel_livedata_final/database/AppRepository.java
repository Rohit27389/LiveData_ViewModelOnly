package com.example.viewmodel_livedata_final.database;

import android.content.Context;

import com.example.viewmodel_livedata_final.utils.SampleDataProvider;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {

    private static AppRepository ourInstance;
    private AppDatabase mDatabase;

    public List<NoteEntity> repNotesList;
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context) {
        return ourInstance = new AppRepository(context);
    }

    private AppRepository(Context context) {
        repNotesList= SampleDataProvider.getSampleData();
        mDatabase=AppDatabase.getInstance(context);

    }

    public void addSampleData() {

        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mDatabase.notesDao().insertAll(repNotesList);
            }
        });

    }
}
