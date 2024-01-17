package cool.helper.api.model.math;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import run.ice.lib.core.serialize.Serializer;

/**
 * @author DaoDao
 */
@Schema(title = "RadixConvert", description = "进制转换参数")
@Data
public class RadixConvert implements Serializer {

    @Schema(title = "原始字符串", description = "约定由 数字，大写字母，小写字母 共 62 个可选字符组成，最大支持 62 进制以内的转换", example = "19900607")
    @NotBlank
    @Size(min = 1, max = 1024)
    @Pattern(regexp = "^[0-9A-Za-z]+$")
    private String origin;

    @Schema(title = "原始进制", description = "原始字符串的进制", example = "10")
    @NotNull
    @Min(value = 1)
    @Max(value = 62)
    private Integer from;

    @Schema(title = "目标进制", description = "目标字符串的进制", example = "16")
    @NotNull
    @Min(value = 1)
    @Max(value = 62)
    private Integer to;

}
