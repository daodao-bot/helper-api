package cool.helper.api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import cool.helper.api.HelperApiApplicationTest;
import cool.helper.api.constant.ApiConstant;
import cool.helper.api.model.math.RadixConvert;
import cool.helper.api.model.math.RadixResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import run.ice.lib.core.error.AppError;
import run.ice.lib.core.model.Request;
import run.ice.lib.core.model.Response;

class MathControllerTest extends HelperApiApplicationTest {

    @Test
    void radixConvert() {

        String api = ApiConstant.MATH_RADIX_CONVERT;

        RadixConvert param = new RadixConvert();
        param.setOrigin("19900607");
        param.setFrom(10);
        param.setTo(16);

        Request<RadixConvert> request = new Request<>(param);

        Response<RadixResult> response = mockMvc(api, request, new TypeReference<>() {
        });

        Assertions.assertNotNull(response);
        Assertions.assertEquals(AppError.OK.code, response.getCode());

        RadixResult data = response.getData();
        Assertions.assertNotNull(data);
        Assertions.assertEquals("12FA8BF", data.getTarget());
    }

}