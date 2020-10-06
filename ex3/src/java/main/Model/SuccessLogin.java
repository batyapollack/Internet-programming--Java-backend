package main.Model;

/**
 * class success login - return if user succeed to login or not
 */
public class SuccessLogin
{
    /**
     * ctor
     */
        public SuccessLogin(){}
        private Boolean success;

    /**
     *
     * @return boolean var that indicate if user succeed to login
     */
        public Boolean getSuccess() {
            return success;
        }

    /**
     *
     * @param success boolean var that indicate if user succeed to login
     */
        public void setSuccess(Boolean success) {
            this.success = success;
        }

}
