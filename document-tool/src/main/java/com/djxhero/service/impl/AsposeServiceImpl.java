package com.djxhero.service.impl;

import com.aspose.pdf.License;
import com.djxhero.service.AsposeService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/30 14:18
 **/
@Scope(value = "prototype")
@Service
public class AsposeServiceImpl implements AsposeService {

    @Override
    public boolean getLicense(String path) {
        boolean result = false;
        InputStream license;
        try {
            license = this.getClass().getClassLoader().getResourceAsStream(path);
//                    "\\license\\aspose-pdf-license.xml");// license路径
            License aposeLic = new License();
            aposeLic.setLicense(license);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
