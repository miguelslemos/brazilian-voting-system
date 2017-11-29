package lala.util.mvp;

/**
 * Created by miguellemos on 18/10/17.
 */
public abstract class BasePresenter<V extends BaseMvpView> extends MvpNullObjectBasePresenter<V> {

    public BasePresenter() {
        super();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }
}
