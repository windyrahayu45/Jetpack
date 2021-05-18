package com.dicoding.windi.jetpack.ui.detail;


import androidx.lifecycle.ViewModel;
import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.utils.DataDummy;
import java.util.List;

public class DetailViewModel extends ViewModel {
    private String pilihanId;
    private String jenisId;
    List<DataEntity> dataEntities  ;

    public void setSelected(String pilihanId,String jenisId) {
        this.pilihanId = pilihanId;
        this.jenisId = jenisId;
    }

    public DataEntity getData() {
        DataEntity data = null;

        if(jenisId.equals("1")){
            dataEntities = DataDummy.generateDummyMovie();
        }
        else{
            dataEntities = DataDummy.generateDummyShow();
        }
        for (DataEntity dataEntity : dataEntities) {

            if (dataEntity.getFilmId().equals(pilihanId)) {

                data = dataEntity;
            }
        }
        return data;
    }


}
