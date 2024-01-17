package cool.helper.api.controller;

import cool.helper.api.api.MathApi;
import cool.helper.api.model.math.RadixConvert;
import cool.helper.api.model.math.RadixResult;
import cool.helper.api.service.MathService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
import run.ice.lib.core.model.Request;
import run.ice.lib.core.model.Response;

@RestController
public class MathController implements MathApi {

    @Resource
    private MathService mathService;

    @Override
    public Response<RadixResult> radixConvert(Request<RadixConvert> request) {
        RadixResult data = mathService.radixConvert(request.getParam());
        return new Response<>(data);
    }

}
