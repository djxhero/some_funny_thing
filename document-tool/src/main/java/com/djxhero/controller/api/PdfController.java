package com.djxhero.controller.api;

import com.djxhero.service.AsposePdfService;
import com.djxhero.service.ExportCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/29 19:35
 **/
@Controller
@RequestMapping("/pdf")
public class PdfController extends AbstractController{

    @Autowired
    AsposePdfService asposePdfService;

    @Autowired
    ExportCommonService exportCommonService;

    @RequestMapping(value = "pdf2doc", method = RequestMethod.POST)
    @ResponseBody
    public Object pdf2doc(@RequestParam MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        try {

            String newFileName =modifyFileName( file.getOriginalFilename(),"doc");
//            String url = asposePdfService.pdf2doc(file.getName(), file.getInputStream(), response.getOutputStream());

            String url="http://pqrgepxur.bkt.clouddn.com/file.doc";
            Map<String ,String> map = new HashMap<>();
            map.put("name",newFileName);
            map.put("url",url);
            return buildSuccess(map);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return buildFailed("转换失败");
    }

    public  String modifyFileName(String fileName,String newExtension)
    {
        int i = fileName.lastIndexOf('.');
        String name = fileName.substring(0,i);
        String s = name+"." + newExtension;
        return s;
    }
}
