package com.neuedu.service.impl;

import com.neuedu.mapper.InvoiceMapper;
import com.neuedu.mapper.PatientCostsMapper;
import com.neuedu.mapper.RegisterMapper;
import com.neuedu.service.RegisterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterMapper registerMapper;
    @Resource
    private InvoiceMapper invoiceMapper;
    @Resource
    private PatientCostsMapper patientCostsMapper;
    @Override
    public String getMaxCaseNumber() {
        return registerMapper.getMaxCaseNumber();
    }

    @Override
    public int getAlreadyRegCount(Map<String, Object> map) {
        return registerMapper.getAlreadyRegCount(map);
    }

    @Transactional   //启用事务
    @Override
    public int addRegister(Map<String, Object> registerMap) {
        //1.register 表添加记录
        //设置看诊状态和挂号时间
        registerMap.put("VisitState",1);
        String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        registerMap.put("RegistTime",time);
        int rid=registerMapper.addRegister(registerMap);

        BigInteger b1= (BigInteger)registerMap.get("id");
        rid=Integer.parseInt(b1.toString());

         System.out.println("挂号主键:"+rid);
        //2.invoice 表添加记录
        Map<String,Object> invoiceMap=new HashMap<String,Object>();
        invoiceMap.put("InvoiceNum",registerMap.get("InvoiceNumber"));
        invoiceMap.put("Money",registerMap.get("Fee"));
        invoiceMap.put("State",3); //发票未打印
        invoiceMap.put("CreationTime",time);
        invoiceMap.put("UserID",registerMap.get("RegisterID"));
        invoiceMap.put("RegistID",rid); //挂号信息的主键
        invoiceMap.put("FeeType",registerMap.get("FeeType"));
        invoiceMap.put("DailyState",0);

        int inid=invoiceMapper.addInvioce(invoiceMap);

        BigInteger b2= (BigInteger)invoiceMap.get("id");
        inid=Integer.parseInt(b2.toString());

        System.out.println("发票主键:"+inid);
        //3.patientCost 表添加记录
        Map<String,Object> pcostMap=new HashMap<String,Object>();
        pcostMap.put("RegistID",rid);
        pcostMap.put("InvoiceID",inid);
        pcostMap.put("ItemID",1); //1 挂号费 2 诊疗费
        pcostMap.put("ItemType",1); //1 非药品 2 药品
        pcostMap.put("Name","挂号费");
        pcostMap.put("Price",registerMap.get("Fee"));
        pcostMap.put("Amount",1);
        pcostMap.put("DeptID",registerMap.get("deptid")); //开立科室
        pcostMap.put("Createtime",time); //开立时间
        pcostMap.put("CreateOperID",registerMap.get("RegisterID")); //开立人员id
        pcostMap.put("PayTime",time); //收费时间
        pcostMap.put("RegisterID",registerMap.get("RegisterID")); //收费人员id
        pcostMap.put("FeeType",registerMap.get("FeeType"));

        int i=patientCostsMapper.addPatientCosts(pcostMap);
        return i;
    }
}
