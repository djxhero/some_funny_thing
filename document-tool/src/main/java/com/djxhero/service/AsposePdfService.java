package com.djxhero.service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/30 14:08
 **/
public interface AsposePdfService {

    String pdf2doc(String newFileName, InputStream inputFile, OutputStream out);
}
