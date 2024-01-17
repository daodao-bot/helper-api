package cool.helper.api.service;

import cool.helper.api.error.HelperError;
import cool.helper.api.model.math.RadixConvert;
import cool.helper.api.model.math.RadixResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import run.ice.lib.core.error.AppException;
import run.ice.lib.util.math.RadixUtil;

@Slf4j
@Service
public class MathService {

    public RadixResult radixConvert(RadixConvert param) {
        String origin = param.getOrigin();
        Integer from = param.getFrom();
        Integer to = param.getTo();
        String result;
        try {
            result = RadixUtil.convert(origin, from, to);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new AppException(HelperError.RADIX_CONVERT_ERROR, param.toJson(), e);
        }
        RadixResult data = new RadixResult();
        data.setTarget(result);
        return data;
    }

}
