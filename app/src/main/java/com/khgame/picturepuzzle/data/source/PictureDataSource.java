package com.khgame.picturepuzzle.data.source;

import com.khgame.picturepuzzle.data.ClassicPicture;
import com.khgame.picturepuzzle.data.Serial;
import com.khgame.picturepuzzle.data.SerialPicture;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public interface PictureDataSource extends PictureLoader, PictureSaver{
    Flowable<List<ClassicPicture>> getClassicPictures();
    Flowable<List<Serial>> getSerials();
    Flowable<List<SerialPicture>> getSerialPictures(String serialId);
}