package cn.hncu;

import cn.hncu.utils.GifCaptcha;

import org.junit.Test;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/3/6.
 * Time: 下午 12:37.
 * Explain:
 */
public class TestCaptcha extends HttpServlet {
    @Test
    public void test1() throws FileNotFoundException {
        GifCaptcha captcha = new GifCaptcha(350,80,new Font("宋体", Font.BOLD, 50),100);// gif格式验证码
        captcha.out(new FileOutputStream("E:/1.gif"));
        System.out.println(captcha.getWord());
    }
}
