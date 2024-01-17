package cool.helper.api.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import run.ice.lib.core.error.ErrorEnum;

@Getter
@AllArgsConstructor
public enum HelperError implements ErrorEnum {

    ERROR("100000", "ERROR"),
    RADIX_CONVERT_ERROR("100001", "进制转换错误"),

    ;

    /**
     * 错误编码
     */
    public final String code;

    /**
     * 错误信息
     */
    public final String message;

}
