package lala.util.mvp;

/**
 * Created by miguellemos on 18/10/17.
 */

public interface MvpPresenter <V extends MvpView> {
    void attachView(V v);

    void detachView(boolean b);
}