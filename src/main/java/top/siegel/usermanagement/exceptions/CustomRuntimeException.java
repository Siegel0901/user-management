package top.siegel.usermanagement.exceptions;

import top.siegel.usermanagement.enums.CommonStatusEnum;
import top.siegel.usermanagement.interfaces.IStatusCode;

/**
 * @projectName: user-management
 * @package: top.siegel.usermanagement.exceptions
 * @className: CustomRuntimeException
 * @author: Siegel
 * @createDate: 2024/8/22
 * @createTime: 19:05
 * @description:
 */
public class CustomRuntimeException extends RuntimeException{
    private final IStatusCode statusCode;

    public CustomRuntimeException(IStatusCode statusCode) {
        super(statusCode.getMessage());
        this.statusCode = statusCode;
    }

    public CustomRuntimeException(IStatusCode statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public CustomRuntimeException(String message) {
        super(message);
        this.statusCode = CommonStatusEnum.ERROR;
    }

    public IStatusCode getStatusCode() {
        return statusCode;
    }
}
