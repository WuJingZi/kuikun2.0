package sys;

public class Result {

    private boolean success;
    private Object obj;
    private String msg;


    Result(boolean success, Object obj, String msg){
        this.success=success;
        this.obj=obj;
        this.msg=msg;
    }

    public static Result success(){
        return new Result(true,null,"");
    }
    public static Result success(Object obj){
        return new Result(true,obj,"");
    }

    public static Result success(String msg){
        return new Result(true,null,msg);
    }


    public static Result success(Object obj, String msg){
        return new Result(true,obj,msg);
    }


    public static Result failing(){
        return new Result(false,null,"");
    }

    public static Result failing(String msg){
        return new Result(false,null,msg);
    }

    public static Result failing(Object obj, String msg){
        return new Result(false,obj,msg);
    }



    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
