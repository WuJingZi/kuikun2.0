package sys;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Serializable;

public class Msg implements Serializable {
	private String msg;
	private String status;

	Msg(String msg, String status){
		this.msg=msg;
		this.status=status;
	}

	public static void success(Model model,String msg){
		model.addAttribute("msg",new Msg(msg,"success")) ;
	}



	public static void success(RedirectAttributes  model, String msg){
		model.addFlashAttribute("msg",new Msg(msg,"success")) ;
	}


	public static void error(Model model,String msg){
		model.addAttribute("msgq",new Msg(msg,"error")) ;
	}


	public static void error(RedirectAttributes  model,String msg){
		model.addFlashAttribute("msg",new Msg(msg,"error")) ;
	}

	public static void warn(Model model,String msg){
		model.addAttribute("msg",new Msg(msg,"warn")) ;
	}


	public static void warn(RedirectAttributes  model,String msg){
		model.addFlashAttribute("msg",new Msg(msg,"warn")) ;
	}



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
