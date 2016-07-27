package com.zlt.gllys.util;
import  com.zlt.gllys.util.ResultUtil.*;

/**
 * Created by zhangletian on 16/7/25.
 */
public class ResultSupportUtil <T> implements Result<T> {



        /**
         *
         */
        private static final long serialVersionUID = -1802692098484483921L;
        /**
         * 请不要修改默认值
         */
        private boolean success = false;

        private String code;

        private String message;

        private T model;

        public ResultSupportUtil() {

        }

        public ResultSupportUtil(T model) {
            this.model = model;
        }

        public String getCode() {
            return code;
        }

        public boolean isSuccess() {
            return success;
        }

        @Override
        public void setModel(T model) {
            this.model = model;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public T getModel() {
            return model;
        }

        public void setResult(boolean success,T model,String code,String message){
            this.success = success;
            this.model = model;
            this.code = code;
            this.message = message;
        }

        public void setResult(boolean success,String code,String message){
            setResult( success,null, code, message);
        }
    }

