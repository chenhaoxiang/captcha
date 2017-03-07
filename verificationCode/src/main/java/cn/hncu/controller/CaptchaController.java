package cn.hncu.controller;

import cn.hncu.utils.GifCaptcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/3/6.
 * Time: 下午 8:26.
 * Explain:演示GIF验证码的控制器
 */
@Controller
public class CaptchaController {
    private Logger logger = LoggerFactory.getLogger(CaptchaController.class);
    /**
     * 获取Gif验证码
     * @param response
     */
    @RequestMapping(value = "gifCaptcha",method= RequestMethod.GET)
    public void getGifCaptcha(HttpServletResponse response,HttpServletRequest request){
        //告诉客户端，输出的格式
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/gif");
        GifCaptcha gifCaptcha =  new GifCaptcha(200,80,new Font("宋体", Font.BOLD, 40),100);
        try {
            gifCaptcha.out(response.getOutputStream());
            logger.info("获取验证码！验证码字符为："+gifCaptcha.getWord());
            HttpSession session = request.getSession(true);
            //存入Session
            session.setAttribute("captchaWord",gifCaptcha.getWord());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //测试同一张图片，返回火狐时是哪样的情况
//        try {
//            ServletOutputStream sos = response.getOutputStream();
//            BufferedInputStream fin = new BufferedInputStream(new FileInputStream("E:/1.gif"));
//            byte[] content = new byte[1024];
//            int length;
//            while ((length = fin.read(content, 0, content.length)) != -1) {
//                sos.write(content, 0, length);
//            }
//            fin.close();
//            sos.flush();
//            sos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    @RequestMapping("index")
    public String index()    {
        return "index";
    }

}
