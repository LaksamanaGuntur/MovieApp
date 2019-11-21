package co.id.movieapp.model;

import java.util.List;

import co.id.movieapp.data.DaoSession;
import co.id.movieapp.data.ResultData;
import co.id.movieapp.data.ResultDataDao;

/**
 * Created by Laksamana Guntur Dzulfikar.
 * Android Developer
 */

public class DataModel extends BaseModel {
    private ResultDataDao mResultDataDao;

    public DataModel(DaoSession daoSession) {
        super(daoSession);
        mResultDataDao = daoSession.getResultDataDao();
    }

    public void insertData(ResultData resultData){
        mResultDataDao.insertOrReplace(resultData);
    }

    public List<ResultData> getAllData(){
        return mResultDataDao.loadAll();
    }

    public void deleteDataList() {
        mResultDataDao.deleteAll();
    }
}
