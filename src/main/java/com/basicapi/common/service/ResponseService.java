package com.basicapi.common.service;

import com.basicapi.common.response.CommonResult;
import com.basicapi.common.response.ListResult;
import com.basicapi.common.response.PageResult;
import com.basicapi.common.response.SingleResult;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    //enum으로 api 요청결과에 대한 code, message를 정의합니다.
    public enum CommonResponse {
        SUCCESS(0, "성공하였습니다");
        final int code;
        final String msg;

        CommonResponse(int code, String msg){
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    // 단일건 결과를 처리하는 메소드
    public <T> SingleResult<T> getSingleResult(T data){
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    // 다중건 결과를 처리하는 메소드
    public <T> ListResult<T> getListResult(List<T> list){
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        setSuccessResult(result);
        return result;
    }


    // 페이지 결과를 처리하는 메소드
    public <T> PageResult<T> getPageResult(Page<T> page){
        PageResult<T> result = new PageResult<>();
        result.setPage(page);
        setSuccessResult(result);
        return result;
    }


    // 성공 결과만 처리하는 메소드
    public CommonResult getSuccessResult(){
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }

    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    // 실패 결과만 처리하는 메소드
    public CommonResult getFailResult(int code, String msg){
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    private <T> void setSuccessResult(SingleResult<T> result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    private <T> void setSuccessResult(ListResult<T> result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

    private <T> void setSuccessResult(PageResult<T> result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }


}
