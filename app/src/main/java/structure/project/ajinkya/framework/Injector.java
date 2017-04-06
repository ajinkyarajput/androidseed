package structure.project.ajinkya.framework;

/**
 * Created by Ajinkya on 6/4/17.
 */

public enum Injector {
    INSTANCE;

    private static ApplicationComponent applicationComponent;

     Injector()
    {
    }

    void initializeApplicationComponent(BaseApplication customApplication)
    {
        ApplicationComponent applicationComponent = DaggerApplicationComponent.builder()
                .appContextModule(new AppContextModule(customApplication))
                .apiServiceContextModule(new ApiServiceContextModule(customApplication))
                .build();
        this.applicationComponent = applicationComponent;

    }


    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
