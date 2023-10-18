package com.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class HelloTagSupport extends TagSupport {

    private PageContext pageContext;
    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }
    private String country;
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 实现开始标签的功能
     * @return
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
        try {
            //打开当前类和使用标签的JSP文件的通道
            JspWriter writer = pageContext.getOut();

            //传输数据到JSP文件标签所在的位置
            writer.write(country + "欢迎您！");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //处理返回值
        return super.doStartTag();
    }
}
