package kr.co.seoulit.erp.account.sys.common.exception;

public class DataAccessException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DataAccessException(String msg) {
        super(msg);
    }
}
