package cool.helper.api.controller;

import cool.helper.api.api.IndexApi;
import cool.helper.api.config.AppConfig;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements IndexApi {

    @Resource
    private AppConfig appConfig;

    @Override
    public String index() {
        return appConfig.getApplication();
    }

}
