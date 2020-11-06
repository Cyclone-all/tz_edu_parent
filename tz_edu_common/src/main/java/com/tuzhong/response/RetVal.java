package com.tuzhong.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
/**
 * @ProjectName: tz_edu_parent
 * @Package: com.tuzhong.response
 * @Author: WangYongShuai
 * @Description: 定义操作状态码
 * @Date: 2020/11/1 15:14
 * @Version: 1.0
 */
@Data
public class RetVal {
    /**
     * 成功或者失败
     */
    private Boolean success;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Map<String,Object> data = new HashMap<>();

    /**
     * 构造方法私有化
     */
    private RetVal(){ }

    /**
     * @Description: 成功的方法
     * @Author: WangYongShuai
     * @Date: 2020/11/5 16:06
     * @return: com.atguigu.response.RetVal
     **/
    public static RetVal success() {
        RetVal retVal = new RetVal();
        retVal.setSuccess(true);
        retVal.setCode(RetCode.OK);
        retVal.setMessage("成功");
        return retVal;
    }

    /**
     * @Description: 失败的方法
     * @Author: WangYongShuai
     * @Date: 2020/11/5 16:06
     * @return: com.atguigu.response.RetVal
     **/
    public static RetVal error() {
        RetVal retVal = new RetVal();
        retVal.setSuccess(false);
        retVal.setCode(RetCode.ERROR);
        retVal.setMessage("失败");
        return retVal;
    }

   /**
    * @Description: 实现链式编程
    * @Author: WangYongShuai
    * @Date: 2020/11/5 16:05
    * @param message:
    * @return: com.atguigu.response.RetVal
    **/
    public RetVal message(String message){
        this.setMessage(message);
        return this;
    }


    public RetVal code(Integer code){
        this.setCode(code);
        return this;
    }

    public RetVal data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public RetVal data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}