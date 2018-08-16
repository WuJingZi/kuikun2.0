package com.xiaoyao.sys;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sys.Log;
import sys.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/sys/")
public class SysController {
	

	@Autowired
	private OperatorService operatorService;



	@GetMapping("login")
	public String login( Model model){
		model.addAttribute("operator",new Operator());
		return "sys/login";
	}



	@PostMapping("login")
	public String login(@Valid Operator operator, BindingResult bindingResult, RedirectAttributes rmodel,HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "login";
		}
		String loginName = operator.getSoperatorname();
		Log.info(String.format("准备登陆用户 =>%s",loginName),this.getClass());
		UsernamePasswordToken token = new UsernamePasswordToken(loginName, operator.getSpassword());
		//获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {
			//在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
			//每个Realm都能在必要时对提交的AuthenticationTokens作出反应
			//所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
			Log.info("对用户[" + loginName + "]进行登录验证..验证开始",this.getClass());
			currentUser.login(token);
			Log.info("对用户[" + loginName + "]进行登录验证..验证通过",this.getClass());
		} catch (UnknownAccountException uae) {
			Log.info("对用户[" + loginName + "]进行登录验证..验证未通过,未知账户",this.getClass());
			Msg.error(rmodel, "未知账户");
		} catch (IncorrectCredentialsException ice) {
			Log.info("对用户[" + loginName + "]进行登录验证..验证未通过,错误的凭证",this.getClass());
			Msg.error(rmodel, "密码不正确");
		} catch (LockedAccountException lae) {
			Log.info("对用户[" + loginName + "]进行登录验证..验证未通过,账户已锁定",this.getClass());
			Msg.error(rmodel, "账户已锁定");
		} catch (ExcessiveAttemptsException eae) {
			Log.info("对用户[" + loginName + "]进行登录验证..验证未通过,错误次数过多",this.getClass());
			Msg.error(rmodel,"用户名或密码错误次数过多");
		} catch (AuthenticationException ae) {
			//通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			Log.info("对用户[" + loginName + "]进行登录验证..验证未通过,堆栈轨迹如下",this.getClass());
			ae.printStackTrace();
			Msg.error(rmodel, "用户名或密码不正确");
		}
		//验证是否登录成功
		if (currentUser.isAuthenticated()) {
			Log.info("用户[" + loginName + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)",this.getClass());
			init(request);
			return "redirect:/sys/index";
		} else {
			token.clear();
			return "redirect:/sys/login";
		}
	}


	/**
	 * 其实没走这里，走的是默认退出
	 * @param rmodel
	 * @return
	 */
	@GetMapping("logout")
	public String logout(RedirectAttributes rmodel) {
		//使用权限管理工具进行用户的退出，跳出登录，给出提示信息
		SecurityUtils.getSubject().logout();
		Msg.success(rmodel, "您已安全退出");
		return "redirect:/login";
	}



	@GetMapping("index")
	@RequiresAuthentication
    public String index(Model model){

		return "sys/index";
	}


	private void init(HttpServletRequest request){
		Operator operator=operatorService.findByOperatorName(SecurityUtils.getSubject().getPrincipal().toString());
		request.getSession().setAttribute("operator",operator);
	}
	
	

}
