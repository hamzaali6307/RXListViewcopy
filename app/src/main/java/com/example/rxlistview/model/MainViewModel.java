package com.example.rxlistview.model;import android.app.Application;import androidx.lifecycle.AndroidViewModel;import androidx.lifecycle.LiveData;import com.example.rxlistview.helpers.BlogRepository;import java.util.List;public class MainViewModel extends AndroidViewModel {    private BlogRepository movieRepository;    public MainViewModel( Application application) {        super(application);        movieRepository = new BlogRepository(application);    }    public LiveData<List<Blog>> getAllBlog() {        return movieRepository.getMutableLiveData();    }}