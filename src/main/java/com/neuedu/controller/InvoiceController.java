package com.neuedu.controller;

import com.neuedu.pojo.Invoice;
import com.neuedu.pojo.User;
import com.neuedu.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/neughsf/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @RequestMapping("/getMaxInvoiceNumber")
    public Map<String ,String> getInvoiceBean(HttpSession session)
    {
        User user = (User)session.getAttribute("userInfo");
        System.out.println("当前用户："+user);
        Map<String,String > map=new HashMap<String ,String>();
        if(user!=null){
            map.put("invoicenum",invoiceService.getMaxInvoiceNumber(user.getId()));
        }
        return map;

    }
}
