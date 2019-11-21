package co.id.movieapp.model;

import co.id.movieapp.data.DaoSession;

/**
 * Created by Laksamana Guntur Dzulfikar.
 * Android Developer
 */

public class BaseModel {
    protected final DaoSession mDaoSession;

    public BaseModel(DaoSession daoSession) {
        mDaoSession = daoSession;
    }
}
