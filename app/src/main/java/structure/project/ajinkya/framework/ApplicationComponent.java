package structure.project.ajinkya.framework;


import javax.inject.Singleton;

import dagger.Component;
import structure.project.ajinkya.service.UserInfoService;
import structure.project.ajinkya.ui.activity.MainActivity;

/**
 * Created by Ajinkya on 6/4/17.
 */

@Singleton
@Component(modules = {AppContextModule.class ,ApiServiceContextModule.class})
//this is where you would add additional component dependencies
public interface ApplicationComponent extends AppContextComponent {
    void inject(UserInfoService userInfoService); //extend to have the provision methods

    void inject(MainActivity mainActivity);

}