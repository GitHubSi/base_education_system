package henu.soft.xiaosi.vo;
import henu.soft.xiaosi.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 前端 响应信息实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultResponse implements Serializable {
    private Integer code;//200是正常
    private String message;
    private Object data;

    //便于直接获取封装的response对象

    //1层封装
    public static ResultResponse success(Integer code,String message,Object data){
       ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(code);
        resultResponse.setMessage(message);
        resultResponse.setData(data);
        return resultResponse;
    }
    public static ResultResponse fail(Integer code,String message,Object data){
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(code);
        resultResponse.setMessage(message);
        resultResponse.setData(data);
        return resultResponse;
    }






}
