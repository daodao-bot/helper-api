package cool.helper.api.model.math;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import run.ice.lib.core.serialize.Serializer;

/**
 * @author DaoDao
 */
@Schema(title = "RadixResult", description = "进制转换结果")
@Data
public class RadixResult implements Serializer {

    @Schema(title = "目标字符串", description = "约定由 数字，大写字母，小写字母 共 62 个可选字符组成，最大支持 62 进制以内的转换", example = "12FA8BF")
    @NotBlank
    @Size(min = 1, max = 1024)
    @Pattern(regexp = "^[0-9A-Za-z]+$")
    private String target;

}
