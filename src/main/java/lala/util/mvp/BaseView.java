package lala.util.mvp;

import lala.di.component.BaseViewComponent;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by miguellemos on 18/10/17.
 */
public abstract class BaseView<COMPONENT extends BaseViewComponent, VIEW extends BaseMvpView, PRESENTER extends MvpPresenter<VIEW>> {


    public BaseView() {
        COMPONENT component = constructComponent();
        component.inject(this);
        createPresenter();
        presenter.attachView(getMvpView());
        onCreate();
    }

    /**
     * Can't inject directly, whatchFields the presenter instantiation needs to happen by mosby in {@link this#createPresenter()}.
     */
    @Inject
    Provider<PRESENTER> presenterProvider;

    private PRESENTER presenter;

    protected abstract COMPONENT constructComponent();


    // MVP related *************************************************************************************************************************

    @SuppressWarnings("unchecked")
    public VIEW getMvpView() {
        return (VIEW) this;
    }

    public void createPresenter() {
        this.presenter = presenterProvider.get();
    }

    public PRESENTER getPresenter() {
        return presenter;
    }

    public void setPresenter(PRESENTER presenter) {
        this.presenter = presenter;
    }

    protected abstract void onCreate();


}
