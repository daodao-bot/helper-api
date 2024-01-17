package cool.helper.api.api;

import cool.helper.api.constant.ApiConstant;
import cool.helper.api.model.math.RadixConvert;
import cool.helper.api.model.math.RadixResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import run.ice.lib.core.constant.AppConstant;
import run.ice.lib.core.model.Request;
import run.ice.lib.core.model.Response;

/**
 * @author DaoDao
 */
@Tag(name = "MathApi", description = "数学接口")
@HttpExchange(url = AppConstant.API)
public interface MathApi {

    @Operation(summary = "进制转换", description = "@DaoDao 字符串进制转换：最大支持 62 进制以内的转换")
    @PostExchange(url = ApiConstant.MATH_RADIX_CONVERT)
    Response<RadixResult> radixConvert(@RequestBody @Valid Request<RadixConvert> request);

}
