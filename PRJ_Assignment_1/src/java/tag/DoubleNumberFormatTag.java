/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package tag;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author fpt
 */
public class DoubleNumberFormatTag extends SimpleTagSupport {

    private String number;
    private String format;

    public void setFormat(String format) {
        this.format = format;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("Number is:" + number);
        System.out.println("Format is:" + format);
        try {
            Double num = Double.valueOf(number);
//            NumberFormat numberFormatter;
//            String numberOut;
//            numberFormatter = NumberFormat.getNumberInstance();
//            numberOut = numberFormatter.format(num);

            DecimalFormat df = new DecimalFormat("#%");
            getJspContext().getOut().write(df.format(num));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
