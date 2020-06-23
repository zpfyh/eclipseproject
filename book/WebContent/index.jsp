<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="image/jpeg; charset=utf-8"%>
<%@ page import="java.awt.*"%>

<%!
 // 随机产生颜色
  
 public Color getColor(){
	Random ran = new Random();
	int r = ran.nextInt(256);
	int g = ran.nextInt(256);
	int b = ran.nextInt(256);
	return new Color(r,g,b);  //red green blue
}

// 产生验证码值
  public String getNum()
  {
	// 0-8999
	int ran = (int)(Math.random()*9000)+1000;
	return String.valueOf(ran);
   }
%>

<%
  //禁止缓存  防止验证码过期
  response.setHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Expires", "0");
  
  //绘制验证码
  BufferedImage image = new BufferedImage(80,30,BufferedImage.TYPE_3BYTE_BGR);
  
  //画笔
  Graphics graphics =image.getGraphics();
  //填充
  graphics.fillRect(0, 0, 80, 30);
  
  //绘制干扰线条
  for(int i = 0 ;i<60;i++){
	  Random ran = new Random();
	int xBegin =  ran.nextInt(80);
	int yBegin =  ran.nextInt(30);
	
	
	int xend = ran.nextInt(xBegin+10);
	int yend = ran.nextInt(yBegin+10);
	

	graphics.setColor(getColor());
	
	//绘制线条
	graphics.drawLine(xBegin, yBegin, xend, yend);
  }
  
  graphics.setFont(new Font("seif",Font.BOLD,20));
  // 绘制验证码
  graphics.setColor(Color.BLACK);
  
   String checkCode = getNum();
  // checkCode.charAt(i);  //验证码数字
  StringBuffer sb = new StringBuffer();
   for(int i=0;i<checkCode.length();i++){
	   sb.append(checkCode.charAt(i) +"");
   }
   
   //画验证码
   graphics.drawString(sb.toString(), 15, 20);
   
   //将验证码值 保存在session中   共使用时比较
   
   session.setAttribute("checkCode",checkCode);
   
   // 真实图片
   ImageIO.write(image, "jpeg", response.getOutputStream());
   
   //关闭操作
   out.clear();
   out = pageContext.pushBody();
   
   
%>