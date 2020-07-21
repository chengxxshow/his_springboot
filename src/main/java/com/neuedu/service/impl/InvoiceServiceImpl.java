package com.neuedu.service.impl;

import com.neuedu.mapper.InvoiceMapper;
import com.neuedu.pojo.Invoice;
import com.neuedu.service.InvoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Resource
    private InvoiceMapper invoiceMapper;
    @Override
    public String getMaxInvoiceNumber(int userid) {
        return invoiceMapper.getMaxInvoiceNumber(userid);
    }
}
