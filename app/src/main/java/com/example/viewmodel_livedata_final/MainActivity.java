package com.example.viewmodel_livedata_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.viewmodel_livedata_final.database.NoteEntity;
import com.example.viewmodel_livedata_final.model.NotesAdapter;
import com.example.viewmodel_livedata_final.viewmodel.ListActivityViewModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.notes_recyclerview)
    RecyclerView mRecyclerView;

    private List<NoteEntity> mNotesList;
    private ListActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewModel();

        ButterKnife.bind(this);
        initRecyclerView();

        mNotesList = mViewModel.mNotesList;
        showData();
    }

    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(ListActivityViewModel.class);
    }

    private void initRecyclerView() {
        mRecyclerView.hasFixedSize();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void showData() {
        NotesAdapter notesAdapter = new NotesAdapter(this, mNotesList);
        mRecyclerView.setAdapter(notesAdapter);
    }


    @OnClick(R.id.fab_add_note)
    void onFabClicked() {
        Intent intent = new Intent(MainActivity.this, EditorActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.add_sample_data: {
                addSampleData();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void addSampleData() {
        mViewModel.addSampleData();
    }

}