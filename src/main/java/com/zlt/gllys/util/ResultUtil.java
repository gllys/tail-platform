package com.zlt.gllys.util;

import java.io.Serializable;

/**
 * Created by zhangletian on 16/7/25.
 */
public class ResultUtil {


    public interface Result<T> extends Serializable {

        public static final String SUCCESS = "success";

        /** 系统出错 */
        public static final String SYSTEM_ERROR = "system_error";

        /** 数据库出错 */
        public static final String DB_ERROR = "db_error";

        /** 非法帐户 */
        public static final String ILLEGAL_ACCOUNT="illegal_account";

        /** 非法操作 */
        public static final String ILLEGAL_OPERATION = "illegal_operation";

        public static final String ILLEGAL_PARAMETER = "illegal_parameter";

        public static final String USERNAME_NOT_EXIST = "username_not_exist";

        public static final String USERNAME_IS_EXIST = "username_is_exist";

        public static final String PAYPASSWORD_ERROR = "paypassword_error";

        public static final String BORROW_NOT_EXIST = "borrow_not_exist";

        public static final String BORROW_ABNORMAL = "borrow_abnormal";

        public static final String TENDER_ABNORMAL = "tender_abnormal";

        public static final String USER_IS_LOCKED = "user_is_locked";

        public static final String BALANCE_INSUFFICIENT = "balance_insufficient";

        public static final String CARD_NOT_EXIST = "card_not_exist";

        public static final String CARD_NOT_ENOUGH = "card_not_enough";

        public static final String CARD_TO_BIGGER = "card_to_bigger";

        public static final String SYS_SUPERVENE_ERROR = "sys_supervene_error";

        public static final String PAY_PASSWORD_ERROR = "pay_password_error";

        public static final String ACCOUNT_NOT_ENOUGH = "account_not_enough";

        public static final String BORROW_WAIT_NOTENOUGH = "borrow_wait_notenough";



        public static final String RECHARGE_NOT_EXIST = "9001";

        public static final String RECHARGE_IS_CHEACKED = "9002";


        public static final String HAS_BEEN_USED_UP = "has_been_used_up";

        public static final String HAVE_NOT_CHANCE = "have_not_chance";

	/*public static final int SUCCUESS = 0;

	public static final int MISSING_PARAMETER = 1000;
	public static final int VALIDATE_PARAMETER = 1001;
	public static final int PARAMETER_BLANK = 1002;

	public static final int TOKEN_ERROR = 1002;

	public static final int METHOD_NOT_SUPPORT = 2000;

	public static final int LOGIN_USER_NOT_EXIST = 3000;
	public static final int LOGIN_USER_PASSWD_ERROR = 3001;
	public static final int PAYPASSWORD_ERROR = 3003;
	public static final int REGIST_USER_DUP_ERROR = 4001;
	public static final int LOGIN_SYSTEM_ERROR = 3002;

	//public static final int SYSTEM_ERROR = 9000;
	public static final int SYSTEM_SESSION_TIMEOUT = 9001;
	public static final int DB_SQL_ERROR = 9002;

	public static final int CONFIG_ERROR = 9003;
	public static final int CURRENT_STATUS_CANT_EDIT_ERROR = 9004;
	public static final int NO_APP_UPDATE_ERROR = 9005;
	public static final int NO_SUCH_USER = 9006;
	public static final int DONOT_NEED_UPDATE_DATABASE = 9007;
	public static final int PARENT_CUSTOMER_NOT_EXIST = 9008;
	public static final int CUSTOMER_NOT_EXIST = 9009;
	public static final int DB_SQL_NOT_UPDATE = 9010;
	public static final int PERMISSION_DENIED = 9011;
	public static final int UPLOAD_FILE_ERROR = 9012;
	public static final int ATTACHMENT_NOT_EXIST = 9013;
	public static final int EMAIL_ALREADY_EXIST = 9014;
	public static final int SAFECODE_INCORRECT = 9015;
	public static final int INVITATION_CODE_NOT_EXIST = 9100;
	public static final int INVITATION_REGISTER_ERROR = 9101;
	public static final int INVITATION_ACCOUNT_ALREADY_EXIST = 9102;
	public static final int MOBILE_HAS_EXIST = 9103;
	public static final int NOT_AVAILABLE = 9104;*/















        /**
         * 请求是否成功。
         *
         * @return 如果成功，则返回<code>true</code>
         */
        public boolean isSuccess();

        /**
         * 设置请求成功标志。
         *
         * @param success
         *            成功标志
         */
        public void setSuccess(boolean success);

        /**
         * 获取返回码
         *
         * @return 返回码
         */
        public String getCode();

        /**
         * 设置返回码
         *
         * @param code
         */
        public void setCode(String code);

        /**
         * 设置结果信息
         *
         */
        public void setMessage(String message);

        /**
         * 返回结果信息
         *
         * @return
         */
        public String getMessage();

        /**
         * <p>
         * 设置 model 对象。key 置为对象 class 类名
         * </p>
         *
         * @param model
         */
        public void setModel(T model);

        /**
         * <p>
         * 从 models 中获取指定类的 model 对象
         * </p>
         *
         * @return
         */
        public T getModel();

    }

}
