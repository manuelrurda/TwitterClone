package com.codepath.apps.restclienttemplate;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.codepath.apps.restclienttemplate.models.SampleModel;
import com.codepath.apps.restclienttemplate.models.SampleModelDao;

@Database(entities={SampleModel.class}, version=1)
public abstract class TwitterDatabase extends RoomDatabase {
    public abstract SampleModelDao sampleModelDao();

    public static final String NAME = "MyDataBase";
}
