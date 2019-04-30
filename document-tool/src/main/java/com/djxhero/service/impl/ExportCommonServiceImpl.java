package com.djxhero.service.impl;

import com.djxhero.service.ExportCommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/1/7 11:51
 **/
@Service
public class ExportCommonServiceImpl implements ExportCommonService {
    private static final Logger logger = LoggerFactory.getLogger(ExportCommonServiceImpl.class);



    /**
     * 设置Excel导出的Header。包括输出的文件名
     *
     * @param request
     * @param response
     * @param fileName
     * @throws Exception
     */
    @Override
    public void setExportHeader(HttpServletRequest request, HttpServletResponse response,
                                String fileName) {
        try {
            String userAgent = request.getHeader("User-Agent").toLowerCase();
            //chrome头也包含safari,需要排除chrome
            if (userAgent.contains("safari") && !userAgent.contains("chrome")) {
                //处理safari的乱码问题
                byte[] bytesName = fileName.getBytes("UTF-8");
                fileName = new String(bytesName, "ISO-8859-1");
                response.setHeader("content-disposition", "attachment;fileName=" + fileName);
            } else {
                response.setCharacterEncoding("UTF-8");
                String encodeFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20")
                        .replaceAll("\\%21", "!")
                        .replaceAll("\\%27", "'")
                        .replaceAll("\\%28", "(")
                        .replaceAll("\\%29", ")")
                        .replaceAll("\\%7E", "~");
                response.setHeader("content-disposition", "attachment;fileName=" + encodeFileName);
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        response.setContentType("application/octet-stream");
    }

}
